/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.addressbookmvc;

import com.thesoftwareguild.addressbookmvc.daos.AddressBookDao;
import com.thesoftwareguild.addressbookmvc.models.Address;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Christian Choi
 */
public class AddressBookTest {
    
    private AddressBookDao dao;
    
    public AddressBookTest() {
    }
    
    @Before
    public void setUp() {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        
        dao = ctx.getBean("addressBookDao", AddressBookDao.class);
        
        JdbcTemplate template = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        
        template.execute("DELETE FROM address");
        
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
    public void addGetAddress() {
        
        Address address = new Address();
        address.setFirstName("John");
        address.setLastName("Smith");
        address.setStreetNumber("1");
        address.setStreetName("Happy Drive");
        address.setCity("Akron");
        address.setState("OH");
        address.setZip("12345");
        
        Address addedAddress = dao.create(address);
        
        Address fromDb = dao.get(addedAddress.getId());
        
        Assert.assertEquals(fromDb.getFirstName(), address.getFirstName());
        Assert.assertEquals(fromDb.getLastName(), address.getLastName());
        Assert.assertEquals(fromDb.getStreetNumber(), address.getStreetNumber());
        Assert.assertEquals(fromDb.getStreetName(), address.getStreetName());
        Assert.assertEquals(fromDb.getCity(), address.getCity());
        Assert.assertEquals(fromDb.getState(), address.getState());
        Assert.assertEquals(fromDb.getZip(), address.getZip());
        
        
    }
    
    @Test
    public void updateAddress() {
        
        //Add a new address to the database. Create address was already tested
        Address address = new Address();
        address.setFirstName("Mary");
        address.setLastName("Swanson");
        address.setStreetNumber("2");
        address.setStreetName("Blah St");
        address.setCity("Cleveland");
        address.setState("OH");
        address.setZip("23456");
        
        Address addedAddress = dao.create(address);
        
        //Edit address all fields (except for ID) using setters
        Address editedAddress = new Address();
        editedAddress.setId(addedAddress.getId());
        editedAddress.setFirstName("Billy");
        editedAddress.setLastName("Johnson");
        editedAddress.setStreetNumber("45");
        editedAddress.setStreetName("Bleh Rd");
        editedAddress.setCity("New York");
        editedAddress.setState("NY");
        editedAddress.setZip("10085");
        
        dao.update(editedAddress);
        
        //Get the address from database using the OLD address object's ID
        Address fromDb = dao.get(addedAddress.getId());
        
        //Test editedAddress after update
        Assert.assertEquals(fromDb.getFirstName(), editedAddress.getFirstName());
        Assert.assertEquals(fromDb.getLastName(), editedAddress.getLastName());
        Assert.assertEquals(fromDb.getStreetNumber(), editedAddress.getStreetNumber());
        Assert.assertEquals(fromDb.getStreetName(), editedAddress.getStreetName());
        Assert.assertEquals(fromDb.getCity(), editedAddress.getCity());
        Assert.assertEquals(fromDb.getState(), editedAddress.getState());
        Assert.assertEquals(fromDb.getZip(), editedAddress.getZip());
        
    }
    
    @Test
    public void deleteAddress() {
        
        //Add a new address to the database. Create address was already tested
        Address address = new Address();
        address.setFirstName("Mary");
        address.setLastName("Swanson");
        address.setStreetNumber("2");
        address.setStreetName("Blah St");
        address.setCity("Cleveland");
        address.setState("OH");
        address.setZip("23456");
        
        Address addedAddress = dao.create(address);
        
        //Delete Address
        dao.delete(addedAddress.getId());
        
        Assert.assertTrue(dao.list().isEmpty());
        
    }
    
    @Test
    public void testListAddresses() {
        
        //Create and add one address
        Address one = new Address();
        one.setFirstName("Mary");
        one.setLastName("Swanson");
        one.setStreetNumber("2");
        one.setStreetName("Blah St");
        one.setCity("Cleveland");
        one.setState("OH");
        one.setZip("23456");
        
        Address addedAddress = dao.create(one);
        
        //Create and add second address
        
        Address two = new Address();
        two.setFirstName("Billy");
        two.setLastName("Johnson");
        two.setStreetNumber("45");
        two.setStreetName("Bleh Rd");
        two.setCity("New York");
        two.setState("NY");
        two.setZip("10085");
        
        Address addedAddress2 = dao.create(two);
        
        List<Address> list = dao.list();
        Assert.assertEquals(one.getId(), list.get(0).getId());
        Assert.assertEquals(two.getId(), list.get(1).getId());
        
    }
    
    @Test
    public void searchByLastNameTest() {
        
        Address a1 = new Address();
        a1.setFirstName("Charles");
        a1.setLastName("Barkley");
        a1.setStreetNumber("34");
        a1.setStreetName("Auburn St");
        a1.setCity("Philadelphia");
        a1.setState("PA");
        a1.setZip("23555");
        Address addedA1 = dao.create(a1);
        
        Address a2 = new Address();
        a2.setFirstName("Karl");
        a2.setLastName("Malone");
        a2.setStreetNumber("32");
        a2.setStreetName("Power Forward st. ");
        a2.setCity("Salt Lake City");
        a2.setState("UT");
        a2.setZip("45632");
        Address addedA2 = dao.create(a2);
        
        Address a3 = new Address();
        a3.setFirstName("Magic");
        a3.setLastName("Johnson");
        a3.setStreetNumber("32");
        a3.setStreetName("Hollywood Blvd");
        a3.setCity("Los Angeles");
        a3.setState("CA");
        a3.setZip("90025");
        Address addedA3 = dao.create(a3);
        
        List<Address> searchResult = dao.searchByLastName(a1.getLastName());
        
        Assert.assertEquals(a1.getLastName(), searchResult.get(0).getLastName());
        
    }
    
    @Test
    public void searchByStateTest() {
        
        Address a1 = new Address();
        a1.setFirstName("Charles");
        a1.setLastName("Barkley");
        a1.setStreetNumber("34");
        a1.setStreetName("Auburn St");
        a1.setCity("Philadelphia");
        a1.setState("PA");
        a1.setZip("23555");
        Address addedA1 = dao.create(a1);
        
        Address a2 = new Address();
        a2.setFirstName("Karl");
        a2.setLastName("Malone");
        a2.setStreetNumber("32");
        a2.setStreetName("Power Forward st. ");
        a2.setCity("Salt Lake City");
        a2.setState("UT");
        a2.setZip("45632");
        Address addedA2 = dao.create(a2);
        
        Address a3 = new Address();
        a3.setFirstName("Magic");
        a3.setLastName("Johnson");
        a3.setStreetNumber("32");
        a3.setStreetName("Hollywood Blvd");
        a3.setCity("Los Angeles");
        a3.setState("CA");
        a3.setZip("90025");
        Address addedA3 = dao.create(a3);
        
        List<Address> searchResult = dao.searchByState(a1.getState());
        
        Assert.assertEquals(a1.getState(), searchResult.get(0).getState());
        
    }
    
    @Test
    public void searchByCityTest() {
        
        Address a1 = new Address();
        a1.setFirstName("Charles");
        a1.setLastName("Barkley");
        a1.setStreetNumber("34");
        a1.setStreetName("Auburn St");
        a1.setCity("Philadelphia");
        a1.setState("PA");
        a1.setZip("23555");
        Address addedA1 = dao.create(a1);
        
        Address a2 = new Address();
        a2.setFirstName("Karl");
        a2.setLastName("Malone");
        a2.setStreetNumber("32");
        a2.setStreetName("Power Forward st. ");
        a2.setCity("Salt Lake City");
        a2.setState("UT");
        a2.setZip("45632");
        Address addedA2 = dao.create(a2);
        
        Address a3 = new Address();
        a3.setFirstName("Magic");
        a3.setLastName("Johnson");
        a3.setStreetNumber("32");
        a3.setStreetName("Hollywood Blvd");
        a3.setCity("Los Angeles");
        a3.setState("CA");
        a3.setZip("90025");
        Address addedA3 = dao.create(a3);
        
        List<Address> searchResult = dao.searchByCity(a1.getCity());
        
        Assert.assertEquals(a1.getCity(), searchResult.get(0).getCity());
        
    }
    
    @Test
    public void searchByZipTest() {
        
        Address a1 = new Address();
        a1.setFirstName("Charles");
        a1.setLastName("Barkley");
        a1.setStreetNumber("34");
        a1.setStreetName("Auburn St");
        a1.setCity("Philadelphia");
        a1.setState("PA");
        a1.setZip("23555");
        Address addedA1 = dao.create(a1);
        
        Address a2 = new Address();
        a2.setFirstName("Karl");
        a2.setLastName("Malone");
        a2.setStreetNumber("32");
        a2.setStreetName("Power Forward st. ");
        a2.setCity("Salt Lake City");
        a2.setState("UT");
        a2.setZip("45632");
        Address addedA2 = dao.create(a2);
        
        Address a3 = new Address();
        a3.setFirstName("Magic");
        a3.setLastName("Johnson");
        a3.setStreetNumber("32");
        a3.setStreetName("Hollywood Blvd");
        a3.setCity("Los Angeles");
        a3.setState("CA");
        a3.setZip("90025");
        Address addedA3 = dao.create(a3);
        
        List<Address> searchResult = dao.searchByZip(a2.getZip());
        
        Assert.assertEquals(a2.getZip(), searchResult.get(0).getZip());
        
    }
    
}
