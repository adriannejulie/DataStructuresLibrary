/**
@author Braden Vivas
braden.vivas@ucalgary.ca
@version 1.0
@since 1.0

*/

package main.java.mylib.datastructures.trees;

import main.java.mylib.datastructures.nodes.TNode;

public class AVL extends BST{
   

    private TNode root;

    public AVL(){

        this.root = null;
    }

    public AVL(int val){

        this.root = new TNode(val, 0, null, null, null);
    }

    public AVL(TNode obj){


        if(obj.getLeft() == null && obj.getRight() == null){

            this.root = obj;
            
        }

        else{

            this.root = convertBSTToAVL(obj);
        }
        


    }


    public static TNode convertBSTToAVL(TNode root) {
        if (root == null) {
            return null;
        }
        
        // Step 1: Convert the getLeft() and getRight() subtrees to AVL trees
        root.setLeft(convertBSTToAVL(root.getLeft()));
        root.setRight(convertBSTToAVL(root.getRight()));
        
        // Step 2: Rebalance the current node
        int balanceFactor = getBalanceFactor(root);
        
        if (balanceFactor > 1) {
            if (getBalanceFactor(root.getLeft()) < 0) {
                root.setLeft(rotateLeft((root.getLeft())));
            }
            root = rotateRight(root);
        } else if (balanceFactor < -1) {
            if (getBalanceFactor(root.getRight()) > 0) {
                root.setRight(rotateRight(root.getRight()));
            }
            root = rotateLeft(root);
        }
        
        return root;
    }
    
    private static int getHeight(TNode node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
    }
    
    private static int getBalanceFactor(TNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }
    
    private static TNode rotateRight(TNode node) {
        TNode newRoot = node.getLeft();
        node.setLeft(newRoot.getRight());
        if (newRoot.getRight() != null) {
            newRoot.getRight().setParent(node);
        }
        newRoot.setRight(node);
        newRoot.setParent(node.getParent());
        node.setParent(newRoot);
        node.setBalance(getHeight(node.getLeft()) - getHeight(node.getRight()));
        newRoot.setBalance(getHeight(newRoot.getLeft()) - getHeight(newRoot.getRight()));
        return newRoot;
    }
    
    private static TNode rotateLeft(TNode node) {
        TNode newRoot = node.getRight();
        node.setRight(newRoot.getLeft());
        if (newRoot.getLeft() != null) {
            newRoot.getLeft().setParent(node);
        }
        newRoot.setLeft(node);
        newRoot.setParent(node.getParent());
        node.setParent(newRoot);
        node.setBalance(getHeight(node.getLeft()) - getHeight(node.getRight()));
        newRoot.setBalance(getHeight(newRoot.getLeft()) - getHeight(newRoot.getRight()));
        return newRoot;
    }


    public void setRoot(TNode root){


        this.root = convertBSTToAVL(root);

    }

    public TNode getRoot(){

        return this.root;
    }

    public void insert(int val){

        super.insert(val);

        //Rebalance tree
        this.root = convertBSTToAVL(this.root);

    }

    public void insert(TNode node){

        super.insert(node);

        this.root = convertBSTToAVL(this.root);
    }

    public void delete(int val){

        TNode t = super.search(val);

        if (t == null){

            System.out.println("The value is not found in the tree");
            return;
        }

        super.delete(val);

        
    }
}