package DataStructure.Neetcode150.a_a_Practice.Mock10;

import java.util.*;

public class DailyTemp {
    public int[] dailyTemperatures(int[] temperatures) {
        var ret = new int[temperatures.length];
        var stack = new Stack<Integer>();//Index
        for (int i = 0; i < temperatures.length; i++) {
            if(stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    int top = stack.pop();
                    ret[top] = i-top;
                }
                stack.push(i);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(new DailyTemp().dailyTemperatures(temperatures)));
    }
}
/*
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 */