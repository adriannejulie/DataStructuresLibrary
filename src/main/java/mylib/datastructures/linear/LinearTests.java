package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;
import main.java.mylib.datastructures.nodes.SNode;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Before;

public class LinearTests {
    private SLL myList;
    SNode node1;
    SNode node2;
    SNode node3;
    SNode node4;
    
    /**
     * Tests SLL file
     */

    @Before
    public void setupNodes(){
        /**
         * Calls Constructors
         */
        myList = new SLL();
        node1 = new SNode(1);
        node2 = new SNode(2);
        node3 = new SNode(3);
        node4 = new SNode(4);
    }

    /**
     * Tests method insertHead(SNode), isEmpty(), getHead(), and deleteHead()
     */
    @Test
    public void testInsertHead() {
        setupNodes();

        myList.insertHead(node1);
        assertEquals(node1, myList.getHead());

        myList.insertHead(node2);
        assertEquals(node2, myList.getHead());

        myList.insertHead(node3);
        assertEquals(node3, myList.getHead());

        SNode node = myList.getHead();
        assertEquals("Head node is not as expected.", node3, node);

        boolean listState = myList.isEmpty();
        assertFalse(listState);

        SNode headNode = myList.deleteHead();
        assertEquals("Head node was not deleted and returned", node3, headNode);
    }

    /**
     * Tests methods insertTail(SNode), deleteTail(), and search(SNode)
     */
    @Test
    public void testInsertTail() {
        myList.insertTail(node1);
        assertEquals(node1, myList.getHead());

        myList.insertTail(node2);
        assertEquals(node1.getNext(), node2);

        myList.insertTail(node3);
        assertEquals(node1.getNext().getNext(), node3);

        myList.deleteTail();
        SNode node = myList.search(node3);
        assertNull(node);
    }

    /**
     * Tests method insert(SNode, int), getSize(), and delete(SNode);
     */
    @Test
    public void testInsert() {
        myList.insert(node1, 0);
        assertEquals(node1, myList.getHead());

        myList.insert(node3, 1);
        assertEquals(node3, myList.getHead().getNext());

        myList.insert(node2, 1);
        assertEquals(node2, myList.getHead().getNext());

        int size = myList.getSize();

        assertThrows(IndexOutOfBoundsException.class, () -> {
            myList.insert(node4, -1);
        });
        assertEquals("Size of the list is not equal.", size, 3);

        myList.delete(node1);
        SNode node = myList.search(node1);
        assertNull(node);
    }

    /**
     * Tests method sortedInster(SNode) and search(SNode)
     */

    @Test
    public void testSortedInsert() {
        myList.sortedInsert(node3);
        assertEquals(node3, myList.getHead());

        myList.sortedInsert(node2);
        assertEquals(node2, myList.getHead());

        myList.sortedInsert(node4);
        assertEquals(node4, myList.getHead().getNext().getNext());
        myList.sortedInsert(node1);
        assertEquals(node1, myList.getHead());

        SNode node = myList.search(node3);
        assertEquals("Node was not found", node3, node);
    }

    /**
     * Tests methods isEmpty(), insertHead(SNode), and clear()
     */
    @Test
    public void testIsEmpty() {
        assertTrue(myList.isEmpty());

        myList.insertHead(node1);
        assertFalse(myList.isEmpty());

        myList.clear();
        assertTrue(myList.isEmpty());
    }


    /**
     * Tests DLL file
     */

     /**
      * Tests methods insertHead(DNode)
      */
     @Test
     public void testInsertHeadDouble() {
        DLL myList = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        myList.insertHead(node1);
        myList.insertHead(node2);
        myList.insertHead(node3);

        assertEquals(node3, myList.getHead());
        assertEquals(node2, myList.getHead().getNext());
        assertEquals(node1, myList.getHead().getNext().getNext());
    }

    /**
     * Tests methods insertTail(DNode), getTail()
     */
    @Test
    public void testInsertTailDouble() {
        DLL myList = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        myList.insertTail(node1);
        myList.insertTail(node2);
        myList.insertTail(node3);

        assertEquals(node1, myList.getTail().getPrev().getPrev());
        assertEquals(node2, myList.getTail().getPrev());
        assertEquals(node3, myList.getTail());

        myList.deleteTail();
        DNode node = myList.search(node3);
        assertNull(node);
    }

    /**
     * Tests methods insert(DNode, int), getHead(), getSize(), 
     * deleteHead(), delete(DNode), search(), clear()
     */
    @Test
    public void testInsertDouble() {
        DLL myList = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        myList.insert(node1, 0);
        myList.insert(node2, 1);
        myList.insert(node3, 1);

        assertEquals(node1, myList.getHead());
        assertEquals(node3, myList.getHead().getNext());

        int size = myList.getSize();
        assertEquals("Size is not as expected", size, 3);

        myList.deleteHead();
        assertEquals(node3, myList.getHead());

        myList.delete(node3);
        assertNotNull(myList.search(node3));

        myList.clear();
        boolean isEmpty = (myList.getHead() == null);
        assertTrue(isEmpty);

    }

    /**
     * Tests methods sortedInsert(DNode), getTail(), search(DNode)
     */
    @Test
    public void testSortedInsertDouble() {
        DLL myList = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        myList.sortedInsert(node2);
        myList.sortedInsert(node1);
        myList.sortedInsert(node3);

        assertEquals(node1, myList.getTail().getPrev().getPrev());
        assertEquals(node2, myList.getTail().getPrev());
        assertEquals(node3, myList.getTail());

        DNode search = myList.search(node1);
        assertEquals("Node was not found", node1, search);
    }


    /**
     * Tests for class CSLL
     */

     /**
      * Tests constructors and method getSize()
      */
     @Test
    public void testEmptyList() {
        CSLL list = new CSLL();
        assertEquals(0, list.getSize());
    }
    
    /**
     * Tests methods insertHead(SNode), getSize(), getHead(), clear()
     */
    @Test
    public void testInsertHeadCS() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(1);
        list.inserthead(node1);
        assertEquals(1, list.getSize());
        assertEquals(node1, list.getHead());
        SNode node2 = new SNode(2);
        list.inserthead(node2);
        assertEquals(2, list.getSize());
        assertEquals(node2, list.getHead());
        assertEquals(node1, list.getHead().getNext());
        list.clear();
        assertEquals(0, list.getSize());

    }
    
    /**
     * Tests methods insertTail(SNode), getSize()
     */
    @Test
    public void testInsertTailCS() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(1);
        list.insertTail(node1);
        assertEquals(1, list.getSize());        
        SNode node2 = new SNode(2);
        list.insertTail(node2);
        assertEquals(2, list.getSize());
        
    }
    
    /**
     * Tests methods insert(SNode, position), getHead(), getSize()
     * deleteHead(), search(SNode)
     */
    @Test
    public void testInsertCS() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(1);
        list.insert(node1, 0);
        assertEquals(1, list.getSize());
        assertEquals(node1, list.getHead());
        SNode node2 = new SNode(2);
        list.insert(node2, 1);
        assertEquals(2, list.getSize());
        assertEquals(node1, list.getHead());
        assertEquals(node2, list.getHead().getNext());
        SNode node3 = new SNode(3);
        list.insert(node3, 1);
        assertEquals(3, list.getSize());
        assertEquals(node1, list.getHead());
        assertEquals(node3, list.getHead().getNext());
        assertEquals(node2, list.getHead().getNext().getNext());

        list.deleteHead();
        assertEquals(node3, list.getHead());

        SNode node = list.search(node2);
        assertEquals(node2, node);


    }

    /**
     * Tests for CDLL class
     */

    private CDLL list;

    @Before
    public void setUp() {
        list = new CDLL();
    }

    /**
     * Tests methods insertHead(DNode), getHead()
     */
    @Test
    public void testInsertHeadCD() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        list.insertHead(node1);
        assertEquals(list.getHead(), node1);
        list.insertHead(node2);
        assertEquals(list.getHead(), node2);
        assertEquals(list.getHead().getNext(), node1);
    }
    
    /**
     * Tests method insertTail(DNode), getHead(), deleteTail()
     */
    @Test
    public void testInsertTailCD() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        list.insertTail(node1);
        assertEquals(list.getHead(), node1);
        list.insertTail(node2);
        assertEquals(list.getHead().getNext(), node2);
        list.deleteTail();
        assertNull(list.search(node2));
    }

    /**
     * Tests insert(DNode, int), getHead()
     */
    @Test
    public void testInsertCD() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.insert(node1, 0);
        assertEquals(list.getHead(), node1);
        list.insert(node2, 1);
        assertEquals(list.getHead().getNext(), node2);
        list.insert(node3, 1);
        assertEquals(list.getHead().getNext().getNext(), node2);
        assertEquals(list.getHead().getNext(), node3);
    }

    /**
     * Tests sortedInsert(DNode), getHead(), deleteHead(), search(DNode), delete(DNode)
     */
    @Test
    public void testSortedInsertCD() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.sortedInsert(node2);
        assertEquals(list.getHead(), node2);
        list.sortedInsert(node1);
        assertEquals(list.getHead(), node1);
        assertEquals(list.getHead().getNext(), node2);
        list.sortedInsert(node3);
        assertEquals(list.getHead().getNext().getNext(), node3);
        list.deleteHead();
        assertNull(list.search(node1));
        list.delete(node2);
        assertNull(list.search(node2));


    }

    /**
     * Tests methods insertHead(), search(), clear()
     */
    @Test
    public void testSearchCD() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.insertHead(node1);
        list.insertHead(node2);
        list.insertHead(node3);
        assertEquals(list.search(node2), node2);
        assertNull(list.search(new DNode(4)));
        list.clear();
        assertEquals("List is not empty.", 0, list.getSize());
    }

    /**
     * Tests IndexOutOfBoundsException
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertOutOfBounds() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        list.insert(node1, 1);
        list.insert(node2, 3);
    }

    /**
     * Tests for Class QueueLL
     */

     /**
      * Tests method enqueue(SNode)
      */
     @Test
     public void testEnqueue() {
         QueueLL queue = new QueueLL();
         SNode node = new SNode(1);
         queue.enqueue(node);
         Assert.assertEquals(node, queue.peek());
     }
     
     /**
      * Tests method dequeue() and NoSuchElementException 
      */
     @Test(expected = NoSuchElementException.class)
     public void testDequeueWhenQueueIsEmpty() {
         QueueLL queue = new QueueLL();
         queue.dequeue();
     }
     
     /**
      * Tests methods enqueue(SNode), dequeue(), peek()
      */
     @Test
     public void testDequeue() {
         QueueLL queue = new QueueLL();
         SNode node1 = new SNode(1);
         SNode node2 = new SNode(2);
         queue.enqueue(node1);
         queue.enqueue(node2);
         SNode dequeuedNode = queue.dequeue();
         Assert.assertEquals(node1, dequeuedNode);
         Assert.assertEquals(node2, queue.peek());
     }

     /**
      * Tests NoSuchElementException and peek()
      */
     @Test(expected = NoSuchElementException.class)
     public void testPeekWhenQueueIsEmpty() {
         QueueLL queue = new QueueLL();
         queue.peek();
     }
     
     /**
      * Tests methods peek() and enqueue(SNode)
      */
     @Test
     public void testPeekS() {
         QueueLL queue = new QueueLL();
         SNode node = new SNode(1);
         queue.enqueue(node);
         Assert.assertEquals(node, queue.peek());
     }
     
     /**
      * Tests methods enqueue(SNode), sort(), and peek()
      */
     @Test
     public void testSort() {
         QueueLL queue = new QueueLL();
         SNode node1 = new SNode(1);
         SNode node2 = new SNode(2);
         queue.enqueue(node2);
         queue.enqueue(node1);
         queue.sort();
         Assert.assertEquals(node1, queue.peek());
     }
     
     /**
      * Tests methods enqueue(SNode), clear(), isEmpty()
      */
     @Test
     public void testClear() {
         QueueLL queue = new QueueLL();
         SNode node = new SNode(1);
         queue.enqueue(node);
         queue.clear();
         Assert.assertEquals(true, queue.isEmpty());
     }
     
     /**
      * Tests methods enqueue(SNode), isEmpty()
      */
     @Test
     public void testIsEmptyQueue() {
         QueueLL queue = new QueueLL();
         Assert.assertEquals(true, queue.isEmpty());
         SNode node = new SNode(1);
         queue.enqueue(node);
         Assert.assertEquals(false, queue.isEmpty());
     }
     
     /**
      * Tests methods seatch(SNode)
      */
     @Test
     public void testSearchWhenNodeIsNotInList() {
         QueueLL queue = new QueueLL();
         SNode node = new SNode(1);
         SNode result = queue.search(node);
         Assert.assertEquals(null, result);
     }
     
     /**
      * Tests methods enqueue(SNode) and seach(SNode)
      */
     @Test
     public void testSearchWhenNodeIsInList() {
         QueueLL queue = new QueueLL();
         SNode node = new SNode(1);
         queue.enqueue(node);
         SNode result = queue.search(node);
         Assert.assertEquals(node, result);
     }


     /**
      * Tests for StackLL class
      */
    private StackLL stack;

     /**
      * Setup for stack
      */
    @Before
    public void setUpStack() {
        stack = new StackLL();
        node1 = new SNode(1);
        node2 = new SNode(2);
        node3 = new SNode(3);
    }
    /**
     * Tests methods push(SNode)
     */
    @Test
    public void testPush() {
        stack.push(node1);
        assertEquals(node1, stack.peek());
        stack.push(node2);
        assertEquals(node2, stack.peek());
    }

    /**
     * Tests methods push(SNode), pop(), and isEmpty()
     */
    @Test
    public void testPop() {
        stack.push(node1);
        stack.push(node2);
        assertEquals(node2, stack.pop());
        assertEquals(node1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    /**
     * Tests methods push(SNode), peek(), pop()
     */
    @Test
    public void testPeek() {
        stack.push(node1);
        stack.push(node2);
        assertEquals(node2, stack.peek());
        stack.pop();
        assertEquals(node1, stack.peek());
    }

    /**
     * Tests methods isEmpty(), push(), pop()
     */
    @Test
    public void testIsEmptyStack() {
        assertTrue(stack.isEmpty());
        stack.push(node1);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }
    /**
     * Tests methods push(SNode), isEmpty(), clear()
     */
    @Test
    public void testClearStack() {
        stack.push(node1);
        stack.push(node2);
        stack.push(node3);
        assertFalse(stack.isEmpty());
        stack.clear();
        assertTrue(stack.isEmpty());
    }
}
