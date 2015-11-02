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
public abstract class Employee implements SpecializedDTO, Auditable {
    
    protected Integer id;
    private String firstName;
    private String lastName;
    
//    public Employee() {
//        System.out.println("Employee default constructor");
//    }
    
//    public Employee(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }
    
    public abstract void doWork();
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public void printName() {
        System.out.println("First name: " + firstName + " Last name: " + lastName);
    }
        

    
    public void createObjectives() {
        System.out.println("Employee creates objectives");
    }
    
    protected void getReviewed() {
        System.out.println("Get reviewed");
    }
    
}
