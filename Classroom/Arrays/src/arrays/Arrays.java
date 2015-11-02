/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

/**
 *
 * @author apprentice
 */
public class Arrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        int[] teamScores;
        
        teamScores = new int[10];
        
        //individually initialize each 'cell'
        teamScores[0] = 2;
        teamScores[1] = 45;
        teamScores[2] = 4;
        teamScores[3] = 11;
        teamScores[4] = 43;
        teamScores[5] = 87;
        teamScores[6] = 98;
        teamScores[7] = 3;
        teamScores[8] = 54;
        teamScores[9] = 34;
        
        int[] teamScores2 = { 2, 45, 4, 8, 99, 23, 67 , 1, 88, 42 };
    
        int teamScoreWeek4 = teamScores[3];
        
        for (int i = 0; i < teamScores.length; i++) {
            System.out.println("Element " + i + " = " + teamScores[i]);
        }
        //this works too for the enhanced for loop if you want to keep count of the index
//        int index = 0;
//        for (int score : teamScores) {
//            index++;
//            System.out.println("Element " + index + " = " + score);
//        }
        
        int min = 0;
        int max = 0;
        int average = 0;
        int sum = 0;
        
        int index = 0;
        for (int score : teamScores) {
            System.out.println("Element = " + score);
            
            if (index == 0) {
                min = score;
                max = score;
                average = score;
            }
            
            //Check if it's the smallest one
            if (score < min) {
                min = score;
            }
            
            //Check if it's the biggest one
            if (score > max) {
                max = score;
            }
            
            //Calculate average
            sum += score;
            
            
            
            index++;
        }
        average = sum / teamScores.length;
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    
        
        
        String[][] teamNames = {
            
            {"Browns", "Cavs", "Indians"},
            {"Bluejackets", "Buckeyes"},
            {"Steelers", "Pirates", "Penguins"}
        
        };
        
        for (String[] names : teamNames) {
            
            for (String name: names) {
                System.out.print(name + " ");
            }
            
            System.out.println();
            
        }
        
    }
    
}
