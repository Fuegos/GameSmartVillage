package Totality;
//Класс - Деревня.
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JButton;

public class Village {
    protected int confidence; //Уровень доверия к председателю
    protected int health; //Уровень здоровья населения деревни
    protected int security; //Уровень безопасности населения деревни
    protected int leisure; //Уровень досуга населения деревни
    protected int education; //Уровень образования населения деревни
    protected int employment; //Уровень занятости населения деревни
    protected int need; //Уровень нужды в потребностях населения деревни
    protected int population; //Число жителей деревни
    protected int coffers; // Казна деревни в рублях
    protected Graphic appC; //Копия графики
    private Building bui[] = new Building[12];
    private int raz;
    // Конструктор, инициализирующий начальные параметры.
    public Village(int con, int hea, int sec, int lei, int edu, int emp, int nee, int pop, int cof, Graphic app) throws FileNotFoundException {
        confidence = con;
        health = hea;
        security = sec;
        leisure = lei;
        education = edu;
        employment = emp;
        need = nee;
        population = pop;
        coffers = cof;
        appC = app;
        print();
        int i = 0;
        try {
            FileInputStream fstream = new FileInputStream("building.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null){
               bui[i] = new Building(strLine, this);
               i++;
            }
        }catch (IOException e){
           System.out.println("Ошибка");
        }
        mouse("naved.PNG", appC.fer, 0, 55, 20, 120, 123);
        mouse("naved1.PNG", appC.kla, 1, 640, 20, 90, 92);
        mouse("naved.PNG", appC.sko, 2, 760, 20, 120, 123);
        mouse("naved.PNG", appC.ele, 3, 495, 55, 120, 123);
        mouse("naved1.PNG", appC.kol, 4, 694, 98, 90, 92);
        mouse("naved1.PNG", appC.pol, 5, 687, 210, 90, 92);
        mouse("naved.PNG", appC.sel, 6, 768, 200, 120, 123);
        mouse("naved.PNG", appC.dk, 7, 441, 315, 120, 123);
        mouse("naved.PNG", appC.dom, 8, 230, 345, 120, 123);
        mouse("naved.PNG", appC.bol, 9, 33, 155, 120, 123);
        mouse("naved.PNG", appC.lab, 10, 178, 168, 120, 123);
        mouse("naved.PNG", appC.mag, 11, 290, 150, 120, 123);
        appC.nad.addActionListener((ActionEvent e4) -> {
            coffers = 0;
            //appC.gameO.setVisible(true);
        });
    };
    public void mouse(String Image, JButton button, int index, int x, int y, int w, int h) {
        button.addMouseListener(new CustomListener(Image, button, appC, bui[index], this, x, y, w, h));
    }
    //Метод, который изменяет параметры
    public void mod1() {
        if(bui[0] != null) {
            for(int i = 0; i < 12; i++) {
               bui[i].ChangeIndicatorAndCoffers();
            }
        }
    }
    //Метод, не дающий показателям выйти из допустимых границ
    public void mod2() {
        confidence = mod2One(confidence);
        health = mod2One(health);
        security = mod2One(security);
        leisure = mod2One(leisure);
        education = mod2One(education);
        employment = mod2One(employment);
        need = mod2One(need);
        population = mod2Two(population);
        coffers = mod2Two(coffers);
    }
    //Зависимость населения от показателей
    public void mod3One() {
        int pop = population;
        int a = (int)((confidence + health + security + leisure + education + employment + need)*0.381);
        raz = pop - a; 
        population = raz + (int)((confidence + health + security + leisure + education + employment + need)*0.381);
    }
    public void mod3Two() {
        population = raz + (int)((confidence + health + security + leisure + education + employment + need)*0.381);
    }
    //Метод, который контролтрует выход из границы допустимых значений
    public int mod2One(int param){
        int a = param;
        if(param > 100) {
           a = 100;
        }
        if(param < 0) {
           a = 0;
        }
        return a;
    }
    public int mod2Two(int param){
        int a = param;
        if(param < 0) {
            a = 0;
        }
        return a;
    }
    //Печать
    public void print(){
        appC.dov2.setText("" + confidence);
        appC.zdo2.setText("" + health);
        appC.bez2.setText("" + security);
        appC.dos2.setText("" + leisure);
        appC.obr2.setText("" + education);
        appC.zan2.setText("" + employment);
        appC.pot2.setText("" + need);
        appC.nas2.setText("" + population);
        appC.kaz2.setText("" + coffers);
    }
    //Проверка конца игры
    public void gameOver(UserTimer uT) {
        if(confidence == 0 || health == 0 || security == 0 || 
           leisure == 0 || education == 0 || employment == 0 || 
           need == 0 || population == 0 || coffers == 0) {
            uT.cancel();
            Chairperson chair = new Chairperson(appC.nameUser.getText(), appC.tai2.getText(), appC);
            appC.GraphGameOver();
        }
    }
}
