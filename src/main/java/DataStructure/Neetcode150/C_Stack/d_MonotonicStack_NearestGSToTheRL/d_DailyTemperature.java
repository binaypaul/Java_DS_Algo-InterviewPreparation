package DataStructure.Neetcode150.C_Stack.d_MonotonicStack_NearestGSToTheRL;

import java.util.Arrays;
import java.util.Stack;
//https://leetcode.com/problems/daily-temperatures/description/
/*
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

Example 1:
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]

Example 2:
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]

Example 3:
Input: temperatures = [30,60,90]
Output: [1,1,0]
 */
public class d_DailyTemperature {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 76, 71, 69, 72, 77, 73})));
    }                                                                //0    1   2   3   4   5   6   7
    public static int[] dailyTemperatures(int[] temperatures) {
/*
        //! normal strategy
        int[] results = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]) {
                results[stack.peek()] = i-stack.pop();
            }
            stack.push(i);
        }
        return results;
*/

        //! nearest greater to right strategy
        int[] results = new int[temperatures.length];
        Stack<TI> stack = new Stack<>();
        stack.push(new TI(temperatures[temperatures.length-1], temperatures.length-1)); //storing TI
        results[temperatures.length-1] = 0;
        for (int i = temperatures.length-2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek().temp<=temperatures[i])
                stack.pop();

            if(stack.isEmpty()) {
                results[i] = 0;
            } else {
                results[i]=stack.peek().index-i;
            }

            stack.push(new TI(temperatures[i], i));
        }
        return results;
    }
}

class TI {
    int temp, index;

    public TI(int temp, int index) {
        this.temp = temp;
        this.index = index;
    }
}