package com.example.utils;

public class MathHelperJavaInterop {
    public static void main(String[] args) {
        int factResult = MathHelper.factorial(5);
        double expResult = MathHelper.exponent(2.0, -3);

        System.out.println("Factorial of 5: " + factResult);
        System.out.println("2^-3 = " + expResult);
    }
}
