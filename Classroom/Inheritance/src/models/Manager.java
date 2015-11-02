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
public class Manager extends Employee {
    
    public Manager() {
        //super("Bill", "Jones"); //invoke default constructor of Employee
        System.out.println("Manager parameterless constructor");
    }
    
    private void hire() {
        System.out.println("Manager hired someone");
    }
    
    public void fire() {
        System.out.println("Manager fired someone");
    }
    
    public void givePerformanceReview() {
        System.out.println("Give performance");
    }
    
    public void doWork() {
        //super.doWork();
        System.out.println("Manager does manager things."); 
    }
    
    public void createObjectives() {
        System.out.println("Manager objectives: make sure all employees show up on time and do good work.");
    }


    @Override
    public void doAudit() {
        System.out.println("Auditing a manager");
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
