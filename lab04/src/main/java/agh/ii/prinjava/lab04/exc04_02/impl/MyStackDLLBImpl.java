package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyStack;
import org.w3c.dom.Node;

/**
 * A stack implementation using a doubly-linked list as the underlying data structure.
 * @param <E> the type of elements held in this stack
 */
public class MyStackDLLBImpl<E> extends DLinkList<E> implements MyStack<E> {
    private DLinkList<E> elems;

    public MyStackDLLBImpl() {
        this.elems = new DLinkList<>();
    }

    /**
     * Remove elem from the stack
     * @return the element removed from the top of the stack
     */
    @Override
    public E pop() {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elems.deleteElem();
    }

    /**
     * Push an elment to the top of the stack
     * @param x the element should be pushed to the top
     */
    @Override
    public void push(E x) {
        elems.addElem(x);
    }

    /**
     * Count the size of ths stack
     * @return size of the stack
     */
    @Override
    public int numOfElems() {
        return elems.size;
    }

    /**
     * Returns the element at the top of the stack without removing it.
     * @return the top element of the stack
     */
    @Override
    public E peek() {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
    return elems.peekElem();
    }


    /**
     * Inner class implementing  double linked list
     * @param <E> type of elements in node
     */
    public class DLinkList<E> {
        private Node<E> first;
        private Node<E> last;
        private int size = 0;

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
        public void addElem(E x){
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

}
