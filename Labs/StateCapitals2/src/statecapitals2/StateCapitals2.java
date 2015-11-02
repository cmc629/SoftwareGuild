/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statecapitals2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Christian Choi
 */
public class StateCapitals2 {
    
    private Map<String, Capital> map;

    /**
     * @param args the command line arguments
     */
    public StateCapitals2() {
        this.map = new HashMap<>(); 
    }

    public Map<String, Capital> getMap() {
        return map;
    }

    public void setMap(Map<String, Capital> map) {
        this.map = map;
    }
    
    
    public static void main(String[] args) {
        Map<String, Capital> sc2 = new HashMap<>();

        sc2.put("Alabama", new Capital("Montgomery", 205764, 156));
        sc2.put("Alaska", new Capital("Juneau", 32167, 3255));
        sc2.put("Arizona", new Capital("Phoenix", 1445623, 518));
        sc2.put("Arkansas", new Capital("Little Rock", 193254, 117));
        sc2.put("California", new Capital("Sacramento", 466488, 100));
        sc2.put("Colorado", new Capital("Denver", 600158, 155));
        sc2.put("Connecticut", new Capital("Hartford", 124893, 18));
        sc2.put("Delaware", new Capital("Dover", 36047, 23));
        sc2.put("Florida", new Capital("Tallahassee", 181376, 104));
        sc2.put("Georgia", new Capital("Atlanta", 447841, 132));
        sc2.put("Hawaii", new Capital("Honolulu", 390738, 68));
        sc2.put("Idaho", new Capital("Boise", 205671, 80));
        sc2.put("Illinois", new Capital("Springfield", 117006, 66));
        sc2.put("Indiana", new Capital("Indianapolis", 820445, 372));
        sc2.put("Iowa", new Capital("Des Moines", 203433, 83));
        sc2.put("Kansas", new Capital("Topeka", 127473, 61));
        sc2.put("Kentucky", new Capital("Frankfort", 25527, 15));
        sc2.put("Louisiana", new Capital("Baton Rouge", 229553, 79));
        sc2.put("Maine", new Capital("Augusta", 18946, 58));
        sc2.put("Maryland", new Capital("Annapolis", 38394, 21));
        sc2.put("Massachusetts", new Capital("Boston", 655884, 90));
        sc2.put("Michigan", new Capital("Lansing", 114297, 37));
        sc2.put("Minnesota", new Capital("St. Paul", 285068, 56));
        sc2.put("Mississippi", new Capital("Jackson", 173514, 278));
        sc2.put("Missouri", new Capital("Jefferson City", 43079, 38));
        sc2.put("Montana", new Capital("Helena", 28190, 16));
        sc2.put("Nebraska", new Capital("Lincoln", 258379, 92));
        sc2.put("Nevada", new Capital("Carson City", 62580, 157));
        sc2.put("New Hampshire", new Capital("Concord", 42695, 68));
        sc2.put("New Jersey", new Capital("Trenton", 84913, 8));
        sc2.put("New Mexico", new Capital("Santa Fe", 67947, 37));
        sc2.put("New York", new Capital("Albany", 100104, 22));
        sc2.put("North Carolina", new Capital("Raleigh", 431746, 145));
        sc2.put("North Dakota", new Capital("Bismarck", 61272, 31));
        sc2.put("Ohio", new Capital("Columbus", 787033, 223));
        sc2.put("Oklahoma", new Capital("Oklahoma City", 579999, 620));
        sc2.put("Oregon", new Capital("Salem", 154637, 48));
        sc2.put("Pennsylvania", new Capital("Harrisburg", 49528, 11));
        sc2.put("Rhode Island", new Capital("Providence", 178042, 26));
        sc2.put("South Carolina", new Capital("Columbia", 129272, 135));
        sc2.put("South Dakota", new Capital("Pierre", 13646, 13));
        sc2.put("Tennessee", new Capital("Nashville", 658602, 526));
        sc2.put("Texas", new Capital("Austin", 912791, 272));
        sc2.put("Utah", new Capital("Salt Lake City", 186440, 110));
        sc2.put("Vermont", new Capital("Montpelier", 7855, 10));
        sc2.put("Virginia", new Capital("Richmond", 217853, 63));
        sc2.put("Washington", new Capital("Olympia", 46479, 20));
        sc2.put("West Virginia", new Capital("Charleston", 51400, 33));
        sc2.put("Wisconsin", new Capital("Madison", 233209, 94));
        sc2.put("Wyoming", new Capital("Cheyenne", 59466, 25));
        
        Set<String> keys = sc2.keySet();
        System.out.println("STATE/CAPITAL PAIRS:\n====================");
        for (String key : keys) {
            System.out.println(key + " - " + sc2.get(key).getName() + " | Pop: " 
                    + sc2.get(key).getPopulation() + " | Area: " + 
                    sc2.get(key).getArea() + " sq mi");
        } 
        
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPlease enter the lower limit for capital city population:");
        int min = Integer.parseInt(sc.nextLine());
        
        System.out.println("LIST CAPITALS WITH POPULATIONS GREATER THAN " + min);
        for (String key : keys) {
            if (sc2.get(key).getPopulation() > min) {
                System.out.println(key + " - " + sc2.get(key).getName() + " | Pop: " 
                    + sc2.get(key).getPopulation() + " | Area: " + 
                    sc2.get(key).getArea() + " sq mi");
            }
        }
    }   

}
