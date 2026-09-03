import DataStructure.Neetcode150.M_Intervals.*;
import java.util.*;
import lombok.*;

public class Test {
    public static void main(String[] args) {
        System.out.println(new Test().coinChange(new int[]{1,2,5}, 11));
    }
    /*
    Input: coins = [1,2,5], amount = 11
    Output: 3
    Explanation: 11 = 5 + 5 + 1
     */
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        int minCoins = dp(coins, amount, memo);
        return minCoins==Integer.MAX_VALUE?-1:minCoins;
    }

    private int dp(int[] coins, int amount, int[] memo) {
        if(amount==0) return 0;
        if(amount<0) return Integer.MAX_VALUE;
        if(memo[amount]!=Integer.MAX_VALUE) return memo[amount];

        int count = Integer.MAX_VALUE;
        for (int coin : coins) {
            int cur = dp(coins, amount - coin, memo);
            if (cur != Integer.MAX_VALUE) {
                count = Math.min(count, cur + 1);
            }
        }
        return memo[amount] = count;
    }
}