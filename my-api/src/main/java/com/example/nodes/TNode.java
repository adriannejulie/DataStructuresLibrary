package mylib.datastructures.nodes;

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

        if (P != null && P.getData() >= data){

            P.setLeft(this);
        }
        else if (P != null && P.getData() < data){

            P.setRight(this);
        }

        this.left = L;
        if (L != null){
        L.setParent(this);}
        this.right= R;
        if(R != null){
        R.setParent(this); }
        this.balance = balance;
    }

    /*Setters and Getters */

    public void setBalance(int balance) { this.balance = balance;}
    public void setData(int data){this.data = data;}
    public void setParent(TNode parent) {this.parent = parent;}
    public void setRight(TNode right) {this.right = right;}
    public void setLeft(TNode left) {this.left = left; }

    public int getData(){return this.data;}
    public TNode getLeft(){return this.left;}
    public TNode getRight(){return this.right;}
    public TNode getParent(){return this.parent;}
    public int getBalance(){return this.balance;}


    public String toString(){

        return String.valueOf(this.data);
        
    } 

    public void print(){

        System.out.println("Node information:");
        System.out.println(String.format("Node Data: %d", this.data));
        System.out.println(String.format("Node Balance: %d", this.balance));
        System.out.println(String.format("Node Parent's Data: %d", this.parent.data));


        System.out.println(String.format("Node's Left Child's Data: %d", this.left.data));
        System.out.println(String.format("Node's Right Child's Data: %d", this.right.data));

    }
}
