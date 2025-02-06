package com.example

class MathHelper {

    tailrec fun factorial(n: Int, acc: Int = 1): Int {
        require(n >= 0) { "Factorial is not defined for negative numbers: n = $n" }
        return if (n == 0) acc else factorial(n - 1, acc * n)
    }

    tailrec fun exponent(base: Double, power: Int, acc: Double = 1.0): Double {
        if (base == 0.0 && power < 0) {
            throw IllegalArgumentException("0 cannot be raised to a negative power.")
        }

        return when {
            power == 0 -> acc
            power > 0 -> exponent(base, power - 1, acc * base)
            else       -> exponent(base, power + 1, acc / base)
        }
    }

}
