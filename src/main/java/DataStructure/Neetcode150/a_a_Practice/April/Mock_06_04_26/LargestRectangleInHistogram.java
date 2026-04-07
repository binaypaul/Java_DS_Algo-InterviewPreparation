package DataStructure.Neetcode150.a_a_Practice.April.Mock_06_04_26;

import java.util.*;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(
                new int[]{2,1,3,4,3,2,3,1,1,1}
        ));
    }
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        var stack = new Stack<Integer>(); // maxStack, containing index of smaller element to the left

        int[] nsl = new int[len];

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                nsl[i]=-1;
            } else {
                nsl[i]=stack.peek();
            }
            stack.add(i);
        }
        System.out.println(Arrays.toString(nsl));
        stack.clear();

        //{2,1,3,4,3,2,3,1,1,1}
        int[] nsr = new int[len];
        for (int i = len-1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                nsr[i] = len;
            } else {
                nsr[i] = stack.peek();
            }
            stack.add(i);
        }
        System.out.println(Arrays.toString(nsr));
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            maxArea = Math.max(maxArea, (heights[i] * (nsr[i]-nsl[i]-1)));
        }
        return maxArea;
    }
}