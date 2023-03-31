package main.java.mylib.datastructures.linear.nodes;

public class SNode {
    private int value;
    private SNode next;

    public SNode(int value) {
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public SNode getNext() {
        return next;
    }

    public void setNext(SNode next) {
        this.next = next;
    }
}