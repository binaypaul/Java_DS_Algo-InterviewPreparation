package DataStructure.Neetcode150.L_1D_DP;
//https://leetcode.com/problems/house-robber/

import java.util.HashMap;
import java.util.Map;

public class c_HouseRobber {
    //! Top down recursion
    public int robR2(int[] nums) {
        return dpR(nums, nums.length-1);
    }

    private int dpR(int[] nums, int i) {
        if(i < 0) return 0;
        if(i == 0) return nums[0];
        if(i == 1) return Math.max(nums[0], nums[1]);

        return Math.max(
                //? The maximum amount of money that can be robbed by robbing the current house (i) and considering houses up to the house before the previous one (i-2).
                nums[i]+ dpR(nums, i-2),
                //? The maximum amount of money that can be robbed by not robbing the current house (i) and considering houses up to the previous house (i-1).
                dpR(nums, i-1)
        );
    }
    //!

    //! Top down Memoization (TDM)
    public int robM(int[] nums) {
        int ret = dpM(nums, nums.length-1);
        return ret;
    }
    //2,1,4,1,3
    Map<Integer, Integer> mapM = new HashMap<>();
    private int dpM(int[] nums, int i) {
        if(i < 0) return 0;
        if(i == 0) return nums[0];
        if(i==1) return Math.max(nums[0], nums[1]);

        if(mapM.containsKey(i)) return mapM.get(i);

        int robCurrent = nums[i] + dpM(nums, i-2);
        int skipCurrent = dpM(nums, i-1);
        mapM.put(i,Math.max(robCurrent, skipCurrent));

        return mapM.get(i);
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
