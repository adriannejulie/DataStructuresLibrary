package main.java.mylib.datastructures.linear;
import main.java.mylib.datastructures.nodes.SNode;


public class StackLL extends SLL {
    
    /*
     * Constructor
     */
    public StackLL(){
        super();
    }

    /*
     * push(node)
     * Adds the given node to the top of the stack
     * Calls insertHead() method of SLL class
     */
    public void push(SNode node) {
        super.insertHead(node);
    }

    /*
     * pop()
     * Removes and returns the node at the top of the stack
     * Calls deleteHead() method of SLL class
     */
    public SNode pop() {
        return super.deleteHead();
    }

    /*
     * peek()
     * Returns the node at the top of the stack without removing it
     * Calls getHead() method of SLL class
     */
    public SNode peek() {
        return super.getHead();
    }

    /*
     * isEmpty()
     * Returns true if the stack is empty, false otherwise
     * Calls isEmpty() method of SLL class
     */
    public boolean isEmpty() {
        return super.isEmpty();
    }

    /*
     * Override insertTail(node) from SLL with empty body
     * insertTail(node) is not needed for a stack
     */
    @Override
    public void insertTail(SNode node) {}

    /*
     * Override insert(node, position) from SLL with empty body
     * insert(node, position) is not needed for a stack
     */
    @Override
    public void insert(SNode node, int position) {}

    /**
     * Override sortedInsert(node) from SLL with empty body
     * sortedInsert(node) is not needed for a stack
     */
    @Override
    public void sortedInsert(SNode node) {}

    /** -- can this be implemented????
     * Override search(node) from SLL with empty body
     * searchnode) is not needed for a stack
     */
    @Override
    public SNode search(SNode node) {
        return node;}
    
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
     * Uses bubble sort algorithm to sort elements into ascending order
     * No returns. No Params
     */
    /* 
    public void sort() {
        if (isEmpty()) {
            return;
        }
        
        SNode curr = getHead();
        SNode next;
        boolean swapped;
        
        do {
            swapped = false;
            curr = getHead();
            
            while (curr.getNext() != null) {
                next = curr.getNext();
                
                if ((int) curr.getData() > (int) next.getData()) {
                    // swap data
                    int temp = curr.getData();
                    curr.setData(next.getData());
                    next.setData(temp);
                    
                    swapped = true;
                }
                
                curr = curr.getNext();
            }
        } while (swapped);
    }*/

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
