package DataStructure.Neetcode150.L_1D_DP;
//https://leetcode.com/problems/house-robber/

import java.util.*;

public class c_HouseRobber {
    //! Top down recursion
    public int robR(int[] nums) {
        return dpR(nums, nums.length);
    }

    private int dpR(int[] nums, int i) {
        if(i<=0) return 0;
        if(i==1) return nums[i-1];
        return Math.max(
                nums[i-1]+dpR(nums, i-2),
                nums[i-2]+dpR(nums, i-3)
        );
    }
    //!

    //! Top down Memoization (TDM)
    public int robM(int[] nums) {
        var memo = new int[nums.length+1];
        Arrays.fill(memo, -1);
        return dpM(nums, nums.length, memo);
    }

    /**
     * Input: nums = [1,2,3,1,6]i
     * Output: 10
     */

    private int dpM(int[] nums, int i, int[] memo) {
        if(i<=0) return 0;
        if(i==1) return nums[i-1];
        if(memo[i] != -1) return memo[i];
        memo[i] = Math.max(
                nums[i-1]+dpM(nums, i-2, memo),
                nums[i-2]+dpM(nums, i-3, memo)
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
                .robM(new int[]{1,2,3,1,6})); //10
    }
}
