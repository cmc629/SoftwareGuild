/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance;

import models.Auditable;

/**
 *
 * @author Christian Choi
 */
public class Auditor {
    
    public void auditChange(Auditable audit) {
        audit.auditChange();
    }
    
}
