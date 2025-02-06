package com.example

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class MathHelperTest {

    private val mathHelper = MathHelper()

    @Test
    fun exponentTest() {
        assertEquals(1.0, mathHelper.exponent(2.0, 0))
        assertEquals(4.0, mathHelper.exponent(2.0, 2))
    }

    @Test
    fun factorialTest() {
        assertEquals(1, mathHelper.factorial(0))
        assertEquals(6, mathHelper.factorial(3))
    }

    @Test
    fun factorialNegativeTest() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            mathHelper.factorial(-1)
        }
        assertEquals("Factorial is not defined for negative numbers: n = -1", exception.message)
    }

    @Test
    fun exponentNegativeTest() {
        assertEquals(0.125, mathHelper.exponent(2.0, -3), 0.0001)
    }
}
