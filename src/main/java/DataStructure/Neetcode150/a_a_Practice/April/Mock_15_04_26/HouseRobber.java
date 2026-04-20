package DataStructure.Neetcode150.a_a_Practice.April.Mock_15_04_26;

import java.util.*;

public class HouseRobber {
    public int rob(int[] nums) {
        var memo = new HashMap<Integer, Integer>();
        dp(nums, nums.length, memo);
        return memo.get(nums.length);
    }

    private int dp(int[] nums, int i, HashMap<Integer, Integer> memo) {
        if(i<=0) return 0;
        if(memo.get(i)!=null) return memo.get(i);

        memo.put(i, Math.max(
                nums[i-1]+dp(nums, i-2, memo),
                dp(nums, i-1, memo)
        ));
        return memo.get(i);
    }
    //{2,7,9,3,1}5
    // |   |   |
    //12
    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(new int[]{1,2,3,1}));
    }
}
