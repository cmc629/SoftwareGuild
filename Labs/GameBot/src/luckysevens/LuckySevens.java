/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luckysevens;

import gamebot.Game;

/**
 *
 * @author apprentice
 */
public class LuckySevens implements Game {

    private Player player;
    private Round round;

    public LuckySevens() {
        this.round = new Round();
        this.player = round.getPlayer();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public void run() {
        System.out.println("\n=====LUCKY SEVENS=====");
        System.out.println("Time to play Lucky Sevens!");
        int money = round.askMoneyToBet();
        player.setCurrentMoney(money);

        round.playRound();

        System.out.println("You are broke after " + round.getCounter() + " rolls.");
        System.out.println("You should have quit after " + round.getCounterAtMaxMoney()
                + " rolls when you had $" + player.getMaxMoney());

    }

    @Override
    public String getName() {
        return "Lucky Sevens";
    }
}
