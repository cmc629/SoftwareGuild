/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.olympian;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 *
 * @author Christian Choi
 */
public class SimpleTimerAspect {
    
    
    public Object timeMethod(ProceedingJoinPoint jp) {
        try {
            //getArgs() get all args of whatever method you passed in
            Object retVal = null;
            
            long start = System.currentTimeMillis();
            
            retVal = jp.proceed();
            
            long end = System.currentTimeMillis();
            
            System.out.println("-----------------------------------------");
            System.out.println(jp.getSignature().getName() + " took " + (end - start) + "ms to execute");
            System.out.println("-----------------------------------------");
            
            return retVal;
        } catch (Throwable ex) {
            Logger.getLogger(SimpleTimerAspect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
