/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Christian Choi
 */
public class QueueImplTest {

    //Queue<String> queue = new QueueImpl(5);
    Queue<String> queue = new QueueLinkedListImpl();

    public QueueImplTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of enqueue method, of class QueueImpl.
     */
    @Test
    public void testEnqueue() {

        for (int i = 0; i < 50; i++) {
            queue.enqueue(new String());
        }
        assertEquals(50, queue.size());

    }

    /**
     * Test of dequeue method, of class QueueImpl.
     */
    @Test
    public void testDequeue() {

        Deque<String> expectedQueue = new ArrayDeque();
        String[] expectedArray;
        for (int i = 0; i < 200; i++) {
            String obj = new String();
            expectedQueue.add(obj);
            queue.enqueue(obj);
        }
        expectedArray = expectedQueue.toArray(new String[queue.size()]);

        for (int i = 0; i < 200; i++) {
            String expected = expectedQueue.poll();
            String actual = queue.dequeue();

            assertEquals(expected, actual);
        }
    }
    
    @Test
    public void testEnqueueDequeueUnbounded() {
        
        String one = "One";
        String two = "Two";
        String three = "Three";
        String four = "Four";
        String five = "Five";
        String six = "Six";
        String seven = "Seven";
        String eight = "Eight";
        String nine = "Nine";
        String ten = "Ten";
        
        queue.enqueue(one);
        queue.enqueue(two);
        queue.enqueue(three);
        queue.enqueue(four);
        queue.enqueue(five);
        
        assertEquals(one, queue.dequeue()); //Remove object one
        assertEquals(4, queue.size()); //Size should be 4
        
        queue.enqueue(six); 
        queue.enqueue(ten);
        queue.enqueue(eight);
        queue.enqueue(nine);
        queue.enqueue(seven);
        
        assertEquals(9, queue.size()); //Added 5 more. Size should be 9
        //Start dequeuing everything
        assertEquals("Two", queue.dequeue());
        assertEquals("Three", queue.dequeue());
        assertEquals("Four", queue.dequeue());
        assertEquals("Five", queue.dequeue());
        assertEquals("Six", queue.dequeue());
        assertEquals("Ten", queue.dequeue());
        assertEquals("Eight", queue.dequeue());
        assertEquals("Nine", queue.dequeue());
        assertEquals("Seven", queue.dequeue());
        
    }

    /**
     * Test of isEmpty method, of class QueueImpl.
     */
    @Test
    public void testIsEmpty() {

        assertTrue(queue.isEmpty());

        queue.enqueue(new String());
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());

    }

    /**
     * Test of size method, of class QueueImpl.
     */
    @Test
    public void testSize() {

        assertEquals(0, queue.size());

        queue.enqueue(new String());
        assertEquals(1, queue.size());

    }
    
    @Test
    public void testIter() {
        
        String one = "One";
        String two = "Two";
        String three = "Three";
        String four = "Four";
        String five = "Five";
        String six = "Six";
        String seven = "Seven";
        String eight = "Eight";
        String nine = "Nine";
        String ten = "Ten";
        
        queue.enqueue(one);
        queue.enqueue(two);
        queue.enqueue(three);
        queue.enqueue(four);
        queue.enqueue(five);
        queue.enqueue(six); 
        queue.enqueue(ten);
        queue.enqueue(eight);
        queue.enqueue(nine);
        queue.enqueue(seven);
        
        
        Deque<String> deque = new ArrayDeque();
        
        deque.add(one);
        deque.add(two);
        deque.add(three);
        deque.add(four);
        deque.add(five);
        deque.add(six); 
        deque.add(ten);
        deque.add(eight);
        deque.add(nine);
        deque.add(seven);
        
        for (String string: queue) {
            assertEquals(deque.remove(), string);
        }
   
    }

}
