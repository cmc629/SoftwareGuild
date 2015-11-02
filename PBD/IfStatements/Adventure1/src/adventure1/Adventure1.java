/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure1;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class Adventure1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("You are in a creepy house! Would you like to go \"upstairs\" or into the \"kitchen\"?");
        
        String option1 = sc.nextLine();
        
        if (option1.equals("kitchen")) {
            System.out.println("There is a long countertop with dirty dishes everywhere. Off to one side there is, as you'd expect, a refrigerator. You may open the \"refrigerator\" or look in a \"cabinet\".");
            
            String option2 = sc.nextLine();
            
            if (option2.equals("refrigerator")) {
                System.out.println("Inside the refrigerator you see food and stuff. It looks prettyy nasty. Would you like to eat some of the food? (\"yes\" or \"no\")");
                
                String option3 = sc.nextLine();
                
                if (option3.equals("no")) {
                    System.out.println("You die of starvation... eventually.");
                } else if (option3.equals("yes")) {
                    System.out.println("You take a bit of what you see. It doesn't actually taste too bad? You continue to eat it and leave the house feeling content.");
                }
            } else if (option2.equals("cabinet")) {
                System.out.println("Inside the cabinet you see a whole bunch of pills and a piece of crumbled paper. Do you want to look at the paper? (\"yes\" or \"no\")");
                
                String option3 = sc.nextLine();
                
                if (option3.equals("no")) {
                    System.out.println("You decide not to look at it, but you are left quite curious.");
                } else if (option3.equals("yes")) {
                    System.out.println("You see a name of a person. Could it be the owner of the house? You wonder where he is...");
                }
            }
            
        } else if (option1.equals("upstairs")) {
            System.out.println("Upstairs you see a hallway. At the end of the hallway is the master \"bedroom\". There is also a \"bathroom\" off the hallway. Where would you like to go?");
            
            String option2 = sc.nextLine();
            
            if (option2.equals("bedroom")) {
                
                System.out.println("You are in a plush bedroom, with expensive-looking hardwood furniture. The bed is unmade. In the back of the room, the closet door is ajar. Would you like to open the door? (\"yeys\" or \"no\")");
                
                String option3 = sc.nextLine();
                
                if (option3.equals("no")) {
                    System.out.println("Well, then I guess you'll never know what was in there. Thanks for playing, I'm tired of making nested if statements.");
                } else if (option3.equals("yes")) {
                    System.out.println("A man pops out of the closet and repeatedly stabs you with a knife. RIP.");
                }
            
            } else if (option2.equals("bathroom")) {
                System.out.println("Upon entering the bathroom, you smell a foul odor. You try to trace the smell by looking in the toilet and the tub. You see flies hovering around the cabinet over the sink. Do you want to open it? (\"yes\" or \"no\")");
                
                String option3 = sc.nextLine();
                
                if (option3.equals("no")) {
                    System.out.println("I guess you'll never know what was in there. Thanks for playing, I'm tired of making nested if statements.");
                } else if (option3.equals("yes")) {
                    System.out.println("You see a dead body...");
                }
            }
            
        }
        
        
    }
    
}
