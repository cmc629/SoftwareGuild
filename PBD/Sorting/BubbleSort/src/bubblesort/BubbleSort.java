/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;

import java.util.Random;

/**
 *
 * @author Christian Choi
 */
public class BubbleSort {

    /**
     * @param args the command line arguments
     */
    public static void bubble_sort(int[] a) {
        boolean swapped = true;
        int j = 0;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < a.length - j; i++) {
                if (a[i+1] < a[i]) {
                    swap(a, i, i+1);
                    swapped = true;
                }
            }
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[10];
        int i;

        // Fill up the array with random numbers
        for (i = 0; i < arr.length; i++) {
            arr[i] = 1 + r.nextInt(100);
        }

        // Display it
        System.out.print("before: ");
        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Sort it
        bubble_sort(arr);

        // Display it again to confirm that it's sorted
        System.out.print("after : ");
        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
