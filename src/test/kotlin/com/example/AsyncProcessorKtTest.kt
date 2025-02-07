package com.example

import async.AsyncProcessorKt
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AsyncProcessorKtTest {

    @Test
    fun `test computeAsync`() = runBlocking {
        val result = AsyncProcessorKt.computeAsync(5)
        assertEquals(120, result)
    }
}
