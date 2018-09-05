package Totality;
//Класс - председатель
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chairperson {
    private String name; //Имя пользователя
    private String result; //Результат пользователя
    private String place; //Место по результатам всех игр пользователя
    private String top;
    private Graphic g;
    private boolean ul = false;
    private boolean f1 = false;
    private boolean f2 = false;
    private boolean f3 = false;
    //Конструктор
    public Chairperson(String nam, String res, Graphic appCus) {
        name = nam;
        result = res;
        g = appCus;
        try{
            FileInputStream fstream = new FileInputStream("results.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null){
                place = strLine.substring(0, strLine.indexOf("*"));
                strLine = strLine.substring(strLine.indexOf("*") + 1, strLine.length());
                if(strLine.substring(0, strLine.indexOf("*")).compareTo(name) == 0) {
                    strLine = strLine.substring(strLine.indexOf("*") + 1, strLine.length());
                    ul = compRez(strLine, result, ul);
                    if(ul == true) {
                        result = strLine;
                        f2 = true;
                    }
                    break;
                }
            }
         }catch (IOException e){
            System.out.println("Ошибка");
        }
        if(f2 == false) {
            place = "" + (Integer.parseInt(place) + 1);
        }
        int pl = 0;
        try{
            FileInputStream fstream = new FileInputStream("results.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            String copLine;
            while ((strLine = br.readLine()) != null){
                pl++;
                copLine = strLine;
                strLine = strLine.substring(strLine.indexOf("*") + 1, strLine.length());
                strLine = strLine.substring(strLine.indexOf("*") + 1, strLine.length());
                if(compRez(strLine, result, false) == true) {
                    f1 = true;
                    if(f1 == true) {
                        copLine = obnPlace(copLine, pl+1);
                    }
                    if(f3 != true) {
                        place = "" + pl;
                        if(top != null) {
                            top += pl + "*" + name + "*" + result + "<br>" + copLine + "<br>";
                        }
                        else {
                            top = pl + "*" + name + "*" + result + "<br>" + copLine + "<br>";
                        }
                    }
                    else {
                        top += copLine + "<br>";
                    }
                    f3 = true;

                }
                else {
                    if(f1 == true) {
                        copLine = obnPlace(copLine, pl+1);
                    }
                    if(top != null) {
                        top += copLine + "<br>";
                    }
                    else {
                        top = copLine + "<br>";
                    }
                }
            }
         }catch (IOException e){
            System.out.println("Ошибка");
         }
        if(f1 == false) {
            top += (pl+1) + "*" + name + "*" + result;
        }
        g.top.setText("<html>" + top + "</html>");
        print();
    }
    //Метод сравнения двух результатов
    public boolean compRez(String str, String rez, boolean bool) {
        int h1, h2;
        str += ":";
        rez += ":";
        if(str.compareTo("") != 0) {
            if(str.substring(0, 1).compareTo("0") == 0) {
                h1 = Integer.parseInt(str.substring(1, str.indexOf(":")));
            }
            else {
                h1 = Integer.parseInt(str.substring(0, str.indexOf(":")));
            }
            str = str.substring(str.indexOf(":") + 1, str.length());
            if(rez.substring(0, 1).compareTo("0") == 0) {
                h2 = Integer.parseInt(rez.substring(1, rez.indexOf(":")));
            }
            else {
                h2 = Integer.parseInt(rez.substring(0, rez.indexOf(":")));
            }
            rez = rez.substring(rez.indexOf(":") + 1, rez.length());
            if(h1 > h2) {
                bool = false;
            }
            else if(h1 < h2) {
                bool = true;
            }
            else {
                bool = compRez(str, rez, bool);
            }
        }
        return bool;
    }
    //Метод обновления позиции
    public String obnPlace(String str, int pl) {
        str = str.substring(1, str.length());
        return pl + str;
    }
    //Метод печати результатов игры
    public void print() {
       g.nam.setText(name);
       g.rez.setText(result);
       g.pl.setText("" + place);
    }
}
