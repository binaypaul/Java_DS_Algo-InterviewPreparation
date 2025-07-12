package JavaConcepts.Multithreading.ThreadSynchronization;

public class SynchronisedMethod {
	public static void main(String[] args) throws InterruptedException {
		CounterMethod c = new CounterMethod(1);
//		Created the thread using thread class for practise.
//		Thread created by Runnable and thread class does the same thing.
//		Can be tried by uncommenting below code.
//		Runnable runnable = () -> {
//			for (int i = 0; i < 2000; i++) {
//				c.increment();
//			}
//		};
//		Thread t1 = new Thread(runnable);
//		Thread t2 = new Thread(runnable);

		MyThread t1 = new MyThread(c);
		MyThread t2 = new MyThread(c);

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println(c.getCounter());
	}
}

class MyThread extends Thread {
	private CounterMethod c;

	public MyThread(CounterMethod c) {
		this.c = c;
	}

	@Override
	public void run() {
		for (int i = 0; i < 2000; i++) {
			c.increment();
		}
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