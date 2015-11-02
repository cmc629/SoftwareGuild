/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christian Choi
 */
public class Adder {
    
    public static void main(String[] args) {
        System.out.println(add(1,1));
        System.out.println(add(2,3));
        System.out.println(add(5,8));
        System.out.println(add(95,42));
    }
    
    public static int add(int first, int second) {
        return first + second;
    }
    
}
