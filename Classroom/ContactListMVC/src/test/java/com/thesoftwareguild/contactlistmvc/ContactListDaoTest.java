/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.contactlistmvc;

import com.thesoftwareguild.contactlistmvc.dao.ContactDao;
import com.thesoftwareguild.contactlistmvc.dao.ContactDaoDbImpl;
import com.thesoftwareguild.contactlistmvc.models.Contact;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Christian Choi
 */
public class ContactListDaoTest {
    
    private ContactDao dao;
    
    public ContactListDaoTest() {
    }
    
    @Before
    public void setUp() {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        
        dao = ctx.getBean("contactDao", ContactDao.class);
        
        //look up another bean from our config to wipe everything from database
        JdbcTemplate template = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        
        template.execute("DELETE FROM contact");
        
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void addGetContact() {
        
        Contact contact = new Contact();
        contact.setFirstName("John");
        contact.setLastName("Worley");
        contact.setCompany("Microsoft");
        contact.setPhone("330-931-8288");
        contact.setEmail("john@microsoft.com");
        
        Contact addedContact = dao.add(contact);
        
        Contact fromDb = dao.get(addedContact.getId());
        
        Assert.assertEquals(fromDb.getFirstName(), contact.getFirstName());
        Assert.assertEquals(fromDb.getLastName(), contact.getLastName());
        Assert.assertEquals(fromDb.getCompany(), contact.getCompany());
        Assert.assertEquals(fromDb.getPhone(), contact.getPhone());
        Assert.assertEquals(fromDb.getEmail(), contact.getEmail());
        
    }
}
