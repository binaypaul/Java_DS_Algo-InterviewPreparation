package Concepts.Multithreading;

import java.util.PriorityQueue;
import java.util.Queue;

public class ProducerConsumer {
    private static volatile int count = 1;

    public static void main(String[] args) {
        int maxSize = 5;
        Queue<Integer> queue = new PriorityQueue<>();

        Thread producerThread = new Thread(() -> {
            synchronized (queue) {
                while (true) {
                    if (queue.size() == maxSize) {
                        try {
                            queue.notifyAll();
                            queue.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    System.out.println("Produced:: " + count);
                    queue.add(count);
                    count++;


                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });


        Thread consumerThread = new Thread(() -> {
            synchronized (queue) {
                while (true) {
                    if (queue.size()==0) {
                        try {
                            queue.notifyAll();
                            queue.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    int removed = queue.remove();
                    System.out.println("Consumed:: " + removed);


                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        producerThread.start();
        consumerThread.start();

    }
}
