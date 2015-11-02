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
public class MonthOffset {
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
}
