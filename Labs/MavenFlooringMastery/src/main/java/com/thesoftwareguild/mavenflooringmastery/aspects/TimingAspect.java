/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.mavenflooringmastery.aspects;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 *
 * @author Christian Choi
 */
public class TimingAspect {
    
    public Object timeMethod(ProceedingJoinPoint jp) {
        
        Object ret = null;
        
        try {
            long start = System.currentTimeMillis();
            
            ret = jp.proceed();
            
            long end = System.currentTimeMillis();
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println(jp.getSignature().getName() + " took " + (end - start) + " ms to execute.");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            
        } catch (Throwable ex) {
            System.out.println("Exception in TimingAspect.timeMethod()");
        }
        
        return ret;
    }
    
}
