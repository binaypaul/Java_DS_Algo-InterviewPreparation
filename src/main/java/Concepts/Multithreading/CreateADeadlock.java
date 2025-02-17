package Concepts.Multithreading;

import lombok.AllArgsConstructor;

public class CreateADeadlock {
	public static void main(String[] args) {
		SharedRes sharedRes1 = new SharedRes();
		SharedRes sharedRes2 = new SharedRes();
		Thread ta = new Thread(new RunnableA(sharedRes1, sharedRes2));
		Thread tb = new Thread(new RunnableB(sharedRes1, sharedRes2));
		ta.start();
		tb.start();
	}
}
@AllArgsConstructor
class RunnableA implements Runnable {
	private SharedRes sharedRes1;
	private SharedRes sharedRes2;
	@Override
	public void run() {
		System.out.println("In RunnableA run");
		System.out.println("RunnableA: Trying to acquire lock on sharedRes1");
		synchronized (sharedRes1) {
			System.out.println("RunnableA: Acquired lock on sharedRes1");
			try {
				System.out.println("RunnableA: Sleeping for 2 sec");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("RunnableA: Trying to acquire lock on sharedRes2");
			synchronized (sharedRes2) {
				System.out.println("RunnableA: Acquired lock on sharedRes2");
				try {
					System.out.println("RunnableA: Sleeping for 2 sec");
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Exiting from RunnableA run");
	}
}

class RunnableB implements Runnable {
	private SharedRes sharedRes1;
	private SharedRes sharedRes2;
	public RunnableB(SharedRes sharedRes1, SharedRes sharedRes2) {
		this.sharedRes1 = sharedRes1;
		this.sharedRes2 = sharedRes2;
	}
	@Override
	public void run() {
		System.out.println("In RunnableB run");
		System.out.println("RunnableB: Trying to acquire lock on sharedRes2");
		synchronized (sharedRes2) {
			System.out.println("RunnableB: Acquired lock on sharedRes2");
			try {
				System.out.println("RunnableB: Sleeping for 2 sec");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("RunnableB: Trying to acquire lock on sharedRes1");
			synchronized (sharedRes1) {
				System.out.println("RunnableB: Acquired lock on sharedRes1");
				try {
					System.out.println("RunnableB: Sleeping for 2 sec");
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Exiting from RunnableB run");
	}
}

class SharedRes {}