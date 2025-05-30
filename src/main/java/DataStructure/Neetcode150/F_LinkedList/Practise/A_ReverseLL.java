package DataStructure.Neetcode150.F_LinkedList.Practise;

import DataStructure.Neetcode150.F_LinkedList.ListNode;

public class A_ReverseLL {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode.printList(head);
        head = reverseList(head);
        ListNode.printList(head);
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;

        while (cur!=null) {
            next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }
        return prev;
    }
}
