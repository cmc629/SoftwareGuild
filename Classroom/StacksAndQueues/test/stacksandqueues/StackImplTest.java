/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EmptyStackException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Christian Choi
 */
public class StackImplTest {
    
    //Stack<String> stack = new StackImpl(5);
    Stack<String> stack = new StackLinkedListImpl();
    
    public StackImplTest() {
    }
    
    @Before
    public void setUp() {

        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of push method, of class StackImpl.
     */
    @Test
    public void testPush() {
        
        stack.push(new String());
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        
        stack.push(new String());
        assertEquals(2, stack.size());
        
    }

    /**
     * Test of pop method, of class StackImpl.
     */
    @Test
    public void testPop() {
        
        String item = new String();
        
        stack.push(item);
        
        assertEquals(item, stack.pop());
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
                
    }
    
    @Test (expected = EmptyStackException.class)
    public void testPopEmpty() {
        
        stack.pop();
        
    }
    
    @Test
    public void testPushPopUnbounded() {
        
        String one = "One";
        String two = "Two";
        String three = "Three";
        String four = "Four";
        String five = "Five";
        String six = "Six";
        
        stack.push(one);
        stack.push(two);
        stack.push(three);
        stack.push(four);
        stack.push(five); //should be 'full'
        stack.push(six);
        
        assertEquals(6, stack.size());
        assertEquals("Six", stack.pop());
        assertEquals(5, stack.size());
        
        assertEquals("Five", stack.pop());
        assertEquals("Four", stack.pop());
        assertEquals("Three", stack.pop());
        assertEquals("Two", stack.pop());
        assertEquals("One", stack.pop());
        
    }

    /**
     * Test of peek method, of class StackImpl.
     */
    @Test
    public void testPeek() {
        
        String item = new String();
        
        stack.push(item);
        
        assertEquals(item, stack.peek());
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        
        
    }
    
    @Test (expected = EmptyStackException.class)
    public void testPeekEmpty() {
        
        stack.peek();
        
    }

    /**
     * Test of isEmpty method, of class StackImpl.
     */
    @Test
    public void testIsEmpty() {
        
        assertTrue(stack.isEmpty());
        
        stack.push(new String());
        assertFalse(stack.isEmpty());
        
        stack.pop();
        assertTrue(stack.isEmpty());
        
    }

    /**
     * Test of size method, of class StackImpl.
     */
    @Test
    public void testSize() {
        
        assertEquals(0, stack.size());
        
        for (int i = 0; i < 5; i++) {
            stack.push(new String());
        }
        
        assertEquals(5, stack.size());
        
    }
    
    @Test
    public void testIter() {
        
        String one = "One";
        String two = "Two";
        String three = "Three";
        String four = "Four";
        String five = "Five";
        String six = "Six";
        
        Deque<String> deque = new ArrayDeque();
        
        deque.push(six);
        deque.push(five);
        deque.push(four);
        deque.push(three);
        deque.push(two);
        deque.push(one);
        
        for (String string : stack) {
            assertEquals(deque.pop(), string);
        }
        
    }
    
}
