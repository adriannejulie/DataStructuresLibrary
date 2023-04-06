

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
     * Mothod checks if the list is null
     * If the list is not null, then the next pointer is pointer of the new node if pointed to the head of the list
     * Returns void.
     */
    public void insertHead(SNode node) {
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
         

    }

    /*
     * insertTail(node)
     * Node Object is inserted at the tail of the list
     * Method checks if the head of the list is null, 
     * if so then the head is set to the new node
     * If the head is not null then the list is traversed until reaching the last node
     * The next pointer of the last node is pointed to the new node
     * The next pointer of the new node is set to null
     * Returns void.
     */
    public void insertTail(SNode node) {
        if (this.head == null) {
            this.head - node;
        } 

        else {
            SNode currentNode = this.head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = node;
            node.next = null;
        }
    }

    /*
     * insert(node, position)
     * Inserts node object into a specified position
     * Checks if position param is positive
     * If position is 0, insertHead will be called
     * Traverse the list until position -1 is found
     * The next pointer of the new node is set to position - 1
     * The next pointer of th
     * Returns Void. 
     */
    public void insert(SNode node, int position) {
        if (position < 0) {
            throw new IllegalArgumentException("Specified position cannot be less than zero.")
        }
        if (position == 0) {
            insertHead(node);
            return;
        }
        SNode current = this.head;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.getNext();
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Position is greater than the size of the list");
        }
        node.setNext(current.getNext());
        current.setNext(node);
        size++;
    }

    /*
     * sortedIntsert(node)
     * Inserts node into its proper position in a sorted list
     * If the head equals to null then the list is empty and the node can simply be inserted
     * List is traversed to find the proper position of the new node and keeps track of previous and current node.
     * The new node and current node is compared at every step until the new node is less than current node's value.
     * If list is found to be out of order, call the sort function before inserting
     * Increment the size of the list
     * calls isSorted() to check if the list is sorted in ascending order
     * Returns void.
     */
    public void sortedInsert(SNode node) {
        if (this.head == null) { // list is empty
        this.head = node;
        } else {
            SNode current =  this.head;
            SNode prev = null;
            while (current != null && current.value < node.value) {
                prev = current;
                current = current.next;
            }
            if (prev == null) { // node should be inserted at the beginning of the list
                node.next = this.head;
                this.head = node;
            } else { // node should be inserted between prev and current
                prev.next = node;
                node.next = current;
            }
            if (!isSorted()) {
                sort();
            }
        }
        size++;
    }

    /*
     * search(node)
     * Searches for a node in the list
     * currentNode first points to the head of the list
     * While currentNode is not null, compare the currentNode and nodc
     * if node object is found then return currentNode
     * If node object is not found, set currentNode to the next node
     * Returns the found object, otherwise returns null
     */
    public SNode search(SNode node) {
        SNode currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.data.equals(node.data)) {
                return currentNode;
            }
            currentNode = current.next;
        }
        return null;
    }

    /*
     * deleteHead()
     * Deletes the head node
     * No params. Returns void.
     */
    public void deleteHead() {
        if (this.head == null) {
            return; // list is empty
        }
        
        this.head = head.next;
    }

    /*
     * deleteTail()
     * Deletes the tail node
     * Checks if the head is equal to null to indicate an empty list
     * Checks if the node after the head is null, if so then head is the tail and will be deleted
     * Searches for the second to last node. If found, currentNode is set to null and currentNode.next is deleted
     * No params. Returns void.
     */
    public void deleteTail() {
        if (this.head == null) {
            return; // list is empty
        }
        
        if (head.next == null) {
            this.head = null; // list only had one node
            return;
        }
        
        Node currentNode = this.head;
        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = null;
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
     * Checks if the first or second node is equal to null. If so it is already sorted.
     * Checks if the next node is null using a temporary node. While the temporary node is not null
     * and the temporary node is less than the next node, the current and previous elements swap until it is in its corret position
     * No params. Returns void.
     */
    public void sort() {
    if (this.head == null || this.head.next == null) {
        return; // already sorted
    }

    Node currentNode = head.next;
    while (currentNode != null) {
        Node tempNode = currentNode;
        while (tempNode != this.head && tempNode.data.compareTo(tempNode.next.data) < 0) {
            // swap temp and temp.next
            T temp = tempNode.data;
            tempNode.data = temp.next.data;
            tempNode.next.data = temp;

            tempNode = tempNode.next;
        }
        currentNode = current.next;
    }
}
    /*
     * clear()
     * Deletes entire list
     * No params. Returns void.
     */
    public void clear(){
        this.head = null;
        this.tail = null;
    }

    /*
     * print()
     * Like a getter but multiple data elements
     * Prints the list information:
     * List Length
     * Sorted Status
     * List Content
     */
    public String print() {
        String listContent = "";
        Node currentNode = this.head;
        int length = 0;
        boolean isSorted = true;

        // Traverse the list and append each node's data to the list content
        while (currentNode != null) {
            listContent += currentNode.data + " ";
            length++;
            if (currentNode.next != null && currentNode.data > currentNode.next.data) {
                isSorted = false;
            }
            currentNode = currentNode.next;
        }

        // Return the list information as a string
        return "List Length: " + length + "\nSorted Status: " + (isSorted ? "Sorted" : "Not Sorted") + "\nList Content: " + listContent;

    }
}