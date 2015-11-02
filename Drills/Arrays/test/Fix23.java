/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christian Choi
 */
class Fix23 {
    
    public int[] Fix23(int[] numbers) {

        for (int i = 0; i < 2; i++) {
            if (numbers[i] == 2 && numbers[i+1] == 3) {
                numbers[i+1] = 0;
            }
        }
        return numbers;
    }
    
}
