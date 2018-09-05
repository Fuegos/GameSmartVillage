package Totality;
//Класс графики
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Graphic extends JPanel {
    protected JFrame frame;
    protected pictureBox panel;
    protected pictureBox tutorial;
    protected pictureBox panel2;
    protected pictureBox dov;
    protected pictureBox zdo;
    protected pictureBox dos;
    protected pictureBox obr;
    protected pictureBox zan;
    protected pictureBox pot;
    protected pictureBox bez;
    protected pictureBox nas;
    protected pictureBox kaz;
    protected pictureBox tai;
    protected pictureBox ok1;
    protected pictureBox ok2;
    protected pictureBox ok3;
    protected pictureBox ok4;
    protected pictureBox ok5;
    protected pictureBox ok6;
    protected pictureBox ok7;
    protected pictureBox ok8;
    protected pictureBox ok9;
    protected pictureBox framePar;
    protected pictureBox frameSit;
    protected pictureBox autor;
    protected pictureBox gameO;
    protected pictureBox[] chel1 = new pictureBox[30];
    protected pictureBox[] chel2 = new pictureBox[30];
    protected pictureBox[] chel3 = new pictureBox[30];
    protected pictureBox mas;
    protected JButton bt1;
    protected JButton bt2;
    protected JButton bt3;
    protected JButton nad;
    protected JButton btVar1;
    protected JButton btVar2;
    protected JButton btVar3;
    protected JButton exit;
    protected JButton pov;
    protected JButton vost;
    protected JButton raz;
    protected JButton vih;
    protected JButton sel;
    protected JButton sko;
    protected JButton lab;
    protected JButton mag;
    protected JButton dk;
    protected JButton bol;
    protected JButton kla;
    protected JButton kol;
    protected JButton pol;
    protected JButton ele;
    protected JButton dom;
    protected JButton fer;
    protected JLabel level;
    protected JLabel levelCost;
    protected JLabel nameSit; 
    protected JLabel var1;
    protected JLabel var2;
    protected JLabel var3;
    protected JLabel name;
    protected JLabel dov2;
    protected JLabel zdo2;
    protected JLabel dos2;
    protected JLabel obr2;
    protected JLabel zan2;
    protected JLabel pot2;
    protected JLabel bez2;
    protected JLabel nas2;
    protected JLabel kaz2;
    protected JLabel tai2;
    protected JLabel change1;
    protected JLabel change2;
    protected JLabel change3;
    protected JLabel change4;
    protected JLabel change5;
    protected JLabel change6;
    protected JLabel change7;
    protected JLabel change8;
    protected JLabel change9;
    protected JLabel nam;
    protected JLabel rez;
    protected JLabel pl;
    protected JLabel top;
    protected Font font;
    protected Font font2;
    protected Font font3;
    protected Font font4;
    protected JTextField nameUser;
    protected boolean flag = false;
    //Конструктор
    public Graphic() {
        frame = new JFrame("Утопаево");
        panel = new pictureBox(new ImageIcon("pred.PNG").getImage());
        panel2 = new pictureBox(new ImageIcon("fon.PNG").getImage());
        dov = new pictureBox(new ImageIcon("dov.PNG").getImage());
        zdo = new pictureBox(new ImageIcon("zdo.PNG").getImage());
        bez = new pictureBox(new ImageIcon("bez.PNG").getImage());
        dos = new pictureBox(new ImageIcon("dos.PNG").getImage());
        obr = new pictureBox(new ImageIcon("obr.PNG").getImage());
        zan = new pictureBox(new ImageIcon("zan.PNG").getImage());
        pot = new pictureBox(new ImageIcon("pot.PNG").getImage());
        nas = new pictureBox(new ImageIcon("nas.PNG").getImage());
        kaz = new pictureBox(new ImageIcon("kaz.PNG").getImage());
        tai = new pictureBox(new ImageIcon("tai.PNG").getImage());
        ok1 = new pictureBox(new ImageIcon("ok.PNG").getImage());
        ok2 = new pictureBox(new ImageIcon("ok.PNG").getImage());
        ok3 = new pictureBox(new ImageIcon("ok.PNG").getImage());
        ok4 = new pictureBox(new ImageIcon("ok.PNG").getImage());
        ok5 = new pictureBox(new ImageIcon("ok.PNG").getImage());
        ok6 = new pictureBox(new ImageIcon("ok.PNG").getImage());
        ok7 = new pictureBox(new ImageIcon("ok.PNG").getImage());
        ok8 = new pictureBox(new ImageIcon("ok2.PNG").getImage());
        ok8 = new pictureBox(new ImageIcon("ok2.PNG").getImage());
        ok9 = new pictureBox(new ImageIcon("ok2.PNG").getImage());       
        framePar = new pictureBox(new ImageIcon("framePar.PNG").getImage());
        frameSit = new pictureBox(new ImageIcon("sit.PNG").getImage());
        tutorial = new pictureBox(new ImageIcon("tut.PNG").getImage());
        autor = new pictureBox(new ImageIcon("avtoriz.PNG").getImage());
        gameO = new pictureBox(new ImageIcon("gameOver.PNG").getImage());
        mas = new pictureBox(new ImageIcon("mas.PNG").getImage());
        
        fer = new JButton(new ImageIcon("proz.png"));
        sko = new JButton(new ImageIcon("proz.png"));
        bol = new JButton(new ImageIcon("proz.png"));
        kol = new JButton(new ImageIcon("proz.png"));
        sel = new JButton(new ImageIcon("proz.png"));
        lab = new JButton(new ImageIcon("proz.png"));
        mag = new JButton(new ImageIcon("proz.png"));
        dk = new JButton(new ImageIcon("proz.png"));
        dom = new JButton(new ImageIcon("proz.png"));
        pol = new JButton(new ImageIcon("proz.png"));
        kla = new JButton(new ImageIcon("proz.png"));
        ele = new JButton(new ImageIcon("proz.png"));
        raz = new JButton(new ImageIcon("raz.PNG"));
        exit = new JButton(new ImageIcon("exit.PNG"));
        nad = new JButton(new ImageIcon("nad.PNG"));
        pov = new JButton(new ImageIcon("ul.PNG"));
        vost = new JButton(new ImageIcon("vos.PNG"));
        btVar1 = new JButton(new ImageIcon("var.PNG"));
        btVar2 = new JButton(new ImageIcon("var.PNG"));
        btVar3 = new JButton(new ImageIcon("var.PNG"));
        bt1 = new JButton(new ImageIcon("bt1.PNG"));
        bt2 = new JButton(new ImageIcon("bt2.PNG"));
        bt3 = new JButton(new ImageIcon("bt3.PNG"));
        vih = new JButton(new ImageIcon("vih.PNG"));
        
        dov2 = new JLabel("");
        zdo2 = new JLabel("");
        bez2 = new JLabel("");
        dos2 = new JLabel("");
        obr2 = new JLabel("");
        zan2 = new JLabel("");
        pot2 = new JLabel("");
        nas2 = new JLabel("");
        kaz2 = new JLabel("");
        nameSit = new JLabel("");
        var1 = new JLabel("");
        var2 = new JLabel("");
        var3 = new JLabel("");
        name = new JLabel("");
        level = new JLabel("");
        levelCost = new JLabel("");
        change1 = new JLabel("");
        change2 = new JLabel("");
        change3 = new JLabel("");
        change4 = new JLabel("");
        change5 = new JLabel("");
        change6 = new JLabel("");
        change7 = new JLabel("");
        change8 = new JLabel("");
        change9 = new JLabel("");
        nam = new JLabel("");
        rez = new JLabel("");
        pl = new JLabel("");
        top = new JLabel("");
        tai2 = new JLabel("00:00:00");
        
        font = new Font("Calibri", Font.PLAIN, 18);
        font2 = new Font("Calibri", Font.PLAIN, 24);
        font3 = new Font("Calibri", Font.TYPE1_FONT, 18);
        font4 = new Font("Calibri", Font.TYPE1_FONT, 16);
        
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(927, 695));
        frame.setLocationRelativeTo(null); //Окно по центру
        creatBut(bt1, panel, 390, 410, 179, 88);
        bt1.addActionListener((ActionEvent e) -> {
            // при нажатии кнопки "Начать"
            panel.remove(bt1); //удаление кнопки
            panel.revalidate();
            panel.repaint();
            creatPBox(panel, tutorial, 50, 11, 830, 527);
            creatBut(bt2, panel, 390, 560, 179, 88);
            bt2.addActionListener((ActionEvent e1) -> {
                // при нажатии кнопки "Далее"
                panel.remove(bt2); //удаление кнопки
                panel.remove(tutorial);
                panel.revalidate();
                panel.repaint();
                creatPBox(panel, autor, 323, 270, 307, 127);
                nameUser = new JTextField("Афанасий Петрушкин");
                nameUser.setFont(font);
                nameUser.setForeground(Color.RED);
                autor.add(nameUser);
                nameUser.setBounds(50, 60, 200, 20);
                if(nameUser.getText().compareTo("") == 0) {
                    nameUser.setText("Вася Пункин");
                }
                creatBut(bt3, panel, 390, 410, 179, 88);
                bt3.addActionListener((ActionEvent e2) -> {
                    // при нажатии кнопки "Пуск"
                    flag = true;
                    frame.remove(panel);
                    frame.revalidate();
                    frame.repaint();
                    frame.getContentPane().add(panel2);
                    creatBut(nad, panel2, 740, 600, 113, 48);
                    nad.addActionListener((ActionEvent e4) -> {
                        GraphGameOver();
                    });
                    creatPBox(panel2, dov, 71, 547, 139, 31);
                    creatPBox(panel2, zdo, 71, 582, 139, 31);
                    creatPBox(panel2, bez, 71, 617, 139, 31);
                    creatPBox(panel2, dos, 280, 547, 139, 31);
                    creatPBox(panel2, obr, 280, 582, 139, 31);
                    creatPBox(panel2, zan, 280, 617, 139, 31);
                    creatPBox(panel2, pot, 489, 547, 139, 31);
                    creatPBox(panel2, nas, 489, 582, 139, 31);
                    creatPBox(panel2, kaz, 489, 617, 139, 31);
                    creatPBox(panel2, tai, 740, 547, 124, 48);
                    creatPBox(panel2, ok1, 222, 547, 44, 31);
                    creatPBox(panel2, ok2, 222, 582, 44, 31);
                    creatPBox(panel2, ok3, 222, 617, 44, 31);
                    creatPBox(panel2, ok4, 431, 547, 44, 31);
                    creatPBox(panel2, ok5, 431, 582, 44, 31);
                    creatPBox(panel2, ok6, 431, 617, 44, 31);
                    creatPBox(panel2, ok7, 640, 547, 44, 31);
                    creatPBox(panel2, ok8, 640, 582, 68, 31);
                    creatPBox(panel2, ok9, 640, 617, 68, 31);
                    creatLab(dov2, font, null, ok1, 12, 6, 30, 20);
                    creatLab(zdo2, font, null, ok2, 12, 6, 30, 20);
                    creatLab(bez2, font, null, ok3, 12, 6, 30, 20);
                    creatLab(dos2, font, null, ok4, 12, 6, 30, 20);
                    creatLab(obr2, font, null, ok5, 12, 6, 30, 20);
                    creatLab(zan2, font, null, ok6, 12, 6, 30, 20);
                    creatLab(pot2, font, null, ok7, 12, 6, 30, 20);
                    creatLab(nas2, font, null, ok8, 12, 6, 100, 20);
                    creatLab(kaz2, font, null, ok9, 12, 6, 100, 20);
                    creatLab(tai2, font2, null, tai, 17, 13, 100, 25);
                    creatPBox(panel2, frameSit, 270, 150, 400, 193);
                    creatBut(fer, panel2, 55, 20, 120, 123);
                    creatBut(sko, panel2, 760, 20, 120, 123);
                    creatBut(sel, panel2, 768, 200, 120, 123);
                    creatBut(lab, panel2, 178, 168, 120, 123);
                    creatBut(mag, panel2, 290, 150, 120, 123);
                    creatBut(dk, panel2, 441, 315, 120, 123);
                    creatBut(bol, panel2, 33, 155, 120, 123);
                    creatBut(kla, panel2, 640, 20, 90, 92);
                    creatBut(kol, panel2, 694, 98, 90, 92);
                    creatBut(pol, panel2, 687, 210, 90, 92);
                    creatBut(ele, panel2, 495, 55, 120, 123);
                    creatBut(dom, panel2, 230, 345, 120, 123);
                    creatPBox(panel2, framePar, 650, 335, 230, 180);
                    creatBut(exit, framePar, 195, 0, 35, 33);
                    creatLab(name, font3, null, framePar, 10, 7, 200, 28); 
                    framePar.setVisible(false);
                    creatLab(level, font, null, framePar, 10, 50, 200, 20);
                    levelCost.setFont(font);
                    levelCost.setForeground(Color.YELLOW);
                    framePar.add(levelCost);
                    levelCost.setBounds(10, 75, 200, 20);
                    creatBut(pov, framePar, 15, 120, 95, 36);
                    creatBut(raz, framePar, 120, 120, 95, 36);
                    creatBut(vost, framePar, 120, 120, 95, 36);
                    frameSit.setVisible(false);
                    frameSit.add(nameSit);
                    nameSit.setBounds(15, 20, 370, 80);
                    nameSit.setFont(font);
                    nameSit.setForeground(Color.YELLOW);
                    creatBut(btVar1, frameSit, 25, 110, 350, 23);
                    creatBut(btVar2, frameSit, 25, 135, 350, 23);
                    creatBut(btVar3, frameSit, 25, 160, 350, 23);
                    creatLab(var1, font, btVar1, null, 15, 115, 350, 20);
                    creatLab(var2, font, btVar2, null, 15, 115, 350, 20);
                    creatLab(var3, font, btVar3, null, 15, 115, 350, 20);  
                    creatLab(change1, font4, null, panel2, 266, 537, 50, 20);
                    creatLab(change2, font4, null, panel2, 266, 572, 50, 20);
                    creatLab(change3, font4, null, panel2, 266, 607, 50, 20);
                    creatLab(change4, font4, null, panel2, 476, 537, 50, 20);
                    creatLab(change5, font4, null, panel2, 476, 572, 50, 20);
                    creatLab(change6, font4, null, panel2, 476, 607, 50, 20);
                    creatLab(change7, font4, null, panel2, 680, 537, 50, 20);
                    creatLab(change8, font4, null, panel2, 708, 572, 50, 20);
                    creatLab(change9, font4, null, panel2, 708, 607, 100, 20);
                    creatPBox(panel2, mas, 50, 125, 50, 22);
                });
            });
        });
    };
    //Метод обнуления данных
    public void ChangeObnul() {
        change1.setText("");
        change2.setText("");
        change3.setText("");
        change4.setText("");
        change5.setText("");
        change6.setText("");
        change7.setText("");
        change8.setText("");
        change9.setText("");
    }
    //Метод, который выводит прирост параметров
    public void Change(int chang1, int chang2, int chang3, int chang4, int chang5, int chang6, int chang7, int chang8, int chang9) {
        if(chang1 > 0) {
            change1.setText("+" + chang1);
        }
        else if(chang1 < 0) {
            change1.setText("" + chang1);
        }
        if(chang2 > 0) {
            change2.setText("+" + chang2);
        }
        else if(chang2 < 0) {
            change2.setText("" + chang2);
        }
        if(chang3 > 0) {
            change3.setText("+" + chang3);
        }
        else if(chang3 < 0) {
            change3.setText("" + chang3);
        }
        if(chang4 > 0) {
            change4.setText("+" + chang4);
        }
        else if(chang4 < 0) {
            change4.setText("" + chang4);
        }
        if(chang5 > 0) {
            change5.setText("+" + chang5);
        }
        else if(chang5 < 0) {
            change5.setText("" + chang5);
        }
        if(chang6 > 0) {
            change6.setText("+" + chang6);
        }
        else if(chang6 < 0) {
            change6.setText("" + chang6);
        }
        if(chang7 > 0) {
            change7.setText("+" + chang7);
        }
        else if(chang7 < 0) {
            change7.setText("" + chang7);
        }
        if(chang8 > 0) {
            change8.setText("+" + chang8);
        }
        else if(chang8 < 0) {
            change8.setText("" + chang8);
        }
        if(chang9 > 0) {
            change9.setText("+" + chang9);
        }
        else if(chang9 < 0) {
            change9.setText("" + chang9);
        }
    }
    //Метод, который изменяет картинку
    public void modBut(String Imgage, JButton button) {
        button.setIcon(new ImageIcon(Imgage));
    }
    //Метод, создающий pictureBox
    public void creatPBox(pictureBox pB, pictureBox picture, int x, int y, int w, int h) {
        pB.add(picture);
        picture.setBounds(x, y, w, h);
    }
    //Метод, создающий JButton
    public void creatBut(JButton button, pictureBox picture, int x, int y, int w, int h) {
        button.setBounds(x, y, w, h);                            
        picture.add(button);  
        button.setVisible(true); 
        button.setContentAreaFilled(false);
        button.setFocusable(false);
        button.setBorderPainted(false);
    }
    //Метод, создающий JButton
    public void creatLab(JLabel label, Font font, JButton button, pictureBox picture, int x, int y, int w, int h) {
        label.setFont(font);
        label.setForeground(Color.YELLOW);
        if(picture == null) 
            button.add(label);
        else
            picture.add(label);
        label.setBounds(x, y, w, h); //  left,top,width,height
    }
    //Метод, выводящий объекты после проигрыша
    public void GraphGameOver() {
        frame.remove(panel2);
        frame.revalidate();
        frame.repaint();
        panel = new pictureBox(new ImageIcon("pred.PNG").getImage());
        frame.add(panel);
        creatPBox(panel, gameO, 60, 10, 800, 597);
        creatBut(vih, panel, 375, 610, 179, 87);
        creatLab(nam, font2, null, gameO, 315, 112, 300, 20);
        creatLab(rez, font2, null, gameO, 500, 152, 100, 20);
        creatLab(pl, font2, null, gameO, 350, 192, 50, 20);
        creatLab(top, font2, null, gameO, 190, 205, 400, 400);
        vih.addActionListener((ActionEvent e) -> {
             System.exit(0);
        });
    }
    //Метод, изменяющий состояние динамических объектов
    public void cheliki(UserTimer uT) {
        for(int i = 0; i < 30; i++) {
            if(uT.seconds > 1 || uT.minutes > 0 || uT.hours > 0) {
                panel2.remove(chel1[i]);
                panel2.remove(chel2[i]);
                panel2.remove(chel3[i]);
            }
            chel1[i] = new pictureBox(new ImageIcon("chel1.png").getImage());
            chel2[i] = new pictureBox(new ImageIcon("chel2.png").getImage());
            chel3[i] = new pictureBox(new ImageIcon("chel3.PNG").getImage());
        }
    }
    //Метод создания динамических объектов
    public void chelikiCreat(int ind, int a, int b, int k, int l, int r, int s) {
        creatPBox(panel2, chel1[ind], a, b, 30, 30);
        creatPBox(panel2, chel2[ind], k, l, 14, 31);
        creatPBox(panel2, chel3[ind], r, s, 15, 26);
    }
    @Override  //переопределение метода
    protected void paintComponent(Graphics g) {
         super.paintComponent(g); //обнуление ситуации    
    }
}
