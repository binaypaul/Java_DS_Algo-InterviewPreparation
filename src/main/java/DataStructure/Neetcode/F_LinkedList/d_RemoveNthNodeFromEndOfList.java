package DataStructure.Neetcode.F_LinkedList;
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class d_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode.printList(removeNthFromEnd(head, 1));                                                                                                                                                     ;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = head, right = head;
        int count = 1;
        while (right != null) {
            if(count > n+1) {
                left = left.next;
            }
            right = right.next;
            count++;
        }
        if(count-1 == n) return left.next;

        if(left.next != null)
            left.next = left.next.next;
        else
            return null;

        return head;
    }
}
