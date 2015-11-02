/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maps;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Christian Choi
 */
public class Maps {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Map<String, Integer> populations = new HashMap<>();
        
        populations.put("USA", 313000000); //key USA, value 313000000
        
        populations.put("Canada", 34000000);
        
        populations.put("UK", 63000000);
        
        populations.put("Japan", 127000000);
        
        System.out.println("Map size: " + populations.size());
        
        
        Integer usaPopulation = populations.get("USA");
        
        System.out.println("USA population: " + usaPopulation);
        
        populations.put("USA", 340000000);
        
        usaPopulation = populations.get("USA");
        
        System.out.println("USA population: " + usaPopulation);
    
        Set<String> keys = populations.keySet();
        
        for (String key : keys) {
            System.out.println(key);
        }
        
        Collection<Integer> values = populations.values();
        
        for (Integer value: values) {
            System.out.println(value);
        }
        
        
        for (Map.Entry<String, Integer> entry : populations.entrySet()) {
            
            System.out.println(entry.getKey() + " - " + entry.getValue());
            
        }
        
        for (String key : keys) {
            System.out.println(key + " - " + populations.get(key));
        }
        
//        System.out.println(populations);
//        System.out.println(populations.entrySet());
//        System.out.println(populations.keySet());
//        System.out.println(populations.values());
        
    }
    

}
