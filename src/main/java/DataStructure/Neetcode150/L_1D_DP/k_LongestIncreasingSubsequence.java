package DataStructure.Neetcode150.L_1D_DP;

import java.util.HashMap;
import java.util.Map;

public class k_LongestIncreasingSubsequence {
    /**
     * Example 1:
     * Input: nums = [10,9,2,5,3,7,101,18]
     * Output: 4
     * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
     * <p/>
     *
     * Example 2:
     * Input: nums = [0,1,0,3,2,3]
     * Output: 4
     *
     * <p/>
     * Example 3:
     * Input: nums = [7,7,7,7,7,7,7]
     * Output: 1
     * <p/>
     * @param nums
     * @return
     */
    //! TDM
    Map<String, Integer> memo = new HashMap<>();
    public int lengthOfLIS(int[] nums) {
        memo.clear();
        return dp(nums, 0, Integer.MIN_VALUE);
    }

    private int dp(int[] nums, int start, int prevVal) {
        if (start == nums.length) return 0;
        if (memo.containsKey(start + "," + prevVal)) return memo.get(start + "," + prevVal);

        int maxCount = 0;
        for (int i = start; i < nums.length; i++) {
            if(nums[i] > prevVal) {
                // Include nums[i] in LIS
                int count = 1 + dp(nums, i + 1, nums[i]);
                maxCount = Math.max(maxCount, count);
            }
        }

        memo.put(start + "," + prevVal, maxCount);
        return maxCount;
    }
    //!


    public static void main(String[] args) {
        System.out.println(new k_LongestIncreasingSubsequence().lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }
}
