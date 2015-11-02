/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacksandqueues;

/**
 *
 * @author Christian Choi
 */
public interface Queue<T> extends Iterable<T> {

    public void enqueue(T object);
    public T dequeue();
    public boolean isEmpty();
    public int size();
    public Object peek();
    
}
