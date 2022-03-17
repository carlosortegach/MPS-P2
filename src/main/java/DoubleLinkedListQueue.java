/**
 * Class representing a node of a double-ended queue (deque). Each node has pointers to the next and
 * previous nodes. The previous and next of the first and last node of the deque is null.
 *
 * @param <T>
 */
public class DoubleLinkedListQueue<T> implements DoubleEndedQueue<T>{
    private DequeNode<T> first;
    private DequeNode<T> last;

    public void append(DequeNode<T> node){
        if(first == null)
            first = node;
        node.setPrevious(last);
        last = node;
    }
    public void appendLeft(DequeNode<T> node){
        if(first == null)
            last = node;
        node.setNext(first);
        first = node;
    }

    public void deleteFirst(){
        if(first != null){
            if(first == last){
                last = null;
                first = null;
            }else{
                first = first.getNext();
            }
        }
    }

    public void deleteLast(){
        if(first != null){
            if(first == last){
                last = null;
                first = null;
            }else{
                last = last.getPrevious();
            }
        }
    }

    public DequeNode<T> peekFirst(){
        return first;
    }

    public DequeNode<T> peekLast(){
        return last;
    }

    public int size(){
        return 0;
    }
}
