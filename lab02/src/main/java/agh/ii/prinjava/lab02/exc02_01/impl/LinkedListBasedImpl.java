package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;

/**
 * create a stack based on linked list
 */

public class LinkedListBasedImpl implements StackOfInts {

    /**
     *pop(): give exception message if the stack is empty, otherwise it delete the first elem in the stack
     */
    @Override
    public int pop() {
        if (first == null){
        throw new IllegalStateException("Stack is empty");
    }
        int elem = first.elem;
        first = first.next;
        numOfElems--;
        return elem;
    }

    /**
     *push(): add new elem in the stack
     */
    @Override
    public void push(int x) {
        first = new Node(x, first);
        numOfElems++;
    }

    /**
     *counter the elems in the stack
     */
    @Override
    public int numOfElems() {
        return numOfElems;
    }

    /**
     *peek(): give exception message if the stack is empty, otherwise it returns the first elem of the stack
     */
    @Override
    public int peek() {
        if (first == null){
        throw new IllegalStateException("Stack is empty");
    }
        return first.elem;
    }

    private static class Node {
        int elem;
        Node next;

        public Node(int elem, Node next) {
            this.elem = elem;
            this.next = next;
        }
    }

    private Node first = null;
    private int numOfElems = 0;
}
