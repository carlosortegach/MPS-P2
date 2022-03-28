package org.wingaben.doubleendedqueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test cases:
 * Append node1, node2
 * ddl.peekFirst() --> node1 *
 * ddl.peekLast() --> node2 *
 *
 * AppendLeft node1, node2
 * peekFirst() --> node2 *
 * peekLast() --> node1 *
 * deleteFirst(), peekFirst() --> node2 *
 * deleteLast(), peekLast() --> node1 *
 * size() --> 2 *
 *
 * append(null) --> raises an exception *
 * appendLeft(null) --> raises an exception *
 * getAt(0) --> raises an exception *
 * getAt(3) --> raises an exception *
 * find(null) --> raises an exception *
 * delete(null) --> raises an exception *
 */

class DoubleLinkedListQueueTest<T> {
    private DoubleEndedQueue<T> ddl;
    private DequeNode<T> node1, node2, node3;
    Integer item1 = 1;
    Integer item2 = 2;
    Integer item3 = 3;

    @BeforeEach
     public void setup(){
        ddl = new DoubleLinkedListQueue<>();
        node1 = new DequeNode(item1,null, null);
        node2 = new DequeNode(item2,null, null);
        node3 = new DequeNode(item3,null, null);
    }

    @BeforeEach
    public void clear(){
        ddl = null;
    }

    @Test
    public void testAppendChangesTheFirstNode(){
        ddl.append(node1);
        ddl.append(node2);
        assertEquals(node1,ddl.peekFirst());
    }

    @Test
    public void testAppendChangesTheLastNode(){
        ddl.append(node1);
        ddl.append(node2);
        assertEquals(node2,ddl.peekLast());
    }

    @Test
    public void testAppendLeftChangesFirstNode(){
        ddl.appendLeft(node1);
        ddl.appendLeft(node2);
        assertEquals(node2,ddl.peekFirst());
    }

    @Test
    public void testAppendLeftChangesLastNode(){
        ddl.appendLeft(node1);
        ddl.appendLeft(node2);
        assertEquals(node1,ddl.peekLast());
    }

    @Test
    public void testDeleteFirstNodeChangesFirstNode(){
        ddl.appendLeft(node1);
        ddl.appendLeft(node2);
        ddl.deleteFirst();
        assertEquals(node1,ddl.peekFirst());
    }

    @Test
    public void testDeleteLastNodeChangesLastNode(){
        ddl.appendLeft(node1);
        ddl.appendLeft(node2);
        ddl.deleteLast();
        assertEquals(node2,ddl.peekLast());
    }

    @Test
    public void testTwoNodesReturnsSize2(){
        ddl.appendLeft(node1);
        ddl.appendLeft(node2);
        assertEquals(2,ddl.size());
    }

    @Test
    public void testGetAtPosition2ReturnsNode2(){
        ddl.append(node1);
        ddl.append(node2);
        assertEquals(node2,ddl.getAt(2));
    }

    @Test
    public void testFindItemReturnsItem(){
        ddl.append(node1);
        ddl.append(node2);

        assertEquals(node2,ddl.find((T)item2));
    }

    @Test
    public void testDeleteLastNode(){
        ddl.append(node1);
        ddl.append(node2);
        ddl.append(node3);
        ddl.delete(node3);

        assertEquals(node1,ddl.peekFirst());
        assertEquals(node2,ddl.peekLast());
    }

    @Test
    public void testDeleteFirstNode(){
        ddl.append(node1);
        ddl.append(node2);
        ddl.append(node3);
        ddl.delete(node1);

        assertEquals(node2,ddl.peekFirst());
        assertEquals(node3,ddl.peekLast());
    }

    @Test
    public void testDeleteMiddleNode(){
        ddl.append(node1);
        ddl.append(node2);
        ddl.append(node3);
        ddl.delete(node2);

        assertEquals(node1,ddl.peekFirst());
        assertEquals(node3,ddl.peekLast());
    }

    @Test
    public void testSortingNodes(){
        ddl.append(node3);
        ddl.append(node1);
        ddl.append(node2);
        node1.setItem((T)item1);
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };
        ddl.sort(comparator);

        assertEquals(node1, ddl.peekFirst());
        assertEquals(node3, ddl.peekLast());
    }


    @Test
    public void testAppendOfANullNodeRaisesAnException(){
        assertThrows(RuntimeException.class, ()->ddl.append(null)) ;
    }
    @Test
    public void testAppendLeftOfANullNodeRaisesAnException(){
        assertThrows(RuntimeException.class, ()->ddl.appendLeft(null)) ;
    }

    @Test
    public void testFindOfANullItemRaisesAnException(){
        assertThrows(RuntimeException.class, ()->ddl.find(null)) ;
    }

    @Test
    public void testDeleteOfANullNodeRaisesAnException(){
        assertThrows(RuntimeException.class, ()->ddl.delete(null)) ;
    }

    @Test
    public void testGetAtOfALowerPositionRaisesAnException(){
        ddl.appendLeft(node1);
        ddl.appendLeft(node2);
        assertThrows(RuntimeException.class, ()->ddl.getAt(0)) ;
    }

    @Test
    public void testGetAtOfAHigherPositionRaisesAnException(){
        ddl.appendLeft(node1);
        ddl.appendLeft(node2);
        assertThrows(RuntimeException.class, ()->ddl.getAt(3)) ;
    }
}