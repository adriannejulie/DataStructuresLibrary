package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SNode;


public class DLL<T> extends SLL<T> {
    
    private DNode<T> tail;

    public DLL() {
        super(); 
        this.tail = null;
    }

    public DLL(T value) {
        super(value);
        this.tail = head;
    }

    public void addFirst(T value) {
        DNode<T> newNode = new DNode<T>(value);
        if (isEmpty()) {
            this.tail = newNode;
        } else {
            head.setPrevious(newNode);
            newNode.setNext(head);
        }
        head = newNode;
    }

    public void addLast(T value) {
        DNode<T> newNode = new DNode<T>(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
        }
        this.tail = newNode;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T removedValue = head.getValue();
        if (head == tail) {
            head = null;
            this.tail = null;
        } else {
            head = head.getNext();
            head.setPrevious(null);
        }
        return removedValue;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T removedValue = tail.getValue();
        if (head == tail) {
            head = null;
            this.tail = null;
        } else {
            this.tail = tail.getPrevious();
            this.tail.setNext(null);
        }
        return removedValue;
    }

    public DNode<T> getTail() {
        return this.tail;
    }

    public void setTail(DNode<T> tail) {
        this.tail = tail;
    }

}