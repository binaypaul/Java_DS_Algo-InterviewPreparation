package DataStructure.Topics.Stack_Queue.Stack.Practise;

public class StackUsingLinkedList {
    ListNode stackHead = null;
    int maxSize = 2;
    int top = -1;

    public void push(int item) {
        if(top == maxSize - 1) {
            System.out.println("Stack is full.");
        } else {
            ++top;
            ListNode listNode = new ListNode(item);
            if (stackHead == null) {
                stackHead = listNode;
            } else {
                listNode.next = stackHead;
                stackHead = listNode;
            }
            System.out.println(item + " is pushed.");
        }
    }

    public int pop() {
        if(top == -1) {
            System.out.println("Stack is empty.");
            return -1;
        } else {
            top--;
            int item = stackHead.data;
            stackHead = stackHead.next;
            return item;
        }
    }
     public int peek() {
        return stackHead != null ? stackHead.data : -1;
     }

    public static void main(String[] args) {
        StackUsingLinkedList stackUsingLinkedList = new StackUsingLinkedList();
        stackUsingLinkedList.push(5);
        stackUsingLinkedList.push(4);
        stackUsingLinkedList.push(3);
        System.out.println(stackUsingLinkedList.peek());
        System.out.println(stackUsingLinkedList.pop());
        System.out.println(stackUsingLinkedList.peek());
        System.out.println(stackUsingLinkedList.pop());
        System.out.println(stackUsingLinkedList.pop());
    }
}

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data){
        this.data = data;
    }
}
