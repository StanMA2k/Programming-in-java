package agh.ii.prinjava.lab02.exc02_01;

/**
 * Stack of integers - Abstract Data Type (ADT)
 * This interface contains all methods that would be applied in ArrayBasedImpl, LinkedListBasedImpl and StackOfIntsFtry.
 * Here is the list of usage for each method:
 *pop(): is used to delete an entered element
 * push(): is used to enter a new element
 * isEmpty(): check if the stack is empty
 * numOfElems(): Calculate the number of elements in a stack
 * peek(): get the peek element of a stack
 */

public interface StackOfInts {
    int pop();

    void push(int x);

    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    int numOfElems();

    int peek();
}
