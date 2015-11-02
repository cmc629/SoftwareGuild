/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countingdice;

import java.util.Random;

/**
 *
 * @author Christian Choi
 */
public class CountingDice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Random r = new Random();
        int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0;
        for (int i = 1; i <= 50; i++) {
            int dice1 = 1 + r.nextInt(6);
            int dice2 = 1 + r.nextInt(6);
            switch (dice1) {
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;
                case 3:
                    count3++;
                    break;
                case 4:
                    count4++;
                    break;
                case 5:
                    count5++;
                    break;
                case 6:
                    count6++;
                    break;
            }
            switch (dice2) {
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;
                case 3:
                    count3++;
                    break;
                case 4:
                    count4++;
                    break;
                case 5:
                    count5++;
                    break;
                case 6:
                    count6++;
                    break;
            }
        }
        System.out.println("1: " + count1);
        System.out.println("2: " + count2);
        System.out.println("3: " + count3);
        System.out.println("4: " + count4);
        System.out.println("5: " + count5);
        System.out.println("6: " + count6);
    }
    
}
