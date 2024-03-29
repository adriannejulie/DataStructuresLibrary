/**
@author Adrianne Julia Lat
adriannejulia.lat@ucalgary.ca
@version 1.2
@since 1.0
*/
package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;


public class CDLL extends DLL{

    /*
     * Constructor
     * No params
     * Creates a null head dobject
     */
    public CDLL(){
        super.head = null;
        super.size = 0;
       
    }

    /*
     * Overload
     * Node object as a param
     */
    public CDLL(DNode newNode) {
        super.head = newNode;
        super.size++;
    }

    /*
     * insertHead(node)
     * Node Object is inserted at the head of the list
     * Mothod checks if the list is null
     * If the list is not null, then the next pointer is pointer of the new node if pointed to the head of the list
     * Returns void.
     */
    public void insertHead(DNode node) {
      if (super.head == null) {
            super.head = node;
            super.size++;
      } else {
            node.setNext(head); //node's next pointer will point to what head is pointing to
            super.head = node; //head will now point to the new node
            super.size++;
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
    public void insertTail(DNode node) {
        if (super.head == null) {
            super.head = node;
            super.size++;
            return;
        } else {
            DNode currentNode = super.head; //currentNode = the node head is pointing to
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext(); //traverse the linked list
            }
            currentNode.setNext(node); //once the next node of currentNode == null, then node is assigned as the next node
            super.size++;
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
    public void insert(DNode node, int position) {
        if (super.head == null) {
            super.head = node;
            super.size++;
            return;
        } else if (position < 0) {
            throw new IndexOutOfBoundsException("Input position cannot be less than 0.");
        } else if (position == 0) {
            node.setNext(super.head); //sets the next node of node to the node head is pointing to
            super.head = node; //sets head to point to the new node
            super.size++;
            return;
        }

        DNode currentNode = super.head; //currentNode = the node head is pointing to
        int currentPosition = 0;
        while ( currentNode != null && currentPosition < position - 1) {
            currentNode = currentNode.getNext();
            currentPosition++;
        }
        if (currentNode == null) {
            throw new IndexOutOfBoundsException("Position is out of bounds.");
        }
        node.setNext(currentNode.getNext());
        currentNode.setNext(node);
        super.size++;
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
        if (super.head == null || node.getData() < head.getData()) { //if list is empty, insert node
            node.setNext(super.head);
            super.head = node;
            super.size++;
            return;
        }
        DNode currentNode = super.head;
        while (currentNode.getNext() != null && currentNode.getNext().getData() < node.getData()) { //ensures list is in ascending order
            currentNode = currentNode.getNext(); //traverse list while the next node is not null and the value of the next node is less than the value of the new node
        }
        node.setNext(currentNode.getNext());
        currentNode.setNext(node);
        super.size++;
    }

    /**
     * search(node)
     * Searches for a node in the list
     * currentNode first points to the head of the list
     * While currentNode is not null, compare the currentNode's data and node's data
     * if node object is found then return currentNode
     * If node object is not found, set currentNode to the next node
     * 
     */
    public DNode search(DNode node) {
        DNode currentNode = super.head;
        while (currentNode != null) {
            if (currentNode.getData() == node.getData()) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }

    /*
     * deleteHead()
     * Deletes the head node
     * No params. Returns void.
     */
    public void deleteHead() {
       if (super.head == null) {
           return;
       }
       super.head.setData(0);
       super.head = super.head.getNext();
       super.size--;

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
      if (super.head == null || head.getNext() == null) {
          super.head = null;
          super.size--;
          return;
      }
      DNode currentNode = super.head;
      while (currentNode.getNext().getNext() != null) {
          currentNode = currentNode.getNext(); //traverses list until it gets to the second last node
      }
      currentNode.setNext(null); //when currentNode is the second last node, it sets the next node to null
      super.size--;
      sort();
    }

    /*
     * delete(node)
     * Finds and deletes a specific node
     * Returns void.
     */
    public void delete(DNode node){
        if (super.head == null) {
            return;
        }
        if (super.head == node){
            super.head = super.head.getNext();
            super.size--;
            return;
        }
        DNode currentNode = super.head;
        while (currentNode != null && currentNode.getNext() != node){
            currentNode = currentNode.getNext();
        }
        if (currentNode == null) {
            return;
        }
        currentNode.setNext(currentNode.getNext().getNext());
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
        DNode current = super.head.getNext();
        while (current != null) {
            DNode temp = current.getNext();
            DNode previous = null;
            DNode traverse = super.head;
            while (traverse != current && traverse.getData() < current.getData()) {
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
    public void clear(){
        super.head = null;
        super.size = 0;
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
        DNode current = super.head;
        current = super.head;
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
        current = super.head;
        System.out.print("List content: ");
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
    }
}
