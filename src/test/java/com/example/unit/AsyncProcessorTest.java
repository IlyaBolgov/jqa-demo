package com.example.unit;

import com.example.async.AsyncProcessor;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AsyncProcessorTest {

    @Test
    void testComputeAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> futureResult = AsyncProcessor.computeAsync(5);
        int result = futureResult.get();
        assertEquals(120, result);
    }
}
