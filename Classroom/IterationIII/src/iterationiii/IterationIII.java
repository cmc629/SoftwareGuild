/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iterationiii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Christian Choi
 */
public class IterationIII {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Map<String, List<String>> cityMap = new HashMap<>();
        
        List<String> cle = new ArrayList();
        List<String> pit = new ArrayList();
        List<String> cin= new ArrayList();
        List<String> min = new ArrayList();
        List<String> kc = new ArrayList();
        
        cle.add("Browns");
        cle.add("Indians");
        pit.add("Steelers");
        pit.add("Pirates");
        cin.add("Bengals");
        cin.add("Reds");
        min.add("Vikings");
        min.add("Twins");
        kc.add("Chiefs");
        kc.add("Royals");
        
        cityMap.put("Cleveland", cle);
        cityMap.put("Pittsburgh", pit);
        cityMap.put("Cincinnati", cin);
        cityMap.put("Minneapolis", min);
        cityMap.put("Kansas City", kc);;
        
        Set<String> citySet = cityMap.keySet();
        
        for (String city : citySet) {
            System.out.println(city + ":");
            for (String team : cityMap.get(city)) {
                System.out.println(team);
            }
        }
        
    }
    
}
