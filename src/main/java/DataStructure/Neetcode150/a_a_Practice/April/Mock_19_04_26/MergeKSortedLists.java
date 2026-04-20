package DataStructure.Neetcode150.a_a_Practice.April.Mock_19_04_26;

import DataStructure.Neetcode150.F_LinkedList.*;
import java.util.*;
import lombok.*;

public class MergeKSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null, cur = null;

        var pq = new PriorityQueue<>(Comparator.comparing(ListNode::getVal));
        for (int i = 0; i < lists.length; i++) {
            if(lists[i]!=null) {
                pq.add(lists[i]);
            }
        }

        while (!pq.isEmpty()) {
            ListNode min = pq.remove();
            if(min.next != null)
                pq.add(min.next);
            if(head == null) {
                head = min;
                cur = head;
            } else {
                cur.next = min;
                cur = cur.next;
            }
        }
        if(cur!=null)
            cur.next=null;
        return head;
    }

    public static void main(String[] args) {
        ListNode.printList(MergeKSortedLists.mergeKLists(
                new ListNode[]{
                        ListNode.create(1,4,5),
                        ListNode.create(1,3,4),
                        ListNode.create(2,6)
                }
        ));
    }
    /*
Input: lists = [[1,4,5],[1,3,4],[2,6]]

Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
     */
}