package agh.ii.prinjava.lab03.exc03_01;


/**
 * Interface QueueOfInts provides a series methods of arranging a queue
 */
public interface QueueOfInts {


    /**
     * add integer x to the tail
     *
     * @param x integer to be added
     */
    void enqueue(int x);


    /**
     * Dequeues an integer from the back of the queue.
     * @return the integer at the front of the queue
     * @throws IllegalStateException if the queue is empty
     */
    int dequeue();


    /**
     * Checks if the queue is empty.
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }


    /**
     * Return the number of elements in the queue.
     * This operation provides the current size of the queue.
     * @return the number of elements in the queue
     */
    int numOfElems();


    /**
     * Return the first element in the queue
     * @return the integer at the front of the queue
     * @throws IllegalStateException if the queue is empty
     */
    int peek();
}
