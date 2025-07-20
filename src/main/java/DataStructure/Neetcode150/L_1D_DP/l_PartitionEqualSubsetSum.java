package DataStructure.Neetcode150.L_1D_DP;
//https://leetcode.com/problems/partition-equal-subset-sum/description/

import java.util.Arrays;

/**
 * Example 1:
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 * Example 2:
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class l_PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        //If length is less than, the array cannot be separated in two halves.
        if(nums.length < 2) return false;

        //If the sum is not even number, the elements cannot be divided into to subsets which sum is equal.
        int sum = Arrays.stream(nums).sum();
        if(sum%2!=0) return false;

        int target = sum/2;
        System.out.println(target);
        Boolean[][] memo = new Boolean[nums.length][target+1];
        return dp(nums, target, -1, 0, memo);
    }

    private boolean dp(int[] nums, int target, int i, int sum, Boolean[][] memo) {
        if(sum>=target)
            return sum == target;
        if (i >= nums.length-1)
            return false;

        if(memo[i+1][sum] != null) return memo[i+1][sum];

        memo[i+1][sum] = dp(nums, target, i+1, sum+nums[i+1], memo)
                || dp(nums, target, i+1, sum, memo);

        return memo[i+1][sum];
    }

    public static void main(String[] args) {
        System.out.println(new l_PartitionEqualSubsetSum().canPartition(new int[] {3,3,6,8,16,16,16,18,20}));
    }
}
