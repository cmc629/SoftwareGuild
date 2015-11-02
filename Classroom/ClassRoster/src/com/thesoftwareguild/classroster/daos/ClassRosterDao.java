/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.classroster.daos;

import com.thesoftwareguild.classroster.dtos.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Christian Choi
 */
public class ClassRosterDao {
    
    private Map<Integer, Student> students = new HashMap<>();
    private static Integer lastId = 0; //only one copy of lastId
    
    public void loadRoster() {
        //similar to decode method
    }
    
    public void writeRoster() {
        //similar to encode method
    }
    
    public Student getStudent(Integer id) {
        return students.get(id);
    }
    
    public Student addStudent(Student student) {
        
        Integer newId = lastId++; //set student to lastId and THEN it increments after assigning
        student.setId(newId);
        
        return students.put(student.getId(), student);
    }
    
    public void removeStudent(Integer id) {
        students.remove(id);
    }
    
    public List<Student> getAllStudents() {
        
        List<Student> result = new ArrayList();
        
        result.addAll(students.values());
        
        return result;
    }
    
}
