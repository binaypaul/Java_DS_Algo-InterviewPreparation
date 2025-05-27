package DataStructure.Concepts.Stack_Queue.Queue.Practise;

public class QueueUsingArray {
    int front, rear, maxsize = 3, size;
    int[] queue = new int[maxsize];

    public void enQueue(int item) {
        if(size < maxsize) {
            queue[(rear++)%maxsize] = item;
            size++;
            System.out.println(item + " enqueued.");
        } else {
            System.out.println("Queue is full.");
        }
    }

    public void deQueue() {
        if(size==0) {
            System.out.println("Queue is empty.");;
        } else {
            int item = queue[(front++)%maxsize];
            --size;
            System.out.println(item + " dequeued.");
        }
    }

    public void printQueue() {
        if(size != 0) {
            for(int data : queue) {
                System.out.print(data + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        QueueUsingArray queue = new QueueUsingArray();
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.enQueue(40);
        queue.enQueue(50);
        queue.printQueue();
        queue.enQueue(60);
        queue.enQueue(70);
        queue.printQueue();
        queue.deQueue();
        queue.printQueue();
        queue.deQueue();
        queue.deQueue();
        queue.enQueue(80);
        queue.enQueue(90);
        queue.printQueue();
        queue.deQueue();
        queue.deQueue();
    }
}
