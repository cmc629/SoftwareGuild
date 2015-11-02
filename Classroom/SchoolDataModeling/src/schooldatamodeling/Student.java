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
public class Student {
    
    private String name;
    private String email;
    private List<Course> listOfCourses;
    private List<Course> availableCourses; //might not need this
    
    public Student() {
        
    }


    public Student(String name, String email) {
        this.name = name;
        this.email = email;
        this.listOfCourses = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public List<Course> getListOfCourses() {
        return listOfCourses;
    }

    public void setListOfCourses(List<Course> listOfCourses) {
        this.listOfCourses = listOfCourses;
    }
    
    public Course searchCourseByID(int number) {
        for (Course course : availableCourses) {
            if (course.getID() == number) return course;
        }
        return null;
    }
    
    public Course searchCourseByName(String name) {
        for (Course course : availableCourses) {
            if (course.getCourseName().equals(name)) return course;
        }
        return null;
    }
    
    public void addCourse(Course course) {
        listOfCourses.add(course);
        course.addStudent(this);
    }
    
    public void removeCourse(Course course) {
        listOfCourses.remove(course);
        course.addStudent(this);
    }
    
}
