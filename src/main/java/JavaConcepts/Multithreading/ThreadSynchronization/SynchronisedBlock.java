package JavaConcepts.Multithreading.ThreadSynchronization;

public class SynchronisedBlock {
	public static void main(String[] args) throws InterruptedException {
		CounterBlock c = new CounterBlock(1);
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

class CounterBlock {
	private int counter;

	public CounterBlock(int counter) {
		this.counter = counter;
	}

	public int getCounter() {
		return counter;
	}

	public void increment() {
		synchronized (this) {
			this.counter += 1;
		}
	}
}