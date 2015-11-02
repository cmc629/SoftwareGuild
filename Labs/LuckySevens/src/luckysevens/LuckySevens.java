/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luckysevens;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class LuckySevens {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int currentMoney = askMoneyToBet();
        int maxMoney = currentMoney;
        
        int counter = 0;
        int counterAtMaxMoney = 0;
        
        while (currentMoney > 0) {
            int sum = randomSum();
            
            if (sum == 7) {
                currentMoney += 4;
                counter += 1;
                if (currentMoney > maxMoney) {
                    maxMoney = currentMoney;
                    counterAtMaxMoney = counter;
                }
            }
            else {
                currentMoney -= 1;
                counter += 1;
            }    
        }
        
        System.out.println("You are broke after " + counter + " rolls.");
        System.out.println("You should have quit after " + counterAtMaxMoney +
                " rolls when you had $" + maxMoney);
        
    }
    
    public static int askMoneyToBet() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("How many dollars do you have? ");
        String stringMoney = sc.next();
        
        int currentMoney = Integer.parseInt(stringMoney);
        
        return currentMoney;
    }
    
    public static int randomSum() {
        Random rGen = new Random();
        int dice1 = rGen.nextInt(6) + 1;
        int dice2 = rGen.nextInt(6) + 1;
        int sum = dice1 + dice2;
        return sum;
    }
}
