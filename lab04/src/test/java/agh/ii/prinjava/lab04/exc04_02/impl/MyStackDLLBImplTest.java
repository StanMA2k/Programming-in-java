package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyStack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackDLLBImplTest {

    MyStack<Integer> stackOfInts = MyStack.<Integer>create();

    @BeforeEach
    void setUp() {
       stackOfInts = MyStack.<Integer>create();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void newStackIsEmpty() {
        assertTrue(stackOfInts.isEmpty(),"A new stack should be empty");
    }

    @Test
    void pushElem(){
        stackOfInts.push(1);
        assertFalse(stackOfInts.isEmpty(), "Stack shouldn't be empty after push");
    }

    @Test
    void popElem(){
        stackOfInts.push(1);
        stackOfInts.pop();
        assertTrue(stackOfInts.isEmpty(), "Stack shouldn't have element");
    }

    @Test
    void peekElem(){
        stackOfInts.push(1);
        stackOfInts.push(2);
        assertEquals(2, stackOfInts.peek(),"Peek should be last pushed element");
    }

}