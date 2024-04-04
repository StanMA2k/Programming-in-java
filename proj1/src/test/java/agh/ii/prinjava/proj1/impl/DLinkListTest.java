package agh.ii.prinjava.proj1.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

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