package DataStructure.Neetcode150.C_Stack.d_MonotonicStack_NearestGSToTheRL;

import java.util.Stack;

/*
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

Example 2:
Input: heights = [2,4]
Output: 4
 */

public class f_LargestRectangleInHistogram {
    public static void main(String[] args) {
        System.out.println(new f_LargestRectangleInHistogram()
                .largestRectangleArea(new int[] {2,1,5,6,2,3}));
    }
    public int largestRectangleArea(int[] heights) {
        int hl = heights.length;
        int[] nsl = new int[hl];
        int[] nsr = new int[hl];
        var s = new Stack<HI>();

        //fill nsl array
        nsl[0] = -1;
        s.push(new HI(heights[0], 0));
        for (int i = 1; i < hl; i++) {
            while (!s.isEmpty() && s.peek().h>=heights[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek().i;
            }

            s.push(new HI(heights[i], i));
        }

        //clear the stack
        s.clear();

        //fill nsr array
        nsr[hl-1] = hl;
        s.push(new HI(heights[hl-1], hl-1));
        for (int i = hl-2; i >=0 ; i--) {
            while (!s.isEmpty() && s.peek().h>=heights[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsr[i] = hl;
            } else {
                nsr[i] = s.peek().i;
            }
            s.push(new HI(heights[i], i));
        }

        //find max area
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < hl; i++) {
                maxArea = Math.max(maxArea, heights[i]*(nsr[i]-nsl[i]-1));
        }
        return maxArea;
    }
}

class HI {
    int h,i;

    public HI(int h, int i) {
        this.h = h;
        this.i = i;
    }

    @Override
    public String toString() {
        return "HI{" +
                "h=" + h +
                ", i=" + i +
                '}';
    }
}
