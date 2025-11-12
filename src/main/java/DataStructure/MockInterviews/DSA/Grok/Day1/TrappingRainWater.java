package DataStructure.MockInterviews.DSA.Grok.Day1;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

/**
 * Given an array of n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining. For example:
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The elevation map can trap 6 units of water.
 * Constraints: n == height.length, 1 <= n <= 2 * 10^4, 0 <= height[i] <= 10^5.
 * Solve this in O(n) time and O(1) space if possible.
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] heights = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println((new TrappingRainWater().trapWater(heights)));
    }
    public int trapWater(int[] heights) {
        var lToR = prefixMax(heights);
        System.out.println(Arrays.toString(lToR));

        var amount = 0;
        var max = heights[heights.length - 1];
        for (int i = heights.length - 1; i >= 0; i--) {
            var rtol = Math.max(max, heights[i]);
            max = Math.max(max, heights[i]);
            amount+= Math.min(rtol, lToR[i]) - heights[i];
        }
        return amount;
    }

    private int[] prefixMax(int[] heights) {
        var max = heights[0];
        var res = new int[heights.length];
        res[0] = heights[0];
        for (int i = 1; i < heights.length; i++) {
            res[i] = Math.max(max, heights[i]);
            max = Math.max(max, heights[i]);
        }
        return res;
    }
}
