package DataStructure.Neetcode150.L_1D_DP;

import java.util.*;

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
    //! Revursive
    int maxLen=Integer.MIN_VALUE;
    public int lengthOfLIS_R(int[] nums) {
        dpR(nums, 0, Integer.MIN_VALUE);
        return maxLen==Integer.MIN_VALUE?1:maxLen;
    }
    private int dpR(int[] nums, int start, int prev) {
        if(start==nums.length) return 0;

        int len=Integer.MIN_VALUE;
        for (int i = start; i < nums.length; i++) {
            if(nums[i]>prev) {
                int cur = dp(nums, i+1, nums[i]);
                if(cur!=Integer.MIN_VALUE) {
                    len = Math.max(len, cur + 1);
                }
            }

            maxLen = Math.max(maxLen, len);
        }
        return len;
    }
    //

    //! TDM
    Map<String, Integer> memo = new HashMap<>();
    public int lengthOfLIS(int[] nums) {
        int ret = dp(nums, 0, Integer.MIN_VALUE);
        return ret==Integer.MIN_VALUE?1:ret;
    }
    //{10,9,2,5,3,7,101,18}
    private int dp(int[] nums, int start, int prevVal) {
        if(start == nums.length) return 0;
        if(memo.containsKey(nums[start]+","+prevVal))
            return memo.get(nums[start]+","+prevVal);

        int longest = Integer.MIN_VALUE;
        for (int i = start; i < nums.length; i++) {
            if(prevVal<nums[i]) {
                int cur = dp(nums, i+1, nums[i]);
                if(cur==Integer.MIN_VALUE) {
                    cur=0;
                }
                longest = Math.max(longest, cur + 1);
            }
        }
        memo.put(nums[start]+","+prevVal, longest);
        return memo.get(nums[start]+","+prevVal);
    }

    public static void main(String[] args) {
//        System.out.println(new k_LongestIncreasingSubsequence().lengthOfLIS(new int[]{10,9,2,5,3,4,7,101,18}));
        System.out.println(new k_LongestIncreasingSubsequence().lengthOfLIS(new int[]{1,3,6,7,9,4,10,5}));
    }
    /*
     * Input: nums = [10,9,2,5,3,4,7,101,18]
     * Output: 5
     * [2,3,4,7,101]
     */
}
