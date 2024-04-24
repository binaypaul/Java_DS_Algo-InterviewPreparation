package DataStructure.Linear.LinkedList.Problems;

import DataStructure.Linear.LinkedList.LinkedList;
import DataStructure.Linear.LinkedList.Node;

public class MiddleOfALinkedList extends LinkedList {
    public static void main(String[] args) {
        Node head = new LinkedList(1,2,3,4,5,6).head();
        LinkedList.printList(head);
        MiddleOfALinkedList.findMiddle(head);

        Node head1 = new LinkedList(1,2,3,4,5,6,7).head();
        LinkedList.printList(head1);
        MiddleOfALinkedList.findMiddle(head1);
    }

    public static void findMiddle(Node head) {
        //base condition
        if(head.next == null) {
            System.out.println(head.data);
        }

        //main condition
        Node slow = head;
        Node fast = head;
        Node prevOfSlow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prevOfSlow = slow;
            slow = slow.next;
        }
        if(fast == null) {
            System.out.println(prevOfSlow.data + ", " + slow.data);
        } else {
            System.out.println(slow.data);
        }
    }
}
