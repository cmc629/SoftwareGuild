/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schooldatamodeling;

import java.util.List;

/**
 *
 * @author Christian Choi
 */
public class SchoolDataModeling {

    private List<Course> courseList;
    private List<Student> studentList;
    private int numCourses;

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public int getNumCourses() {
        return numCourses;
    }

    public void setNumCourses(int numCourses) {
        this.numCourses = numCourses;
    }


    public void addCourse(String name, int id) {
        Course course = new Course(name, id);
        this.courseList.add(course);
        this.numCourses++;
    }

    public void removeCourse(Course course) {
        this.courseList.remove(course);
        this.numCourses--;
    }
    
    public void addExistingStudentToCourse(Student student, Course course) {
        student.addCourse(course);
    }
    
    public void addNewStudentToCourse(String name, String email, Course course) {
        Student newStudent = new Student(name, email);
        newStudent.addCourse(course);
        this.studentList.add(newStudent);
    }
    
    public void removeStudentFromCourse(Student student, Course course) {
        student.removeCourse(course);
    }

    public List<Student> getListofStudents(Course course) {
        return course.getListOfStudents();
    }
  
}

