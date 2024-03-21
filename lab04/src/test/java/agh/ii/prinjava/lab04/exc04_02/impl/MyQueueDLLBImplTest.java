package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyQueue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueDLLBImplTest {

    MyQueue<Integer> queueOfInts = MyQueue.<Integer>create();

    @BeforeEach
    void setUp() {
        queueOfInts = MyQueue.<Integer>create();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void newQueueIsEmpty() {
        assertTrue(queueOfInts.isEmpty(),"A new queue shouldn't be empty");
    }

    @Test
    void enqueueElem(){
        queueOfInts.enqueue(1);
        assertFalse(queueOfInts.isEmpty(), "Stack shouldn't be empty after push");
    }

    @Test
    void dequeueElem(){
        queueOfInts.enqueue(1);
        queueOfInts.dequeue();
        assertTrue(queueOfInts.isEmpty(), "Stack shouldn't have element");
    }

    @Test
    void peekElem(){
        queueOfInts.enqueue(1);
        queueOfInts.enqueue(2);
        assertEquals(1, queueOfInts.peek(),"Peek should be last pushed element");
    }

}