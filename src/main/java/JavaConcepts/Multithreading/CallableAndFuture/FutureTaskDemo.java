package JavaConcepts.Multithreading.CallableAndFuture;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
//https://www.geeksforgeeks.org/callable-future-java/?ref=lbp

public class FutureTaskDemo {
    public static void main(String[] args) throws Exception {
        Callable<Integer> rgCallable = new RandomGenerator();
        FutureTask<Integer> ft = new FutureTask<>(rgCallable);
        Thread t = new Thread(ft);
        t.start();
        System.out.println("Hello FutureTask is non blocking in nature!");
        System.out.println("From futureTasks:: "+ft.get());
    }
}

class RandomGenerator implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Random random = new Random();
        int randomInt = random.nextInt(5);
        System.out.println("From Callable:: "+randomInt);
        Thread.sleep(randomInt*1000);
        return randomInt;
    }
}