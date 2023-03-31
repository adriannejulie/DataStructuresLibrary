package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SNode;

public class SLL<T> {
    private SNode head;
    private SNode tail;
    private int size;

    /*
     * Constructor
     * No params
     * Creates a null hea dobject
     */
    public SLL(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /*
     * Overload
     * Node object as a param
     */
    public SLL(SNode newNode) {
        this.head = newNode;
        this.tail = newNode;
        this.size = 1;
    }

    /*
     * insertHead(node)
     * Node Object is inserted at the head of the list
     * Returns void.
     */
    public void insertHead(SNode node) {

    }

    /*
     * insertTail(node)
     * Node Object is inserted at the tail of the list
     * Returns void.
     */
    public void insertTail(SNode node) {

    }

    /*
     * insert(node, position)
     * Inserts node object into a specified position
     * Returns Void. 
     */
    public void insert(SNode node, int position) {

    }

    /*
     * sortedIntsert(node)
     * Inserts node into its proper position in a sorted list
     * Checks for list sort validity
     * If list is foudn to be out of order, call the sort function before inserting
     * Returns void.//Maybe implement a isSorted() function to check if it's sorted
     */
    public void sortedInsert(SNode node) {

    }

    /*
     * search(node)
     * Searches for a node in the list
     * Returns the found object, otherwise returns null
     */
    public SNode Search (SNode node) {

    }

    /*
     * deleteHead()
     * Deletes the head node
     * No params. Returns void.
     */
    public void deleteHead(){

    }

    /*
     * deleteTail()
     * Deletes the tail node
     * No params. Returns void.
     */
    public void deleteTail(){
        
    }

    /*
     * deleteHead(node)
     * Deletes the head node
     * Returns void.
     */
    public void delete(SNode node){
        
    }

    /*
     * sort()
     * Applies insertion sort to the list
     * Insertion starts at the head
     * No params. Returns void.
     */
    public void sort(){

    }

    /*
     * clear()
     * Deletes entire list
     * No params. Returns void.
     */
    public void clear(){

    }

    /*
     * print()
     * Like a getter but multiple data elements
     * Prints the list information:
     * List Length
     * Sorted Status
     * List Content
     */
    public String print(){
        
    }
    
}