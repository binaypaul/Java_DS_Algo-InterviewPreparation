package DataStructure.LinkedList;

public class Node {
	public int data;
	public Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
	
	@Override
	public String toString() {
		return String.valueOf(data);
	}
//	
//	public int getData() {
//		return data;
//	}
//	public void setData(int data) {
//		this.data = data;
//	}
//	public Node getNext() {
//		return next;
//	}
//	public void setNext(Node next) {
//		this.next = next;
//	}
}
