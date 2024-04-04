package agh.ii.prinjava.proj1;
import agh.ii.prinjava.proj1.impl.MyQueueDLLBImpl;
/**
 * A generic interface representing a queue data structure.
 *
 * @param <E> the type of elements stored in the queue
 */
public interface MyQueue<E> {
    /**
     * Inserts the specified element into the queue.
     *
     * @param x the element to insert into the queue
     */
    void enqueue(E x);

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the element at the front of the queue
     */
    E dequeue();

    /**
     * Checks whether the queue is empty.
     *
     * @return {@code true} if the queue is empty, {@code false} otherwise
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue
     */
    int numOfElems();

    /**
     * Returns the element at the front of the queue without removing it.
     *
     * @return the element at the front of the queue
     */
    E peek();

    /**
     * Factory method to create instances of {@code MyQueue}.
     *
     * <p>Consider pros and cons of having a factory method in the interface.
     *
     * @param <T> the type of elements stored in the queue
     * @return a new instance of {@code MyQueue}
     */
    static <T> MyQueue<T> create() {
        return new MyQueueDLLBImpl<>();
    }
}
