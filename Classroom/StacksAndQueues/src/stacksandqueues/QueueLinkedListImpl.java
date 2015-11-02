/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacksandqueues;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import linkedlist.DoublyLinkedListImpl;

/**
 *
 * @author Christian Choi
 */
public class QueueLinkedListImpl<T> implements Queue<T> {
    
    private DoublyLinkedListImpl<T> linkedList = new DoublyLinkedListImpl();
    private int changeCount = 0;
    
    @Override
    public void enqueue(T object) {
        changeCount++;
        linkedList.add(object);
    }

    @Override
    public T dequeue() {
        changeCount++;
        return linkedList.remove(0);
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public Object peek() {
        return linkedList.get(0);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator() {
            
            private DoublyLinkedListImpl<T> linkedList = QueueLinkedListImpl.this.linkedList;
            private int idx = 0;
            private int changeCount = QueueLinkedListImpl.this.changeCount;
            
            @Override
            public boolean hasNext() {
                return idx != linkedList.size();
            }

            @Override
            public Object next() {
                if (this.changeCount != QueueLinkedListImpl.this.changeCount) {
                    throw new ConcurrentModificationException();
                }
                if (hasNext()) {
                    T toReturn = linkedList.get(idx++);
                    return toReturn;
                }
                else {
                    throw new NoSuchElementException();
                }
            }
            
        };
    }
    
    
    
}
