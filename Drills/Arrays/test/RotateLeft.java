/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christian Choi
 */
class RotateLeft {
    //{5, 11, 9}) -> {11, 9, 5}
    // 0  1   2       1   2   0
    public int[] RotateLeft(int[] numbers) {
        int lastIndex = numbers.length - 1;
        int temp = numbers[0];
        for (int index = 1; index <= lastIndex; index++) {
            numbers[index-1] = numbers[index];
        }
        numbers[lastIndex] = temp;
        return numbers;
    }
    
}
