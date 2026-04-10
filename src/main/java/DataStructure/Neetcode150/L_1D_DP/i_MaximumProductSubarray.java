package DataStructure.Neetcode150.L_1D_DP;

//https://leetcode.com/problems/maximum-product-subarray/description/

public class i_MaximumProductSubarray {
    public static void main(String[] args) {
        System.out.println(new i_MaximumProductSubarray().maxProductRightApproachWithoutDP(new int[]{-2,-3,0,-2,-4,-5}));
    }                                                               // max:   [-2, 6,0,-2, 8,20]
                                                                    // min:   [-2,-3,0,-2,-4,-40]
    //!Normal Bruteforce
    public int maxProductBruteForce(int[] nums) {
        int maxProd = nums[0];
        int len = nums.length;
        for(int i = 0; i<len; i++) {
            int cur = nums[i];
            maxProd = Math.max(maxProd, cur);
            for (int j = i+1; j<len; j++) {
                cur *= nums[j];
                maxProd = Math.max(maxProd, cur);
            }
        }
        return maxProd;
    }
    //!
    //! Right approach
    //! new int[]{-2,-3,0,-2,-4,-5}));
    // min:   [-2,-3,0,-2,-4,-40]
    // max:   [-2, 6,0,0, 8,20]
    public int maxProductRightApproachWithoutDP(int[] nums) {
        int min=1 , max =1;
        int res = nums[0];
        for(int i = 0 ; i < nums.length ; i++){
            int curMin = min * nums[i];
            int curMax = max * nums[i];

            min = Math.min(nums[i] , Math.min(curMin , curMax)); // min among nums[i], curMin, curMax
            max = Math.max(nums[i] , Math.max(curMin , curMax)); // max among nums[i], curMin, curMax

            res = Math.max(res , max);
        }

        return res;
    }
    //!

    //!BUT - Right approach is easier and works better
    //? Key insight: At each index, you need both max and min values because:
    //? A negative number × large negative = large positive
    //? A negative number × large positive = large negative

    public int maxProductBut(int[] nums) {
        int n = nums.length;
        int max = nums[0], min = nums[0];
        int[][] dp = new int[n][2];

        dp[0][0] = nums[0];//max
        dp[0][1] = nums[0];//min

        for (int i = 1; i < n; i++) {
            dp[i][0] = nums[i]==0 ? 0 : Math.max(Math.max(nums[i] * dp[i-1][0], nums[i] * dp[i-1][1]), nums[i]);
            max = Math.max(max, dp[i][0]);
            dp[i][1] = nums[i]==0 ? 0 : Math.min(Math.min(nums[i] * dp[i-1][0], nums[i] * dp[i-1][1]), nums[i]);
            min = Math.min(min, dp[i][1]);
        }
        return max;
    }
}
