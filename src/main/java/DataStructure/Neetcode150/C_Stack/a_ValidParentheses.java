package DataStructure.Neetcode150.C_Stack;
/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([])"
Output: true

Example 5:
Input: s = "([)]"
Output: false
 */

public class a_ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }

    public static boolean isValid(String s) {
        for(String inBracket : s.split("")) {
            if(inBracket.equals("(")
            || inBracket.equals("{")
            || inBracket.equals("[")) {
                String element = Stack1.push(inBracket);
                if(element == null) {
                    return false;
                }
            } else {
                String element = Stack1.pop();
                if(element == null) {
                    return false;
                } else if (inBracket.equals(")") && !element.equals("(")) {
                    return false;
                }else if (inBracket.equals("}") && !element.equals("{")) {
                    return false;
                }else if (inBracket.equals("]") && !element.equals("[")) {
                    return false;
                }
            }
        }
        return Stack1.peek()==null;
    }
}

class Stack1 {
    static int maxSize = Integer.MAX_VALUE;
    private static String[] Stack1 = new String[maxSize];
    private static int top = -1;

    static String push (String s) {
        if(top+1 >= maxSize) {
            return null;
        }
        top++;
        Stack1[top] = s;
        return s;
    }

    static String pop () {
        if(top == -1) {
            return null;
        }
        String element = Stack1[top];
        top--;
        return element;
    }

    static String peek () {
        if(top == -1) {
            return null;
        }
        return Stack1[top];
    }
}