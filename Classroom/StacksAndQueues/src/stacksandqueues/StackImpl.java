/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacksandqueues;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Christian Choi
 */
public class StackImpl<T> implements Stack<T> {

    private T[] array;
    private int size = 0;
    private int nextIdx = 0;
    private int changeCount = 0;

    public StackImpl(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public StackImpl() {
        this(10);
    }

    @Override
    public void push(T object) {
        if (array.length == size) {
            array = Arrays.copyOf(array, size * 2);
        }
        array[nextIdx++] = object;
        size++;
        changeCount++;
    }

    @Override
    public T pop() {
        if (size != 0) {
            size--;
            changeCount++;
            return array[--nextIdx];
        } else {
            throw new EmptyStackException();
        }
    }

    @Override
    public T peek() {
        if (size != 0) {
            return array[nextIdx - 1];
        } else {
            throw new EmptyStackException();
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator() {
            
            private T[] array = StackImpl.this.array; //StackImpl used to refer to the class outside the inner class
            private int idx = StackImpl.this.nextIdx - 1;
            private int changeCount = StackImpl.this.changeCount;
            
            @Override
            public boolean hasNext() {
                return idx != -1;
            }

            @Override
            public T next() {
                if (this.changeCount != StackImpl.this.changeCount) {
                    throw new ConcurrentModificationException();
                }
                if (hasNext()) {
                    return array[idx--];
                }
                else {
                    throw new NoSuchElementException();
                }
            }
            
        };
    }

}
