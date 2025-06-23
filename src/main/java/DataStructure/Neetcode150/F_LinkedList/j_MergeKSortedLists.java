package DataStructure.Neetcode150.F_LinkedList;

//https://leetcode.com/problems/merge-k-sorted-lists/

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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode cur = null;
        ListNode head = null;
        int count = 0;

        Integer[] arr = new Integer[lists.length];

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                arr[i] = lists[i].val;
                count++;
                lists[i] = lists[i].next;
            }
        }

        while (count > 0) {
            int curMinI = 0;
            int curMin = Integer.MAX_VALUE;


            for (int i = 0; i < arr.length; i++) {
                if(arr[i] != null) {
                    if(arr[i] < curMin) {
                        curMin = arr[i];
                        curMinI = i;
                    }
                }
            }
            if (head == null) {
                head = new ListNode(curMin);
                cur = head;
            } else {
                cur.next = new ListNode(curMin);
                cur = cur.next;
            }

            if(lists[curMinI] != null) {
                arr[curMinI] = lists[curMinI].val;
                lists[curMinI] = lists[curMinI].next;
            } else {
                arr[curMinI] = null;
                count--;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[][] listsArr = new int[][]{{1,4,5}, {1,3,4}, {2,6}};
        ListNode[] lists = new ListNode[listsArr.length];
        for (int i = 0; i < listsArr.length; i++) {
            lists[i] = ListNode.create(listsArr[i]);
            ListNode.printList(lists[i]);
        }
        ListNode.printList(new j_MergeKSortedLists().mergeKLists(lists));
    }
}
