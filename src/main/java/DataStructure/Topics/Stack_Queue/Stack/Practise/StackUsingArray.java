package DataStructure.Topics.Stack_Queue.Stack.Practise;

public class StackUsingArray {
    int maxSize = 1;
    int[] stack = new int[maxSize];
    int top = -1;

    private void push(int item) {
        if(top == maxSize-1) {
            System.out.println("Stack is full.");
        } else {
            stack[++top] = item;
            System.out.println(item + " is pushed.");
        }
    }

    private int pop() {
        if(top == -1) {
            System.out.println("Stack is empty.");
            return -1;
        } else {
            return stack[top--];
        }
    }

    private int peek() {
        return stack[top];
    }

    public static void main(String[] args) {
        StackUsingArray stackUsingArray = new StackUsingArray();
        stackUsingArray.push(5);
        stackUsingArray.push(4);
        System.out.println(stackUsingArray.peek());
        System.out.println(stackUsingArray.peek());
        System.out.println(stackUsingArray.pop());
        System.out.println(stackUsingArray.pop());
    }

}
