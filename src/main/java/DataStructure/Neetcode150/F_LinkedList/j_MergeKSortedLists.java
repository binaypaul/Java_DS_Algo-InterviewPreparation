package DataStructure.Neetcode150.F_LinkedList;

//https://leetcode.com/problems/merge-k-sorted-lists/
/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted linked list:
1->1->2->3->4->4->5->6

Example 2:
Input: lists = []
Output: []

Example 3:
Input: lists = [[]]
Output: []
 */

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class j_MergeKSortedLists {
    public static void main(String[] args) {
        int[][] listsArr = new int[][]{{1}, {1,4,5}, {1,3,4}, {2,6}};
        ListNode[] lists = new ListNode[listsArr.length];
        for (int i = 0; i < listsArr.length; i++) {
            lists[i] = ListNode.create(listsArr[i]);
            ListNode.printList(lists[i]);
        }
        ListNode.printList(new j_MergeKSortedLists().mergeKLists(lists));
    }
    public ListNode mergeKLists(ListNode[] lists) {
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
        return head;
    }
}
