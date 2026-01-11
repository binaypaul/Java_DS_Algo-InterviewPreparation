package DataStructure.Neetcode150.a_a_Practice.Mock6_4Q90Min;

import java.util.*;

public class CoinChange {
    public static void main(String[] args) {
        System.out.println(new CoinChange().noOfCoins(new int[]{1,2,5}, 11));
    }
    public int noOfCoins(int[] coins, int amount) {
        Arrays.sort(coins);
        return dp(coins, amount, 0);
    }

    private int dp(int[] coins, int amount, int n) {
        for (int i = coins.length-1; i >=0 ; i--) {
            if(amount == coins[i]) {
                return n+1;
            } else if(amount > coins[i]) {
                return dp(coins, amount-coins[i], n+1);
            }
        }
        return -1;
    }
}
