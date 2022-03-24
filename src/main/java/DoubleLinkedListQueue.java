import java.util.Comparator;

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
        if(node == null){
            throw new RuntimeException("Nodo pasado como argumento es nulo");
        }else{
            if(first == null) first = last = node;
            else {
                node.setNext(first);
                first.setPrevious(node);
                first = node;
            }
        }
    }
    public void appendLeft(DequeNode<T> node){
        if(node == null){
            throw new RuntimeException("Nodo pasado como argumento es nulo");
        }else{
            if(last == null) first = last = node;
            else {
                node.setPrevious(last);
                last.setNext(node);
                last = node;
            }
        }
    }

    public void deleteFirst(){
        if(first != null){
            first = first.getNext();
            if(first == null) last = null;
            else first.setPrevious(null);
        }
    }

    public void deleteLast(){
        if(first != null){
            last = last.getPrevious();
            if(last == null) first = null;
            else last.setNext(null);
        }
    }

    public DequeNode<T> peekFirst(){
        return first;
    }

    public DequeNode<T> peekLast(){
        return last;
    }

    public int size(){
        int l = 0;
        DequeNode<T> nodo1 = first;
        DequeNode<T> nodo2 = last;
        while(nodo1 != nodo2 && nodo1.getPrevious() != nodo2){
            l+=2;
            nodo1 = nodo1.getNext();
            nodo2 = nodo2.getPrevious();
        }
        if(nodo1 == nodo2) l++;
        return l;
    }

    @Override
    public DequeNode<T> getAt(int position) {
        DequeNode<T> nodo1 = first;
        if(nodo1 == null)
            throw new RuntimeException("La lista es nula");
        else if(position < 1 && position > this.size())
            throw new RuntimeException("Posicion invalida");
        for (int i = 1; i < position; i++) {
            nodo1.getNext();
        }
        return nodo1;
    }

    @Override
    public DequeNode<T> find(T item) {
        DequeNode<T> nodo1 = first;
        if(nodo1 == null)
            throw new RuntimeException("La lista es nula");
        while(nodo1 != null && !nodo1.getItem().equals(item)){
            nodo1 = nodo1.getNext();
        }
        if(nodo1 == null)
            throw new RuntimeException("Item no encontrado");
        return nodo1;
    }

    @Override
    public void delete(DequeNode<T> node) {
        DequeNode<T> nodo1 = first;
        while(nodo1 != null && !nodo1.equals(node)){
            nodo1 = nodo1.getNext();
        }
        if(nodo1 == null)
            throw new RuntimeException("Item no encontrado");
        if(!nodo1.isNotATerminalNode()){
            first = null;
            last = null;
        }
        else if(nodo1.isLastNode()){
            nodo1.getPrevious().setNext(null);
            last = last.getPrevious();
        }
        else if(nodo1.isFirstNode()) {
            nodo1.getNext().setPrevious(null);
            first = first.getNext();
        }
        else {
            nodo1.getPrevious().setNext(nodo1.getNext());
            nodo1.getNext().setPrevious(nodo1.getPrevious());
        }
    }

    @Override
    public void sort(Comparator<?> comparator) {

    }
}
