package DataStructure.Neetcode150.L_1D_DP;

//https://leetcode.com/problems/maximum-product-subarray/description/

public class i_MaximumProductSubarray {
    public static void main(String[] args) {
        System.out.println(new i_MaximumProductSubarray().maxProductRightApproachWithoutDP_simple(new int[]{-2,-3,0,-2,-4,-5}));
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

    //{-2,-3,0,-2,-4,-5}
    // A variety of Kadane's Algo.
    public int maxProductRightApproachWithoutDP_simple(int[] nums) {
        int res = nums[0];
        int maxProd = nums[0];
        int minProd = nums[0];

        // Traverse from second element
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            // Swap if current is negative to make Kadane's Algo work correctly.
            /* because: (-ve * larger number) < (-ve * smaller number)
            eg: curr from array is -ve number: -2
                    prev iteration          current iteration->swap                 current iteration->product
        minProd         2                           3                                       3*-2 = -6
        maxProd         3                           2                                       2*-2 = -4

        minProd        -3                           2                                       2*-2 = -4
        maxProd         2                          -3                                      -3*-2 =  6

        minProd        -3                          -2                                      -2*-2 = 4
        maxProd        -2                          -3                                      -3*-2 = 6
             */
            if (curr < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }
            // Kadane's Algo.
            // Update max and min product
            maxProd = Math.max(curr, maxProd * curr);
            minProd = Math.min(curr, minProd * curr);

            // Update result
            res = Math.max(res, maxProd);
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
