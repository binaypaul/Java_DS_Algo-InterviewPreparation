package DataStructure.Linear.LinkedList.Problems;

import DataStructure.Linear.LinkedList.Node;

public class a_ReverseALinkedList {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		printList(head);
		reverse(head);
		printList(head);
	}
	
	public static void reverse(Node head) {
		while(head.next != null) {
			Node prev = head;
			head = head.next;
			Node current = head;
			current.next = prev;
		}
	}
	
	public static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
}
