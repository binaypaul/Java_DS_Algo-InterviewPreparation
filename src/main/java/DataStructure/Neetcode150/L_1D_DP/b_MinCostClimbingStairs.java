package DataStructure.Neetcode150.L_1D_DP;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 */
public class b_MinCostClimbingStairs {
    //! recursion without DP
    public int minCostClimbingStairsR(int[] cost) {
        return dp(cost, cost.length);
    }
    //1,2,3,_
    private int dp(int[] costs, int n) {
        if(n < 2) return 0;
        return Math.min((costs[n-1] + dp(costs, n-1)) , (costs[n-2] + dp(costs, n-2)));
    }
    //!

    //! Top-down Memoization (TDM) DP
    public int minCostClimbingStairsTDM(int[] cost) {
        int dp = dpMemo(cost, cost.length);
        return dp;
    }

    Map<Integer, Integer> cache = new HashMap<>();
    private int dpMemo(int[] costs, int n) {
        if(n < 2) return 0;
        cache.putIfAbsent(n-1, costs[n-1] + dpMemo(costs, n-1));
        cache.putIfAbsent(n-2, costs[n-2] + dpMemo(costs, n-2));
        return Math.min(cache.get(n-1) , cache.get(n-2));
    }
    //!


    //! Bottom-up / tabulation (BUT) DP
    public int minCostClimbingStairsBUT(int[] cost) {
        int len = cost.length;
        int[] arr = new int[len+1];

        for (int i = 0; i <= len; i++) {
            if(i<2) {
                arr[i] = 0;
            } else {
                arr[i] = Math.min(cost[i-1]+arr[i-1], cost[i-2]+arr[i-2]);
            }
        }
        return arr[len];
    }
    //!

    public static void main(String[] args) {
        System.out.println(new b_MinCostClimbingStairs()
                .minCostClimbingStairsTDM(
                        new int[]{2,3,4,5}
                ));
    }                                              //0 1  2  3 4 5  6  7 8  9  10
}
