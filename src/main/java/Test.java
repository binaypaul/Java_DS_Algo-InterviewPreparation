import DataStructure.Neetcode150.M_Intervals.*;
import java.util.*;
import lombok.*;

public class Test {
    public static void main(String[] args) {
        System.out.println(new Test().jump(new int[]{2,2,1,0,4}));
    }

    public int jump(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, Integer.MAX_VALUE);
        dp(nums, 0, memo);
        System.out.println(Arrays.toString(memo));
        return memo[0]==Integer.MAX_VALUE ? -1 : memo[0];
    }

//    int min = Integer.MAX_VALUE;
    private int dp(int[] nums, int curIdx, int[] memo) {
        if(nums[curIdx]==0) return Integer.MAX_VALUE;
        if(curIdx >= nums.length-1) {
            if(curIdx==nums.length-1) {
                return 0;
            }
            return Integer.MAX_VALUE;
        }
        if(memo[curIdx]!=Integer.MAX_VALUE) return memo[curIdx];

        int len = Integer.MAX_VALUE;
        for (int i = nums[curIdx]; i > 0 ; i--) {
            int cur = dp(nums, curIdx+i, memo);
            if(cur!=Integer.MAX_VALUE) {
                len = Math.min(cur+1, len);
            }
        }
        return memo[curIdx]= Math.min(memo[curIdx], len);
    }
}