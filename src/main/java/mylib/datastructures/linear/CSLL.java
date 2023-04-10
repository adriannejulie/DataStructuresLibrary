
package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SNode;

public class CSLL {
    private SNode head;
    private int size;

    /*
     * Constructor
     * No params
     * Creates a null head dobject that points to itself
     */
    public CSLL(){
        this.head = new SNode();
        this.head.setNext(head);
        this.size = 0;
       
    }

    /*
     * Overload
     * Node object as a param
     */
    public CSLL(SNode newNode) {
        this.head = newNode;
        this.head.setNext(newNode);
        size++;
    }

    /*
     * insertHead(node)
     * Node Object is inserted at the head of the list
     * Mothod checks if the list is null
     * If the list is not null, we traverse the list until the next node is the head
     * If the next node is the head then the node is inserted at that position
     * Returns void.
     */
    public void insertHead(SNode node) {
      if (head == null) {
            this.head = node;
            this.head.setNext(head);
            
      } else {
            node.setNext(head); //node's next pointer will point to what head is pointing to
            SNode currentNode = this.head;
            while (currentNode.getNext() != head) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(node);
            this.head = node; //head will now point to the new node
            
      }
      size++;
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
            this.head = node;
            node.setNext(node);
            size++;
            return;
        }

        SNode currentNode = head; //currentNode = the node head is pointing to
        while (currentNode.getNext() != head) {
            currentNode = currentNode.getNext(); //traverse the linked list
        }
        currentNode.setNext(node); //once the next node of currentNode == null, then node is assigned as the next node
        node.setNext(head);
        size++;
        
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
    public void insert(SNode node, int position) {
        if (this.head == null) {
            this.head = node;
            this.head.setNext(node);
            size++;
            return;
        } else if (position < 0) {
            throw new IndexOutOfBoundsException("Input position cannot be less than 0.");
        } else if (position == 0) {
            node.setNext(head); //sets the next node of node to the node head is pointing to
            this.head = node; //sets head to point to the new node
            size++;
            return;
        }

        SNode currentNode = head; //currentNode = the node head is pointing to
        int currentPosition = 0;
        while ( currentNode.getNext() != head && currentPosition < position - 1) {
            currentNode = currentNode.getNext();
            currentPosition++;
        }
        if (currentPosition < position - 1) {
            throw new IndexOutOfBoundsException("Position is out of bounds.");
        }
        node.setNext(currentNode.getNext());
        currentNode.setNext(node);
        size++;
    }


    /**
     * sortedIntsert(node)
     * Inserts node into its proper position in a sorted list in ascending order based on it's value
     * First the method checks if the list is empty or if the new node has a value less than the head node
     * If either of these conditions are true, the node is inserted at the head of the list
     * If neither of these conditions are true, the method will traverse the list until 
     * a node with a greater value is found, or until the end of the list is reached (the head)
     * The new node is inserted here.
     * The tarversal stops once it reaches the end of the list
     * @param node the new node to insert into the sorted list
     */
    public void sortedInsert(SNode node) {
        if (head == null ) { //if list is empty, insert node
            this.head = node;
            node.setNext(head);
            size++;
            return;
        }
    SNode currentNode = this.head;
    SNode prevNode = null;
    boolean inserted = false;
    
    do {
        if (node.getData() < currentNode.getData()) { // insert node before currentNode
            node.setNext(currentNode);
            if (prevNode == null) { // new node becomes the new head of the circular list
                head = node;
                // set the next node of the last node in the list to the new head
                SNode lastNode = head;
                while (lastNode.getNext() != currentNode) {
                    lastNode = lastNode.getNext();
                }
                lastNode.setNext(head);
            } else { // new node is inserted between prevNode and currentNode
                prevNode.setNext(node);
            }
            inserted = true;
            break;
        }
        prevNode = currentNode;
        currentNode = currentNode.getNext();
    } while (currentNode != head); // loop until we come back to the head of the list
    
    if (!inserted) { // if the new node should be inserted at the end of the list
        node.setNext(head);
        prevNode.setNext(node);
    }
    
    size++;
    }

    /**
     * search(node)
     * Searches for a node in the list
     * First we check if the list is empty, in which case, 'null' is returned
     * If the list is not empty, the currentNode's data is compared to the @param node data
     * If they are equal, currentNode is returned
     * If they are not equal, the list is traversed until it reaches the head, which returns null
     * @param node the node that will be searched for
     */
    public SNode search(SNode node) {
        if (this.head == null) {
            return null;
        }
        SNode currentNode = this.head;
        do {
            if (currentNode.getData() == node.getData()) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        } while (currentNode != this.head);
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
        if (this.head.getNext() == this.head) { // if there is only one node in the list
            this.head = null;
        } else {
            SNode currentNode = this.head;
            while (currentNode.getNext() != this.head) {
                currentNode = currentNode.getNext();
            }
            this.head = this.head.getNext();
            currentNode.setNext(this.head);
        }
        size--;
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
      if (head == null || head.getNext() == null) {
          this.head = null;
          size--;
          return;
      }
      SNode currentNode = this.head;
      while (currentNode.getNext().getNext() != head) {
          currentNode = currentNode.getNext(); //traverses list until it gets to the second last node
      }
      currentNode.setNext(head); //when currentNode is the second last node, it sets the next node to null
      size--;
      sort();
    }

    /*
     * delete(node)
     * Finds and deletes a specific node
     * Returns void.
     */
    public void delete(SNode node){
        if (head == null) {
            return;
        }
        if (this.head == node){
            head = head.getNext();
            size--;
            return;
        }
        SNode currentNode = this.head.getNext();
        SNode previousNode = this.head;
        while (currentNode != null && currentNode != this.head){
            if (currentNode == node) {
                previousNode.setNext(currentNode.getNext());
                size--;
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNext();

        }
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
        SNode current = head.getNext();
        while (current != null) {
            SNode temp = current.getNext();
            SNode previous = null;
            SNode traverse = this.head;
            while (traverse != head && traverse.getData() < current.getData()) {
                previous = traverse;
                traverse = traverse.getNext();
            }
            if (traverse == current) {
                // No need to insert, already in correct position
                previous = current;
            } else {// does this need to be there?
                // Insert current node before the node at traverse
                current.setNext(traverse);
                previous.setNext(current);
            }
            current = temp;
        }
    }

    /*
     * clear()
     * Deletes entire list
     * No params. Returns void.
     */
    public void clear() {
        if (head == null) {
            return; // list is already empty
        }
        SNode current = head.getNext(); // start from the first node after head
        while (current != head) { // traverse until we reach head again
            SNode next = current.getNext();
            current.setNext(null); // set current node's next reference to null
            current = next; // move to the next node
        }
        head.setNext(null); // set head's next reference to null
        head = null; // set head to null
        size = 0; // reset size to 0
    }

    /*
     * print()
     * Like a getter but multiple value elements
     * Prints the list information:
     * List Length
     * Sorted Status
     * List Content
     */
    public void print() {
        System.out.println("Length of List: " + size);
        boolean sorted = true;
        SNode current = head;
        do {
            if (current.getData() > current.getNext().getData()) {
                sorted = false;
                break;
            }
            current = current.getNext();
        } while (current != head);
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
    }
    
}