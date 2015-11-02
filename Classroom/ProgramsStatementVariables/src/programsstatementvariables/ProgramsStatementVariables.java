/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programsstatementvariables;

/**
 *
 * @author apprentice
 */
public class ProgramsStatementVariables {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean active = true;
        active = false;
        
        float money = 3.45f;
        double d = 3.444444;
        
        double pi = 3.14;
        double e2 = 89;
        int e4 = 89;
        
        double e3 = 3.66d;
        
        float s4 = (float) e3;
        
        float s3 = 7.889f;
        
        //String n = null;
        //n.endsWith("x");
        
        int counter;
        counter = 7;
        
        boolean isDone;
        isDone = false;
        
        s3++;
        int d4 = 2+2;
        
        int result;
        result = (int) (e4 + e2);
        
        double r = 8/9;
        
        result = 1 + e4;
        result = 1 + e4 + counter;
        
        result = 2;
        
        result += 4;
        result = result + 4;
        
        result += counter;
        
        
        result = 9 - 5;
        result = e4 - counter;
        
        result -= 4;
        
        result = result - counter;
        result -= counter;
        
        
        
        result = 2 * 3;
        
        result = e4 * counter;
        result = 2 * e4;
        result = 2 * e4 * counter;
        
        result  = 2;
        result *= 4;
        
        //This applies for division as well
        result = 6 / 3;
        
        result = e4 / counter;
        result = e4 / counter / 245 / 500;
        
        result = e4 % counter;
        result = 9 % 3; // answer is 0
        result = 5 % 2; // answer is 1
        
        /*
        Anything I type will not be compiled by Java
        */
    }
    
}
