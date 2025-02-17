package Concepts.Multithreading;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
//https://www.geeksforgeeks.org/callable-future-java/?ref=lbp

public class CallableFutureTask {
    public static void main(String[] args) throws Exception {
        FutureTask[] tasks = new FutureTask[5];
        for (int i=0;i<5;i++) {
            Callable<Integer> rgCallable = new RandomGenerator();
            tasks[i] = new FutureTask<Integer>(rgCallable);
            Thread t = new Thread(tasks[i]);
            t.start();
        }

        for (int i = 0; i <5; i++) {
            System.out.println("From futureTasks:: "+tasks[i].get());
        }
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