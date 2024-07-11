package DataStructure.Linear.LinkedList.Problems;

import DataStructure.Linear.LinkedList.LinkedList;
import DataStructure.Linear.LinkedList.Node;
//Merge two sorted list in order till there are equal number of elements and add the remaining elements.
public class d_MergeTwoSortedLinkedList {
    public static void main(String[] args) {
        Node head1 = new LinkedList(1,3,5,22,42,9).head();
        LinkedList.printList(head1);

        Node head2 = new LinkedList(2,4,6,7,8).head();
        LinkedList.printList(head2);

        Node h = d_MergeTwoSortedLinkedList.mergeTwoSortedLinkedList(head1, head2);
        LinkedList.printList(h);
    }

    public static Node mergeTwoSortedLinkedList(Node h1, Node h2) {
        Node h = null;
        Node cur = null;
        while (h1 != null && h2 != null) {
            //base con
            if(h1.data <= h2.data) {
                if (cur == null) {
                    cur = new Node(h1.data);
                    h = cur;
                } else {
                    cur.next = new Node(h1.data);
                    cur = cur.next;
                }
                cur.next = new Node(h2.data);
                cur = cur.next;
            } else {
                if (cur == null) {
                    cur = new Node(h2.data);
                    h = cur;
                } else {
                    cur.next = new Node(h2.data);
                    cur = cur.next;
                }
                cur.next = new Node(h1.data);
                cur = cur.next;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        if(h1 != null) cur.next = h1;
        else cur.next = h2;
        return h;
    }
}
