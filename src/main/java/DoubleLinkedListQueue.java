package org.wingaben.doubleendedqueue;
import java.util.Comparator;

public class DoubleLinkedListQueue<T> implements DoubleEndedQueue<T>{
    private DequeNode<T> first;
    private DequeNode<T> last;

    public void append(DequeNode<T> node){
        if(node == null){
            throw new RuntimeException("Null node");
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
            throw new RuntimeException("Null node");
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
        DequeNode<T> node1 = first;
        DequeNode<T> node2 = last;
        while(node1 != node2 && node1.getPrevious() != node2){
            l+=2;
            node1 = node1.getNext();
            node2 = node2.getPrevious();
        }
        if(node1 == node2) l++;
        return l;
    }

    @Override
    public DequeNode<T> getAt(int position) {
        if(position < 1 || position > this.size())
            throw new RuntimeException("Invalid position");
        DequeNode<T> node = first;
        for (int i = 1; i < position; i++) {
            node = node.getNext();
        }
        return node;
    }

    @Override
    public DequeNode<T> find(T item) {
        if(item == null)
            throw new RuntimeException("Null item");
        DequeNode<T> node = first;
        DequeNode<T> encontrado = null;
        while(node != null){
            if(node.getItem().equals(item))
                encontrado = node;
            node = node.getNext();
        }
        return encontrado;
    }

    @Override
    public void delete(DequeNode<T> node) {
        if(node == null)
            throw new RuntimeException("Null node");
        DequeNode<T> node1 = first;
        while(node1 != null){
            if(node1.equals(node)){
                if(node1.isFirstNode()){
                    node1.getNext().setPrevious(null);
                    first = first.getNext();
                }else if(node1.isLastNode()){
                    node1.getPrevious().setNext(null);
                    last = last.getPrevious();
                }else if(node1.isNotATerminalNode()){
                    node1.getPrevious().setNext(node1.getNext());
                    node1.getNext().setPrevious(node1.getPrevious());
                }
            }
            node1 = node1.getNext();
        }
    }

    @Override
    public void sort(Comparator<Integer> comparator) {
        if (this.size()>1) {
            boolean cambio;
            do {
                DequeNode<T> actual = first;
                DequeNode<T> anterior = null;
                DequeNode<T> siguiente = first.getNext();
                cambio = false;
                while ( siguiente != null ) {
                    if (comparator.compare((Integer) actual.getItem(), (Integer) siguiente.getItem())>=0){
                        cambio = true;
                        if ( anterior != null ) {
                            DequeNode<T> sig = siguiente.getNext();
                            anterior.setNext(siguiente);
                            siguiente.setNext(actual);
                            actual.setNext(sig);

                        } else {
                            DequeNode<T> sig = siguiente.getNext();
                            first = siguiente;
                            siguiente.setNext(actual);
                            actual.setNext(sig);
                        }

                        anterior = siguiente;
                        siguiente = actual.getNext();
                    } else {
                        last = siguiente;
                        anterior = actual;
                        actual = siguiente;
                        siguiente = siguiente.getNext();
                    }
                }
            } while( cambio );
        }
    }
}
