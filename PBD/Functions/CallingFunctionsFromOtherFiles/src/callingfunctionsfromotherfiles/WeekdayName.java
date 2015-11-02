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
public class WeekdayName {
    public static String weekday_name(int weekday) {
        
        String result = "";

        if (weekday == 1) {
            result = "Sunday";
        }
        else if (weekday == 2) {
            result = "Monday";
        }
        else if (weekday == 3) {
            result = "Tuesday";
        }
        else if (weekday == 4) {
            result = "Wednesday";
        }
        else if (weekday == 5) {
            result = "Thursday";
        }
        else if (weekday == 6) {
            result = "Friday";
        }
        else if (weekday == 0) {
            result = "Saturday";
        }
        else {
            result = "error";
        }

        return result;
    }
}
