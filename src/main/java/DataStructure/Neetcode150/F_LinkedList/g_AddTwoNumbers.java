package DataStructure.Neetcode150.F_LinkedList;
//https://leetcode.com/problems/add-two-numbers/description/
public class g_AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(5))));
        System.out.println(new g_AddTwoNumbers().addTwoNumbers(l1,l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryOver = 0;
        while (l1.next != null && l2.next != null) {
            int val = l1.val + l2.val + carryOver;
            //TODO
        }
        return l1;
    }
}
