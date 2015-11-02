/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monthname;

/**
 *
 * @author Christian Choi
 */
public class MonthName {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println( "Month 1: " + month_name(1) );
        System.out.println( "Month 2: " + month_name(2) );
        System.out.println( "Month 3: " + month_name(3) );
        System.out.println( "Month 4: " + month_name(4) );
        System.out.println( "Month 5: " + month_name(5) );
        System.out.println( "Month 6: " + month_name(6) );
        System.out.println( "Month 7: " + month_name(7) );
        System.out.println( "Month 8: " + month_name(8) );
        System.out.println( "Month 9: " + month_name(9) );
        System.out.println( "Month 10: " + month_name(10) );
        System.out.println( "Month 11: " + month_name(11) );
        System.out.println( "Month 12: " + month_name(12) );
        System.out.println( "Month 43: " + month_name(43) );
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
    
}
