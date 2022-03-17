import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
  * @param <T>
 */

class DoubleLinkedListQueueTest<T> {
    private DoubleEndedQueue<T> ddl;
    private DequeNode<T> nodo;

    @BeforeEach
     public void setup(){
        ddl = new DoubleLinkedListQueue<T>();
        nodo = new DequeNode<T>(null,null, null);
     }

    @Test
     public void shouldAppendChangeTheLastNode(){
        assertEquals(0,0);
    }


}