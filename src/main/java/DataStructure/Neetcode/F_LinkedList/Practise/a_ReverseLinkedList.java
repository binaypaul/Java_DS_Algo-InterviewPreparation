package DataStructure.Neetcode.F_LinkedList.Practise;

import DataStructure.Neetcode.F_LinkedList.ListNode;

public class a_ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode.printList(head);
        ListNode.printList(reverseList(head));
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null, next = null, cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }
        return prev;
    }
}
