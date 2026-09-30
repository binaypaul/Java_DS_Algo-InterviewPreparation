package DataStructure.Practice.Sept2026._21;

import java.util.*;

public class PrimeJumpMaximumScore {
    private boolean isPrime(int n) {
        if(n<2) return false;
        for (int i = 2; (long)i*i <= n; i++) {
            if(n%i == 0) return false;
        }
        return true;
    }
    List<Integer> primes = new ArrayList<>();
    public int maxScore(int[] nums) {
        //setup -- start
        int nl = nums.length;
        var memo = new int[nl];
        Arrays.fill(memo, Integer.MIN_VALUE);

        primes.add(1);
        for (int n = 3; n <= nl+1; n+=10) {
            if(isPrime(n))
                primes.add(n);
        }
        System.out.println(primes);
        //setup -- end

        return nums[0]+dp(nums, 0, memo);
    }

    private int dp(int[] nums, int i, int[] memo) {
        int nl = nums.length, pl = primes.size();

        if(i>=nl-1) {
            if(i==nl-1) {
                return 0;
            }
            return Integer.MIN_VALUE;
        }

        if(memo[i] != Integer.MIN_VALUE)
            return memo[i];

        int max = Integer.MIN_VALUE;
        for (Integer prime : primes) {
            int cur = dp(nums, i + prime, memo);
            if (cur != Integer.MIN_VALUE) {
                max = Math.max(max, nums[i + prime] + cur);
            }
        }
        return memo[i]=max;
    }

    public static void main(String[] args) {
        PrimeJumpMaximumScore primeJumpMaximumScore = new PrimeJumpMaximumScore();
//        int[] nums = {1, -5, -20, 4};//4
//                    0,  1,   2, 3

//        int[] nums = {1, -5, -20, 4, -1, 3, -6, -3};//8
                  //  0,  1,  2,  3,  4, 5,  6,  7

        int[] nums = {1, -5, -20, 4, -1, 3, -6, -3, 1, -5, -20, 4, -1, 3};//14
                     // 0,  1,  2,  3,  4, 5,  6,  7, 8,  9,  10, 11,12,13

        var ret = primeJumpMaximumScore.maxScore(nums);
        System.out.println(ret);
    }
}
