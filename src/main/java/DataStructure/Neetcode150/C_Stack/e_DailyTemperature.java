package DataStructure.Neetcode150.C_Stack;

import java.util.Arrays;
import java.util.Stack;

public class e_DailyTemperature {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 76, 71, 69, 72, 77, 73})));
    }                                                                //0    1   2   3   4   5   6   7
    public static int[] dailyTemperatures(int[] temps) {
        int[] results = new int[temps.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temps.length; i++) {
            while (!stack.isEmpty() && temps[i]>temps[stack.peek()]) {
                results[stack.peek()] = i-stack.pop();
            }
            stack.push(i);
        }
        return results;
    }
}
