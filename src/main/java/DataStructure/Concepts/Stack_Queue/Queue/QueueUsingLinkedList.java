package DataStructure.Concepts.Stack_Queue.Queue;

public class QueueUsingLinkedList {
	public static void main(String[] args) {
		Queue1 queue = new Queue1(5);
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		queue.enQueue(40);
		queue.enQueue(50);
		queue.printQueue();
		queue.deQueue();
		queue.deQueue();
		queue.printQueue();
		queue.enQueue(60);
		queue.printQueue();
		queue.deQueue();
		queue.printQueue();
		queue.enQueue(70);
		queue.enQueue(80);
		queue.enQueue(90);
	}
}

class Node {
	int data;
	Node next;
	public Node(int data) {
		this.data = data;
	}
}

class Queue1 {
	Node front;
	Node rear;
	int size, maxsize;
	public Queue1(int maxsize) {
		this.maxsize = maxsize;
	}
	
	public boolean isFull() {
		return size == maxsize;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean enQueue(int data) {
		if(isFull()) {
			System.out.println("Queue is full.");
			return false;
		} else {
			Node n = new Node(data);
			if(isEmpty()) {
				front = rear = n;
			} else {
				front.next = n;
				front = n;
			}
			size++;
			System.out.println(data + " is enQueued.");
			return true;
		}
	}
	
	public int deQueue() {
		if(isEmpty()) {
			System.out.println("Queue is empty.");
			return -1;
		} else {
			int data = rear.data;
			rear = rear.next;
			size--;
			System.out.println(data + " is deQueued.");
			return data;
		}
	}
	
	public void printQueue() {
		Node n = rear;
		System.out.println("-====================");
		System.out.println("| Queue: ");
		while(rear != null) {
			System.out.println("| " + rear.data);
			rear = rear.next;
		}
		System.out.println("-====================");
		rear = n;
	}
}