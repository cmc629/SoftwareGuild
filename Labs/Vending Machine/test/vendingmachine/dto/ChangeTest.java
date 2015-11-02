/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dto;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class ChangeTest {

    Change c;

    public ChangeTest() {
    }

    @Before
    public void setUp() {
        c = new Change(72);
    }

    @Test
    public void testGetPennies() {
        assertEquals(2, c.getPennies());
    }

    @Test
    public void testGetNickels() {
        assertEquals(0, c.getNickels());
    }

    @Test
    public void testGetDimes() {
        assertEquals(2, c.getDimes());
    }

    @Test
    public void testGetQuarters() {
        assertEquals(2, c.getQuarters());
    }

    @Test
    public void testHashCode() {
    }

    @Test
    public void testEquals() {
    }

}
