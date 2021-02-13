package com.example.android3_hw6.domain;

public class Math {
    public int add(int a, int b) {
        return a + b;
    }

    public int minus(int a, int b) {
        return a - b;
    }

    public int division(int a, int b) {
        if (b != 0) {
            return a / b;
        } else {
            return (int) Double.NaN;
        }
    }

    public int multiplication(int a, int b) {
        return a * b;
    }

    public int subtractFunction(int a, int b) {
        return a/b;
    }

}
