package Totality;
//Генерация ситуаций
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Situation {
    private int number; //Рандомный номер ситуации
    private int a = 0;
    private int b = 40;
    private String str;
    private String s1;
    private String s2;
    private String s3;
    private int k1;
    private int k2;
    private int k3;
    private int ch[] = new int[9];
    //Конструктор
    public Situation(Graphic g, Village vil) {
        g.frameSit.setVisible(true);
        number = a + (int) (Math.random() * b);
        try{
            FileInputStream fstream = new FileInputStream("developments.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null){
                if(("" + number).compareTo(strLine.substring(0, strLine.indexOf("/"))) == 0) {
                    strLine = strLine.substring(strLine.indexOf("/") + 1, strLine.length());
                    g.nameSit.setText("<html>" + strLine.substring(0, strLine.indexOf("/"))+ "</html>");
                    strLine = strLine.substring(strLine.indexOf("/") + 1, strLine.length());
                    str = strLine.substring(0, strLine.indexOf("/"));
                    strLine = strLine.substring(strLine.indexOf("/") + 1, strLine.length());
                    if(str.substring(0, str.indexOf(" ")).compareTo("Доверие") == 0) {
                        str = str.substring(str.indexOf(" ") + 1, str.length());
                        vil.confidence += Integer.parseInt(str);
                    }
                    else if(str.substring(0, str.indexOf(" ")).compareTo("Здоровье") == 0) {
                        str = str.substring(str.indexOf(" ") + 1, str.length());
                        vil.health += Integer.parseInt(str);
                    }
                    else if(str.substring(0, str.indexOf(" ")).compareTo("Безопасность") == 0) {
                        str = str.substring(str.indexOf(" ") + 1, str.length());
                        vil.security += Integer.parseInt(str);
                    }
                    else if(str.substring(0, str.indexOf(" ")).compareTo("Досуг") == 0) {
                        str = str.substring(str.indexOf(" ") + 1, str.length());
                        vil.leisure += Integer.parseInt(str);
                    }
                    else if(str.substring(0, str.indexOf(" ")).compareTo("Образование") == 0) {
                        str = str.substring(str.indexOf(" ") + 1, str.length());
                        vil.education += Integer.parseInt(str);
                    }
                    else if(str.substring(0, str.indexOf(" ")).compareTo("Знятость") == 0) {
                        str = str.substring(str.indexOf(" ") + 1, str.length());
                        vil.employment += Integer.parseInt(str);
                    }
                    else if(str.substring(0, str.indexOf(" ")).compareTo("Потребность") == 0) {
                        str = str.substring(str.indexOf(" ") + 1, str.length());
                        vil.need += Integer.parseInt(str);
                    }
                    else if(str.substring(0, str.indexOf(" ")).compareTo("Казна") == 0) {
                        str = str.substring(str.indexOf(" ") + 1, str.length());
                        vil.coffers += Integer.parseInt(str);
                    }
                    else if(str.substring(0, str.indexOf(" ")).compareTo("Население") == 0) {
                        str = str.substring(str.indexOf(" ") + 1, str.length());
                        vil.confidence += vil.population * 0.01*Integer.parseInt(str);
                    }
                    g.var1.setText(strLine.substring(0, strLine.indexOf("/")));
                    strLine = strLine.substring(strLine.indexOf("/") + 1, strLine.length());
                    k1 = Integer.parseInt(strLine.substring(0, strLine.indexOf("/")));
                    strLine = strLine.substring(strLine.indexOf("/") + 1, strLine.length());
                    s1 = strLine.substring(0, strLine.indexOf("/"));
                    strLine = strLine.substring(strLine.indexOf("/") + 1, strLine.length());
                    g.btVar1.addActionListener((ActionEvent e) -> {
                        clik(k1, s1, vil, g);
                        g.frameSit.setVisible(false);
                    });
                    g.var2.setText(strLine.substring(0, strLine.indexOf("/")));
                    strLine = strLine.substring(strLine.indexOf("/") + 1, strLine.length());
                    k2 = Integer.parseInt(strLine.substring(0, strLine.indexOf("/")));
                    strLine = strLine.substring(strLine.indexOf("/") + 1, strLine.length());
                    s2 = strLine.substring(0, strLine.indexOf("/"));
                    strLine = strLine.substring(strLine.indexOf("/") + 1, strLine.length());
                    g.btVar2.addActionListener((ActionEvent e) -> {
                        clik(k2, s2, vil, g);
                        g.frameSit.setVisible(false);
                    });
                    g.var3.setText(strLine.substring(0, strLine.indexOf("/")));
                    strLine = strLine.substring(strLine.indexOf("/") + 1, strLine.length());
                    k3 = Integer.parseInt(strLine.substring(0, strLine.indexOf("/")));
                    strLine = strLine.substring(strLine.indexOf("/") + 1, strLine.length());
                    s3 = strLine;
                    g.btVar3.addActionListener((ActionEvent e) -> {
                        clik(k3, s3, vil, g);
                        g.frameSit.setVisible(false);
                    }); 
                }
            }
         }catch (IOException e){
            System.out.println("Ошибка");
         }  
    }
    //Нажатие на вариант исхода ситуации
    public void clik(int kol, String str, Village vil, Graphic g) {
        ch[0] = vil.confidence;
        ch[1] = vil.health;
        ch[2] = vil.security;
        ch[3] = vil.leisure;
        ch[4] = vil.education;
        ch[5] = vil.employment;
        ch[6] = vil.need;
        ch[7] = vil.population;
        ch[8] = vil.coffers;
        for(int i = 0; i < kol; i++) {  
            if(str.substring(0, str.indexOf(" ")).compareTo("Доверие") == 0) {
                str = str.substring(str.indexOf(" ") + 1, str.length());
                vil.confidence += Integer.parseInt(str.substring(0, str.indexOf(" ")));
                str = str.substring(str.indexOf(" ") + 1, str.length());
            }
            else if(str.substring(0, str.indexOf(" ")).compareTo("Здоровье") == 0) {
                str = str.substring(str.indexOf(" ") + 1, str.length());
                vil.health += Integer.parseInt(str.substring(0, str.indexOf(" ")));
                str = str.substring(str.indexOf(" ") + 1, str.length());
            }
            else if(str.substring(0, str.indexOf(" ")).compareTo("Безопасность") == 0) {
                str = str.substring(str.indexOf(" ") + 1, str.length());
                vil.security += Integer.parseInt(str.substring(0, str.indexOf(" ")));
                str = str.substring(str.indexOf(" ") + 1, str.length());
            }
            else if(str.substring(0, str.indexOf(" ")).compareTo("Досуг") == 0) {
                str = str.substring(str.indexOf(" ") + 1, str.length());
                vil.leisure += Integer.parseInt(str.substring(0, str.indexOf(" ")));
                str = str.substring(str.indexOf(" ") + 1, str.length());
            }
            else if(str.substring(0, str.indexOf(" ")).compareTo("Образование") == 0) {
                str = str.substring(str.indexOf(" ") + 1, str.length());
                vil.education += Integer.parseInt(str.substring(0, str.indexOf(" ")));
                str = str.substring(str.indexOf(" ") + 1, str.length());
            }
            else if(str.substring(0, str.indexOf(" ")).compareTo("Знятость") == 0) {
                str = str.substring(str.indexOf(" ") + 1, str.length());
                vil.employment += Integer.parseInt(str.substring(0, str.indexOf(" ")));
                str = str.substring(str.indexOf(" ") + 1, str.length());
            }
            else if(str.substring(0, str.indexOf(" ")).compareTo("Потребность") == 0) {
                str = str.substring(str.indexOf(" ") + 1, str.length());
                vil.need += Integer.parseInt(str.substring(0, str.indexOf(" ")));
                str = str.substring(str.indexOf(" ") + 1, str.length());
            }
            else if(str.substring(0, str.indexOf(" ")).compareTo("Казна") == 0) {
                str = str.substring(str.indexOf(" ") + 1, str.length());
                vil.coffers += Integer.parseInt(str.substring(0, str.indexOf(" ")));
                str = str.substring(str.indexOf(" ") + 1, str.length());
            }
            else if(str.substring(0, str.indexOf(" ")).compareTo("Население") == 0) {
                str = str.substring(str.indexOf(" ") + 1, str.length());
                vil.population += Integer.parseInt(str.substring(0, str.indexOf(" ")));
                str = str.substring(str.indexOf(" ") + 1, str.length());
            }
        }
        g.Change(vil.confidence - ch[0], vil.health - ch[1], vil.security - ch[2],
                        vil.leisure - ch[3], vil.education - ch[4], vil.employment - ch[5],
                        vil.need - ch[6], vil.population - ch[7], vil.coffers - ch[8]);
    } 
}
