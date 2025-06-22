package DataStructure.Neetcode150.C_Stack;

import java.util.Arrays;
import java.util.Stack;
//https://leetcode.com/problems/next-greater-element-ii/description/
/**
 * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
 *
 * The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number. <p/>
 * Examples:
 * Input: nums = [1,2,1]
 * Output: [2,-1,2]
 *
 * Input: nums = [1,2,3,4,3]
 * Output: [2,3,4,-1,4]
 */
public class z1_NextGreaterElementII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new z1_NextGreaterElementII()
                .nextGreaterElements(new int[] {5,4,3,2,1})));
    }

    private int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];

        int[] doubleNums = new int[nums.length*2-1];
        System.arraycopy(nums, 0, doubleNums, 0, nums.length);
        System.arraycopy(nums, 0, doubleNums, nums.length, nums.length-1);

        for (int i = doubleNums.length-1; i >= 0 ; i--) {
            if(stack.isEmpty()) {
                if(i<nums.length)
                    res[i] = -1;
                stack.push(doubleNums[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() <= doubleNums[i]) {
                    stack.pop();
                }
                if(i<nums.length)
                    res[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(doubleNums[i]);
            }
        }
        return res;
    }
}