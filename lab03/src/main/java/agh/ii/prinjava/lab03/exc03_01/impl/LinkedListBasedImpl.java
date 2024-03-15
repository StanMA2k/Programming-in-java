package agh.ii.prinjava.lab03.exc03_01.impl;

import agh.ii.prinjava.lab03.exc03_01.QueueOfInts;


/**
 * {@code LinkedListBasedImpl} provides a linked-list-based implementation of the {@code QueueOfInts} interface
 */
public class LinkedListBasedImpl implements QueueOfInts {


    /**
     * Adds an integer element to the front of the queue.
     * This method implements the enqueue operation of the {@code QueueOfInts} interface by inserting the element at the beginning of the linked list.
     * @param x the integer element to be added to the front of the queue
     */
    @Override
    public void enqueue(int x) {
        Node node = new Node(x);
        if (first == null){
            first = last = new Node(x);
        }else{
            node.next = first;
            first.prev = node;
            first = node;
        }
        numOfElems++;
    }


    /**
     * Removes and returns the integer element from the back of the queue.
     * This method implements the dequeue operation of the {@code QueueOfInts} interface by removing the element from the end of the linked list.
     * @return the integer element removed from the back of the queue
     * @throws IllegalStateException if the queue is empty
     */
    @Override
    public int dequeue() {
        if (last == null){
            throw new IllegalStateException("Linked list is empty");
        }
        int elem = last.elem;
        last = last.prev;
        if (last != null){
            last.next = null;
        }else{
            first = null;
        }
        numOfElems--;
        return elem;
    }


    /**
     * Return the number of elements in the queue.
     * This method implements the numOfElems operation of the {@code QueueOfInts} interface
     * @return the number of elements in the queue
     */
    @Override
    public int numOfElems() {
        return numOfElems;
    }


    /**
     * Return the first element of the queue.
     * This method implements the peek operation of the {@code QueueOfInts} interface by returning the element at the front of the linked list without removing it.
     * @return the integer at the front of the queue
     * @throws IllegalStateException if the queue is empty
     */
    @Override
    public int peek() {
        if (first == null) {
            throw new IllegalStateException("Linked list is empty");
        }
        return first.elem;
    }



/**
 * Node is a private static inner class used to implement the linked list.
 * Each node stores an integer element and has references to the next and previous nodes in the list.
 */
    private static class Node {
        int elem;
        Node next;
        Node prev;

        public Node(int elem) {
            this.elem = elem;
        }

        public Node(int elem, Node next, Node prev) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node first = null;
    private Node last = null;

    private int numOfElems = 0;
}
