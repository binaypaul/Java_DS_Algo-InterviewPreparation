package DataStructure.Neetcode150.F_LinkedList;

public class g_LinkedListCycle {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode thi = new ListNode(3);
        ListNode fou = new ListNode(4);
        ListNode fif = new ListNode(5);

        one.next = two;
        two.next = thi;
        thi.next = fou;
        fou.next = fif;
//        fif.next = two;

        System.out.println(hasCycle(one));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}
