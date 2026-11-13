package com.practice.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MathUtilsTest {

    @Test
    void testAdd() {
        assertEquals(15, MathUtils.add(10, 5));
    }

    @Test
    void testAddNegativeNumbers() {
        assertEquals(-7, MathUtils.add(-10, 3));
    }

    @Test
    void testSubtract() {
        assertEquals(5, MathUtils.subtract(10, 5));
    }

    @Test
    void testDivide() {
        assertEquals(5, MathUtils.divide(10, 2));
    }

    @Test
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> MathUtils.divide(10, 0));
    }
}
