package JavaConcepts.Multithreading.CallableAndFuture;

import java.util.concurrent.*;

public class FutureTaskSimpleDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newSingleThreadExecutor();
        FutureTask<String> ftc = new FutureTask<>(new FutureTaskCallable());
        es.submit(ftc);
        System.out.println("From futureTasks:: " + ftc.get());
        System.out.println("FutureTask is also blocking in nature!");
        System.out.println("Future is a class that provides implementation of the interface!");
    }
}

class FutureTaskCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        try {
            System.out.println("FutureTask (Callable) execution started!");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Helloooo!";
    }
}
