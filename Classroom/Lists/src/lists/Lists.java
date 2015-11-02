/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Christian Choi
 */
public class Lists {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        List<String> stringList = new ArrayList();
        
        System.out.println("List size: " + stringList.size()); //size is 0
        
        //Add a string to list
        stringList.add("My first string");       
        System.out.println("List size: " + stringList.size()); //size is 1     
        
        //Add a second string
        stringList.add("My second string");        
        System.out.println("List size: " + stringList.size()); //size is 2
        stringList.remove(stringList.indexOf("My first string"));
        //Add an integer WON'T WORK!
//        Integer i = 6;
//        
//        stringList.add(i);      
        //Add a third string
        stringList.add("My third string");    
        System.out.println("List size: " + stringList.size()); //size should be 3
        
        
        //Removing elements
//        stringList.remove(1); //removes item of that index. it removes and all items afterwards gets shifted one index forward        
//        System.out.println("List size: " + stringList.size());
//        
//        stringList.remove(0);
//        System.out.println("List size: " + stringList.size());
//        
//        stringList.remove(0);
//        System.out.println("List size: " + stringList.size());
//        
//        //empty list at this point
//        stringList.remove(0); //get exception error
        
        
        //Use enchanced for loop
        for (String s : stringList) {
            System.out.println(s);
        }
        
        //Use iterator to visit every item as well
        Iterator<String> iter = stringList.iterator(); //iterator method returns iterator object from list
        
        while (iter.hasNext()) {
            String current = iter.next();
            System.out.println(current);
        }
        
        System.out.println(stringList);

    }
    
}
