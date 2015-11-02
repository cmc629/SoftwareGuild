/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schooldatamodeling;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian Choi
 */
public class Course {
    
    private String courseName;
    private int ID;
    private List<Student> listOfStudents;
    
    public Course(String name, int id) {
        this.courseName = name;
        this.ID = id;
        this.listOfStudents = new ArrayList();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(List<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }
    
    public void addStudent(Student student) {
        listOfStudents.add(student);
    }
    
    public void removeStudent(Student student) {
        listOfStudents.remove(student);
    }
    
}
