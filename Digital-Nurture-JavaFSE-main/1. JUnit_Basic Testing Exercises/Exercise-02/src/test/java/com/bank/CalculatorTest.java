package com.bank;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        int result = calc.add(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void testSubtract() {
        Calculator calc = new Calculator();
        int result = calc.subtract(10, 4);
        assertEquals(6, result);
    }

    @Test
    public void testMultiply() {
        Calculator calc = new Calculator();
        int result = calc.multiply(3, 4);
        assertEquals(12, result);
    }

    @Test
    public void testDivide() {
        Calculator calc = new Calculator();
        int result = calc.divide(10, 2);
        assertEquals(5, result);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        Calculator calc = new Calculator();
        calc.divide(10, 0);
    }

    @Test
    public void testIsPositive() {
        Calculator calc = new Calculator();
        assertTrue(calc.isPositive(5));
        assertFalse(calc.isPositive(-1));
        assertFalse(calc.isPositive(0));
    }

    @Test
    public void testGetGreeting() {
        Calculator calc = new Calculator();
        assertEquals("Hello, John!", calc.getGreeting("John"));
        assertEquals("Hello, Guest!", calc.getGreeting(null));
    }
}
