/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christian Choi
 */
public class AreTheyTrue {
    
    public static void main(String[] args) {
        System.out.println(howTrue(true, true));
        System.out.println(howTrue(false, false));
        System.out.println(howTrue(true, false));
        System.out.println(howTrue(false, true));
       
    }
    
    public static String howTrue(boolean bool1, boolean bool2) {
        if (bool1 != true && bool2 != true) {
            return "NEITHER";
        } else if (bool1 == true && bool2 == true) {
            return "BOTH";
        } else {
            return "ONLY ONE";
        }    
    }
    
}
