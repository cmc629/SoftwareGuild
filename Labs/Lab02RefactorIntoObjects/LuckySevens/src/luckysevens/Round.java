/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luckysevens;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class Round {
    
    private int counter;
    private int counterAtMaxMoney;
    private Player player;
    
    public Round() {
        this.counter = 0;
        this.counterAtMaxMoney = 0;
        this.player = new Player();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getCounterAtMaxMoney() {
        return counterAtMaxMoney;
    }

    public void setCounterAtMaxMoney(int counterAtMaxMoney) {
        this.counterAtMaxMoney = counterAtMaxMoney;
    }  
    
    public int askMoneyToBet() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("How many dollars do you have? ");
        String stringMoney = sc.next();
        int currentMoney = Integer.parseInt(stringMoney);
        
        player.setCurrentMoney(currentMoney);
        player.setMaxMoney(currentMoney);
        
        return player.getCurrentMoney();
    }
    
    public int getDiceSum() {
        int diceSum = Dice.rollDice() + Dice.rollDice();
        //System.out.println("You rolled a total of " + diceSum + "!");
        return diceSum;
    }
    
    
    public void playRound() {
        while (player.getCurrentMoney() > 0) {
            int sum = getDiceSum();
            update(sum);
        }
    }

    public void update(int sum) {
        if (sum == 7) {
            player.setCurrentMoney(player.getCurrentMoney() + 4);
            this.counter += 1;
            if (player.getCurrentMoney() > player.getMaxMoney()) {
                player.setMaxMoney(player.getCurrentMoney());
                this.counterAtMaxMoney = this.counter;
            }
        }
        else {
            player.setCurrentMoney(player.getCurrentMoney() - 1);
            this.counter += 1;    
        }
    }

}
