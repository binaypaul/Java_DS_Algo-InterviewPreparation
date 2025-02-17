package DataStructure.Neetcode.B_TwoPointers;

import java.util.Arrays;

/**
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 * Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.<p></p>
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 *
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * Your solution must use only constant extra space.
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 *
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 */
public class b_TwoSumII_InputArrayIsSorted {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{-7, -6, -4, -2, 1, 7, 11, 14}, 9)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length-1;
        while (l<r) {
            if(numbers[l] + numbers[r] < target) {
                l++;
            } else if (numbers[l] + numbers[r] > target) {
                r--;
            } else {
                return new int[]{l+1, r+1};
            }
        }
        return null;
    }
}
