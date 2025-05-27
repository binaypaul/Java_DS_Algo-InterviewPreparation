package JavaConcepts.Multithreading;

public class ThreadGroupDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("t1: " + i);
            }
        });

        ThreadGroup tg = new ThreadGroup("tg");

        Thread t2 = new Thread(tg, ()-> {
            for (int i = 0; i < 100; i++) {
                System.out.println("t2: " + i);
            }
        });

        Thread t3 = new Thread(tg, ()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("t3: " + i);
            }
        });

        t1.setPriority(Thread.MAX_PRIORITY);
        tg.setMaxPriority(Thread.MIN_PRIORITY);

        t2.start();
        t3.start();
        t1.start();

    }
}
