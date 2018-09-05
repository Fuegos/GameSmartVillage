package Totality;
//Таймер
import java.util.Timer;
import java.util.TimerTask;

public class UserTimer extends TimerTask {
    protected int seconds;
    protected int minutes = 0;
    protected int hours = 0;
    private Timer GTimer;
    private Graphic g;
    private String sec = "";
    private String min = "";
    private String hou = "";
    private Village vil;
    private Situation sit;
    protected int exp = 0;
    protected boolean f1 = false;
    private int ch[] = new int[9];
    private int kor1 = 50;
    private int kor2 = 125;
    //Конструктор
    UserTimer(Timer Time,int sec, Graphic app, Village utopaevo) {
        this.seconds = sec;
        this.GTimer = Time;
        g = app;
        vil = utopaevo;
    }
    //Работа таймера
    @Override
    public void run() {
        if(g.flag == true) {
            this.seconds++;
            if(seconds%5 == 0) {
                g.ChangeObnul();
            }
            ch[0] = vil.confidence;
            ch[1] = vil.health;
            ch[2] = vil.security;
            ch[3] = vil.leisure;
            ch[4] = vil.education;
            ch[5] = vil.employment;
            ch[6] = vil.need;
            ch[7] = vil.population;
            ch[8] = vil.coffers;
            if(f1 == true) {
               exp++; 
            }
            if (this.seconds<0) {
                /* Делаем здесь то что вам нужно по истечению времени*/
               GTimer.cancel();
            }
            else {
                if(seconds == 60) {
                    seconds = 0;
                    minutes++;
                }
                else if(minutes == 60) {
                    minutes = 0;
                    hours++;
                }
                if(seconds < 10){
                    sec = "0" + seconds; 
                }
                else {
                    sec = "" + seconds;
                }
                if(minutes < 10){
                    min = "0" + minutes; 
                }
                else {
                    min = "" + minutes;
                }
                if(hours < 10){
                    hou = "0" + hours; 
                }
                else {
                    hou = "" + hours;
                }
                
                if(seconds == 0 && minutes != 0 && (minutes + 1)%2 == 0) {
                    sit = new Situation(g, vil);
                    f1 = true;
                }
                vil.mod3One();
                if((seconds == 0 && minutes > 0)||(seconds == 30)) {
                    vil.mod1();
                }
                vil.mod3Two();
                vil.mod2();
                if(exp > 30 && g.frameSit.isVisible() == true) {
                    vil.coffers = 0;
                }
                else if(exp < 30 && g.frameSit.isVisible() == false) {
                    exp = 0;
                    f1 = false;
                }
                g.Change(vil.confidence - ch[0], vil.health - ch[1], vil.security - ch[2],
                        vil.leisure - ch[3], vil.education - ch[4], vil.employment - ch[5],
                        vil.need - ch[6], vil.population - ch[7], vil.coffers - ch[8]);
                vil.print();
                g.tai2.setText(hou + ":" + min + ":" + sec);
                vil.gameOver(this);
                g.cheliki(this);
                int z1 = 50;
                int z2 = 570;
                int z3 = 400;
                int z4 = 20;
                int q1 = 200;
                int q2 = 300;
                int q3 = 30;
                int q4 = 70;
                int w1 = 500;
                int w2 = 300;
                int w3 = 150;
                int w4 = 210;
                for(int i = 0; i < (int) (vil.population/21); i++) {
                    g.chelikiCreat(i, z1 + (int)(Math.random() * z2), z3 + (int)(Math.random() * z4),
                            q1 + (int)(Math.random() * q2), q3 + (int)(Math.random() * q4),
                            w1 + (int)(Math.random() * w2), w3 + (int)(Math.random() * w4));
                }
                kor1 += 20;
                if(kor1 > 355 && kor1 < 680) {
                    kor2 += 13;
                }
                g.mas.setBounds(kor1, kor2, 50, 22);
                if(kor1 > 835) {
                    kor1 = 50;
                    kor2 = 125;
                }
            }
        }
    }   
}
