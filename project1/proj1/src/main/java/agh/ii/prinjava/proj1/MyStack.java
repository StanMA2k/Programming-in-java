package agh.ii.prinjava.proj1;

import agh.ii.prinjava.proj1.impl.MyStackDLLBImpl;

/**
 * A generic interface representing a stack data structure.
 *
 * @param <E> the type of elements stored in the stack
 */
public interface MyStack<E> {
    /**
     * Removes and returns the top element of the stack.
     *
     * @return the top element of the stack
     */
    E pop();

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param x the element to push onto the stack
     */
    void push(E x);

    /**
     * Checks whether the stack is empty.
     *
     * @return {@code true} if the stack is empty, {@code false} otherwise
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return the number of elements in the stack
     */
    int numOfElems();

    /**
     * Returns the top element of the stack without removing it.
     *
     * @return the top element of the stack
     */
    E peek();

    /**
     * Factory method to create instances of {@code MyStack}.
     *
     * <p>Consider pros and cons of having a factory method in the interface.
     *
     * @param <T> the type of elements stored in the stack
     * @return a new instance of {@code MyStack}
     */
    static <T> MyStack<T> create() {
        return new MyStackDLLBImpl<>();
    }
}
