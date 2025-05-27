package JavaConcepts.Multithreading.Synchronised;

import lombok.AllArgsConstructor;
import lombok.Data;

public class SynchronisedBlock {

	public static void main(String[] args) throws InterruptedException {
		Sender s = new Sender("Sending...");
		SynchronisedBlockTester s0 = new SynchronisedBlockTester(s, "Its from Thread T0");
		Thread t0 = new Thread(s0);
		SynchronisedBlockTester s1 = new SynchronisedBlockTester(s, "Its from Thread T1");
		Thread t1 = new Thread(s1);
		t0.start();
		t1.start();
		System.out.println("Both thread started.");
	}
}

class SynchronisedBlockTester implements Runnable{
	private Sender sender;
	private String msg;

	public SynchronisedBlockTester(Sender sender, String msg) {
		this.sender = sender;
		this.msg = msg;
	}

	@Override
	public void run() {
		try {
			print();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void print() throws InterruptedException {
		synchronized (sender) {
			System.out.println(Thread.currentThread().getName() + " " + sender.getStr());
			Thread.sleep(2000);
			System.out.println(msg);
		}
	}
}

@Data
@AllArgsConstructor
class Sender {
	private String str;
}