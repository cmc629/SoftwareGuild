/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christian Choi
 */
class Sum {
    
    public int Sum(int[] numbers) {
        int sum = 0;
        for(int i : numbers) {
            sum += i;
        }
        return sum;
    }
    
}
