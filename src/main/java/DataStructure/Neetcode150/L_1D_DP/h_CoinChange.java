package DataStructure.Neetcode150.L_1D_DP;

import java.util.Arrays;

public class h_CoinChange {
    //! simple recursion
    int minCount = Integer.MAX_VALUE;
    public int coinChangeR(int[] coins, int amount) {
        dpR(coins, amount, 0);
        return minCount==Integer.MAX_VALUE ? -1 : minCount;
    }

    void dpR(int[] coins, int amount, int count) {
        if(amount == 0) {
            minCount = Math.min(count, minCount);
            return;
        }

        for(int coin : coins) {
            if(amount-coin < 0)
                continue;
            dpR(coins, amount-coin, count+1);
        }
    }
    //!

    //! TDM
    public int coinChangeTDM(int[] coins, int amount) {
        Integer[] memo = new Integer[amount + 1];
        int result = dpTDM(coins, amount, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dpTDM(int[] coins, int amount, Integer[] memo) {
        // Base cases
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;

        // Check if we've already solved this sub-amount
        if (memo[amount] != null) return memo[amount];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = dpTDM(coins, amount - coin, memo);

            // If the subproblem was solvable, update our local min
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, res + 1);
            }
        }
        // Store the result in the memo table before returning
        return memo[amount] = min;
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
        System.out.println(new h_CoinChange().coinChangeTDM(
                new int[]{1,2,5},
                12
        ));
    }
}
