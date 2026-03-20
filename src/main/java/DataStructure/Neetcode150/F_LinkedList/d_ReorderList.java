package DataStructure.Neetcode150.F_LinkedList;
//https://leetcode.com/problems/reorder-list/description/
public class d_ReorderList {
    public static void main(String[] args) {
        ListNode head =
                new ListNode(
                        1, new ListNode(
                                2, new ListNode(
                                        3, new ListNode(
                                                4, new ListNode(
                                                        5, new ListNode(
                                                                6))))));
        ListNode.printList(head);
        reorderList(head);
        ListNode.printList(head);
    }

    private static void reorderList(ListNode head) {
        //base
        if (head == null) return;

        ListNode mid = findMid(head);

        ListNode rightPart = mid.next;
        rightPart = reverseRightPart(rightPart);

        mid.next = null;
        ListNode leftPart = head;

        // leftPart = 1->2
        //rightPart = 4->3
        while (rightPart != null) {
            ListNode leftNext = leftPart.next; //2
            ListNode rightNext = rightPart.next; //3

            leftPart.next = rightPart;
            leftPart.next.next = leftNext; //"leftPart.next.next" is "rightPart" here

            leftPart = leftNext;
            rightPart = rightNext;
        }
    }

    private static ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode reverseRightPart(ListNode rightPart) {
        ListNode prev = null, curr = rightPart, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }
}
