package agh.ii.prinjava.proj1.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;



/**
 * Unit tests for the {@link DLinkList} class.
 */
class DLinkListTest {
    private DLinkList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new DLinkList<>();
    }

    @Test
    void addFirst() {
        list.addFirst(1);
        list.addFirst(2);
        assertEquals("[2, 1]", list.toString());
    }

    @Test
    void addLast() {
        list.addLast(1);
        list.addLast(2);
        assertEquals("[1, 2]", list.toString());
    }

    @Test
    void removeFirst() {
        list.addLast(1);
        list.addLast(2);
        assertEquals(1, list.removeFirst());
        assertEquals("[2]", list.toString());
    }

    @Test
    void removeLast() {
        list.addLast(1);
        list.addLast(2);
        assertEquals(2, list.removeLast());
        assertEquals("[1]", list.toString());
    }

    @Test
    void removeFirst_emptyList_throwsException() {
        assertThrows(NoSuchElementException.class, () -> list.removeFirst());
    }

    @Test
    void removeLast_emptyList_throwsException() {
        assertThrows(NoSuchElementException.class, () -> list.removeLast());
    }
}

/**
 * Unit tests for the {@link MyStackDLLBImpl} class.
 */
class MyStackDLLBImplTest {
    private MyStack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new MyStackDLLBImpl<>();
    }

    @Test
    void pushAndPop() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void pushAndPeek() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.peek());
        assertEquals(2, stack.peek());
    }

    @Test
    void pop_emptyStack_throwsException() {
        assertThrows(NoSuchElementException.class, () -> stack.pop());
    }

    @Test
    void peek_emptyStack_throwsException() {
        assertThrows(NoSuchElementException.class, () -> stack.peek());
    }

    @Test
    void numOfElems() {
        assertEquals(0, stack.numOfElems());
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.numOfElems());
        stack.pop();
        assertEquals(1, stack.numOfElems());
    }
}

/**
 * Unit tests for the {@link MyQueueDLLBImpl} class.
 */
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