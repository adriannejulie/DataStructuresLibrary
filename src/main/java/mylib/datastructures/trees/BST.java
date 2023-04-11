/**
@author Braden Vivas
braden.vivas@ucalgary.ca
@version 1.0
@since 1.0

*/



package main.java.mylib.datastructures.trees;

import main.java.mylib.datastructures.nodes.TNode;

/*
 * BST is a class that defines a Binary Search Tree. 
 * It contains a root node that connects other nodes together to create a Tree Structure.
 * Features such as Inserting, Deleting and Searching are implemented
 */
public class BST {


    private TNode root;

    /*
     * Constructor, sets root node to null
     */
    public BST(){
        
        this.root = null;
    
    }

    public BST(int val){

        this.root = new TNode(val, 0, null, null, null);

    }

    public BST(TNode obj){

        this.root = obj;
    }

    /* Setter and Getter for root node:*/

    public void setRoot(TNode newRoot){this.root = newRoot;}
    public TNode getRoot(){return this.root;}


    public void insert(int val){

        TNode newTnode = new TNode(val, 0, null, null, null);

        TNode current = getRoot();

        TNode parent = new TNode();

        //Find the parent of the new node to be added
        while (current != null){

            parent = current;
            if (val <= current.getData()){
                current = current.getLeft();
            }
            else{
                current = current.getRight();
            }
        }

        if (this.root == null){
            setRoot(newTnode);
        }
        else if (val <= parent.getData()){

            parent.setLeft(new TNode(val, 0, parent, null, null));
        }
        else{
            parent.setRight(new TNode(val, 0, parent, null, null));
        }
    }

    public void insert(TNode node){

        int val = node.getData();

        TNode current = getRoot();

        TNode parent = new TNode();

        //Find the parent of the new node to be added
        while (current != null){

            parent = current;
            if (val <= current.getData()){
                current = current.getLeft();
            }
            else{
                current = current.getRight();
            }
        }

        if (this.root == null){
            setRoot(node);
        }
        else if (val <= parent.getData()){

            parent.setLeft(node);
        }
        else{
            parent.setRight(node);
        }
    }

    public void delete(int val) {

        TNode nodeToDelete = search(val);
    
        if (nodeToDelete == null) {
            // Node to delete was not found in the tree
            return;
        }
    
        // Case 1: The node to delete has no children
        if (nodeToDelete.getLeft() == null && nodeToDelete.getRight() == null) {
            if (nodeToDelete == root) {
                root = null;
            } else if (nodeToDelete == nodeToDelete.getParent().getLeft()) {
                nodeToDelete.getParent().setLeft(null);
            } else {
                nodeToDelete.getParent().setRight(null);
            }
        }
        // Case 2: The node to delete has only one child
        else if (nodeToDelete.getLeft() == null) {
            transplant(nodeToDelete, nodeToDelete.getRight());
        } else if (nodeToDelete.getRight() == null) {
            transplant(nodeToDelete, nodeToDelete.getLeft());
        }
        // Case 3: The node to delete has two children
        else {
            TNode successor = minimum(nodeToDelete.getRight());
            if (successor.getParent() != nodeToDelete) {
                transplant(successor, successor.getRight());
                successor.setRight(nodeToDelete.getRight());
                successor.getRight().setParent(successor);
            }
            transplant(nodeToDelete, successor);
            successor.setLeft(nodeToDelete.getLeft());
            successor.getLeft().setParent(successor);
        }
    }
    
    private void transplant(TNode u, TNode v) {
        if (u.getParent() == null) {
            root = v;
        } else if (u == u.getParent().getLeft()) {
            u.getParent().setLeft(v);
        } else {
            u.getParent().setRight(v);
        }
        if (v != null) {
            v.setParent(u.getParent());
        }
    }
    
    private TNode minimum(TNode node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }
    
    
    public TNode search(int val){

        return searchRecursive(root, val);

    }

    public TNode searchRecursive(TNode node, int val){

        if (node == null || node.getData() == val)
            return node;

        if (node.getData() > val)
            return searchRecursive(node.getLeft(), val);

        return searchRecursive(node.getRight(), val);
    }


    public void printInOrder(TNode node){

        if (node != null){

            printInOrder(node.getLeft());
            System.out.print(node.getData() + " ");
            printInOrder(node.getRight());
        }

    }

    public void printBF() {
        if (root == null) {
            return;
        }
    
        int height = getHeight(root);
    
        for (int i = 1; i <= height; i++) {
            printLevel(root, i);
        }
    }
    
    private int getHeight(TNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = getHeight(node.getLeft());
            int rightHeight = getHeight(node.getRight());
    
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    
    private void printLevel(TNode node, int level) {
        if (node == null) {
            return;
        }
    
        if (level == 1) {
            System.out.print(node.getData() + " ");
        } else if (level > 1) {
            printLevel(node.getLeft(), level - 1);
            printLevel(node.getRight(), level - 1);
        }
    }
    




}