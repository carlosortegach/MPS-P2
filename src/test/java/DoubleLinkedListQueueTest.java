package org.wingaben.doubleendedqueue;

import org.junit.jupiter.api.Test;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DoubleLinkedListQueueTest {

    @Test
    public void testDeleteFirstNodeChangesFirstNode(){
        var ddl = new DoubleLinkedListQueue<Integer>();
        var node1 = new DequeNode<>(1,null, null);
        var node2 = new DequeNode<>(2,null, null);
        ddl.appendLeft(node1);
        ddl.appendLeft(node2);
        ddl.deleteFirst();

        assertEquals(1,ddl.size());
        assertEquals(node1,ddl.peekFirst());
    }

    @Test
    public void testDeleteLastNodeChangesLastNode(){
        var ddl = new DoubleLinkedListQueue<Integer>();
        var node1 = new DequeNode<>(1,null, null);
        var node2 = new DequeNode<>(2,null, null);
        ddl.appendLeft(node1);
        ddl.appendLeft(node2);
        ddl.deleteLast();

        assertEquals(1,ddl.size());
        assertEquals(node2,ddl.peekLast());
    }

    @Test
    public void testGetAtPosition2ReturnsNode2(){
        var ddl = new DoubleLinkedListQueue<Integer>();
        var node1 = new DequeNode<>(1,null, null);
        var node2 = new DequeNode<>(2,null, null);
        ddl.append(node1);
        ddl.append(node2);
        assertEquals(node2,ddl.getAt(2));
    }

    @Test
    public void testFindItemReturnsItem(){
        var ddl = new DoubleLinkedListQueue<Integer>();
        var node1 = new DequeNode<>(1,null, null);
        var node2 = new DequeNode<>(2,null, null);
        ddl.append(node1);
        ddl.append(node2);

        assertEquals(node2,ddl.find(2));
    }

    @Test
    public void testDeleteLastNode(){
        var ddl = new DoubleLinkedListQueue<Integer>();
        var node1 = new DequeNode<>(1,null, null);
        var node2 = new DequeNode<>(2,null, null);
        var node3 = new DequeNode<>(3,null, null);
        ddl.append(node1);
        ddl.append(node2);
        ddl.append(node3);
        ddl.delete(node3);

        assertEquals(node1,ddl.peekFirst());
        assertEquals(node2,ddl.peekLast());
    }

    @Test
    public void testDeleteFirstNode(){
        var node1 = new DequeNode<>(1,null, null);
        var node2 = new DequeNode<>(2,null, null);
        var node3 = new DequeNode<>(3,null, null);
        var ddl = new DoubleLinkedListQueue<Integer>();
        ddl.append(node1);
        ddl.append(node2);
        ddl.append(node3);
        ddl.delete(node1);

        assertEquals(node2,ddl.peekFirst());
        assertEquals(node3,ddl.peekLast());
    }

    @Test
    public void testDeleteMiddleNode(){
        var node1 = new DequeNode<>(1,null, null);
        var node2 = new DequeNode<>(2,null, null);
        var node3 = new DequeNode<>(3,null, null);
        var ddl = new DoubleLinkedListQueue<Integer>();
        ddl.append(node1);
        ddl.append(node2);
        ddl.append(node3);
        ddl.delete(node2);

        assertEquals(node1,ddl.peekFirst());
        assertEquals(node3,ddl.peekLast());
    }

    @Test
    public void testSortingNodes(){
        var node1 = new DequeNode<>(1,null, null);
        var node2 = new DequeNode<>(2,null, null);
        var node3 = new DequeNode<>(3,null, null);
        var ddl = new DoubleLinkedListQueue<Integer>();
        ddl.append(node3);
        ddl.append(node1);
        ddl.append(node2);
        node1.setItem(1);
        Comparator<Integer> comparator = Comparator.comparingInt(o -> o);
        ddl.sort(comparator);

        assertEquals(node1, ddl.peekFirst());
        assertEquals(node3, ddl.peekLast());
    }

    @Test
    public void testAppendOfANullNodeRaisesAnException(){
        var ddl = new DoubleLinkedListQueue<Integer>();
        assertThrows(RuntimeException.class, ()->ddl.append(null)) ;
    }
    @Test
    public void testAppendLeftOfANullNodeRaisesAnException(){
        var ddl = new DoubleLinkedListQueue<Integer>();
        assertThrows(RuntimeException.class, ()->ddl.appendLeft(null)) ;
    }

    @Test
    public void testFindOfANullItemRaisesAnException(){
        var ddl = new DoubleLinkedListQueue<Integer>();
        assertThrows(RuntimeException.class, ()->ddl.find(null)) ;
    }

    @Test
    public void testDeleteOfANullNodeRaisesAnException(){
        var ddl = new DoubleLinkedListQueue<Integer>();
        assertThrows(RuntimeException.class, ()->ddl.delete(null)) ;
    }

    @Test
    public void testGetAtOfALowerPositionRaisesAnException(){
        var ddl = new DoubleLinkedListQueue<Integer>();
        assertThrows(RuntimeException.class, ()->ddl.getAt(0)) ;
    }

    @Test
    public void testGetAtOfAHigherPositionRaisesAnException(){
        var node1 = new DequeNode<>(1,null, null);
        var node2 = new DequeNode<>(2,null, null);
        var ddl = new DoubleLinkedListQueue<Integer>();
        ddl.appendLeft(node1);
        ddl.appendLeft(node2);
        assertThrows(RuntimeException.class, ()->ddl.getAt(3)) ;
    }
}