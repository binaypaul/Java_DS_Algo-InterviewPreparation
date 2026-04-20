package DataStructure.Neetcode150.a_a_Practice.April.Mock_17_04_26;

import DataStructure.Neetcode150.F_LinkedList.*;
import org.w3c.dom.*;

public class ReorderList {
    public static void main(String[] args) {
        ListNode head = ListNode.create(1,2,3,4,5);
        ListNode.printList(head);
        ReorderList.reorderList(head);
        ListNode.printList(head);
    }
    public static void reorderList(ListNode head) {
        ListNode mid = findMid(head);
        ListNode nextPart = mid.next;
        nextPart = reverseList(nextPart);
        mid.next = null;
        while (nextPart != null && head!=null) {
            ListNode headNext = head.next;
            ListNode nextPartNext = nextPart.next;

            head.next = nextPart;
            head.next.next = headNext;

            nextPart = nextPartNext;
            head = head.next.next;
        }
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null, next = null, cur = head;
        while (cur!=null) {
            next = cur.next;
            cur.next=prev;

            prev = cur;
            cur = next;
        }
        return prev;
        //1->2->3->4->null
    }

    private static ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    /*
Example 1:

Input: 1 -> 2 -> 3 -> 4
            mid
Output: 1 -> 4 -> 2 -> 3

Example 2:

Input: 1 -> 2 -> 3 -> 4 -> 5
                mid
Output: 1 -> 5 -> 2 -> 4 -> 3
     */
}
