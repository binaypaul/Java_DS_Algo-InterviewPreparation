package DataStructure.Concepts.Stack_Queue.Queue;

public class QueueUsingArray {

	public static void main(String[] args) {
		Queue queue = new Queue(5);
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
		queue.enQueue(60);
		queue.enQueue(70);
		queue.deQueue();
	}

}
class Queue{
	int size, maxsize, front, rear;
	int[] arr;
	public Queue(int maxsize) {
		this.maxsize = maxsize;
		arr = new int[maxsize];
	}
	
	public boolean isFull() {
		return size >= maxsize;
	}
	
	public boolean isEmpty() {
		return size <= 0;
	}
	
	public boolean enQueue(int data) {
		if(isFull()) {
			System.out.println("Queue is full.");
			return false;
		} else {
			arr[rear] = data;
			rear = (rear + 1) % maxsize;
			size++;
			System.out.println(data + " is enQueued.");
			return true;
		}
	}
	
	public int deQueue() {
		if(!isEmpty()) {
			int data = arr[front];
			front = (front + 1) % maxsize;
			size--;
			System.out.println(data + " is deQueued.");
			return data;
		} else {
			System.out.println("Queue is empty.");
			return -1;
		}
	}
	
	public void printQueue() {
		if(!isEmpty()) {
			for(int data : arr) {
				System.out.print(data + " ");
			}
			System.out.println();
		}
	}
}