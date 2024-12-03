package DataStructure.Neetcode.F_LinkedList;

public class ListNode implements Cloneable{
    public int val;
    public ListNode next;
    public ListNode() {

    }
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void printList(ListNode head) {
        StringBuilder s = new StringBuilder();
        while (head != null) {
            s.append(head.val);
            if(head.next != null) {
                s.append(" -> ");
            }
            head = head.next;
        }

        System.out.println(s);
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    @Override
    public ListNode clone() {
        try {
            ListNode clone = (ListNode) super.clone();
            if (clone.next != null) {
                clone.next = clone.next.clone();
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}