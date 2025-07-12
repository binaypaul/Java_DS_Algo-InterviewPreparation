package DataStructure.Neetcode150.L_1D_DP;

//https://leetcode.com/problems/maximum-product-subarray/description/

public class i_MaximumProductSubarray {
    public static void main(String[] args) {
        System.out.println(new i_MaximumProductSubarray().maxProduct(new int[]{-2,-3,0,-2,-4,-5}));
    }                                                               // max:   {-2, 6,0,-2, 8,20
                                                                    // min:   {-2,-3,0,-2,-4,-40

    //!BUT
    public int maxProduct(int[] nums) {
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
