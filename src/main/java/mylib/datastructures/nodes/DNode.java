package main.java.mylib.datastructures.linear.nodes;

public class DNode<T> extends SNode<T> {

    private DNode<T> previousNode;
    private DNode<T> head;
    private DNOde<T> tail;

    public DNode(){
        this.head = null;
        this.tail = null;
    }

    public DNode<T> getHead() {
        return this.head;
    }

    public void setHead(DNode<T> head) {
        this.head = head;
    }

    public DNode<T> getTail() {
        return this.tail;
    }

    public void setTail(DNode<T> tail) {
        this.tail = tail;
    }

    public DNode (T value) {
        super(value);
        this.previousNode = null;
    }
    public void setPreviousNode(DNode<t> previousNode) {
        this.previousNode = previousNode;
    }

    public DNode<T> getPreviousNode() {
        return this.previousNode;
    }
    
}
