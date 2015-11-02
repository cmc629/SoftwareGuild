/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christian Choi
 */
class Make2 {
    
    public int[] Make2(int[] a, int[] b) {
        
        int[] array = new int[2];
        
        if (a.length >= 2) {
            array[0] = a[0];
            array[1] = a[1];
        } else if (a.length == 1) {
            array[0] = a[0];
            if (b.length >= 1) {
                array[1] = b[0];
            }
        } else {
            if (b.length >= 2) {
                array[0] = b[0];
                array[1] = b[1];
            }
            if (b.length == 1) {
                array[0] = b[0];
            }
        }
        
        return array;
    }
}
