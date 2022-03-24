import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
  * @param <T>
 */

class DoubleLinkedListQueueTest<T> {
    private DoubleEndedQueue<Integer> ddl;
    private DequeNode<Integer> nodo1, nodo2;

    @BeforeEach
     public void setup(){
        ddl = new DoubleLinkedListQueue<Integer>();
        nodo1 = new DequeNode<Integer>(1,null, null);
        nodo2 = new DequeNode<Integer>(2,null, null);
     }
    @BeforeEach
    public void clear(){
        ddl = null;
    }

    @Test
     public void AppendChangesTheFirstNode(){
        ddl.append(nodo1);
        assertEquals(nodo1,ddl.peekFirst());
    }
    @Test
    public void AppendLeftChangesTheLastNode(){
        ddl.appendLeft(nodo1);
        assertEquals(nodo1,ddl.peekLast());
    }
    @Test
    public void DeleteLastChangesTheLastNodeToPrevious(){
        ddl.appendLeft(nodo1);
        ddl.appendLeft(nodo2);
        ddl.deleteLast();
        assertEquals(nodo1,ddl.peekLast());
    }
    @Test
    public void DeleteFirstChangesTheFirstNodeToNext(){
        ddl.appendLeft(nodo1);
        ddl.appendLeft(nodo2);
        ddl.deleteFirst();
        assertEquals(nodo2,ddl.peekFirst());
    }
    @Test
    public void PeekFirstReturnsFirstElement(){
        ddl.appendLeft(nodo1);
        ddl.appendLeft(nodo2);
        assertEquals(nodo1,ddl.peekFirst());
    }
    @Test
    public void PeekLastReturnsLastElement(){
        ddl.appendLeft(nodo1);
        ddl.appendLeft(nodo2);
        assertEquals(nodo2,ddl.peekLast());
    }
    @Test
    public void ListOf2ElementsReturnSize2(){
        ddl.appendLeft(nodo1);
        ddl.appendLeft(nodo2);
        assertEquals(2,ddl.size());
    }



}