import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases:
 * secondNode.getPrevious --> firstNode *
 * secondNode.getNext --> thirdNode *
 * secondNode.getItem --> newItem *
 * firstNode.isFirstNode --> true *
 * thirdNode.isLastNode --> true *
 * secondNode.isNotATerminalNode --> true *
 * setNext --> newNext *
 * setPrevious --> newPrevious *
 */

public class DequeNodeTest<T> {
    T item;
    DequeNode firstNode ;
    DequeNode secondNode ;
    DequeNode thirdNode ;
    T newItem;
    DequeNode<T> newNext;
    DequeNode<T> newPrevious;

    @BeforeEach
    public void setup(){
        firstNode = new DequeNode(item, secondNode, null) ;
        thirdNode = new DequeNode(item, null, secondNode) ;
        secondNode = new DequeNode(item, thirdNode, firstNode) ;
    }

    @AfterEach
    public void finish(){
        firstNode = null ;
        secondNode = null ;
        thirdNode = null ;
    }

    @Test
    public void testComputeReturnsPreviousNode(){
        DequeNode<T> expectedValue = firstNode;
        DequeNode<T> obtainedValue = secondNode.getPrevious();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void testComputeReturnsNextNode(){
        DequeNode<T> expectedValue = thirdNode;
        DequeNode<T> obtainedValue = secondNode.getNext();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void testComputeReturnsItem(){
        firstNode.setItem(newItem);
        T expectedValue = newItem;
        T obtainedValue = (T) firstNode.getItem();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void testComputeReturnsFirstNode(){
        assertTrue(firstNode.isFirstNode());
    }

    @Test
    public void testComputeReturnsLastNode(){
        assertTrue(thirdNode.isLastNode());
    }

    @Test
    public void testComputeReturnsNotTerminalNode(){
        assertTrue(secondNode.isNotATerminalNode());
    }

    /*@Test
    public void testComputeReturnsSameItem(){
        firstNode.setItem(newItem);
        T expectedValue = newItem;
        T obtainedValue = (T) firstNode.getItem();

        assertEquals(expectedValue, obtainedValue);
    }*/

    @Test
    public void testComputeReturnsSameNextNode(){
        firstNode.setNext(newNext);
        DequeNode<T> expectedValue = newNext;
        DequeNode<T> obtainedValue = firstNode.getNext();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void testComputeReturnsSamePreviousNode() {
        secondNode.setPrevious(newPrevious);
        DequeNode<T> expectedValue = newPrevious;
        DequeNode<T> obtainedValue = secondNode.getPrevious();

        assertEquals(expectedValue, obtainedValue);
    }


}
