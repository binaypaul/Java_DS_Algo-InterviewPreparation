package DataStructure.Neetcode150.a_a_Practice.Mock4_4Q90Min;

import java.util.*;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println("Valid: " + new ValidParentheses()
                .isValid("}"));
    }

    private boolean isValid(String s) {
        var stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if(c=='(' || c=='{'||c=='[') {
                stack.push(c);
            } else {
                if(!stack.isEmpty()) {
                    if(c==')' && stack.peek()=='(') {
                        stack.pop();
                    } else if(c=='}' && stack.peek()=='{') {
                        stack.pop();
                    } else if(c==']' && stack.peek()=='[') {
                        stack.pop();
                    } else return false;
                } else if(c==']' || c=='}'||c==')') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
