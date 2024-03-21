package agh.ii.prinjava.lab04.exc04_02.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DLinkListTest {

    DLinkList<Integer> dLinkList = new DLinkList<>();

    @BeforeEach
    void setUp() {
        dLinkList = new DLinkList<>();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void deleteElem(){
        dLinkList.addElem(1);
        dLinkList.deleteElem();
        assertTrue(dLinkList.listIsEmpty(),"Linked list should be empty");
    }

    @Test
    void addElem(){
        dLinkList.addElem(1);
        assertFalse(dLinkList.listIsEmpty(), "Linked list shouldn't be empty");
    }

    @Test
    void addElemToQueue(){
        dLinkList.addElemToQueue(1);
        dLinkList.addElemToQueue(2);
        assertEquals(1, dLinkList.peekElem());
    }

    @Test
    void peakElem(){
        dLinkList.addElem(1);
        dLinkList.addElem(2);
        assertEquals(2, dLinkList.peekElem(), "Peek elem should be last added elem");
    }
}