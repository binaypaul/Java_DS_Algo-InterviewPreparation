package DataStructure.Neetcode.B_TwoPointers;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 *
 * https://leetcode.com/problems/container-with-most-water/description/
 */
public class d_ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,3,2,5,25,24,5}));
    }                                      //0 1 2 3  4  5 6

    public static int maxArea(int[] height) {
        int l =0, r=height.length-1;
        int maxArea = 0;
        while (l<r) {
            int minHeight = Math.min(height[l], height[r]);
            int lengthDiff = r-l;
            int curArea = lengthDiff * minHeight;

            maxArea = Math.max(maxArea, curArea);

            if(height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return maxArea;
    }
}