/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booleanexpressions;

/**
 *
 * @author apprentice
 */
public class BooleanExpressions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        boolean operand1 = false;
        boolean operand2 = true;
        
        if (operand1 == operand2) {
            
        }
        
        if (operand1 != operand2) {
            //execute
        }
        
        if (!operand2) {
            //execute code
        }
        
        if (operand1 == true && operand2 == true) {
            //execute code
        }
        //^ is an "exclusive or" Only going to execute if only one of them is
        //  true. very rarely used
        if (operand1 ^ operand2) {
            //execute code
        }
        
        int int1 = 4;
        int int2 = 5;
        
        if (int1 >= int2) {
            
        }
        
        
        
        if (operand1 == true && operand2 == true) {
            //execute code
        } else if (operand1) {
            
        } else if (operand2) {
            
        } else {
            
        }
        
        int1 = 4;
        
        switch (int1) {
            
            case 3:
                //code for when int1 equals 3
                break;
            case 4:
                //code for when int1 equals 4
                break;
            default:
                //executed if no match found
                break;
                
        }
        
        String testString = "test";
        
        switch(testString) {
            case "test":
                //executed code
                break;
            case "something else":;
                
                break;
            case "football":
                
                break;
            default:
                //executed if no match found
                break;
        }
        
        
        int day = 4;
        String dayName = "";
        
        if (day == 1) {
            dayName = "Monday";
        } else if (day == 2) {
            dayName = "Tuesday";
        } else if (day == 3) {
            dayName = "Wednesday";
        } else if (day == 4) {
            dayName = "Thursday";
        } else if (day == 5) {
            dayName = "Friday";
        } else if (day == 6) {
            dayName = "Saturday";
        } else if (day == 7) {
            dayName = "Sunday";
        } else {
            dayName = "Invalid Day";
        }
        
        switch (day) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            case 7:
                dayName = "Sunday";
                break;
            default:
                dayName = "Invalid Day";
                break;
        }
        
        day = 4;
        String typeOfDay = "";
        
        switch (day) {
            
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                typeOfDay = "Weekday";
                break;
            case 6:
            case 7:
                typeOfDay = "Weekend";
                break;
            default:
                typeOfDay = "Invalid Day";
                break;
            
        }
        
        
        
        
        
        
    }
    
}
