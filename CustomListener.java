package Totality;
//Класс - слушатель мыши
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class CustomListener implements MouseListener {
    private JButton jB;  
    private Building bui;
    private Village v;
    private Graphic appCus;
    private String im;
    private int xx;
    private int yy;
    private int ww;
    private int hh;
    private ActionListener actionListener1;
    private ActionListener actionListener2;
    private ActionListener actionListener3;
    //Конструктор
    public CustomListener(String Image, JButton button, Graphic appC, Building buiI, Village vil, int x, int y, int w, int h) {
        im = Image;
        jB = button;
        appCus = appC; 
        bui = buiI;
        v = vil;
        xx = x;
        yy = y;
        ww = w;
        hh = h;
    }
    //Клик мыши по объекту
    @Override
    public void mouseClicked(MouseEvent e) {
 
    }
    //Ввод мыши в объект
    @Override
    public void mouseEntered(MouseEvent e) {
        if(bui.working == true) {
            appCus.modBut(im, jB);
        }
        else {
            appCus.modBut("over.PNG", jB);
        }
    }
    //Выход мыши из объекта
    @Override
    public void mouseExited(MouseEvent e) {
        if(bui.working == true) {
            appCus.modBut("proz.PNG", jB);
        }
        else {
            appCus.modBut("over.PNG", jB);
        }
    }
    //Первое нажатие на объект
    @Override
    public void mousePressed(MouseEvent e) {
        appCus.framePar.setVisible(true);
        obnov();
        actionListener1 = new TestActionListener(1);
        appCus.pov.addActionListener(actionListener1);
        actionListener2 = new TestActionListener(2);
        appCus.raz.addActionListener(actionListener2);  
        actionListener3 = new TestActionListener(3);
        appCus.vost.addActionListener(actionListener3);
        appCus.exit.addActionListener((ActionEvent e3) -> {
            appCus.framePar.setVisible(false);
            appCus.pov.removeActionListener(actionListener1);
            appCus.raz.removeActionListener(actionListener2);
            appCus.vost.removeActionListener(actionListener3);
        });   
    }
    @Override
    public void mouseReleased(MouseEvent e) {
              
    }
    //Метод, обновляющий информацию
    private void obnov() {
        appCus.name.setText(bui.name);
        appCus.level.setText("Уровень: " + bui.level);
        if(bui.working == true) {
            appCus.level.setText("Уровень: " + bui.level);
            appCus.raz.setVisible(true);
            if(bui.level == 5) {
                appCus.pov.setVisible(false);
                appCus.levelCost.setText("");
            }
            else {
                appCus.levelCost.setText("Стоимость уровня: " + (int)(bui.CostLevel + bui.CostLevel*bui.level*0.3));
                appCus.pov.setVisible(true);
            }
            appCus.vost.setVisible(false);
        }
        if(bui.working == false) {
            appCus.level.setText("");
            appCus.levelCost.setText("Cтоимость: " + bui.CostOfRestoration);
            appCus.pov.setVisible(false);
            appCus.raz.setVisible(false);
            appCus.vost.setVisible(true);
        }
    }
    //Объект слушателя мыши
    public class TestActionListener implements ActionListener {
        private int i;
        public TestActionListener(int num) {
            i = num;
        }
        public void actionPerformed(ActionEvent e) {
            int ch = v.coffers;
            if(i == 1) {
                if(bui.level < 5) {
                    appCus.levelCost.setText("Стоимость уровня: " + (int)(bui.CostLevel + bui.CostLevel*bui.level*0.3));
                    v.coffers -= (int)(bui.CostLevel + bui.CostLevel*bui.level*0.3);
                    bui.level++;
                    obnov();
                }
            }
            if(i == 2) {
                bui.working = false;
                bui.level = 0;
                appCus.modBut("over.PNG", jB);
                obnov();
            }
            if(i == 3) {
                bui.working = true;
                v.coffers -= bui.CostOfRestoration;
                appCus.modBut("proz.PNG", jB);
                obnov();
            }
            appCus.Change(0, 0, 0, 0, 0, 0, 0, 0, v.coffers - ch);
        }
    }
}
