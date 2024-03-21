package agh.ii.prinjava.lab04.exc04_01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairTest {

    Pair<Integer, String> pairOfIntStr;

    @BeforeEach
    void setUp() {
        pairOfIntStr = new Pair<>(1, "snd");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void t1() {
        assertTrue(true);
    }

    @Test
    void testClone() throws CloneNotSupportedException {
        super.clone();
        assertEquals(pairOfIntStr,clone(),"Cloned pair should be same as original pair" );
    }
}