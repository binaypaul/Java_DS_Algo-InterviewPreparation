package DataStructure.Neetcode150.F_LinkedList;

import org.w3c.dom.*;

//https://leetcode.com/problems/add-two-numbers/description/
public class g_AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode.printList(new g_AddTwoNumbers().addTwoNumbers(l1,l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return null;
    }
}
