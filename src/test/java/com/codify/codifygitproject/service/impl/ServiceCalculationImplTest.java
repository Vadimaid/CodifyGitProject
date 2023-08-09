package com.codify.codifygitproject.service.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceCalculationImplTest {

    @Test
    public void testPlus() {
        Integer result = ServiceCalculationImpl.plus(5, 3);
        assertEquals(8, result);
    }

    @Test
    public void testMinus() {
        Integer result = ServiceCalculationImpl.minus(10, 4);
        assertEquals(6, result);
    }

    @Test
    public void testMultiplication() {
        Integer result = ServiceCalculationImpl.multiplication(6, 7);
        assertEquals(42, result);
    }

    @Test
    public void testDivision() {
        Integer result = ServiceCalculationImpl.division(15, 3);
        assertEquals(5, result);
    }

    @Test
    public void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> ServiceCalculationImpl.division(10, 0));
    }

    @Test
    public void testPlusWithNullInput() {
        assertThrows(NullPointerException.class, () -> ServiceCalculationImpl.plus(null, null));
    }

    // Тесты для других методов и сценариев

}