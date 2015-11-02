/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weekdaycalculator;

import java.util.Scanner;

/**
 *
 * @author Christian Choi
 */
public class WeekdayCalculator {

    public static void main( String[] args ) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to Mr. Mitchell's fantastic birth-o-meter!");
        System.out.println();
        System.out.println("All you have to do is enter your birth date, and it will");
        System.out.println("tell you the day of the week on which you were born.");
        System.out.println();
        System.out.println("Some automatic tests....");
        System.out.println("12 10 2003 => " + weekday(12,10,2003));
        System.out.println(" 2 13 1976 => " + weekday(2,13,1976));
        System.out.println(" 2 13 1977 => " + weekday(2,13,1977));
        System.out.println(" 7  2 1974 => " + weekday(7,2,1974));
        System.out.println(" 1 15 2003 => " + weekday(1,15,2003));
        System.out.println("10 13 2000 => " + weekday(10,13,2000));
        System.out.println();

        System.out.println("Now it's your turn!  What's your birthday?");
        System.out.print("Birth date (mm dd yyyy): ");
        int mm = keyboard.nextInt();
        int dd = keyboard.nextInt();
        int yyyy = keyboard.nextInt();

        // put a function call for weekday() here
        System.out.print("You were born on ");
        System.out.println(weekday(mm, dd, yyyy));
    }


    public static String weekday( int mm, int dd, int yyyy ) {
        int yy, total;
        String date = "";

        // bunch of calculations go here
        yy = yyyy - 1900;
        total = yy/4;
        total += yy;
        total += dd;
        total += month_offset(mm);
        if (is_leap(yyyy) && (mm == 1 || mm == 2)) {
            total--;
        }
        String day = weekday_name(total % 7);
        date =  day + ", " + month_name(mm) + " " + dd + ", " + yyyy;

        return date;
    }


    // paste your functions from MonthName, WeekdayName, and MonthOffset here

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
    
    public static String month_name(int number) {
        switch (number) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "error";
        }
    }
    
    public static int month_offset( int month ) {
        int result;
        switch (month) {
            case 1:
                result = 1;
                break;
            case 2:
                result = 4;
                break;
            case 3:
                result = 4;
                break;
            case 4:
                result = 0;
                break;
            case 5:
                result = 2;
                break;
            case 6:
                result = 5;
                break;
            case 7:
                result = 0;
                break;
            case 8:
                result = 3;
                break;
            case 9:
                result = 6;
                break;
            case 10:
                result = 1;
                break;
            case 11:
                result = 4;
                break;
            case 12:
                result = 6;
                break;
            default:
                result = -1;
                break;
        }
		
        return result;
    }
    
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
