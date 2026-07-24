package com.bank;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public boolean isPositive(int num) {
        return num > 0;
    }

    public String getGreeting(String name) {
        if (name == null) {
            return "Hello, Guest!";
        }
        return "Hello, " + name + "!";
    }
}
