package JavaConcepts.Multithreading.Synchronised;

import lombok.AllArgsConstructor;
import lombok.Data;

public class SynchronisedMethod {

	public static void main(String[] args) throws InterruptedException {
		Sender1 s = new Sender1("Sending...");
		SynchronisedMethodTester s0 = new SynchronisedMethodTester(s, "Its from Thread T0");
		Thread t0 = new Thread(s0);
		SynchronisedMethodTester s1 = new SynchronisedMethodTester(s, "Its from Thread T1");
		Thread t1 = new Thread(s1);
		t0.start();
		t1.start();
		System.out.println("Both thread started.");
	}
}

class SynchronisedMethodTester implements Runnable{
	private Sender1 sender;
	private String msg;
	public SynchronisedMethodTester(Sender1 sender, String msg) {
		this.sender = sender;
		this.msg = msg;
	}
	@Override
	public void run() {
		try {
			sender.print(msg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

@Data
@AllArgsConstructor
class Sender1 {
	private String str;

	public synchronized void print(String msg) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " " + this.getStr());
		Thread.sleep(2000);
		System.out.println(msg);
	}
}