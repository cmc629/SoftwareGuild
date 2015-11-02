/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christian Choi
 */
class Unlucky1 {
    //We'll say that a 1 immediately followed by a 3 in an array is an "unlucky" 1. 
    //Return true if the given array contains an unlucky 1 in the first 2 or last 2 positions in the array. 
    
    public boolean Unlucky1(int[] numbers) {
        
        int length = numbers.length;
        int lastIndex = length - 1;
        
        boolean containsUnlucky = false;
                 
        if (length >= 3) {
            if (numbers[lastIndex-1] == 1 && numbers[lastIndex] == 3 ) {
                containsUnlucky = true;
            }
            
            if (numbers[0] == 1 && numbers[1] == 3) {
                containsUnlucky = true;
            }
            
            if (numbers[1] == 1 && numbers[2] == 3) {
                containsUnlucky = true;
            }
        }
        
        return containsUnlucky;
        
    }
    
}
