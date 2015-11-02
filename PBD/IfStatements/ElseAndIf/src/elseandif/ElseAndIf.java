/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elseandif;

/**
 *
 * @author apprentice
 */
public class ElseAndIf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int people = 30;
        int cars = 30;
        int buses = 15;
        //else if statements are executed if the initial if statement condition
        //is not met but the else if condition is met.
        //The following if, else if, else statements had the else part removed.
        //After changing the value such that people == cars, the code within
        //the else block is not executed even though it fulfills the else
        //criteria.
        if (cars > people) {
            System.out.println("We should take the cars.");
        }
        else if (cars < people) {
            System.out.println("We should not take the cars.");
        }
        /*else {
            System.out.println("We can't decide.");
        } */


        if (buses > cars) {
            System.out.println("That's too many buses.");
        }
        else if (buses < cars) {
            System.out.println("Maybe we could take the buses.");
        }
        else {
            System.out.println("We still can't decide.");
        }


        if (people > buses) {
            System.out.println("All right, let's just take the buses.");
        }
        else {
            System.out.println("Fine, let's stay home then.");
        }
    }
    
}
