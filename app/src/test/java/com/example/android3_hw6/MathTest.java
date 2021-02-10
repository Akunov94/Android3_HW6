package com.example.android3_hw6;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.example.android3_hw6.domain.Math;

import static org.junit.Assert.assertEquals;

public class MathTest {

    private Math math;

    @Before
    public void setup() {
        math = new Math();
        System.out.println("BEFORE");
    }

    @Test
    public void addTest() {
        assertEquals(5, math.add(2, 3));
        System.out.println("TEST ADD");
    }

    @Test
    public void minusTest() {
        assertEquals(5, math.minus(8, 3));
        System.out.println("TEST MINUS");
    }
    @Test
    public void multiplicationTest() {
        assertEquals(25, math.multiplication(5, 5));
        System.out.println("TEST MULTIPLICATION");
    }
    @Test
    public void divisionTest() {
        assertEquals(5, math.division(15, 3));
        System.out.println("TEST DIVISION");
    }

    @After
    public void clear() {
        math = null;
        System.out.println("CLEAR");
    }

}
