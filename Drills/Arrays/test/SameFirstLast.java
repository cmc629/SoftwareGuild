/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christian Choi
 */
class SameFirstLast {

    public boolean SameFirstLast(int[] numbers) {
        int lastIndex = numbers.length - 1;
        return (numbers[0] == numbers[lastIndex]);
    }
}
