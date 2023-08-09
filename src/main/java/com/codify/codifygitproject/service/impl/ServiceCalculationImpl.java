package com.codify.codifygitproject.service.impl;


import org.springframework.stereotype.Service;

@Service
public class ServiceCalculationImpl {
    public static Integer plus(Integer num1, Integer num2) {
        if (num1 == null && num2 == null) {
            throw new NullPointerException("Есть null!");
        }
        return num1 + num2;
    }

    public static Integer minus(Integer num1, Integer num2) {
        if (num1 == null && num2 == null) {
            throw new NullPointerException("Есть null!");
        }
        return num1 - num2;
    }

    public static Integer multiplication(Integer num1, Integer num2) {
        if (num1 == null && num2 == null) {
            throw new NullPointerException("Есть null!");
        }
        return num1 * num2;
    }

    public static Integer division(Integer num1, Integer num2) {
        if (num1 == null && num2 == null) {
            throw new NullPointerException("Есть null!");
        }
        if (num1 == 0 && num2 == 0) {
            throw new ArithmeticException("Делить на 0 нельзя!");
        }
        return num1 / num2;
    }
}
