/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Christian Choi
 */
public class Intern extends Employee {

//    public Intern(String firstName, String lastName) {
//        super(firstName, lastName);
//    }
    
    public void doWork() {
        System.out.println("Intern does intern things");
    }
    
    public void createObjectives() {
        System.out.println("Intern objectives: stay employed. Try not to drink too much.");
    }

    @Override
    public void doAudit() {
        System.out.println("Auditing an intern");
    }

    @Override
    public void otherThing() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void auditChange() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
