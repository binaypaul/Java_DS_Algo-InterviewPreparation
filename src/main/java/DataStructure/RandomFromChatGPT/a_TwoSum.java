package DataStructure.RandomFromChatGPT;

import java.util.Arrays;

/**
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number. Return the indices of the two numbers.
 *
 * You must use only constant extra space.
 * Input: numbers = [2, 7, 11, 15], target = 9
 * Output: [1, 2]
 */
public class a_TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new a_TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0, right = numbers.length;
        while (left<right) {
            if(numbers[left] + numbers[right] == target) {
                res = new int[] {left+1, right+1};
                break;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
}
