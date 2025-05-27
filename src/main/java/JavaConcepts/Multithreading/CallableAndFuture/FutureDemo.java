package JavaConcepts.Multithreading.CallableAndFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<String> f = es.submit(()-> {
            try {
                System.out.println("Future (Callable) execution started!");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Helloooo!";
        });
        System.out.println("From future:: " + f.get());
        System.out.println("Future is blocking in nature!");
        System.out.println("Future is an interface!");
    }
}
