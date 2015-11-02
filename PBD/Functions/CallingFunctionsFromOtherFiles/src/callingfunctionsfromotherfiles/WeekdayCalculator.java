/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callingfunctionsfromotherfiles;

/**
 *
 * @author Christian Choi
 */
public class WeekdayCalculator {
        public static boolean is_leap( int year ) {
            // years which are evenly divisible by 4 are leap years,
            // but years divisible by 100 are not leap years,
            // though years divisible by 400 are leap years
        boolean result;

        if ( year%400 == 0 )
            result = true;
        else if ( year%100 == 0 )
            result = false;
        else if ( year%4 == 0 )
            result = true;
        else
            result = false;

        return result;
    }
}
