package DataStructure.Neetcode150.F_LinkedList;

public class DoublyListNode {
    int val;
    DoublyListNode prevNode;
    DoublyListNode nextNode;

    public DoublyListNode(int val) {
        this.val = val;
    }

    public DoublyListNode(int val, DoublyListNode prevNode, DoublyListNode nextNode) {
        this.val = val;
        this.prevNode = prevNode;
        this.nextNode = nextNode;
    }
}
