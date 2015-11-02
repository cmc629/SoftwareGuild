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
public class HiringManager extends Manager {
    
    private void hire() {
        System.out.println("Hiring manager hire");
    }
    
    public void doWork() {
        hire();
    }
    
}
