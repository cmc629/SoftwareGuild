/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christian Choi
 */
class HasEven {
    
    public boolean HasEven(int[] a) {
        boolean hasEven = false;
        for (int i = 0; i < a.length; i++) {
            if (a[i]%2 == 0) {
                hasEven = true;
            }
        }
        return hasEven;
    }
    
}
