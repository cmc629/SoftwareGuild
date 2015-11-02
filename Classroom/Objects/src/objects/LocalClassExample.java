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
public class LocalClassExample {
    
    public static void validatePhoneNumber(String phoneNumber1, String phoneNumber2) {
        
        final int numberLength = 10;
        //local class
        class PhoneNumber {
            
            String formattedPhoneNumber = null;
            
            PhoneNumber(String phoneNumber) {
                
            }
            
            public String getNumber() {
                return formattedPhoneNumber;
            }
            
            public void format() {
                
            }
    
        }
        
        PhoneNumber number1 = new PhoneNumber(phoneNumber1);
        PhoneNumber number2 = new PhoneNumber(phoneNumber2);
        number1.format();
        
    }
    
}
