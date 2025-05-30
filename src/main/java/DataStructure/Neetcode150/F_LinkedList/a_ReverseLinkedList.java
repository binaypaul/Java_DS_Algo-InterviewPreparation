package DataStructure.Neetcode150.F_LinkedList;
//https://leetcode.com/problems/reverse-linked-list/
public class a_ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode.printList(head);
        head = reverseList(head);
        ListNode.printList(head);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head, next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }
        head = prev;
        return head;
    }
}