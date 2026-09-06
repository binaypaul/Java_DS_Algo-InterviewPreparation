package JavaConcepts.Multithreading.CallableAndFuture;

import java.util.concurrent.*;

public class a_FutureTask_Vs_Future_Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = new FTCall();

        //Running FutureTask via Thread class.
        FutureTask<String> ft_t = new FutureTask<>(callable);
        Thread t = new Thread(ft_t);
        System.out.println("'FutureTask via Thread' - Execution submitted/started");
        t.start();
        System.out.println("'FutureTask via Thread' - Execution is non-blocking");
        System.out.println("'FutureTask via Thread'" + ft_t.get());
        System.out.println("'FutureTask via Thread' - get() is blocking");


        ExecutorService es = Executors.newFixedThreadPool(2);

        //Running FutureTask via ExecutorService class.
        FutureTask<String> ft_es = new FutureTask<>(callable);
        System.out.println("'FutureTask via ExecutorService' - Execution submitted");
        es.submit(ft_es);
        es.submit(ft_es);
        System.out.println("'FutureTask via ExecutorService' - Execution is non-blocking");
        System.out.println("'FutureTask via ExecutorService'" + ft_es.get());
        System.out.println("'FutureTask via ExecutorService' - get() is blocking");

        //Running Future via ExecutorService class.
        System.out.println("'Future via ExecutorService' - Execution submitted");
        Future<String> f_es = es.submit(callable);
        System.out.println("'Future via ExecutorService' - Execution is non-blocking");
        System.out.println("'Future via ExecutorService'" + f_es.get());
        System.out.println("'Future via ExecutorService' - get() is blocking");

        // FutureTask can be run by a thread (as it implements Runnable) or ExecutorService.
        // But "Future" can only be executed or created by ExecuterService via "es.submit(callable)".
    }
}

class FTCall implements Callable<String> {
    @Override
    public String call() throws Exception {
        try {
            System.out.println(":: Callable execution started!");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return ":: Helloooo!";
    }
}
