package DataStructure.Neetcode.F_LinkedList.Practise;

import DataStructure.Neetcode.F_LinkedList.ListNode;

public class d_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode.printList(head);
        head = removeNthNode(head, 5);
        ListNode.printList(head);
    }

    private static ListNode removeNthNode(ListNode head, int n) {
        if(head == null) return null;
        ListNode prev = null, slowCur = null, fastCur = head;
        int countNode = 1;

        while (fastCur != null) {
            if(countNode > n) {
                if(slowCur==null)
                    slowCur = head;
                else
                    slowCur = slowCur.next;
            }

            fastCur = fastCur.next;
            countNode++;
        }
        if(slowCur == null) {
            head = head.next;
        } else {
            slowCur.next = slowCur.next.next;
        }
        return head;
    }
}
