package async

import kotlinx.coroutines.*

object AsyncProcessorKt {

    suspend fun computeAsync(number: Int): Int = withContext(Dispatchers.Default) {
        println("Computing factorial for $number on thread ${Thread.currentThread().name}")
        factorial(number)
    }

    private fun factorial(n: Int): Int {
        require(n >= 0) { "Factorial is not defined for negative numbers" }
        return (1..n).fold(1) { acc, i -> acc * i }
    }
}
