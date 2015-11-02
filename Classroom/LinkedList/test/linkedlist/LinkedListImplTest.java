/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Christian Choi
 */
public class LinkedListImplTest {
    
    SinglyLinkedListImpl<Integer> linkedList = new SinglyLinkedListImpl();
    //DoublyLinkedListImpl<Integer> linkedList = new DoublyLinkedListImpl();
    
    public LinkedListImplTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class SinglyLinkedListImpl.
     */
    @Test
    
    public void testAdd() {
        
        //assert that it's initially empty
        assertTrue(linkedList.isEmpty());
        
        //add one element
        linkedList.add(20);
        
        assertEquals(1, linkedList.size());
        assertFalse(linkedList.isEmpty());
        
        //add second element
        linkedList.add(40);
        
        assertEquals(2, linkedList.size());
        assertFalse(linkedList.isEmpty());
        
    }

    /**
     * Test of add method, of class SinglyLinkedListImpl.
     */
    @Test
    public void testAddIndex() {
        
        //add one element, index should be 0
        linkedList.add(20);
        
        //add element at index 0
        linkedList.add(0, 10);
        
        Integer ten = 10;
        Integer twenty = 20;
        
        assertEquals(2, linkedList.size());
        assertEquals(ten, linkedList.get(0));
        assertEquals(twenty, linkedList.get(1));
        
        //add element at index 1
        linkedList.add(1, 30);
        
        Integer thirty = 30;
        
        assertEquals(3, linkedList.size());
        assertEquals(ten, linkedList.get(0));
        assertEquals(thirty, linkedList.get(1));
        assertEquals(twenty, linkedList.get(2));
        
    }
    
    /**
     * Test of add method, of class SinglyLinkedListImpl.
     */
    @Test (expected = NoSuchElementException.class)
    public void testNullAddIndex() {
        
        //Linked list should be empty! Adding when list doesn't exist should
        //throw NoSuchElementException
        linkedList.add(0, 10);
        
    }
    
    /**
     * Test of add method, of class SinglyLinkedListImpl.
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testOutOfBoundsAddIndex() {
        
        //Add element. Should be at index 0
        linkedList.add(10);
        
        //Add element at index 5. This should throw IndexOutOfBoundsException
        linkedList.add(5, 50);
    }
    
    /**
     * Test of clear method, of class SinglyLinkedListImpl.
     */
    @Test
    public void testClear() {
        
        //Add a bunch of elements to linked list and check the size
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        
        assertEquals(4, linkedList.size());
        assertFalse(linkedList.isEmpty());
        
        //Remove everything!
        linkedList.clear();
        
        assertEquals(0, linkedList.size());
        assertTrue(linkedList.isEmpty());
        
    }

    /**
     * Test of get method, of class SinglyLinkedListImpl.
     */
    @Test
    public void testGet() {
        
        //Add three elements
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        
        Integer ten = 10;
        Integer twenty = 20;
        Integer thirty = 30;
        
        //Test the get method
        assertEquals(ten, linkedList.get(0));
        assertEquals(twenty, linkedList.get(1));
        assertEquals(thirty, linkedList.get(2));
        
    }
    
    /**
     * Test of get method, of class SinglyLinkedListImpl.
     */
    @Test (expected = NoSuchElementException.class)
    public void testNullGet() {
        
        //Get at index 3 when list doesn't exist. Should throw exception.
        linkedList.get(3);
        
    }
    
    /**
     * Test of get method, of class SinglyLinkedListImpl.
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testOutOfBoundsGet() {
        
        //Add three elements. 10 is at index 0, 20 at 1, 30 at 2.
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        
        //Get at index 3. Should throw exception.
        linkedList.get(3);
        
    }

    /**
     * Test of indexOf method, of class SinglyLinkedListImpl.
     */
    @Test
    public void testIndexOf() {
        
        //Add three elements
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        
        Integer ten = 10;
        Integer twenty = 20;
        Integer thirty = 30;
        
        //Test the indexOf method. Should get index 0, 1, 2
        assertEquals(0, linkedList.indexOf(ten));
        assertEquals(1, linkedList.indexOf(twenty));
        assertEquals(2, linkedList.indexOf(thirty));
        
        //Check index of an element that doesn't exist in the list
        //It should return -1
        Integer forty = 40;
        
        assertEquals(-1, linkedList.indexOf(forty));
        
    }

    /**
     * Test of remove method, of class SinglyLinkedListImpl.
     */
    @Test
    public void testRemove() {
        
        //Add three elements
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        
        //Remove 20, which is at index 1. The size should be 2
        assertEquals((Integer) 20, linkedList.remove(1));
        
        //Remove 30, which is now at index 1. The size should be 1
        assertEquals((Integer) 30, linkedList.remove(1));
        
        //Remove 10, which is at index 0. The size should be 0 and list is empty
        assertEquals((Integer) 10, linkedList.remove(0));
        assertEquals(0, linkedList.size());
        assertTrue(linkedList.isEmpty());
        
    }
    
    /**
     * Test of remove method, of class SinglyLinkedListImpl.
     */
    @Test (expected = NoSuchElementException.class)
    public void testNullRemove() {
        
        //Remove element from list that doesn't exist. Should throw exception
        linkedList.remove(0);
        
    }
    
    /**
     * Test of remove method, of class SinglyLinkedListImpl.
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testOutOfBoundsRemove() {
        
        //Add three elements
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        
        //Index 0, 1, 2 exist. Index 4 DOES not exist. Remove at index 4
        //should throw exception
        linkedList.remove(4);
        
    }

    /**
     * Test of isEmpty method, of class SinglyLinkedListImpl.
     */
    @Test
    public void testIsEmpty() {
        
        //Nothing in linked list
        assertTrue(linkedList.isEmpty());
        
        //Add one element and check if it's not empty
        linkedList.add(10);
        
        assertFalse(linkedList.isEmpty());
        
    }

    /**
     * Test of size method, of class SinglyLinkedListImpl.
     */
    @Test
    public void testSize() {
        
        //Nothing in linked list
        assertEquals(0, linkedList.size());
        
        //Add one element and check if size increased
        linkedList.add(10);
        
        assertEquals(1, linkedList.size());
        
    }
    
    
    
    
}
