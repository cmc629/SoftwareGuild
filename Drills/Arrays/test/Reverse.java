/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christian Choi
 */
class Reverse {
    
    public int[] Reverse(int[] numbers) {
        
        int length = numbers.length;
        int[] reverse = new int[length];
        
        int lastIndex = numbers.length - 1;
        for (int i = 0; i < length; i++) {
            reverse[i] = numbers[lastIndex - i];
        }
        return reverse;
    }
    
}
