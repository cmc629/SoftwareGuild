/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.classroster.controllers;

import com.thesoftwareguild.classroster.daos.ClassRosterDao;
import com.thesoftwareguild.classroster.dtos.Student;
import com.thesoftwareguild.classroster.ui.ConsoleIO;
import java.util.List;

/**
 *
 * @author Christian Choi
 */
public class ClassRosterController {
    
    private ClassRosterDao dao = new ClassRosterDao();
    private ConsoleIO con = new ConsoleIO();
    
    public void run() {
        
        boolean keepGoing = true;;
        
        dao.loadRoster();
        
        while(keepGoing) {
            
            printMenu();
            
            int menuSelection = con.promptInt("Please select from the above choices");
            
            switch (menuSelection) {
                case 1:
                    con.printToConsole("Listing student IDs");
                    listAllStudents();
                    break;
                case 2:
                    con.printToConsole("Create new student");
                    createStudent();
                    break;
                case 3:
                    con.printToConsole("Viewing student information");
                    viewStudent();
                    break;
                case 4:
                    con.printToConsole("Removing student...");
                    removeStudent();
                case 5:
                    //exit
            }
            
        }
        
        
        
    }
    
    private void printMenu() {
        con.printToConsole("Here's my menu with 5 different options");
    }
    
    private void viewStudent() {
        
        Integer studentId = con.promptInt("Please enter the ID of the student you wish to view");
        
        Student currentStudent = dao.getStudent(studentId);
        
        if (currentStudent != null) {
            con.printToConsole("ID: " + currentStudent.getId());
            con.printToConsole("First name: " + currentStudent.getFirstName());
        } else {
            con.printToConsole("No student with ID: " + studentId);
        }
        
    }
    
    private void createStudent() {
        
        //Integer studentId = con.readInteger("Please enter a student ID");
        String firstName = con.promptString("Please enter a first name");
        String lastName = con.promptString("Please enter a last name");
        
        Student student = new Student();
        //student.setId(studentId);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        
        dao.addStudent(student);
        
        con.printToConsole("Student with ID " + student.getId() + " created");
        
    }
    
    private void removeStudent() {
        
        Integer studentId = con.promptInt("Please enter the ID of the student to be removed");
        dao.removeStudent(studentId);
        con.printToConsole("Student successfully removed.");
        
    }
    
    private void listAllStudents() {
        
        List<Student> students = dao.getAllStudents();
        
        for (Student student : students) {
            con.printToConsole("First name: " + student.getFirstName() + " Last name: " + student.getLastName());
        }
        
    }
    
}
