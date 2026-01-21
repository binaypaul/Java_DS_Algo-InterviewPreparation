package JavaConcepts.Multithreading.ThreadSynchronization;

import JavaConcepts.Multithreading.*;

public class SynchronisedMethod {
	public static void main(String[] args) throws InterruptedException {
		CounterMethod c = new CounterMethod(1);
		Runnable runnable = () -> {
			for (int i = 0; i < 2000; i++) {
				c.increment();
			}
		};
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println(c.getCounter());
	}
}

class CounterMethod {
	private int counter;

	public CounterMethod(int counter) {
		this.counter = counter;
	}

	public int getCounter() {
		return counter;
	}

	public synchronized void increment() {
		this.counter += 1;
	}
}