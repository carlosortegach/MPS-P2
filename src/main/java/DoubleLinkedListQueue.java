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
                node.setPrevious(last);
                last.setNext(node);
                last = node;
            }
        }
    }
    public void appendLeft(DequeNode<T> node){
        if(node == null){
            throw new RuntimeException("Nodo pasado como argumento es nulo");
        }else{
            if(last == null) first = last = node;
            else {
                node.setNext(first);
                first.setPrevious(node);
                first = node;
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
        if(position < 1 || position > this.size())
            throw new RuntimeException("Posicion invalida");
        DequeNode<T> node = first;
        for (int i = 1; i < position; i++) {
            node = node.getNext();
        }
        return node;
    }

    @Override
    public DequeNode<T> find(T item) {
        if(item == null)
            throw new RuntimeException("Item nulo");
        DequeNode<T> node = first;
        while(node != null && !node.getItem().equals(item)){
            node = node.getNext();
        }
        return node;
    }

    @Override
    public void delete(DequeNode<T> node) {
        if(node == null)
            throw new RuntimeException("Nodo nulo");
        DequeNode<T> node1 = first;
        while(node1 != null && !node1.equals(node)){
            node1 = node1.getNext();
        }
        if(!node1.isNotATerminalNode()){
            first = null;
            last = null;
        }
        else if(node1.isLastNode()){
            node1.getPrevious().setNext(null);
            last = last.getPrevious();
        }
        else if(node1.isFirstNode()) {
            node1.getNext().setPrevious(null);
            first = first.getNext();
        }else {
            node1.getPrevious().setNext(node1.getNext());
            node1.getNext().setPrevious(node1.getPrevious());
        }
    }

    @Override
    public void sort(Comparator<Integer> comparator) {
        DequeNode<Integer> current, index;
        if(first != null) {
            //Current will point to head
            for(current = (DequeNode<Integer>) first; current.getNext() != null; current = current.getNext()) {
                //Index will point to node next to current
                for(index = current.getNext(); index != null; index = index.getNext()) {
                    if(comparator.compare(current.getItem(), index.getItem())>=0){
                        Integer tmp=current.getItem();
                        current.setItem(index.getItem());
                        index.setItem(tmp);

                    }
                }
            }
        }


    }
}
