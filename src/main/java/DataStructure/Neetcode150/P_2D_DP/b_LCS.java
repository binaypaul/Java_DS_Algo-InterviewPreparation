package DataStructure.Neetcode150.P_2D_DP;

import java.util.Arrays;
//didn't understand, only memorize.
public class b_LCS {
    // Memoization table to store results of subproblems
    static int[][] memo;

    public static int lcsTopDown(String s1, String s2, int m, int n) {
        // Base case: if either string is empty
        if (m == 0 || n == 0) return 0;

        // Return stored result if already calculated
        if (memo[m][n] != -1) return memo[m][n];

        // If characters match, add 1 and recurse for remaining strings
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return memo[m][n] = 1 + lcsTopDown(s1, s2, m - 1, n - 1);
        }
        // If they don't match, take the maximum of two recursive calls
        else {
            return memo[m][n] = Math.max(lcsTopDown(s1, s2, m, n - 1),
                    lcsTopDown(s1, s2, m - 1, n));
        }
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        int m = s1.length();
        int n = s2.length();

        // Initialize memo table with -1
        memo = new int[m + 1][n + 1];
        for (int[] row : memo) Arrays.fill(row, -1);

        System.out.println("Length of LCS: " + lcsTopDown(s1, s2, m, n));
    }
}