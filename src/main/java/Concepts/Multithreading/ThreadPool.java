package Concepts.Multithreading;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(new ThreadPoolTester("--T0--"));
		es.execute(new ThreadPoolTester("--T1--"));
		es.execute(new ThreadPoolTester("--T2--"));
		es.execute(new ThreadPoolTester("--T3--"));
		es.execute(new ThreadPoolTester("--T4--"));
		es.execute(new ThreadPoolTester("--T5--"));
		es.shutdown();
	}
}

class ThreadPoolTester implements Runnable {
	String taskName;
	public ThreadPoolTester(String taskName) {
		this.taskName = taskName;
	}
	@Override
	public void run() {
		try {
			task();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void task() throws Exception {
		for(int i=0;i<3;i++) {
			if(i==0)
				System.out.println("Initialization of task: "+ taskName +" done at time: " + printDateTime());
			else
				System.out.println("Execution " + i + " of task: "+ taskName +" done at time: " + printDateTime());
		}
		Thread.sleep(2000);
		if(taskName.equals("--T2--")) {
			Thread.sleep(500);
			throw new Exception();	//causes thread with this runnable to cease. However, other runnable can run using this thread from the pool.
		}
		System.out.println("Completed task: " + taskName + " at time: " + printDateTime());

	}
	public String printDateTime() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		return sdf.format(d);
	}

}