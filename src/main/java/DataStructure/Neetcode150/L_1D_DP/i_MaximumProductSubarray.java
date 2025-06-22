package DataStructure.Neetcode150.L_1D_DP;

//https://leetcode.com/problems/maximum-product-subarray/description/

public class i_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int maxEndingHere = nums[0];
        int minEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
        }
        return maxProd;
    }

    public static void main(String[] args) {
        System.out.println(new i_MaximumProductSubarray().maxProduct(new int[]{4,-2, 2, 3}));
//
//                                                                        max 4
//                                                                        min 4
    }
}
