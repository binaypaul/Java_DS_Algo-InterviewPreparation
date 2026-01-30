package JavaConcepts.Multithreading.CallableAndFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import lombok.*;

public class d_CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Example using supplyAsync
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            // Simulate a long-running task
            try {
                System.out.println("CompletableFuture thread started to run!");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello, CompletableFuture!";
        });
        System.out.println("CompletableFuture is non blocking in nature - 1!");

        // Using thenApply to transform the result
        CompletableFuture<String> transformedFuture = completableFuture.thenApply(result -> result + " Transformed");

        System.out.println("CompletableFuture is non blocking in nature - 2!");

        // Get the result (blocks until completion)
        //this will wait until transformedFuture is complete.
        String result = transformedFuture.get();
        System.out.println("CompletableFuture is non blocking in nature - 3!");
        System.out.println("Result: " + result);

        // Using thenAccept to consume the result
        CompletableFuture<Void> consumerFuture = transformedFuture.thenAccept(r -> System.out.println(r));
        System.out.println("CompletableFuture is non blocking in nature - 4!");
        // Wait for consumerFuture to complete
        consumerFuture.get();

        System.out.println("CompletableFuture is non blocking in nature - 5!");
    }
}