package DataStructure.Neetcode150.C_Stack;

import java.util.Stack;

public class c_EvaluateReversePolishNotation {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int y = stack.pop();
                int x = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(x+y);
                        break;
                    case "-":
                        stack.push(x-y);
                        break;
                    case "*":
                        stack.push(x*y);
                        break;
                    default:
                        stack.push(x/y);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
