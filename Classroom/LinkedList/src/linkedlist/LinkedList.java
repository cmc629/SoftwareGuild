/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author Christian Choi
 */
public interface LinkedList<T> {
    
    public void add(T element); //add to the end of the list
    public void add(int index, T element);
    public void clear();
    public T get(int index);
    public int indexOf(T element);
    public T remove(int index);
    public boolean isEmpty();
    public int size();
}
