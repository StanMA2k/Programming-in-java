package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;

/**
 * Create a stack using an array
 */
public class ArrayBasedImpl implements StackOfInts {
    /**
     *Stack to create array list
     */
    @Override
    /**
     * delete top element of the array
     */
    public int pop() {
        if (isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        size--;
        numOfElems--;
        return stack[--numOfElems];
    }

    /**
     *add element to the top of the array
     */
    @Override
    public void push(int x) {
        if (numOfElems == size) {
            size++;
        }
        int top;
        numOfElems++;
        top = stack[numOfElems++];
    }

    /**
     *return the numbers of element (size) in the array
     */
    @Override
    public int numOfElems() {
        return numOfElems;
    }

    /**
     *return the top element
     */
    @Override
    public int peek() {
        if (isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
       return stack[numOfElems-1];
    }

    private int numOfElems = 0;
    private int [] stack;
    private int size;//= numOfElems;

}
