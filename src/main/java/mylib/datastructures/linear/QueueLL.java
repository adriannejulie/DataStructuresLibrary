/**
@author Adrianne Julia Lat
adriannejulia.lat@ucalgary.ca
@version 1.1
@since 1.0
*/
package main.java.mylib.datastructures.linear;
import java.util.NoSuchElementException;

import main.java.mylib.datastructures.nodes.SNode;


public class QueueLL extends SLL{
    
    public QueueLL(){
        super();
    }

    
    /*
     * Override insertHead(node) from SLL with empty body
     * insertHead(node) is not needed for a queue
     */
    @Override
    public void insertHead(SNode node) {}

    /*
     * Override insert(node, position) from SLL with empty body
     * insert(node, position) is not needed for a queue
     */
    @Override
    public void insert(SNode node, int position) {}

    /**
     * Override sortedInsert(node) from SLL with empty body
     * sortedInsert(node) is not needed for a stack
     */
    @Override
    public void sortedInsert(SNode node) {}

    /**
     * search(node)
     * @param node a node that is searched for in the list
     * @return a node that was found
     */
    public SNode search(SNode node) {
        return super.search(node);
    }
    
    /**
     * Override deleteTail() from SLL with empty body
     * deleteTail() is not needed for a stack
     */
    @Override    
    public void deleteTail() {}

    /**
     * Override delete(node) from SLL with empty body
     * delete(node) is not needed for a stack
     */
    @Override
    public void delete(SNode node){}

    /**
     * Add an element to the tail of the queue
     * @param node the node to add
     */
    public void enqueue (SNode node) {
        super.insertTail(node);
    }

    /**
     * Deletes the front node and returns the front node
     * @return the node at the front of the list
     * @throws NoSuchElementException if the queue is empty
     */
    public SNode dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        SNode node = super.getHead();
        super.deleteHead();
        return node;
    }

    /**
     * Peek the front element of the queue without removing it
     * @return the node at the front of the list
     * @throws NoSuchElementException if the queue is empty
     */
    public SNode peek(){
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return super.getHead();
    }


    /*
     * sort()
     * Applies insertion sort to the list
     * No params. Returns void.
     */
    public void sort(){
        super.sort();
    }

    /**
     * clear()
     * Clears the Stack.
     * No params. No Return.
     */
    public void clear(){
        super.clear();
    }

    /**
     * print()
     * prints the list length, sorted status, and list content
     * No params. No Return.
     */
    public void print(){
        super.print();
    }
}
