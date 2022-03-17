import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    /*@Test
     public void shouldAppendChangeTheLastNode(){
        DequeNodeexpectedValue = nodo;
        int obtainedValue =
        assertEquals(expectedValue,);
    }*/


}