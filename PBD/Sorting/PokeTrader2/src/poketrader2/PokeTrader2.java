/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poketrader2;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class PokeTrader2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        String[] pokeParty = {"PIKACHU", "CHARMELEON", "GEODUDE", "GYARADOS", "BUTTERFREE", "MANKEY"};

        int a;
        int b;

        do {
            System.out.println("EXCHANGE POKEMON\n");
            for (int i = 0; i < pokeParty.length; i++) {
                System.out.println("    " + i + ". " + pokeParty[i]);
            }

            System.out.print("\nChoose a Pokemon (or -1 to quit). => ");
            a = keyboard.nextInt();

            if (a >= 0) {
                System.out.print("Choose a Pokemon to exchange with " + pokeParty[a] + ". => ");
                b = keyboard.nextInt();

                System.out.println("\nExchanging " + pokeParty[a] + " with " + pokeParty[b] + ".\n");

                String temp = pokeParty[a];
                pokeParty[a] = pokeParty[b];
                pokeParty[b] = temp;
            }

        } while (a >= 0);

    }

}
