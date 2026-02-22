package DataStructure.Neetcode150.L_1D_DP;
//https://leetcode.com/problems/house-robber/

import java.util.*;

public class c_HouseRobber {
    //! Top down recursion
    public int robR(int[] nums) {
        return dpR(nums, nums.length);
    }

    private int dpR(int[] nums, int i) { // "i" is index of the house after last house.
        if(i < 1) return 0;

        return Math.max(
            //? The maximum amount of money that can be robbed by robbing the last house (i-1) + amount of money till house previous to the house previous to the last house (i-2).
            nums[i-1] + dpR(nums, i-2),
            //? The maximum amount of money that can be robbed by not robbing the last house (i-1) but amount of money till the house previous to last house (i-1) .
            dpR(nums, i-1)
        );
    }
    //!

    //! Top down Memoization (TDM)
    public int robM(int[] nums) {
        int[] memo = new int[nums.length+1];
        Arrays.fill(memo, -1);
        return dpM(nums, memo, nums.length);
    }

    int dpM(int[] nums, int[] memo, int i) {
        if(i < 1) return 0;
        if(memo[i] != -1) return memo[i];

        memo[i] = Math.max(
                nums[i-1] + dpM(nums, memo, i-2),
                dpM(nums, memo, i-1)
        );
        return memo[i];
    }
    //!

    //! Bottom up tabulation (BUT) using map
    Map<Integer, Integer> mapT = new HashMap<>();
    public int robT(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);


        mapT.put(0,nums[0]);
        mapT.put(1, Math.max(nums[0], nums[1]));

        for (int i = 2; i < n; i++) {
            mapT.put(i, Math.max(nums[i]+ mapT.get(i-2), mapT.get(i-1)));
        }

        return mapT.get(n-1);
    }
    //!

    public static void main(String[] args) {
        System.out.println(new c_HouseRobber()
                .robM(new int[]{114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240})); //21
    }
}
