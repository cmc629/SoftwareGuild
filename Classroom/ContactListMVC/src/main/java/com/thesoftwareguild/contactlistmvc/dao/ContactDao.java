/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.contactlistmvc.dao;

import com.thesoftwareguild.contactlistmvc.models.Contact;
import java.util.List;

/**
 *
 * @author Christian Choi
 */
public interface ContactDao {

    Contact add(Contact contact);

    Contact get(Integer id);

    void remove(Integer id);

    void update(Contact contact);
    
    List<Contact> list();
    
}
