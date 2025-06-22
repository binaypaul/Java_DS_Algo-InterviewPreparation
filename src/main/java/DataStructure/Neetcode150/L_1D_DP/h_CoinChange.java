package DataStructure.Neetcode150.L_1D_DP;

import java.util.Arrays;

public class h_CoinChange {
    //! simple recursion
    int leastCount = Integer.MAX_VALUE;
    public int coinChangeR(int[] coins, int amount) {
        dpR(coins, amount, 0, 0);
        return leastCount==Integer.MAX_VALUE ? -1 : leastCount;
    }

    private void dpR(int[] coins, int amount, int i, int c) {
        if(amount <= 0 || i >= coins.length) {
            if(amount == 0) {
                leastCount = Math.min(leastCount, c);
            }
            return;
        }

        dpR(coins, amount-coins[i], i, c+1);
        dpR(coins, amount, i+1, c);
    }
    //!

    //! TDM
    public int coinChangeTDM(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        return dpTDM(coins, amount, memo);
    }

    private int dpTDM(int[] coins, int amount, int[] memo) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (memo[amount] != 0) return memo[amount];
        //? Explanation of below lines:
        /*Initialization:
            minCount is set to Integer.MAX_VALUE to track the minimum coins needed.
        Loop Through Coins:
            For each coin, recursively compute the result for amount - coin.
            Key Insight: If we use this coin, the remaining amount becomes (amount - coin), and the total coins used would be 1 + (coins needed for remaining amount).
        Update minCount:
            If res (result of subproblem) is valid (>= 0) and better than the current minCount, update minCount to 1 + res. */
        int minCount = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = dpTDM(coins, amount - coin, memo);
            if (res >= 0 && res < minCount) {
                minCount = 1 + res;
            }
        }
        //?

        //? Explanation of below lines:
        /*Memoization:
            If minCount remains Integer.MAX_VALUE, it means no valid combination was found, so store -1 in memo[amount].
            Otherwise, store minCount (the best solution for this amount). */
        memo[amount] = (minCount == Integer.MAX_VALUE) ? -1 : minCount;
        //?
        return memo[amount];
    }
    //!

    //! BUT
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
    //!


    public static void main(String[] args) {
        System.out.println(new h_CoinChange().coinChangeBUT(
                new int[]{1,2,5},
                11
        ));
    }
}
