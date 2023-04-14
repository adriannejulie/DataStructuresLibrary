package main.java.mylib.datastructures.nodes;

public class SNode {
   
        int data; // the data that the node holds
        SNode next; // the next node in the linked list
    
        // constructor to create a new node with the given data
        public SNode(int data) {
            this.data = data;
            this.next = null;
        }
    
        public SNode() {
            this.data = 0;
            this.next = null;

        }

        // getter and setter methods for the data field
        public int getData() {
            return data;
        }
    
        public void setData(int data) {
            this.data = data;
        }
    
        // getter and setter methods for the next field
        public SNode getNext() {
            return next;
        }
    
        public void setNext(SNode next) {
            this.next = next;
        }
    
}