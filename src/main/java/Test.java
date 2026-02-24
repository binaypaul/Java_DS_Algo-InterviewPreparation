import java.lang.reflect.*;
import java.util.*;
import java.util.stream.*;

public class Test {

    public static void main(String[] args) {
        System.out.println(new Test().coinChange(new int[]{1,2,5}, 100));
    }

    public int coinChange(int[] coins, int amount) {
        return dpR(coins, amount, 0, new Integer[amount+1]);
    }

    int dpR(int[] coins, int amount, int count, Integer[] memo) {
        if(amount == 0) {
            return 0;
        } else if(amount < 0) {
            return Integer.MAX_VALUE;
        }
        if(memo[amount] != null) return memo[amount];

        int min = Integer.MAX_VALUE;
        for(int coin : coins) {
            if(amount-coin < 0)
                continue;
            int res = dpR(coins, amount-coin, count+1, memo);
            if(res != Integer.MAX_VALUE) {
                min = Math.min(min, res+1);
            }
        }
        return memo[amount] = min;
    }
}