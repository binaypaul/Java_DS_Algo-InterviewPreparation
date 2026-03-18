package DataStructure.Neetcode150.L_1D_DP.practise;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[] { 2 }, 3));
    }

    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        int ret = dp(coins, amount, memo);
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }

    private int dp(int[] coins, int amount, int[] memo) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return Integer.MAX_VALUE;
        if (memo[amount] != Integer.MAX_VALUE)
            return memo[amount];

        int count = Integer.MAX_VALUE;
        for (int coin : coins) {
            int cur = dp(coins, amount - coin, memo);
            if (cur != Integer.MAX_VALUE) {
                count = Math.min(cur + 1, count);
            }
        }

        return memo[amount] = count;
    }
}