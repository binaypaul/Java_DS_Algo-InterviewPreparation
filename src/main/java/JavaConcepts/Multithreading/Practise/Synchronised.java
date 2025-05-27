package JavaConcepts.Multithreading.Practise;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Synchronised {
    public static void main(String[] args) {
        CommonLock commonLock = new CommonLock("Starting!");
        SynMethodPrint synMethodPrint = new SynMethodPrint();

        Thread t1 = new Thread(new SyncTest("From thread t1", commonLock, synMethodPrint));
        Thread t2 = new Thread(new SyncTest("From thread t2", commonLock, synMethodPrint));
        t1.start();
        t2.start();
        System.out.println("Both thread started.");
    }
}

@Data
@AllArgsConstructor
class SyncTest implements Runnable {
    String msg;
    CommonLock commonLock;
    SynMethodPrint synMethodPrint;
    @Override
    public void run() {
        try {
            synBlockPrint(msg, commonLock);
            Thread.sleep(2000);
            synMethodPrint.synMethodPrint(msg, commonLock);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void synBlockPrint(String msg, CommonLock commonLock) throws InterruptedException {
        synchronized (commonLock) {
            System.out.println(commonLock.msg);
            Thread.sleep(2000);
            System.out.println(msg);
            Thread.sleep(2000);
        }
    }
}

@Data
@AllArgsConstructor
class CommonLock {
    String msg;
}

class SynMethodPrint {
    public synchronized void synMethodPrint(String msg, CommonLock commonLock) throws InterruptedException {
        System.out.println(commonLock.msg);
        Thread.sleep(2000);
        System.out.println(msg);
        Thread.sleep(2000);
    }
}