/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yan.stackandqueues;

import java.util.Iterator;
import stacksandqueues.Queue;

/**
 *
 * @author apprentice
 */
public class QueueImpl<T> implements Queue<T> {
    
    private T[] array;
    private int front;
    private int back;
    private int size;
    
    public QueueImpl(){
        this.array = (T[])new Object[10];
        this.front = 0;
        this.back = -1;
        this.size = 0;
    }

    @Override
    public void enqueue(T t) {
        if(size == array.length -1){
            resize();
           // System.out.println("Resized array");
        }
   //     System.out.println("Added " + obj + "to queue");
        if(back  == array.length -1 ){
            back = -1;
        }
        array[++back] = t;
        size++;
    }

    @Override
    public T dequeue() {
        if(size!=0){
            size--;
            if(front == array.length){
                front = 0;
            }
            return (T)array[front++];
        }
        else 
            return null;
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
        array = (T[])new Object[temp.length*2];
//        for(int i = 0; i < temp.length; i++){
//            array[i] = temp[front++];
//        }
        int i = 0;
        while(true){
            if(front == temp.length){
                front = 0;
            }
            if(front - 1 == back){
                
                break;
            }
            array[i++] = temp[front++];
        }
        front = 0;
        back = size - 1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){
            private int iteratorFront = front;
            private int iteratorBack = back;

            @Override
            public boolean hasNext() {
                return  ((iteratorFront - 1) != iteratorBack);
            }

            @Override
            public T next() {
                return array[iteratorFront++];
            }
            
        };
    }

    @Override
    public Object peek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
  
    