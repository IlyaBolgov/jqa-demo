package com.example


import com.example.utils.MathHelper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MathHelperTest {

    @Test
    fun exponentTest() {
        assertEquals(1.0, MathHelper.exponent(2.0, 0))
        assertEquals(4.0, MathHelper.exponent(2.0, 2))
    }

    @Test
    fun factorialTest() {
        assertEquals(1, MathHelper.factorial(0))
        assertEquals(6, MathHelper.factorial(3))
    }

    @Test
    fun factorialNegativeTest() {
        val exception = assertThrows<IllegalArgumentException> {
            MathHelper.factorial(-1)
        }
        assertEquals("Factorial is not defined for negative numbers: n = -1", exception.message)
    }

    @Test
    fun exponentNegativeTest() {
        assertEquals(0.125, MathHelper.exponent(2.0, -3), 0.0001)
    }
}
