package DataStructure.Neetcode.F_LinkedList.Practise;

import DataStructure.Neetcode.F_LinkedList.ListNode;

public class b_MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode.printList(list1);
        ListNode list2 = new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7))));
        ListNode.printList(list2);
        ListNode.printList(mergeTwoLists(list1, list2));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null, curr = null;

        if(list1 == null)
            return list2;
        else if (list2 == null) {
            return list1;
        }

        while (list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                if(head == null) {
                    head = new ListNode(list1.val);
                    curr = head;
                } else {
                    curr.next = new ListNode(list1.val);
                    curr = curr.next;
                }
                list1 = list1.next;
            }
            else {
                if(head == null) {
                    head = new ListNode(list2.val);
                    curr = head;
                } else {
                    curr.next = new ListNode(list2.val);
                    curr = curr.next;
                }
                list2 = list2.next;
            }
        }
        if (list1 == null) {
            curr.next = list2;
        } else {
            curr.next = list1;
        }
        return head;
    }
}
