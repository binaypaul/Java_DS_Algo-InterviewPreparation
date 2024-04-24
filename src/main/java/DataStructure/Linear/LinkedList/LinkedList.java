package DataStructure.Linear.LinkedList;

public class LinkedList {
    private Node head = null;
    public Node head() {
        return this.head;
    }


    public LinkedList(int... elements) {
        Node curr = null;
        for (int i = 0; i < elements.length; i++) {
            if(i == 0) {
                head = new Node(elements[0]);
                curr = head;
            } else {
                Node node = new Node(elements[i]);
                curr.next = node;
                curr = node;
            }
        }
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.print("NULL");
        System.out.println();
    }
}