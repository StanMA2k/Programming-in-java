package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListBasedImplTest {

    // Create an empty stack
    private final StackOfInts stackOfInts = StackOfIntsFtry.create(StackOfIntsFtry.Impln.L_LIST_B);

    @BeforeEach
    void setUp() {
         StackOfInts stackOfInts = StackOfIntsFtry.create(StackOfIntsFtry.Impln.L_LIST_B);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void newStackIsEmpty() {
        assertTrue(stackOfInts.isEmpty(), "A new stack should be empty");
    }

    @Test
    void pushElem(){
        stackOfInts.push(1);
        assertFalse(stackOfInts.isEmpty(), "Stack shouldn't be empty after first push");
    }

    @Test
    void popElem (){
        stackOfInts.push(1);
        stackOfInts.pop();
        assertTrue(stackOfInts.isEmpty(), "Stack should be empty after one push and one pop");
    }

    @Test
    void elemNum (){
        stackOfInts.push(1);
        assertEquals(1, stackOfInts.numOfElems(),"Number of element should increased after push");
    }

    @Test
    void peekElem(){
        stackOfInts.push(1);
        stackOfInts.push(2);
        assertEquals(2, stackOfInts.peek(), "Peek should be the last push element");
    }

}