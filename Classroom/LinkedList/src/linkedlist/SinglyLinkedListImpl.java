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
public class SinglyLinkedListImpl<T> implements LinkedList<T> {
    
    private Node<T> head = null;
    private int size = 0;
    
    @Override //this adds to the END of the linked list
    public void add(T element) {
        if (head == null) {
            head = new Node(element, null);
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(element, null);
        }
        size++;
    }

    @Override
    public void add(int index, T element) {
        if (head != null) {
            if (index == 0) {
                head = new Node(element, head);
                size++;
            } else if (index > 0 && index <= size - 1) {
                Node<T> nodeBefore = getNode(index - 1);
                nodeBefore.next = new Node(element, nodeBefore.next);
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
        size = 0;
    }

    @Override
    public T get(int index) {
        if (head != null) {
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
        if (head != null) {
            if (index == 0) {
                T elementToReturn = head.element;
                if (head.next != null) {
                    head = head.next;
                } else {
                    head = null;
                }
                size--;
                return elementToReturn;
            } else if (index > 0 && index <= size - 1) {
                Node<T> currentNode = getNode(index);
                Node<T> nodeBefore = getNode(index - 1);
                nodeBefore.next = currentNode.next;
                size--;
                return currentNode.element;
            } else {
                throw new IndexOutOfBoundsException();
            }
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0; //or return head == null;
    }

    @Override
    public int size() {
        return size;
    }
    
    private Node<T> getNode(int index) {
        if (index <= size - 1) {
            int count = 0;
            Node<T> nodeToReturn = head;
            while (count != index) {
                nodeToReturn = nodeToReturn.next;
                count++;
            }
            return nodeToReturn;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    
    private class Node<T> {
        T element;
        Node<T> next;
        
        public Node(T element, Node<T> nextNode) {
            this.element = element;
            this.next = nextNode;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
        
    }
    
}
