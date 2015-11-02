/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.mavenflooringmastery.daos;

import com.thesoftwareguild.mavenflooringmastery.dtos.AuditEntry;
import com.thesoftwareguild.mavenflooringmastery.dtos.Order;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christian Choi
 */
public class AuditEntryDao {
    
    private final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    public void log(AuditEntry entry) {
        
        try {
            
            PrintWriter out = new PrintWriter(new FileWriter("auditor.txt", true));
            
            String dateTimeString = sdf.format(entry.getDate());
            
            out.printf("Date and Time: %s | Order ID: %d | Status: %s\n",
                    dateTimeString, entry.getOrder().getOrderNumber(), entry.getStatus());
            
            out.flush();
            out.close();
            
        } catch (IOException ex) {
            Logger.getLogger(AuditEntryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
