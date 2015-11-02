/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package city;

/**
 *
 * @author Christian Choi
 */
public class App {
    
    public static void main(String[] args) {
        Cities c = new Cities();
        c.addCities();
        c.printOver2M();
        c.printUnder1M();
        c.printLeastGrowth();
        c.printMostGrowth();
    }
    
}
