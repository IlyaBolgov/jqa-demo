package com.example.integration;

import com.example.async.AsyncProcessor;
import com.example.utils.MathHelper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SyncAndAsyncFactorialTest {

    @Test
    @Tag("Integration")
    public void testSynchronousVsAsyncFactorial() throws ExecutionException, InterruptedException {
        int syncFactorial = MathHelper.factorial(5);

        CompletableFuture<Integer> asyncFactorialFuture = AsyncProcessor.computeAsync(5);
        int asyncFactorial = asyncFactorialFuture.get();

        // Assert that both results match
        assertEquals(syncFactorial, asyncFactorial, "Asynchronous and synchronous factorials should match");
    }

    @AfterAll
    public static void tearDown() {
        AsyncProcessor.shutdown();
    }
}
