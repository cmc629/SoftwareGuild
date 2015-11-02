/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacksandqueues;

import java.util.ConcurrentModificationException;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import linkedlist.DoublyLinkedListImpl;

/**
 *
 * @author Christian Choi
 */
public class StackLinkedListImpl<T> implements Stack<T> {

    private DoublyLinkedListImpl<T> linkedList = new DoublyLinkedListImpl();
    private int changeCount = 0;
    
    @Override
    public void push(T object) {
        changeCount++;
        linkedList.add(object);
    }

    @Override
    public T pop() {
        if (linkedList.size() != 0) {
            changeCount++;
            return linkedList.remove(linkedList.size() - 1);
        } else {
            throw new EmptyStackException();
        }
    }

    @Override
    public T peek() {
        if (linkedList.size() != 0) {
            return linkedList.get(linkedList.size() - 1);
        } else {
            throw new EmptyStackException();
        }
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
    public Iterator<T> iterator() {
        return new Iterator() {
            
            private DoublyLinkedListImpl<T> linkedList = StackLinkedListImpl.this.linkedList; //StackImpl used to refer to the class outside the inner class
            private int idx = StackLinkedListImpl.this.size() - 1;
            private int changeCount = StackLinkedListImpl.this.changeCount;
            
            @Override
            public boolean hasNext() {
                return idx != -1;
            }

            @Override
            public T next() {
                if (this.changeCount != StackLinkedListImpl.this.changeCount) {
                    throw new ConcurrentModificationException();
                }
                if (hasNext()) {
                    return linkedList.get(idx--);
                }
                else {
                    throw new NoSuchElementException();
                }
            }
            
        };
    }
    
    
    
}
