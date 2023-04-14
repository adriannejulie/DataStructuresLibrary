/**
@author Adrianne Julia Lat
adriannejulia.lat@ucalgary.ca
@version 1.3
@since 1.0
*/
package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;


public class DLL extends DNode{
    
    protected DNode head;
    private DNode tail;
    protected int size;

    /*
     * Constructor
     * No params
     * Creates a null head dobject
     */
    public DLL(){
        this.head = new DNode();
        this.tail = new DNode();
        this.head.setNext(tail);
        this.tail.setPrev(head);
        this.size = 0;
       
    }

    /*
     * Overload
     * Node object as a param
     */
    public DLL(DNode newNode) {
        this.head = newNode;
        this.tail = newNode;
        this.head.setNext(tail);
        this.tail.setPrev(head);
        size++;
    }

    /*
     * insertHead(node)
     * Node Object is inserted at the head of the list
     * Returns void.
     */
    public void insertHead(DNode node) {
        if (head == null) {
            this.head = node;
            this.tail = node;
            this.head.setNext(tail);
            this.tail.setPrev(head);
            size++;
      } else {
            node.setNext(head); //node's next pointer will point to what head is pointing to
            head.setPrev(node); //the previous pointer of the head node will point to the new node
            this.head = node; //head will now point to the new node
            this.head.setPrev(tail); //the previous pointer of the new head node will point to the tail
            this.tail.setNext(head); //the next pointer of the tail node will point to the new head node
            size++;
      }
    }

    /*
     * insertTail(node)
     * Node Object is inserted at the tail of the list
     * Method checks if the tail of the list is null, 
     * if so then the head and tail is set to the new node
     * If the head is not null then the node at the tail is setNext to the new node
     * the new node's previous node will then be set to the object at the tail
     * the new node's next node will be set to head
     * finally, the tail is pointed to the new node
     */
    public void insertTail(DNode node) {
        if (this.head == null) {
            this.head = node;
            this.tail = node;
            size++;
            return;
        } else {
            this.tail.setNext(node); 
            node.setPrev(tail);
            node.setNext(null);
            this.tail = node;
            
            size++;
        }
    }

    /*
     * insert(node, position)
     * Inserts node object into a specified position
     * Checks if position param is positive
     * If position is 0, insertHead will be called
     * Traverse the list until position -1 is found
     * The next pointer of the new node is set to position - 1
     * Returns Void. 
     */
    public void insert(DNode node, int position) {
        if (this.head == null) {
            this.head = node;
            this.tail = node;
            size++;
            return;
        } else if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Input position cannot be less than 0.");
        } else if (position == 0) {
            insertHead(node);
            return;
        } else if (position == size) {
            insertTail(node);
            return;
        }

        DNode currentNode = head; //currentNode = the node head is pointing to
        int currentPosition = 0;
        while ( currentNode != null && currentPosition < position - 1) {
            currentNode = currentNode.getNext();
            currentPosition++;
        }
        if (currentNode == null) {
            throw new IndexOutOfBoundsException("Position is out of bounds.");
        }
        node.setNext(currentNode.getNext());
        currentNode.getNext().setPrev(node);
        currentNode.setNext(node);
        node.setPrev(currentNode);
        size++;
    }


    /*
     * sortedIntsert(node)
     * Inserts node into its proper position in a sorted list
     * If the head equals to null then the list is empty and the node can simply be inserted
     * List is traversed to find the proper position of the new node and keeps track of previous and current node.
     * The new node and current node is compared at every step until the new node is less than current node's value.
     * Increment the size of the list
     * Returns void.
     */
    public void sortedInsert(DNode node) {
        if (head == null ) {
            this.head = node;
            this.tail = node;
        }else if (node.getData() < head.getData()) { 
            node.setNext(head);
            head.setPrev(node); // set the previous node to the new node, not the node itself
            this.head = node;
        } else {
            DNode currentNode = head;
            while (currentNode.getNext() != null && currentNode.getNext().getData() < node.getData()) { // ensures list is in ascending order
                currentNode = currentNode.getNext(); // traverse list while the next node is not null and the value of the next node is less than the value of the new node
            }
            node.setNext(currentNode.getNext());
            if (currentNode.getNext() != null) {
                currentNode.getNext().setPrev(node);
            } else {
                this.tail = node;
            }
            currentNode.setNext(node);
            node.setPrev(currentNode);
        }
        size++;
    }
    
    

    /**
     * search(node)
     * Searches for a node in the list
     * currentNode first points to the head of the list
     * While currentNode is not null, compare the currentNode's data and node's data
     * if node object is found then return currentNode
     * If node object is not found because currentNode == head then break while loop
     * 
     */
    public DNode search(DNode node) {
        DNode currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.getData() == node.getData()) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
            if (currentNode == head) {
                break;
            }
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
           return;
       }
       this.head = this.head.getNext();
       if (head != null) {
        this.head.setPrev(null);
        tail.setNext(head);
       } else {
        tail = null;
       }
       size--;
    }

    /*
 * deleteTail()
 * Deletes the tail node
 * No params. Returns void.
 */
public void deleteTail() {
    if (head == null) {
        return;
    } else if (head.getNext() == null) {
        this.head = null;
        this.tail = null;
    } else {
        DNode secondToLastNode = tail.getPrev();
        tail.setPrev(null);
        tail.setNext(null);
        secondToLastNode.setNext(null);
        size--;
        
    }
}


    /*
     * delete(node)
     * Finds and deletes a specific node
     * Returns void.
     */
    public void delete(DNode node){
        if (head == null) {
            return;
        }
        else if (this.head == node){
            head = head.getNext();
        } else {
            node.getPrev().setNext(node.getNext());
            if (node.getNext() != null) {
                node.getNext().setPrev(node.getPrev());
            }
        }
        size--;
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
        if (head == null || head.getNext() == null) {
            return;
        }
        DNode current = head.getNext();
        while (current != null) {
            DNode temp = current.getNext();
            DNode previous = null;
            DNode traverse = this.head;
            while (traverse != current && traverse.getData() < current.getData()) {
                previous = traverse;
                traverse = traverse.getNext();
            }
            if (traverse == current) {
                // No need to insert, already in correct position
                previous = current;
            } else {// does this need to be there? bruh
                // Insert current node before the node at traverse
                current.setNext(traverse);
                current.setPrev(previous);
                
                if (previous != null) {
                    previous.setNext(current);
                } else {
                    head = current;
                }
                traverse.setPrev(current);
            }
            current = temp;
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
        this.size = 0;
    }

    /*
     * print()
     * Like a getter but multiple value elements
     * Prints the list information:
     * List Length
     * Sorted Status
     * List Content
     * List Content (in reverse)
     */
    public void print() {
        System.out.println("Length of List: " + size);
        boolean sorted = true;
        DNode current = head;
        
        while (current != null && current.getNext() != null) {
            if (current.getData() > current.getNext().getData()) {
                sorted = false;
                break;
            }
            current = current.getNext();
        }
        if (sorted) {
            System.out.println("List is sorted");
        } else {
            System.out.println("List is not sorted");
        }
        // Print the contents of the list
        current = head;
        System.out.print("List content: ");
        do {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        } while (current != head);
        System.out.println();

        System.out.print("List content (in reverse): ");
        current = tail;
        do {
            System.out.print(current.getData() + " ");
            current = current.getPrev();
        } while (current != head);

    }

    /**
     * Getter for head
     * @return DNode object head
     */
    public DNode getHead(){
        return this.head;
    }

    /**
     * Getter for head
     * @return DNode object head
     */
    public DNode getTail(){
        return this.tail;
    }

    /**
     * Getter for head
     * @return DNode object head
     */
    public int getSize(){
        return this.size;
    }
}