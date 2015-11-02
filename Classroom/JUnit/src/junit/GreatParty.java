/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junit;

/**
 *
 * @author Christian Choi
 */
public class GreatParty {
    
    
    //greatParty(30, false) - false
    //greatParty(50, false) - true
    //greatParty(70, true) - true
    
    public boolean greatParty(int cigars, boolean isWeekend) {
        if (isWeekend) {
            if (cigars >= 40) {
                return true;
            } else {
                return false;
            }
        } else {
            if (cigars >= 40 && cigars <= 60) {
                return true;
            } else {
                return false;
            }
        }
    }
    
}
