package DataStructure.Neetcode150.a_a_Practice.Mock2;

import java.util.*;

public class HouseRobber {
    public static void main(String[] args) {
        System.out.println(new HouseRobber().maxCash(new int[]{1,2,3,4}));
                                                            // 0,1,2,3,4
    }

    private int maxCash(int[] houses) {
        if(houses.length==1) return houses[0];
        if(houses.length==2) return Math.max(houses[0], houses[1]);
        int[] dp = new int[houses.length];
        Arrays.fill(dp,-1);
        dp[0] = houses[0];
        dp[1] = Math.max(houses[0], houses[1]);
        return dp(houses, houses.length-1, dp);

    }

    private int dp(int[] houses, int i, int[] dp) {
        if(i<0) return 0;
        if(i==0) return dp[0];
        if(i==1) return dp[1];
        if(dp[i]!=-1) return dp[i];
        dp[i] = Math.max(houses[i]+dp(houses, i-2, dp), dp(houses, i-1, dp));
        return dp[i];
    }
}
//i=3, max(4+2, 4) 6
     //i=1, 2
     //i=2, 4
        //i=1, max(2+0, 1)
