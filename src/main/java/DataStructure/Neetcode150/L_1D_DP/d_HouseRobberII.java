package DataStructure.Neetcode150.L_1D_DP;
//https://leetcode.com/problems/house-robber-ii/description/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Input: nums = [2,3,2]
 * Output: 3
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 *
 * Input: nums = [1,2,3,1,6]
 * Output: 9
 */
public class d_HouseRobberII {
    //! Top down recursion
    public int robR(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(
                robHelperR(Arrays.copyOfRange(nums, 0, nums.length-1)),
                robHelperR(Arrays.copyOfRange(nums, 1, nums.length))
        );
    }
    private int robHelperR(int[] nums) {
        return dpR(nums, nums.length);
    }

    private int dpR(int[] nums, int i) {
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
        if(nums.length == 1) return nums[0];
        return Math.max(
                robHelperM(Arrays.copyOfRange(nums, 0, nums.length-1)),
                robHelperM(Arrays.copyOfRange(nums, 1, nums.length))
        );
    }
    private int robHelperM(int[] nums) {
        int[] memo = new int[nums.length+1];
        Arrays.fill(memo, -1);
        return dpM(nums, memo, nums.length);
    }

    private int dpM(int[] nums, int[] memo, int i) {
        if(i < 1) return 0;
        if(memo[i] != -1) return memo[i];

        memo[i] = Math.max(
                nums[i-1] + dpM(nums, memo, i-2),
                dpM(nums, memo, i-1)
        );
        return memo[i];
    }
    //!

    //! Bottom up tabulation (BUT)
    public int robT(int[] nums) {
        int i = nums.length-1;
        if(i< 0) return 0;
        if(i==0) return nums[i];
        if(i==1) return Math.max(nums[i],nums[i-1]);

        return Math.max(
                dpT(Arrays.copyOfRange(nums, 0, nums.length-1), nums.length-2, new HashMap<>()),
                dpT(Arrays.copyOfRange(nums, 1, nums.length), nums.length-2, new HashMap<>())
        );
    }
    private int dpT(int[] nums, int i, Map<Integer, Integer> mapT) {
        if(i< 0) return 0;
        mapT.put(-1, 0);
        if(i==0) return nums[i];
        mapT.put(0, nums[0]);
        if(i==1) return Math.max(nums[i],nums[i-1]);
        mapT.put(1, Math.max(nums[1],nums[0]));

        for (int j = 2; j < i+1; j++) {
            mapT.put(j, Math.max(mapT.get(j-1), nums[j]+mapT.get(j-2)));
        }
        //2,1,1,2,3,4,1
        return mapT.get(i);
    }
    public static void main(String[] args) {
        System.out.println(new d_HouseRobberII()
                .robM(new int[]{200, 3, 140,20, 10}));
    }                         //200,200,340,340,340
}
