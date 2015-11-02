/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christian Choi
 */
class KeepLast {
    
    public int[] KeepLast(int[] numbers) {
        
        int lastIndex = numbers.length - 1;
        int newLength = numbers.length*2;
        int newLastIndex = newLength -1;
        int[] newArray = new int[newLength];
        newArray[newLastIndex] = numbers[lastIndex];
        
        return newArray;
    }
    
}
