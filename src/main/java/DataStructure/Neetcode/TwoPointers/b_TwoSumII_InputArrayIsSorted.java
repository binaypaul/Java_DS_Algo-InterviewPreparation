package DataStructure.Neetcode.TwoPointers;

import java.util.Arrays;

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
