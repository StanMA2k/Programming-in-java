package agh.ii.prinjava.lab03.exc03_01.impl;

import agh.ii.prinjava.lab03.exc03_01.QueueOfInts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListBasedImplTest {

    // Create an empty queue
    private final QueueOfInts queueOfInts = QueueOfIntsFtry.create(QueueOfIntsFtry.Impln.L_LIST_B);

    @BeforeEach
    void setUp() {
        final QueueOfInts queueOfInts = QueueOfIntsFtry.create(QueueOfIntsFtry.Impln.L_LIST_B);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void newQueueIsEmpty() {
        assertTrue(queueOfInts.isEmpty(), "A new queue should be empty");
    }

    @Test
    void enqueue(){
        queueOfInts.enqueue(1);
        assertFalse(queueOfInts.isEmpty(), "Queue shouldn't be empty after enqueue");

    }

    @Test
    void enqueueToHead(){
        queueOfInts.enqueue(1);
        queueOfInts.enqueue(2);
        assertEquals(2, queueOfInts.peek(), "Queue head should be the latest enqueued elem");
    }

    @Test
    void dequeue(){
        queueOfInts.enqueue(1);
        queueOfInts.dequeue();
        assertTrue(queueOfInts.isEmpty(), "Queue should be empty");
    }

    @Test
    void dequeueFromTail(){
        queueOfInts.enqueue(1);
        queueOfInts.enqueue(2);
        assertEquals(1, queueOfInts.dequeue());
        assertEquals(2, queueOfInts.peek());
    }

    @Test
    void numOfElemsChanges(){
        queueOfInts.enqueue(10);
        assertEquals(1, queueOfInts.numOfElems(), "Number of elems should change");
        queueOfInts.dequeue();
        assertEquals(0,queueOfInts.numOfElems());
    }

    @Test
    void peekShouldBeLastInElem(){
        queueOfInts.enqueue(1);
        queueOfInts.enqueue(2);
        assertEquals(2, queueOfInts.peek(), "Peek should be last in elem");
    }

}
