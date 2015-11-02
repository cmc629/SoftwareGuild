/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fortunecookie;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class FortuneCookie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        
        int num = 1 + r.nextInt(6);
        String message = "";
        switch (num) {
            case 1:
                message = "You will find happiness with a new love.";
                break;
            case 2:
                message = "You will find much pain and suffering in the coming days.";
                break;
            case 3:
                message = "Destiny will bring you to this person.";
                break;
            case 4:
                message = "I feel sorry for you. I'm just so sorry...";
                break;
            case 5:
                message = "Stick with your wife. Else, go find one.";
                break;
            case 6:
                message = "Fortunes don't necessarily tell the truth.";
                break;
        }
        System.out.println("Fortune cookie says: \"" + message + "\".");
        int lucky1 = 1 + r.nextInt(54);
        int lucky2 = 1 + r.nextInt(54);
        int lucky3 = 1 + r.nextInt(54);
        int lucky4 = 1 + r.nextInt(54);
        int lucky5 = 1 + r.nextInt(54);
        int lucky6 = 1 + r.nextInt(54);
        
        System.out.println(lucky1 + " - " + lucky2 + " - " + lucky3 + " - " + lucky4 + " - " + lucky5 + " - " + lucky6);
    }
    
}
