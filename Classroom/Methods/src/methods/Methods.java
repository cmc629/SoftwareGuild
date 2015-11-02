/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

/**
 *
 * @author apprentice
 */
public class Methods {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int total = calculateTotal(10, 40); //need variable here to store the value total
        calculateTotal();
    }
    //put static here for now b/c static methods can only call other static methods
    public static int calculateTotal(int price, int quantity) { 
        
        int total = price * quantity;
        
        return total;
        
    }
    
    public static void calculateTotal(int price, int quantity, double tax) {
        
    }
    
    public static void calculateTotal() {
        
    }
    
//    public static int calculateTotal() {
//        This will NOT work because it has the same method signature as the method above
//    }
    
    
    
}
