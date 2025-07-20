package DataStructure.Neetcode150.N_Greedy;

import java.util.Arrays;
//https://leetcode.com/problems/jump-game/description/
public class b_JumpGame {
    //!TDM DP
    public boolean canJump_TDM_DP(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        Boolean[][] leadsToRes = new Boolean[nums.length][max+1];
        return dp(nums, 0, nums[0], leadsToRes);
    }

    private boolean dp(int[] nums,
                       int i,
                       int dec,
                       Boolean[][] leadsToRes) {
        if(i+dec >= nums.length-1)
            return true;
        if(leadsToRes[i][dec] != null)
            return leadsToRes[i][dec];

        boolean flag = false;
        while(dec >= 1) {
            if(nums[i+dec] != 0)
                flag = dp(nums, i+dec, nums[i+dec], leadsToRes);
            leadsToRes[i][dec] = flag;
            if (flag)
                return flag;
            dec--;
        }
        return flag;
    }

    //!Greedy
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) return false;
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest >= nums.length - 1) return true;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new b_JumpGame().canJump(new int[]{2,3,1,1,4}));
    }
}
