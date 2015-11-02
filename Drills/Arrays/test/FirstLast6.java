/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christian Choi
 */
class FirstLast6 {
    
    
    //Given an array of ints, 
    //return true if 6 appears as either the first or last element in the array.
    //The array will be length 1 or more.
    public boolean firstLast6(int[] numbers) {
        int lastIndex = numbers.length - 1;
        return (numbers[0] == 6 || numbers[lastIndex] == 6);
    }
    
}
