/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.mavenflooringmastery.aspects;

import com.thesoftwareguild.mavenflooringmastery.daos.AuditEntryDao;
import com.thesoftwareguild.mavenflooringmastery.daos.OrderDao;
import com.thesoftwareguild.mavenflooringmastery.dtos.AuditEntry;
import com.thesoftwareguild.mavenflooringmastery.dtos.Order;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 *
 * @author Christian Choi
 */

public class AuditAspect {

    AuditEntryDao dao = new AuditEntryDao();
    OrderDao odao;
    
    public AuditAspect(OrderDao odao) {
        this.odao = odao;
    }
    
    //This is the advice
    public Object logCreate(ProceedingJoinPoint jp) {
        
        Object retVal = null;
        
        try {
            retVal = jp.proceed();
            
            Order order = (Order) jp.getArgs()[0];
            Date now = new Date();
            AuditEntry entry = new AuditEntry(now, order, "CREATED");

            dao.log(entry);

        } catch (Throwable ex) {
            Logger.getLogger(AuditAspect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retVal;
        
    }
    
    public Object logUpdate(ProceedingJoinPoint jp) {
        
        Object retVal = null;
        
        try {
            retVal = jp.proceed();
            
            Order order = (Order) jp.getArgs()[0];
            Date now = new Date();
            AuditEntry entry = new AuditEntry(now, order, "UPDATED");

            dao.log(entry);
            
        } catch (Throwable ex) {
            Logger.getLogger(AuditAspect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retVal;
        
    }
    
    public Object logDelete(ProceedingJoinPoint jp) {
        
        Object retVal = null;
        
        try {
            //retVal = jp.proceed(); CANT DO THIS BECAUSE AFTER THE METHOD DELETE IN ORDERDAO IS CALLED, the order is gone. It'll throw a nullpointerexception!
            
            Integer orderNumber = (Integer) jp.getArgs()[0]; //This is an Integer because the argument passed in the delete method is an integer
            Order order = odao.get(orderNumber);
            
            retVal = jp.proceed();
            
            Date now = new Date();
            AuditEntry entry = new AuditEntry(now, order, "DELETED");

            dao.log(entry);
            
        } catch (Throwable ex) {
            Logger.getLogger(AuditAspect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retVal;
        
    }
    
}
