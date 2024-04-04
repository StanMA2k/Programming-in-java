package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;

import java.util.NoSuchElementException;

/**
 * Doubly Linked List-based implementation of the {@code MyQueue} interface.
 *
 * @param <E> the type of elements stored in the queue
 */
public class MyQueueDLLBImpl<E> implements MyQueue<E> {

    private DLinkList<E> elems;

    /**
     * Constructs a doubly linked list.
     */
    public MyQueueDLLBImpl() {
        this.elems = new DLinkList<>();
    }


    /**
     * Inserts the specified element into the queue.
     *
     * @param x the element to insert into the queue
     */
    @Override
    public void enqueue(E x) {
        elems.addLast(x);

    }

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the element at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    @Override
    public E dequeue() {
        return elems.removeFirst();
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue
     */
    @Override
    public int numOfElems() {
        return elems.size;
    }

    /**
     * Returns the element at the front of the queue without removing it.
     *
     * @return the element at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return elems.peekElem();
    }


}
