package DataStructure.Topics.Stack_Queue.Stack;

public class StackUsingArray {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.printStack();
        stack.push(60);
        stack.push(70);
        stack.printStack();
        stack.pop();
        stack.printStack();
    }
}

class Stack {
    private int[] array;
    private int top = -1;
    private int maxsize;
    public Stack(int maxsize) {
        this.maxsize = maxsize;
        this.array = new int[maxsize];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxsize-1;
    }

    public void push(int data) {
        if(isFull()) {
            System.out.println("Stack Overflow!");
        } else {
            array[++top] = data;
            System.out.println(data + " pushed.");
        }
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack Underflow!");
            return -1;
        } else {
            int data = array[top--];
            System.out.println(data + " popped.");
            return data;
        }
    }

    public void printStack() {
        for (int i = top; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }
}