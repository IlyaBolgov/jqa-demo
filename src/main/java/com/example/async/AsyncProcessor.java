package com.example.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AsyncProcessor {

    private static final ExecutorService executor = Executors.newFixedThreadPool(4);

    public static CompletableFuture<Integer> computeAsync(int number) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Computing factorial for " + number + " on thread " + Thread.currentThread().getName());
            return factorial(number);
        }, executor);
    }

    private static int factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
