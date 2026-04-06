package DataStructure.Neetcode150.a_a_Practice.Past.Mock15;

import java.util.*;

public class CoinChange {
    public static void main(String[] args) {
        System.out.println(new CoinChange()
                .coinChange(new int[]{1,2,5}, 11));
    }

    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount+1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        int min = dp(coins, amount, memo);
        System.out.println(Arrays.toString(memo));
        return min==Integer.MAX_VALUE ? -1 : min;
    }
    private int dp(int[] coins, int amount, int[] memo) {
        if(amount == 0)
            return 0;
        if(amount < 0)
            return Integer.MAX_VALUE;
        if(memo[amount] != Integer.MAX_VALUE)
            return memo[amount];

        int curMin = Integer.MAX_VALUE;
        for (int i=0; i < coins.length; i++) {
            int ncoins = dp(coins, amount-coins[i], memo);
            if(ncoins != Integer.MAX_VALUE) {
                curMin = Math.min(ncoins+1, curMin);
            }
        }
        return memo[amount]=curMin;
    }
    /*
        Example 1:
        Input: coins = {1,2,5}, amount = 11
        Output: 3
        Explanation: 11 = 5 + 5 + 1
     */
}
