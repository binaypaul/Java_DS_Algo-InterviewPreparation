package DataStructure.Neetcode150.a_a_Practice.Mock6_4Q90Min;

import DataStructure.Neetcode150.F_LinkedList.*;
import java.util.*;

public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode l1 = ListNode.create(new int[] {1,4,5});
        ListNode l2 = ListNode.create(new int[] {2,3});

        System.out.println(new MergeKSortedLists().mergeKLists(new ListNode[]{l1,l2}).toString());
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null, cur = null;
        var pq = new PriorityQueue<ListNode>(Comparator.comparingInt(a -> a.val));
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                pq.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }

        while (!pq.isEmpty()) {
            if(head == null) {
                head = pq.poll();
                cur = head;
            } else {
                cur.next = pq.poll();
                cur = cur.next;
            }
        }
        if(cur!=null) cur.next = null;
        return head;
    }
}