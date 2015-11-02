/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christian Choi
 */
class CommonEnd {
    
    public boolean commonEnd(int[] a, int[] b) {
        int arr1LastIndex = a.length - 1;
        int arr2LastIndex = b.length - 1;
        return (a[arr1LastIndex] == b[arr2LastIndex]);
    }
    
}
