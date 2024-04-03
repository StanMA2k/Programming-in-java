package agh.ii.prinjava.proj1.impl;

import java.util.NoSuchElementException;

/**
 * Doubly Linked List-based implementation of the {@code MyStack} interface.
 *
 * @param <E> the type of elements stored in the stack
 */
public class MyStackDLLBImpl<E> implements MyStack<E> {
    private static class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        Node(E item, Node<E> prev, Node<E> next) {
            this.data = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> top;
    private int size;

    public MyStackDLLBImpl() {
        top = null;
        size = 0;
    }

    /**
     * Removes and returns the top element of the stack.
     *
     * @return the top element of the stack
     * @throws NoSuchElementException if the stack is empty
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        E item = top.data;
        top = top.prev;
        size--;
        return item;
    }

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param x the element to push onto the stack
     */
    @Override
    public void push(E x) {
        Node<E> newNode = new Node<>(x, top, null);
        if (top != null) {
            top.next = newNode;
        }
        top = newNode;
        size++;
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return the number of elements in the stack
     */
    @Override
    public int numOfElems() {
        return size;
    }

    /**
     * Returns the top element of the stack without removing it.
     *
     * @return the top element of the stack
     * @throws NoSuchElementException if the stack is empty
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return top.data;
    }

    /**
     * Checks whether the stack is empty.
     *
     * @return {@code true} if the stack is empty, {@code false} otherwise
     */
    private boolean isEmpty() {
        return top == null;
    }
}
