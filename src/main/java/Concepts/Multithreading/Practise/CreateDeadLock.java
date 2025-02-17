package Concepts.Multithreading.Practise;

import lombok.AllArgsConstructor;
import lombok.Data;

public class CreateDeadLock {
    public static void main(String[] args) {
        Resource resource1 = new Resource("resource1");
        Resource resource2 = new Resource("resource2");

        Thread1 t1 = new Thread1(resource1, resource2);
        Thread2 t2 = new Thread2(resource1, resource2);

        t1.start();
        t2.start();
    }

}

@AllArgsConstructor
@Data
class Thread1 extends Thread {
    Resource resource1;
    Resource resource2;

    public void run() {
        synchronized (resource1) {
            System.out.println(resource1.msg);
            System.out.println("Trying to concat resource1 and resource2 msgs.");
            synchronized (resource2) {
                System.out.println(resource2.msg);
                System.out.println(resource1.msg + resource2.msg);
            }
        }
    }
}

@AllArgsConstructor
@Data
class Thread2 extends Thread {
    Resource resource1;
    Resource resource2;

    public void run() {
        synchronized (resource2) {
            System.out.println(resource2.msg);
            System.out.println("Trying to concat resource2 and resource1 msgs.");
            synchronized (resource1) {
                System.out.println(resource1.msg);
                System.out.println(resource1.msg + resource2.msg);
            }
        }
    }
}

@Data
@AllArgsConstructor
class Resource {
    String msg;
}
