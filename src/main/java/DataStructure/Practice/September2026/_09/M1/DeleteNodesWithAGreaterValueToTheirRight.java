package DataStructure.Practice.September2026._09.M1;

import DataStructure.Concepts.LinkedList.*;
import java.util.*;

public class DeleteNodesWithAGreaterValueToTheirRight {
    public static void main (String[] args) {
        ListNode head = ListNode.create(1,1,1,1,1); //OP: [13, 8]
        ListNode.printList(new DeleteNodesWithAGreaterValueToTheirRight().removeNodes(head));
    }

    public ListNode removeNodes(ListNode head) {
        var stack = new ArrayDeque<ListNode>();
        ListNode cur = head;
        while (cur!=null) {
            while (!stack.isEmpty() && stack.peek().val < cur.val) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                head = cur;
            } else {
                stack.peek().next=cur;
            }
            stack.push(cur);
            cur=cur.next;
        }
        return head;
    }
}
