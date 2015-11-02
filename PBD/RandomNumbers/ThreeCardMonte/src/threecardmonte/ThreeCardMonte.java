/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threecardmonte;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class ThreeCardMonte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int random = 1 + r.nextInt(3);
        
        System.out.println("You slide up to Fast Eddie's card table and plop down your cash.");
        System.out.println("He glances at you out of the corner of his eye and stars shuffling.");
        System.out.println("He lays down three cards.");
        System.out.println("\nWhich one is the ace?\n");
        System.out.println("## ## ##\n## ## ##\n1  2  3");
        int answer = Integer.parseInt(sc.nextLine());
        
        if (answer == random) {
            System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.");
        } else {
            System.out.println("Ha! Fast Eddie wins again! The ace was card number " + random + ".\n");
        }
        
        if (random == 1) {
            System.out.println("AA ## ##\nAA ## ##\n1  2  3");
        } else if (random == 2) {
            System.out.println("## AA ##\n## AA ##\n1  2  3");
        } else {
            System.out.println("## ## AA\n## ## AA\n1  2  3");
        }
    }
    
}
