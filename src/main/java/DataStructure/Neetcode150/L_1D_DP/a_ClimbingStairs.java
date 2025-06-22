package DataStructure.Neetcode150.L_1D_DP;

import java.util.HashMap;

//https://leetcode.com/problems/climbing-stairs/description/
public class a_ClimbingStairs {
    //! simple recursion
    public int climbStairsR(int n) {
        return dpR(n);
    }

    private int dpR(int n) {
        if(n < 3) return n;

        return dpR(n-1) + dpR(n-2);
    }
    //!

    //! Top-down Memoization (TDM) DP
    public int climbStairsTDM(int n) {
        return dpTDM(n, new HashMap<Integer, Integer>());
    }

    private int dpTDM(int n, HashMap<Integer, Integer> cache) {
        if(n<3) return n;
        cache.putIfAbsent(n, dpTDM(n-1, cache) + dpTDM(n-2, cache));
        return cache.get(n);
    }
    //!

    //! Bottom Up Tabulation (BUT) DP
    public int climbStairsBUT(int n) {
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }
    //!

    public static void main(String[] args) {
        System.out.println(new a_ClimbingStairs().climbStairsBUT(40));
    }
}