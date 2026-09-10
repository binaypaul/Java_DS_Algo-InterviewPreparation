package DataStructure.Concepts.LinkedList;

public class DoublyListNode {
    public int val;
    public DoublyListNode prevNode;
    public DoublyListNode nextNode;

    public DoublyListNode(int val) {
        this.val = val;
    }

    public DoublyListNode(int val, DoublyListNode prevNode, DoublyListNode nextNode) {
        this.val = val;
        this.prevNode = prevNode;
        this.nextNode = nextNode;
    }
}
