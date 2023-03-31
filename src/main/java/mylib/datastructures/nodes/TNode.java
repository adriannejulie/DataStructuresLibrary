package main.java.mylib.datastructures.nodes;

public class TNode {
    private int data;
    private TNode left;
    private TNode right;
    private TNode parent;
    private int balance;

    /*
     * constructor
     * Initializes members to default values
     * No params
     */
    public TNode(){
        this.data = 0;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.balance = 0;
    }

    /*
     * Overload
     * An overload constructor that takes an integer data, 
     * an integer balance to initialize the data and balance members. 
     * Initializes the parent using the P argument, 
     * L to initialize left child, and R to initialize right child
     */
    
    public TNode(int data, int balance, TNode P, TNode L, TNode R){
        this.data = data;
        this.parent = P;
        this.left = L;
        this.right= R;
        this.balance = balance;
    }

    /*Setters and Getters */

    public void setBalance(int balance) {

    }

    public void setData(int data){

    }

    public void setParent(TNode parent) {

    }

    public void setRight(TNode right) {

    }

    public void setLeft(TNode left) {

    }

    public int 
}
