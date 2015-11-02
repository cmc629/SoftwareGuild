/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.contactlistmvc.dao;

import com.thesoftwareguild.contactlistmvc.models.Contact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Christian Choi
 */
public class ContactDaoImpl implements ContactDao {
    
    private static Integer nextId = 0;
    
    Map<Integer, Contact> contacts = new HashMap<>();
    
    
    
    @Override
    public Contact add(Contact contact) {
        nextId++;
        contact.setId(nextId);
        contacts.put(nextId, contact);
        return contact;
    }
    
    @Override
    public void remove(Integer id) {
        
        contacts.remove(id);
        
    }
    
    @Override
    public void update(Contact contact) {
        
        contacts.put(contact.getId(), contact);
        
    }
    
    @Override
    public Contact get(Integer id) {
        
        return contacts.get(id);
        
    }

    @Override
    public List<Contact> list() {
        return new ArrayList(contacts.values());
    }
    
}
