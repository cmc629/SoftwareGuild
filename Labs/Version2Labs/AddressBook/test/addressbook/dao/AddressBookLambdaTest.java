/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook.dao;

import addressbook.data.AddressBookLambdaImpl;
import java.util.Collection;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class AddressBookLambdaTest {

    com.thesoftwareguild.dao.AddressBookDao addressBook;
    com.thesoftwareguild.model.Address a;
    com.thesoftwareguild.model.Address b;

    @Before
    public void setUp() {
        addressBook = new AddressBookLambdaImpl();

        a = new com.thesoftwareguild.model.Address();
        a.setFirstName("Damien");
        a.setLastName("Marble");
        a.setCity("Akron");
        a.setState("OH");
        a.setStreetNumber("401");
        a.setStreetName("S Main St");
        a.setZip("44233");

        b = new com.thesoftwareguild.model.Address();
        b.setFirstName("Christian");
        b.setLastName("Choi");
        b.setCity("Akron");
        b.setState("OH");
        b.setStreetNumber("401");
        b.setStreetName("S Main St");
        b.setZip("44233");

        addressBook.create(a);
        addressBook.create(b);
    }

    @Test
    public void testAddAddress() {
        assertTrue(addressBook.list().contains(a));
        assertTrue(addressBook.list().contains(b));
    }

    @Test
    public void testGetAddressesForCity() {
        Collection<com.thesoftwareguild.model.Address> addresses = addressBook.searchByCity("Akron");
        assertTrue(addresses.size() == 2);
        assertTrue(addresses.contains(a));
        assertTrue(addresses.contains(b));
    }

    @Test
    public void testGetAddressesForMissingCity() {
        Collection<com.thesoftwareguild.model.Address> addresses = addressBook.searchByCity("Cincinatti");
        assertTrue(addresses.isEmpty());
        assertFalse(addresses.contains(a));
        assertFalse(addresses.contains(b));
    }

    @Test
    public void testGetAddressesForLastName() {
        Collection<com.thesoftwareguild.model.Address> addresses = addressBook.searchByLastName("Choi");
        assertTrue(addresses.size() == 1);
        assertFalse(addresses.contains(a));
        assertTrue(addresses.contains(b));
    }

    @Test
    public void testGetAddressesForState() {
        List<com.thesoftwareguild.model.Address> addresses = addressBook.searchByState("OH");
        assertTrue(addresses.contains(a));
        assertTrue(addresses.contains(b));
    }

    @Test
    public void testGetAddressesForZip() {
        Collection<com.thesoftwareguild.model.Address> addresses = addressBook.searchByZip("44233");
        assertTrue(addresses.contains(a));
        assertTrue(addresses.contains(b));
    }

    @Test
    public void testGetAllAddresses() {
        assertTrue(addressBook.list().contains(a));
        assertTrue(addressBook.list().contains(b));
    }

    @Test
    public void testRemoveAddress() {
        addressBook.delete(a.getId());
        assertTrue(addressBook.list().size() == 1);
        assertFalse(addressBook.list().contains(a));
        assertTrue(addressBook.list().contains(b));
    }
}
