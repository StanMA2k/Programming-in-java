package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;

import java.util.NoSuchElementException;

/**
 * Doubly Linked List-based implementation of the {@code MyStack} interface.
 *
 * @param <E> the type of elements stored in the stack
 */
public class MyStackDLLBImpl<E> implements MyStack<E> {
    private DLinkList<E> elems;

    /**
     * Constructs a doubly linked list.
     */
    public MyStackDLLBImpl() {
        this.elems = new DLinkList<>();
    }

    /**
     * Removes and returns the top element of the stack.
     *
     * @return the top element of the stack
     * @throws NoSuchElementException if the stack is empty
     */
    @Override
    public E pop() {
       return elems.removeFirst();
    }

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param x the element to push onto the stack
     */
    @Override
    public void push(E x) {
        elems.addFirst(x);
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return the number of elements in the stack
     */
    @Override
    public int numOfElems() {
        return elems.size;
    }

    /**
     * Returns the top element of the stack without removing it.
     *
     * @return the top element of the stack
     * @throws NoSuchElementException if the stack is empty
     */
    @Override
    public E peek() {
        return elems.peekElem();
    }


}
