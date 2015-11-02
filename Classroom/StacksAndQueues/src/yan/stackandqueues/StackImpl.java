/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yan.stackandqueues;

import java.util.Iterator;
import stacksandqueues.Stack;

/**
 *
 * @author apprentice
 */
public class StackImpl<T> implements Stack<T> {
    
    private T[] array;
    private int size;
    private int top;

    public StackImpl() {
        this.top = -1;
        this.size = 0;
        array = (T[])new Object[10];
    }

    
    
    @Override
    public void push(T obj) {
        if (size == array.length){
            resize();
        }
        array[++top] = obj;
        size++;
        
    }

    @Override
    public T pop() {
        
        if(size!=0){ // !(size==0)
            size--;
            return array[top--];
        }
        else
            return null;
        
    }

    @Override
    public T peek() {
        return array[top];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
    
    private void resize(){
        
        T[] temp = array;
        array = (T[]) new Object[temp.length*2];
        for(int i = 0; i < temp.length; i++){
            array[i] = temp[i];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){
            
            private int iteratorTop = top;
            private int iteratorSize = size;

            @Override
            public boolean hasNext() {
                return (iteratorSize > 0);
            }

            @Override
            public T next() {
                iteratorSize--;
                return array[iteratorTop--];
            }
            
        };
    }
    
}