package JavaConcepts.Multithreading;

public class WaysOfThreadCreation {
    public static void main(String[] args) throws InterruptedException {

        //myThread
        MyThread myThread = new MyThread();
        myThread.start();

        //myRunnableThread
        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();

        //myRunnableLambdaThread
        Thread myRunnableLambdaThread = new Thread(() -> {
            for (int k = 0; k < 100; k++) {
                System.out.println("In " + Thread.currentThread().getName() + ". k: " + k);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        myRunnableLambdaThread.start();

    }
}

class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("In " + Thread.currentThread().getName() + ". i: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int j = 0; j < 100; j++) {
            System.out.println("In " + Thread.currentThread().getName() + ". j: " + j);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}