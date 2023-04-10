package main.java.mylib.datastructures.nodes;

public class DNode  {

    private DNode prev;
    private DNode next;
    private int data;

    public DNode() {
        this.data = 0;
        this.next = null;
        this.prev = null;

    }

    public DNode (int data) {
        this.prev = null;
        this.next = null;
        this.data = data;
    }

    public void setPrev(DNode node) {
        this.prev = node;
    }
    public void setNext(DNode node) {
        this.next = node;
    }
    public void setData(int data) {
        this.data = data;
    }

    public DNode getPrev() {
        return this.prev;
    }
    public DNode getNext() {
        return this.next;
    }
    public int getData() {
        return this.data;
    }
}
