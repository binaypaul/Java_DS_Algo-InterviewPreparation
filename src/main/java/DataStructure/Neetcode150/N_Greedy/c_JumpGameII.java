package DataStructure.Neetcode150.N_Greedy;

import java.util.*;

public class c_JumpGameII {
    public static void main(String[] args) {
        System.out.println(new c_JumpGameII().minJumpII(new int[]{2,3,1,1,4}));
    }

    private int minJumpII(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, Integer.MAX_VALUE);
        int ret = dp(nums, 0, memo);
        System.out.println(Arrays.toString(memo));
        return ret;
    }

    private int dp(int[] nums, int start, int[] memo) {
        if(start >= nums.length-1) {
            return 0;
        }
        if(nums[start]==0) {
            return Integer.MAX_VALUE;
        }
        if(memo[start] != Integer.MAX_VALUE) {
            return memo[start];
        }

        int min = Integer.MAX_VALUE;
        for (int i = nums[start]; i > 0; i--) {
            int cur = dp(nums, start+i, memo);
            if(cur != Integer.MAX_VALUE) {
                min = Math.min(cur+1, min);
            }
        }
        return memo[start] = Math.min(min, memo[start]);
    }
}