package DataStructure.Neetcode150.A_ArraysAndHashing;

import java.util.Arrays;

public class c_TwoSums {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,11,7,15}, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
