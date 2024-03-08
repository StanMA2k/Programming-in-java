package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayBasedImplTest {

    // Create an empty stack
    private final StackOfInts stackOfInts = StackOfIntsFtry.create(StackOfIntsFtry.Impln.ARRAY_B);

    @BeforeEach
    void setUp() {
        StackOfInts stackOfInts = StackOfIntsFtry.create(StackOfIntsFtry.Impln.ARRAY_B);
    }


    @AfterEach
    void tearDown() {
    }

    @Test
    void newStackIsEmpty() {
        assertTrue(stackOfInts.isEmpty());
    }

    @Test
    void popElem(){
        stackOfInts.push(1);
        stackOfInts.pop();
        assertTrue(stackOfInts.isEmpty(), "A stack should be empty");
    }

    @Test
    void pushElem(){
        stackOfInts.push(1);
        assertFalse(stackOfInts.isEmpty(), "A stack shouldn't be empty");
    }

    @Test
    void peekElem(){
        stackOfInts.push(1);
        stackOfInts.push(2);
        assertEquals(2, stackOfInts.peek(), "The top of the stack should be the last pushed element");
    }

    @Test
    void elemNum (){
        stackOfInts.push(1);
        assertEquals(1, stackOfInts.numOfElems(),"Number of element should increased after push");
    }
}