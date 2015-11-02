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
public class School {
    
    private int numStudents;
    private int numTeachers;
    private String name;
    private String mascot;
    private int numOfGrades;

    public School(int numStudents, int numTeachers, String name, String mascot, int numOfGrades) {
        this.numStudents = numStudents;
        this.numTeachers = numTeachers;
        this.name = name;
        this.mascot = mascot;
        this.numOfGrades = numOfGrades;
    }

    public int getNumStudents() {
        return numStudents;
    }

    public void setNumStudents(int numStudents) {
        this.numStudents = numStudents;
    }

    public int getNumTeachers() {
        return numTeachers;
    }

    public void setNumTeachers(int numTeachers) {
        this.numTeachers = numTeachers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMascot() {
        return mascot;
    }

    public void setMascot(String mascot) {
        this.mascot = mascot;
    }

    public int getNumOfGrades() {
        return numOfGrades;
    }

    public void setNumOfGrades(int numOfGrades) {
        this.numOfGrades = numOfGrades;
    }
    
    public int getSchoolSize() {
        return this.numStudents + this.numTeachers;
    }
    
    public String getSchoolType() {
        if (this.numOfGrades == 4) {
            return "High School";
        } else if (this.numOfGrades == 3) {
            return "Middle School";
        } else {
            return "Elementary School";
        }
    }
    
}
