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
        int i = nums.length-1;
        if(i< 0) return 0;
        if(i==0) return nums[i];
        if(i==1) return Math.max(nums[i],nums[i-1]);
        return Math.max(
                dpR(Arrays.copyOfRange(nums, 1, nums.length), nums.length-2),
                dpR(Arrays.copyOfRange(nums, 0, nums.length-1), nums.length-2)
        );
    }
    //{200, 3, 140,20, 10}
    private int dpR(int[] nums, int i) {
        if(i< 0) return 0;
        if(i==0) return nums[i];
        if(i==1) return Math.max(nums[i],nums[i-1]);

        return Math.max(nums[i] + dpR(nums, i-2), dpR(nums, i-1));
    }
    //!

    //! Top down memoization (TDM)
    public int robM(int[] nums) {
        int i = nums.length-1;
        if(i< 0) return 0;
        if(i==0) return nums[i];
        if(i==1) return Math.max(nums[i],nums[i-1]);

        return Math.max(
                dpM(Arrays.copyOfRange(nums, 0, nums.length-1), nums.length-2, new HashMap<>()),
                dpM(Arrays.copyOfRange(nums, 1, nums.length), nums.length-2, new HashMap<>())
        );
    }
    private int dpM(int[] nums, int i, Map<Integer, Integer> mapM) {
        if(i< 0) return 0;
        if(i==0) return nums[i];
        if(i==1) return Math.max(nums[i],nums[i-1]);

        if(mapM.containsKey(i)) return mapM.get(i);

        int robCurHome = nums[i]+dpM(nums, i-2, mapM);
        int skipCurHome = dpM(nums, i-1, mapM);

        mapM.put(i, Math.max(robCurHome, skipCurHome));

        return mapM.get(i);
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
                .robR(new int[]{200, 3, 140,20, 10}));
    }                         //200,200,340,340,350
}
