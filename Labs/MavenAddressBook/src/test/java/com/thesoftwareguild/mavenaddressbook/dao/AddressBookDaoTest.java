package com.thesoftwareguild.mavenaddressbook.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.thesoftwareguild.mavenaddressbook.model.Address;
import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Christian Choi
 */
public class AddressBookDaoTest {
    
    AddressBookDao dao;
    Address a;
    Address b;

    @Before
    public void setUp() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        dao = ctx.getBean("addressBookDao", AddressBookLambdaImpl.class);
        //dao = new AddressBookLambdaImpl(true);
        
        a = new Address();
        a.setFirstName("Damien");
        a.setLastName("Marble");
        a.setCity("Akron");
        a.setState("OH");
        a.setStreetNumber("401");
        a.setStreetName("S Main St");
        a.setZip("44233");


        b = new Address();
        b.setFirstName("Christian");
        b.setLastName("Choi");
        b.setCity("Akron");
        b.setState("OH");
        b.setStreetNumber("401");
        b.setStreetName("S Main St");
        b.setZip("44233");

        dao.create(a);
        dao.create(b);
    }

    @Test
    public void testAddAddress() {
        assertTrue(dao.list().contains(a));
        assertTrue(dao.list().contains(b));
    }


    @Test
    public void testGetAddressesForCity() {
        Collection<Address> addresses = dao.searchByCity("Akron");
        assertTrue(addresses.size() == 2);
        assertTrue(addresses.contains(a));
        assertTrue(addresses.contains(b));
    }

    @Test
    public void testGetAddressesForMissingCity() {
        Collection<Address> addresses = dao.searchByCity("Cincinatti");
        assertTrue(addresses.isEmpty());
        assertFalse(addresses.contains(a));
        assertFalse(addresses.contains(b));
    }


    @Test
    public void testGetAddressesForLastName() {
        Collection<Address> addresses = dao.searchByLastName("Choi");
        assertTrue(addresses.size() == 1);
        assertFalse(addresses.contains(a));
        assertTrue(addresses.contains(b));
    }

    @Test
    public void testGetAddressesForState() {
        List<Address> addresses = dao.searchByState("OH");
        assertTrue(addresses.contains(a));
        assertTrue(addresses.contains(b));
    }


    @Test
    public void testGetAddressesForZip() {
        Collection<Address> addresses = dao.searchByZip("44233");
        assertTrue(addresses.contains(a));
        assertTrue(addresses.contains(b));
    }

    @Test
    public void testGetAllAddresses() {
        assertTrue(dao.list().contains(a));
        assertTrue(dao.list().contains(b));
    }


    @Test
    public void testRemoveAddress() {
        dao.delete(a.getId());
        assertTrue(dao.list().size() == 1);
        assertFalse(dao.list().contains(a));
        assertTrue(dao.list().contains(b));
    }

}
