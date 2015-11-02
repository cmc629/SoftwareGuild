/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacksandqueues;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Christian Choi
 */
public class QueueImpl<T> implements Queue<T> {

    T[] array;
    int head = 0;
    int tail = 0;
    int size = 0;
    int changeCount = 0;

    public QueueImpl(int size) {
        this.array = (T[]) new Object[size];
    }
    
    public QueueImpl() {
        this(10);
    }
    
    @Override
    public void enqueue(T object) {
        
        if (size == array.length) {
            T[] newArray = (T[]) new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[(i + head) % array.length];
            }
            head = 0;
            tail = array.length;
            array = newArray;
        }
        tail %= array.length;
        array[tail++] = object;
        size++;
        changeCount++;
    }

    
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            size--;
            changeCount++;
            T toReturn = (T) array[head];
            head = (head + 1) % array.length;
            return toReturn;

        }
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return (T) array[head];
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
            
            private T[] array = QueueImpl.this.array;
            private int idx = QueueImpl.this.head;
            private int changeCount = QueueImpl.this.changeCount;
            private int iterCount = 0;
            
            @Override
            public boolean hasNext() {
                return iterCount != array.length;
            }

            @Override
            public Object next() {
                if (this.changeCount != QueueImpl.this.changeCount) {
                    throw new ConcurrentModificationException();
                }
                if (hasNext()) {
                    T toReturn = array[idx];
                    idx = (idx + 1) % array.length;
                    iterCount++;
                    return toReturn;
                }
                else {
                    throw new NoSuchElementException();
                }
            }
            
        };
    }

}
