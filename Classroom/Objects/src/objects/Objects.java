/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author Christian Choi
 */
public class Objects {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        FacebookAccount account = new FacebookAccount("Bill");
        
        FacebookAccount account2 = account;
        
        account.printName();
        account2.printName(); //account2 is a reference to the same object
        
        
        
        Cache cache = new Cache(10);
        
        cache.store(account);
        cache.store(account2);
        
        
    
        
    }
    
}
