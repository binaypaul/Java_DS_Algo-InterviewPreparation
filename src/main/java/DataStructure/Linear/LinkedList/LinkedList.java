package DataStructure.Linear.LinkedList;

public class LinkedList {
    public Node head = null;
    public LinkedList(int... elements) {
        for (int i = 0; i < elements.length; i++) {
            if(i == 0) {
                head = new Node(elements[0]);
            } else {
                Node node = new Node(elements[i]);
                head.next = node;
            }
        }
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr.next != null) {
            System.out.print("| " + curr.data + " -> ");
            curr = curr.next;
        }
        System.out.print("NULL");
    }
}