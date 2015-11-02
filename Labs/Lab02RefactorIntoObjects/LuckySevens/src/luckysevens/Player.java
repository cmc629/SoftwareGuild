/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luckysevens;

/**
 *
 * @author Christian Choi
 */
public class Player {
    
    private int maxMoney;
    private int currentMoney;

    public Player() {
        this.maxMoney = 0;
        this.currentMoney = 0;
    }

    public int getMaxMoney() {
        return maxMoney;
    }

    public void setMaxMoney(int maxMoney) {
        this.maxMoney = maxMoney;
    }

    public int getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(int currentMoney) {
        this.currentMoney = currentMoney;
    } 
    
}
