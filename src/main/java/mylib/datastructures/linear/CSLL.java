/**
@author Adrianne Julia Lat
adriannejulia.lat@ucalgary.ca
@version 1.2
@since 1.0
*/
package mylib.datastructures.linear;

import mylib.datastructures.nodes.SNode;

public class CSLL extends SLL{

    /*
     * Constructor
     * No params
     * Creates a null super.head dobject that points to itself
     */
    public CSLL(){
        super.head = new SNode();
        super.head.setNext(super.head);
        super.size = 0;
       
    }

    /*
     * Overload
     * Node object as a param
     */
    public CSLL(SNode newNode) {
        super.head = newNode;
        super.head.setNext(newNode);
        super.size++;
    }

    /*
     * insertsuper.head(node)
     * Node Object is inserted at the super.head of the list
     * Mothod checks if the list is null
     * If the list is not null, we traverse the list until the next node is the super.head
     * If the next node is the super.head then the node is inserted at that position
     * Returns void.
     */
    public void inserthead(SNode node) {
      if (super.head == null) {
            super.head = node;
            super.head.setNext(super.head);
            
      } else {
            node.setNext(super.head); //node's next pointer will point to what super.head is pointing to
            SNode currentNode = super.head;
            while (currentNode.getNext() != super.head) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(node);
            super.head = node; //super.head will now point to the new node
            
      }
      super.size++;
    }

    /*
     * insertTail(node)
     * Node Object is inserted at the tail of the list
     * Method checks if the super.head of the list is null, 
     * if so then the super.head is set to the new node
     * If the super.head is not null then the list is traversed until reaching the last node
     * The next pointer of the last node is pointed to the new node
     * The next pointer of the new node is set to null
     * Returns void.
     */
    public void insertTail(SNode node) {
        if (super.head == null) {
            super.head = node;
            node.setNext(node);
            super.size++;
            return;
        }

        SNode currentNode = super.head; //currentNode = the node super.head is pointing to
        while (currentNode.getNext() != super.head) {
            currentNode = currentNode.getNext(); //traverse the linked list
        }
        currentNode.setNext(node); //once the next node of currentNode == null, then node is assigned as the next node
        node.setNext(super.head);
        super.size++;
        
    }

    /*
     * insert(node, position)
     * Inserts node object into a specified position
     * Checks if position param is positive
     * If position is 0, insertsuper.head will be called
     * Traverse the list until position -1 is found
     * The next pointer of the new node is set to position - 1
     * Returns Void. 
     */
    public void insert(SNode node, int position) {
        if (super.head == null) {
            super.head = node;
            super.head.setNext(node);
            super.size++;
            return;
        } else if (position < 0) {
            throw new IndexOutOfBoundsException("Input position cannot be less than 0.");
        } else if (position == 0) {
            node.setNext(super.head); //sets the next node of node to the node super.head is pointing to
            super.head = node; //sets super.head to point to the new node
            super.size++;
            return;
        }

        SNode currentNode = super.head; //currentNode = the node super.head is pointing to
        int currentPosition = 0;
        while ( currentNode.getNext() != super.head && currentPosition < position - 1) {
            currentNode = currentNode.getNext();
            currentPosition++;
        }
        if (currentPosition < position - 1) {
            throw new IndexOutOfBoundsException("Position is out of bounds.");
        }
        node.setNext(currentNode.getNext());
        currentNode.setNext(node);
        super.size++;
    }


    /**
     * sortedIntsert(node)
     * Inserts node into its proper position in a sorted list in ascending order based on it's value
     * First the method checks if the list is empty or if the new node has a value less than the super.head node
     * If either of these conditions are true, the node is inserted at the super.head of the list
     * If neither of these conditions are true, the method will traverse the list until 
     * a node with a greater value is found, or until the end of the list is reached (the super.head)
     * The new node is inserted here.
     * The tarversal stops once it reaches the end of the list
     * @param node the new node to insert into the sorted list
     */
    public void sortedInsert(SNode node) {
        if (super.head == null ) { //if list is empty, insert node
            super.head = node;
            node.setNext(super.head);
            super.size++;
            return;
        }
    SNode currentNode = super.head;
    SNode prevNode = null;
    boolean inserted = false;
    
    do {
        if (node.getData() < currentNode.getData()) { // insert node before currentNode
            node.setNext(currentNode);
            if (prevNode == null) { // new node becomes the new super.head of the circular list
                super.head = node;
                // set the next node of the last node in the list to the new super.head
                SNode lastNode = super.head;
                while (lastNode.getNext() != currentNode) {
                    lastNode = lastNode.getNext();
                }
                lastNode.setNext(super.head);
            } else { // new node is inserted between prevNode and currentNode
                prevNode.setNext(node);
            }
            inserted = true;
            break;
        }
        prevNode = currentNode;
        currentNode = currentNode.getNext();
    } while (currentNode != super.head); // loop until we come back to the super.head of the list
    
    if (!inserted) { // if the new node should be inserted at the end of the list
        node.setNext(super.head);
        prevNode.setNext(node);
    }
    
    super.size++;
    }

    /**
     * search(node)
     * Searches for a node in the list
     * First we check if the list is empty, in which case, 'null' is returned
     * If the list is not empty, the currentNode's data is compared to the @param node data
     * If they are equal, currentNode is returned
     * If they are not equal, the list is traversed until it reaches the super.head, which returns null
     * @param node the node that will be searched for
     */
    public SNode search(SNode node) {
        if (super.head == null) {
            return null;
        }
        SNode currentNode = super.head;
        do {
            if (currentNode.getData() == node.getData()) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        } while (currentNode != super.head);
        return null;
    }

    /*
     * deletesuper.head()
     * Deletes the super.head node and returns it
     * No params. Returns void.
     */
    public SNode deletehead() {
        if (super.head == null) {
            return null;
        }
        SNode deletedNode = super.head;
        if (super.head.getNext() == super.head) { // if there is only one node in the list
            super.head = null;
        } else {
            SNode currentNode = super.head;
            while (currentNode.getNext() != super.head) {
                currentNode = currentNode.getNext();
            }
            super.head = super.head.getNext();
            currentNode.setNext(super.head);
        }
        super.size--;
        return deletedNode;
    }
    

    /*
     * deleteTail()
     * Deletes the tail node
     * Checks if the super.head is equal to null to indicate an empty list
     * Checks if the node after the super.head is null, if so then super.head is the tail and will be deleted
     * Searches for the second to last node. If found, currentNode is set to null and currentNode.next is deleted
     * No params. Returns void.
     */
    public void deleteTail() {
      if (super.head == null || super.head.getNext() == null) {
          super.head = null;
          super.size--;
          return;
      }
      SNode currentNode = super.head;
      while (currentNode.getNext().getNext() != super.head) {
          currentNode = currentNode.getNext(); //traverses list until it gets to the second last node
      }
      currentNode.setNext(super.head); //when currentNode is the second last node, it sets the next node to null
      super.size--;
      sort();
    }

    /*
     * delete(node)
     * Finds and deletes a specific node
     * Returns void.
     */
    public void delete(SNode node){
        if (super.head == null) {
            return;
        }
        if (super.head == node){
            super.head = super.head.getNext();
            super.size--;
            return;
        }
        SNode currentNode = super.head.getNext();
        SNode previousNode = super.head;
        while (currentNode != null && currentNode != super.head){
            if (currentNode == node) {
                previousNode.setNext(currentNode.getNext());
                super.size--;
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
        if (super.head == null || super.head.getNext() == null) {
            return;
        }
        SNode current = super.head.getNext();
        while (current != null) {
            SNode temp = current.getNext();
            SNode previous = null;
            SNode traverse = super.head;
            while (traverse != super.head && traverse.getData() < current.getData()) {
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
        if (super.head == null) {
            return; // list is already empty
        }
        SNode current = super.head.getNext(); // start from the first node after super.head
        while (current != super.head) { // traverse until we reach super.head again
            SNode next = current.getNext();
            current.setNext(null); // set current node's next reference to null
            current = next; // move to the next node
        }
        super.head.setNext(null); // set super.head's next reference to null
        super.head = null; // set super.head to null
        super.size = 0; // reset super.size to 0
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
        System.out.println("Length of List: " + super.size);
        boolean sorted = true;
        SNode current = super.head;
        do {
            if (current.getData() > current.getNext().getData()) {
                sorted = false;
                break;
            }
            current = current.getNext();
        } while (current != super.head);
        if (sorted) {
            System.out.println("List is sorted");
        } else {
            System.out.println("List is not sorted");
        }
        // Print the contents of the list
        current = super.head;
        System.out.print("List content: ");
        do {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        } while (current != super.head);
    }
    
}