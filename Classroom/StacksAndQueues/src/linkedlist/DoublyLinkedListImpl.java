/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

import java.util.NoSuchElementException;

/**
 *
 * @author Christian Choi
 */
public class DoublyLinkedListImpl<T> implements LinkedList<T> {
    
    Node<T> head = null;
    Node<T> tail = null;
    int size = 0;
    

    @Override //this adds to the end of the linked list
    public void add(T element) {
        if (size == 0) {
            Node<T> node = new Node(element, null, null);
            head = node;
            tail = node;
        } else {
            Node<T> node = new Node(element, tail, null);
            tail.next = node;
            tail = node;
        }
        size++;
    }

    @Override
    public void add(int index, T element) {
        if (head != null && tail != null) {
            if (index == 0) {
                Node<T> node = new Node(element, null, head);
                head.previous = node;
                head = node;
                size++;
            } else if (index <= size - 1) {
                Node<T> nodeBefore = getNode(index - 1);
                Node<T> nodeAfter = getNode(index);
                Node<T> nodeToAdd = new Node(element, nodeBefore, nodeAfter);
                nodeBefore.next = nodeToAdd;
                nodeAfter.previous = nodeToAdd;
                size++;
            } else {
                throw new IndexOutOfBoundsException();
            }
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        if (head != null && tail != null) {
            return getNode(index).element;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public int indexOf(T element) {
        int index = 0;
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.element.equals(element)) {
                return index;
            }
            currentNode = currentNode.next;
            index++;
        }
        return -1;
    }

    @Override
    public T remove(int index) {
        if (head != null && tail != null) {
            if (index <= size - 1) {
                if (index == 0) {
                    Node<T> nodeToReturn = head;
                    head = head.next;
                    if (head != null) {
                        head.previous = null;
                    }
                    size--;
                    return nodeToReturn.element;
                } else if (index == size - 1) {
                    Node<T> nodeToReturn = tail;
                    tail = tail.previous;
                    if (tail != null) {
                        tail.next = null;
                    }
                    size--;
                    return nodeToReturn.element;
                } else {
                    Node<T> nodeToReturn = getNode(index);
                    getNode(index-1).next = nodeToReturn.next;
                    getNode(index+1).previous = nodeToReturn.previous;
                    size--;
                    return nodeToReturn.element;
                }
            } else {
                throw new IndexOutOfBoundsException();
            }
        } else {
            throw new NoSuchElementException();
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
    
    private Node<T> getNode(int index) {
        if (index <= size - 1) {
            if (index <= size/2) { //If the index lies within first half of size, start from head
                int count = 0;
                Node<T> nodeToReturn = head;
                while (count != index) {
                    nodeToReturn = nodeToReturn.next;
                    count++;
                }
                return nodeToReturn;
            } else { //if the index lies within the latter half of size, start from tail
                int count = size - 1;
                Node<T> nodeToReturn = tail;
                while (count != index) {
                    nodeToReturn = nodeToReturn.previous;
                    count--;
                }
                return nodeToReturn;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    
    
    private class Node<T> {
        private T element;
        private Node<T> previous;
        private Node<T> next;
        
        public Node(T element, Node<T> previous, Node<T> next) {
            this.element = element;
            this.previous = previous;
            this.next = next;
        }
        
        
    }
}
