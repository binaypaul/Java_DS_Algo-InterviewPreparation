package DataStructure.Neetcode150.L_1D_DP;

import java.util.Arrays;

public class h_CoinChange {
    // ! simple recursion
    int minCount = Integer.MAX_VALUE;

    public int coinChangeR(int[] coins, int amount) {
        dpR(coins, amount, 0);
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

    void dpR(int[] coins, int amount, int count) {
        if (amount == 0) {
            minCount = Math.min(count, minCount);
            return;
        }

        for (int coin : coins) {
            if (amount - coin < 0)
                continue;
            dpR(coins, amount - coin, count + 1);
        }
    }
    // !

    // ! TDM
    public int coinChangeTDM(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        // Time limit exceeds error because of below line.
        // Still kept this line just to maintain consistency of initialization of memo
        // array.
        // Instead we can create "Integer" memo array and do the base checks as follows:
        // if (memo[amount] != null)
        // return memo[amount];
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
    // !

    // ! BUT
    public int coinChangeBUT(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // Initialize with a value larger than the possible maximum
        dp[0] = 0; // Base case: 0 coins needed for amount 0

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
    // !

    public static void main(String[] args) {
        System.out.println(new h_CoinChange().coinChangeTDM(
                new int[] { 1, 2, 5 },
                12));
    }
}
