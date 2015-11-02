/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statecapitals;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Christian Choi
 */
public class StateCapitals {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Map<String, String> statecapital = new HashMap<>();
        statecapital.put("Alabama" , "Montgomery");
        statecapital.put( "Alaska" , "Juneau");
        statecapital.put("Arizona" , "Phoenix");
        statecapital.put("Arkansas" , "Little Rock");
        statecapital.put("California" , "Sacramento");
        statecapital.put("Colorado" , "Denver");
        statecapital.put("Connecticut" , "Hartford");
        statecapital.put("Delaware" , "Dover");
        statecapital.put("Florida" , "Tallahassee");
        statecapital.put("Georgia" , "Atlanta");
        statecapital.put("Hawaii" , "Honolulu");
        statecapital.put("Idaho" , "Boise");
        statecapital.put("Illinois" , "Springfield");
        statecapital.put("Indiana" , "Indianapolis");
        statecapital.put("Iowa" , "Des Moines");
        statecapital.put("Kansas" , "Topeka");
        statecapital.put("Kentucky" , "Frankfort");
        statecapital.put("Louisiana" , "Baton Rouge");
        statecapital.put("Maine" , "Augusta");
        statecapital.put("Maryland" , "Annapolis");
        statecapital.put("Massachusetts" , "Boston");
        statecapital.put("Michigan" , "Lansing");
        statecapital.put("Minnesota" , "St. Paul");
        statecapital.put("Mississippi" , "Jackson");
        statecapital.put("Missouri" , "Jefferson City");
        statecapital.put("Montana" , "Helena");
        statecapital.put("Nebraska" , "Lincoln");
        statecapital.put("Nevada" , "Carson City");
        statecapital.put("New Hampshire" , "Concord");
        statecapital.put("New Jersey" , "Trenton");
        statecapital.put("New Mexico" , "Santa Fe");
        statecapital.put("New York" , "Albany");
        statecapital.put("North Carolina" , "Raleigh");
        statecapital.put("North Dakota" , "Bismarck");
        statecapital.put("Ohio" , "Columbus");
        statecapital.put("Oklahoma" , "Oklahoma City");
        statecapital.put("Oregon" , "Salem");
        statecapital.put("Pennsylvania" , "Harrisburg");
        statecapital.put("Rhode Island" , "Providence");
        statecapital.put("South Carolina" , "Columbia");
        statecapital.put("South Dakota" , "Pierre");
        statecapital.put("Tennessee" , "Nashville");
        statecapital.put("Texas" , "Austin");
        statecapital.put("Utah" , "Salt Lake City");
        statecapital.put("Vermont" , "Montpelier");
        statecapital.put("Virginia" , "Richmond");
        statecapital.put("Washington" , "Olympia");
        statecapital.put("West Virginia" , "Charleston");
        statecapital.put("Wisconsin" , "Madison");
        statecapital.put("Wyoming" , "Cheyenne");
        
        System.out.println("STATES:\n=======");
        Set<String> keys = statecapital.keySet();
        for(String key : keys) {
            System.out.println(key);
        }
        
        System.out.println("CAPITALS:\n=========");
        Collection<String> values = statecapital.values();
        for(String value : values) {
            System.out.println(value);
        }
        
        System.out.println("STATE/CAPITAL PAIRS:\n====================");
        for(String key : keys) {
            System.out.println(key + " - " + statecapital.get(key));
        }
    }
    
}
