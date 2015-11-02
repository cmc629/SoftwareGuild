/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.bodyshop.daos;

import com.thesoftwareguild.bodyshop.dtos.User;
import java.util.List;

/**
 *
 * @author Christian Choi
 */
public interface UserDao {
    
    public User addUser(User user);
    
    public void updateUser(User user);
    
    public User getUser(Integer userId);
    
    public void deleteUser(Integer userId);
    
    public List<User> listUsers();
    
    public List<User> searchByLastName(String lastName);
    
    public List<User> searchByEmail(String email);
    
    public List<User> searchByCity(String city);
    
    public List<User> searchByState(String state);
    
    public List<User> searchByZip(Integer zip);
    
}
