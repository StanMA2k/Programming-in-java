package agh.ii.prinjava.proj1.impl;

public class DLinkList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    public boolean listIsEmpty(){
        return size== 0;
    }

    private static class Node<T> {
        T elem;
        Node<T> next;
        Node<T> prev;

        /**
         * Constructor of node
         * @param elem the elem of this node
         * @param prev the previous node in the list
         * @param next the next node in the list
         */
        Node(T elem, Node<T> prev, Node<T> next) {
            this.elem = elem;
            this.prev = prev;
            this.next = next;
        }

    }
    public E deleteElem(){
        E elem = first.elem;
        Node<E> next = first.next;
        first.elem = null;
        first.next = null;
        first = next;
        if (first == null){
            last = null;
        }
        size--;
        return elem;
    }

    public void addLastToQueue(E x){
        final Node<E> f = last;
        final Node<E> newNode = new Node<>(x, f, null);
        last = newNode;
        if (f == null) {
            first = newNode;
        } else {
            f.next = newNode;
        }
        size++;
    }
    public void addFirst(E x){
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(x, null, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    public E peekElem(){
        return first.elem;
    }


}
