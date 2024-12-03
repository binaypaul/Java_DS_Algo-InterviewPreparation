package DataStructure.Neetcode.F_LinkedList;

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

        while (list1 != null && list2 != null) {
            int val1 = list1.val;
            int val2 = list2.val;
            if(val2 > val1) {
                if(head == null) {
                    curr = new ListNode(val1);
                    head = curr;
                } else {
                    curr.next = new ListNode(val1);
                    curr = curr.next;
                }
                list1 = list1.next;
            } else {
                if(head == null) {
                    curr = new ListNode(val2);
                    head = curr;
                } else {
                    curr.next = new ListNode(val2);
                    curr = curr.next;
                }
                list2 = list2.next;
            }
        }


        if(list1 != null) {
            if(head != null) {
                curr.next = list1;
            } else {
                head = list1;
            }
        } else {
            if(head != null) {
                curr.next = list2;
            } else {
                head = list2;
            }
        }

        return head;
    }
}
