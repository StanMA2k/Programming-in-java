package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueDLLBImplTest {
    private MyQueue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new MyQueueDLLBImpl<>();
    }

    @Test
    void enqueueAndDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
    }

    @Test
    void enqueueAndPeek() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.peek());
        assertEquals(1, queue.peek());
    }

    @Test
    void dequeue_emptyQueue_throwsException() {
        assertThrows(NoSuchElementException.class, () -> queue.dequeue());
    }

    @Test
    void peek_emptyQueue_throwsException() {
        assertThrows(NoSuchElementException.class, () -> queue.peek());
    }

    @Test
    void numOfElems() {
        assertEquals(0, queue.numOfElems());
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.numOfElems());
        queue.dequeue();
        assertEquals(1, queue.numOfElems());
    }
}