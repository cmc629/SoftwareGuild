/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findingprimenumbers;

/**
 *
 * @author Christian Choi
 */
public class FindingPrimeNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i = 2; i <= 100; i++) {
            if (isPrime(i)) System.out.println(i);
        }
    }
    
    public static boolean isPrime(int n) {
        boolean isPrime = true;
        if (n == 2) {
            isPrime = true;
        }
        else {
            for (int i = 2; i < n/2; i++) {
                if (n % i == 0) {
                    isPrime = false;
                }
            }
        }
        return isPrime;
    }
    
}
