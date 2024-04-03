package agh.ii.prinjava.proj1;

import java.util.NoSuchElementException;

/**
 * Doubly Linked List-based implementation of the {@code MyQueue} interface.
 *
 * @param <E> the type of elements stored in the queue
 */
public class MyQueueDLLBImpl<E> implements MyQueue<E> {
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

    private Node<E> front;
    private Node<E> rear;
    private int size;

    public MyQueueDLLBImpl() {
        front = null;
        rear = null;
        size = 0;
    }

    /**
     * Inserts the specified element into the queue.
     *
     * @param x the element to insert into the queue
     */
    @Override
    public void enqueue(E x) {
        Node<E> newNode = new Node<>(x, null, rear);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.prev = newNode;
        }
        rear = newNode;
        size++;
    }

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the element at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        E item = front.data;
        if (size == 1) {
            front = null;
            rear = null;
        } else {
            front = front.prev;
            front.next = null;
        }
        size--;
        return item;
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue
     */
    @Override
    public int numOfElems() {
        return size;
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
        return front.data;
    }

    /**
     * Checks whether the queue is empty.
     *
     * @return {@code true} if the queue is empty, {@code false} otherwise
     */
    /*private boolean isEmpty() {
        return size == 0;
    }*/
}
