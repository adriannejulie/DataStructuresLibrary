package main.java.mylib.datastructures.trees;

import main.java.mylib.datastructures.nodes.TNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;



public class GraphTest{



    @Test
    public void testConstructors(){


        boolean passed = true;
        try{
            TNode oneNode = new TNode(1,0,null,null,null);
            TNode twoNode = new TNode(2, 0, null, null, null);
            TNode threeNode = new TNode(3, 0, oneNode, null, null);
            BST binaryTreeNoArg = new BST();
            BST binaryTreeValArg = new BST(4);
            BST binaryTreeNodeArg = new BST(twoNode);
            AVL avlTreeNoArg = new AVL();
            AVL avlTreeValArg = new AVL(4);
            AVL avlTreeNodeArgSingle = new AVL(twoNode);
            AVL avlTreeNodeArgBalance = new AVL(oneNode);
        }
        catch(Exception e){
            passed = false;
        }

        assertTrue("Constructors did not work", passed);

    }

    @Test
    public void testSearch(){

        boolean passed = true;

        try{

            BST b = new BST(5);

            if(b.search(5) == null){

                passed = false;
            }
        }
        catch(Exception e){ passed = false;}

        assertTrue("Search Method does not work", passed);
    }



    @Test
    public void TestBSTInsertData(){

        boolean passed = false;

        try{


            BST binaryTreeNoArg = new BST();

            binaryTreeNoArg.insert(1);

            if (binaryTreeNoArg.search(1) != null){

                passed = true;

            }

        }

        catch(Exception e){}

        assertTrue("Insert function did not work properly", passed);
    }

    @Test
    public void TestBSTInsertNode(){

        boolean passed = false;

        try{

            TNode oneNode = new TNode(1,0,null,null,null);

            BST binaryTreeNoArg = new BST();

            binaryTreeNoArg.insert(oneNode);

            if (binaryTreeNoArg.search(1) != null){

                passed = true;

            }

        }

        catch(Exception e){}

        assertTrue("Insert function did not work properly", passed);
    }

    @Test
    public void TestBSTDelete(){

        boolean passed = true;

        TNode fourNode = new TNode(4,0,null,null,null);

        BST binaryTreeNoArg = new BST();

        binaryTreeNoArg.insert(fourNode);


        try{

            //Delete something that is not there
            binaryTreeNoArg.delete(5);
        }
        catch(Exception e){ passed = false;}

        try{

            binaryTreeNoArg.delete(4);
        }
        catch(Exception e){passed = false;}


        if (binaryTreeNoArg.search(4) != null){

            passed = false;

        }

        
        assertTrue("Delete function did not work properly", passed);



    }


    @Test
    public void testPrintInOrder(){

        boolean passed = true;
        TNode oneNode = new TNode(1,0,null,null,null);
        TNode twoNode = new TNode(2, 0, null, null, null);
        TNode threeNode = new TNode(3, 0, null, null, null);
        TNode fiveNode = new TNode(5,0,null,null,null);
        TNode sevenNode = new TNode(7, 0, null, null, null);
        TNode sixtyNode = new TNode(60, 0, null, null, null);


        BST b = new BST(oneNode);

        b.insert(twoNode);
        b.insert(threeNode);
        b.insert(fiveNode);
        b.insert(sevenNode);
        b.insert(sixtyNode);

        try{
            b.printInOrder(oneNode);
        }
        catch(Exception e){passed = false;}

        assertTrue("Print in order does not work", passed);
    }

    @Test
    public void testPrintBF(){

        boolean passed = true;
        TNode oneNode = new TNode(1,0,null,null,null);
        TNode twoNode = new TNode(2, 0, null, null, null);
        TNode threeNode = new TNode(3, 0, null, null, null);
        TNode fiveNode = new TNode(5,0,null,null,null);
        TNode sevenNode = new TNode(7, 0, null, null, null);
        TNode sixtyNode = new TNode(60, 0, null, null, null);


        BST b = new BST(oneNode);

        b.insert(twoNode);
        b.insert(threeNode);
        b.insert(fiveNode);
        b.insert(sevenNode);
        b.insert(sixtyNode);

        try{
            b.printBF();
        }
        catch(Exception e){passed = false;}

        assertTrue("Print in order does not work", passed);
    }


    @Test
    public void testExistingConvert(){

        boolean passed = true;
        
        TNode oneNode = new TNode(1,0,null,null,null);
        TNode twoNode = new TNode(2, 0, oneNode, null, null);
        TNode threeNode = new TNode(3, 0, twoNode, null, null);

        AVL a = new AVL();



        try{


            a.setRoot(oneNode);

        }
        catch(Exception e){ passed = false;}

        assertTrue("Method convertBSTToAVL does not work", passed);
    }

}