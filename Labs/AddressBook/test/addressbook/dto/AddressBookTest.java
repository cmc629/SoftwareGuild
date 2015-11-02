/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook.dto;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class AddressBookTest {

    AddressBook ab;

    public AddressBookTest() {
    }

    @Before
    public void setUp() {
        ab = new AddressBook();
    }

    @Test
    public void testAddAddress() {
        ab.addAddress(new Address(1));
        assertTrue(ab.getAllAddresses().contains(new Address(1)));
    }

    @Test(expected = IllegalStateException.class)
    public void testAddDupliateAddress() {
        ab.addAddress(new Address(1));
        ab.addAddress(new Address(1));
    }
}
