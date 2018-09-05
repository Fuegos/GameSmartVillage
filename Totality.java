/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Totality;

import java.io.FileNotFoundException;
import java.util.Timer;
/**
 *
 * @author Tihchenko Andrey, PI-52.
 */
public class Totality {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Graphic app = new Graphic(); 
        Village utopaevo = new Village(75, 75, 75, 75, 75, 75, 75, 200, 10000, app);
        Timer MyTimer;
        MyTimer = new Timer();
        UserTimer myTask = new UserTimer(MyTimer, 0, app, utopaevo);
        MyTimer.schedule(myTask, 1000, 1000);       
    } 
}
