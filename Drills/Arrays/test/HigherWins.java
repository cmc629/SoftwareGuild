/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christian Choi
 */
class HigherWins {

    public int[] HigherWins(int[] numbers) {
        int length = numbers.length;
        int lastIndex = numbers.length - 1;
        int[] array = new int[length];
        if (numbers[0] >= numbers[lastIndex])
            for (int i = 0; i <= lastIndex; i++) {
                array[i] = numbers[0];
            }
        else {
            for (int i = 0; i <= lastIndex; i++) {
                array[i] = numbers[lastIndex];
            }
        }
        return array;
    }
    
}
