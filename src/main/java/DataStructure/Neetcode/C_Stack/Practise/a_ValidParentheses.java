package DataStructure.Neetcode.C_Stack.Practise;

import java.util.Arrays;

public class a_ValidParentheses {
    public static void main(String[] args) {
        System.out.println(new a_ValidParentheses().isValid("{[()]"));
    }

    private boolean isValid(String s) {
        Stack stack = new Stack();

        char[] schar = s.toCharArray();
        for(char sc : schar) {
            if(sc == '[' || sc == '{' || sc == '(') {
                stack.push(sc);
            } else if (sc == ']' || sc == '}' || sc == ')') {
                if(sc == ']' && stack.pop() != '[') return false;
                else if(sc == '}' && stack.pop() != '{') return false;
                else if(sc == ')' && stack.pop() != '(') return false;
            }
        }
        return stack.top == -1;
    }

}


class Stack {
    int maxSize = 10;
    char[] stack = new char[maxSize];
    int top = -1;

    void push(char item) {
        if (top == maxSize - 1) {
            System.out.println("Stack is full.");
        } else {
            stack[++top] = item;
            System.out.println(item + " is pushed.");
        }
    }

    char pop() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return '-';
        } else {
            return stack[top--];
        }
    }

    char peek() {
        return stack[top];
    }
}