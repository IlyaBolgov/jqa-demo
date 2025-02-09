package com.example.unit;

import com.example.async.AsyncProcessor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.CompletableFuture;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AsyncProcessorTest {

    @BeforeEach
    void setup() {
        AsyncProcessor.restartExecutor();  // Ensure executor is active before each test
    }

    @Test
    public void testComputeAsync() {
        CompletableFuture<Integer> future = AsyncProcessor.computeAsync(5);
        assertEquals(120, future.join());
    }

    @AfterAll
    static void cleanup() {
        AsyncProcessor.shutdown();
    }
}
