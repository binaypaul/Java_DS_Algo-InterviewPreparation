package JavaConcepts.Multithreading;

public class CreateADeadlock_CleanCode {
    public static void main(String[] args) {
        Resource res1 = new Resource();
        Resource res2 = new Resource();

        Thread t1 = new Thread(()-> {
            synchronized (res1) {
                System.out.println("hello-1-t1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (res2) {
                    System.out.println("hello-2-t1");
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(()-> {
            synchronized (res2) {
                System.out.println("hello-1-t2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (res1) {
                    System.out.println("hello-2-t2");
                }
            }
        });
        t2.start();
    }
}

class Resource {}