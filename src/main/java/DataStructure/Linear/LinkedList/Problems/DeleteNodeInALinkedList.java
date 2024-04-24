package DataStructure.Linear.LinkedList.Problems;

import DataStructure.Linear.LinkedList.LinkedList;
import DataStructure.Linear.LinkedList.Node;

public class DeleteNodeInALinkedList {
    public static void main(String[] args) {

        Node head = new LinkedList(1,2,3,4,5,6,7).head();
        LinkedList.printList(head);
        Node deletedNodeHead = DeleteNodeInALinkedList.deleteNode(head,7);
        LinkedList.printList(deletedNodeHead);
    }

    public static Node deleteNode(Node head, int pos) {
        //base condition
        if (pos == 1) {
            head = head.next;
            return head;
        }

        //main condition
        int count = 1;
        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            count++;
            if(pos == count) {
                prev.next = curr.next;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}
