package JavaConcepts.Multithreading;

import java.util.concurrent.*;

public class ExecutorServiceDemo {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("running!");
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(runnable);

        executorService.shutdown();
    }
}
