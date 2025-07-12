package JavaConcepts.Multithreading.CallableAndFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Example using supplyAsync
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // Simulate a long-running task
            try {
                System.out.println("CompletableFuture thread started to run!");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello, CompletableFuture!";
        });
        System.out.println("CompletableFuture is non blocking in nature - 1!");

        // Using thenApply to transform the result
        CompletableFuture<String> transformedFuture = future.thenApply(result -> result + " Transformed");

        System.out.println("CompletableFuture is non blocking in nature - 2!");

        // Using thenAccept to consume the result
        CompletableFuture<Void> consumerFuture = transformedFuture.thenAccept(System.out::println);

        // Get the result (blocks until completion)
        String result = transformedFuture.get();
        System.out.println("Result: " + result);

        // Wait for consumer to complete
        consumerFuture.get();
    }
}