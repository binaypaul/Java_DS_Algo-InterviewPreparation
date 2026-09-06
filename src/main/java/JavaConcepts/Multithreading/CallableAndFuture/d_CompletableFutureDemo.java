package JavaConcepts.Multithreading.CallableAndFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import lombok.*;

public class d_CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Example using supplyAsync
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            // Simulate a long-running task using "Callable"
            try {
                System.out.println(":: Callable execution started!");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return ":: Helloooo!";
        });
        System.out.println("CompletableFuture Execution  - 'supplyAsync()' is non blocking in nature - 1!");

        // Using thenApply to transform the result
        CompletableFuture<String> transformedFuture = completableFuture.thenApply(result -> result + " Transformed");

        System.out.println("***** CompletableFuture Transformation - 'thenApply()' is non blocking in nature - 2!");

        // Get the result (blocks until completion)
        // this will wait until transformedFuture is complete.
        String result = transformedFuture.get();
        System.out.println("CompletableFuture GetResult - 'get()' is blocking in nature - 3!");
        System.out.println("transformedFuture Result: " + result);

        // Using thenAccept to consume the result
        CompletableFuture<Void> consumerFuture = transformedFuture.thenAccept(r -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("consumerFuture Result: " + r);
        });
        System.out.println("***** CompletableFuture - 'thenAccept()' is blocking in nature if  - 4!");
        consumerFuture.get(); // this line doesn't do anything.
        System.out.println("consumerFuture GetResult - 'get()' is blocking in nature - 5!");
    }

    /*
    ***** Any "then" method (thenApply(), thenAccept(), etc.) is either blocking or non-blocking depending on if the "CompletableFuture" instance is
    * already completed (a 'get()' call is done previously) or not already completed.
    * In above example:
    * 'completableFuture.thenApply()' is non-blocking as "completableFuture" is not already completed.
    * 'completableFuture.thenApply()' is blocking as "transformedFuture" is already completed by 'get()' call before it.
     */
}