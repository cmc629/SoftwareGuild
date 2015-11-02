/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christian Choi
 */
class Double23 {

    public boolean Double23(int[] numbers) {
        
        int count2 = 0;
        int count3 = 0;
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 2) {
                count2++;
            }
            if (numbers[i] == 3) {
                count3++;
            }
        }
        
        return (count2 == 2 || count3 == 3);
}
    
}
