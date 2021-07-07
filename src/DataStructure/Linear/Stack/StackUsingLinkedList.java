package DataStructure.Stack;

public class StackUsingLinkedList {

	public static void main(String[] args) {
		Stack1 s = new Stack1(5);
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		System.out.println("--push done--");
		s.printStack();
		s.pop();
		System.out.println("--pop done--");
		s.printStack();
	}
}

class Node {
	int data;
	Node next;
	public Node(int data) {
		this.data = data;
	}
}

class Stack1 {
	int size;
	int maxSize;
	Node head;
	
	public Stack1(int maxSize) {
		this.maxSize = maxSize;
	}
	
	public boolean isEmpty() {
		return size <= 0;
	}
	
	public boolean isFull() {
		return size == maxSize;
	}
	
	public boolean push(int data) {
		if(isFull()) {
			System.out.println("Stack is full");
			return false;
		} else {
			Node n = new Node(data);
			if(isEmpty()) {
				head = n;
			} else {
				n.next = head;
				head = n;
			}
			size++;
			System.out.println(data + " is pushed into stack.");
			return true;
		}
	}
	
	public int pop() {
		if(!isEmpty()) {
			int data = head.data;
			head = head.next;
			size--;
			System.out.println(data + " is popped from stack.");
			return data;
		}
		return -1;
	}
	
	public void printStack() {
		if(isEmpty()) {
			System.out.println("Stack is empty.");
		} else {
			Node n = head;
			while(n != null) {
				System.out.println(n.data);
				n = n.next;
			}
		}
	}
}