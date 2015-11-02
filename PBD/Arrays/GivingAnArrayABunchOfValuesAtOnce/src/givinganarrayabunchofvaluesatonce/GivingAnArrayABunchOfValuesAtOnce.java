/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package givinganarrayabunchofvaluesatonce;

/**
 *
 * @author Christian Choi
 */
public class GivingAnArrayABunchOfValuesAtOnce {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String[] arr1 = {"alpha", "bravo", "charlie", "delta", "echo"};

        System.out.print("The first array is filled with the following values:\n\t");
        
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        
        System.out.println();
        
        int[] arr2 = {11, 23, 37, 41, 53};
        
        System.out.print("The second array is filled with the following values:\n\t");
        
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
    }
    
}
