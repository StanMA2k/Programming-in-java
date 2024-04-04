package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

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
