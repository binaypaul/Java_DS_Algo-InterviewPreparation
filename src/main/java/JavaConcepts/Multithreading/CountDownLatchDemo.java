package JavaConcepts.Multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService es = Executors.newFixedThreadPool(3);
        es.execute(new LatchRunnable(latch));
        es.execute(new LatchRunnable(latch));
        es.execute(new LatchRunnable(latch));
        latch.await();
        System.out.println("Printing this after 3 count down completed as all 3 thread's execution is complete!");
    }
}

class LatchRunnable implements Runnable {

    CountDownLatch latch;

    public LatchRunnable(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " service started.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " service completed.");
        latch.countDown();
    }
}
