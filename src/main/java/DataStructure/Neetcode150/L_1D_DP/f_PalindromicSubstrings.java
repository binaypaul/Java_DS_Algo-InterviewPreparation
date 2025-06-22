package DataStructure.Neetcode150.L_1D_DP;

//https://leetcode.com/problems/palindromic-substrings/description/
public class f_PalindromicSubstrings {
    //! Recursion approach
    int countR = 0;
    public int countSubstringsR(String s) {
        int len = s.length();
        char[] sar = s.toCharArray();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if(isPaliR(sar, i, j) == 1) {
                    countR++;
                }
            }
        }
        return countR;
    }

    private int isPaliR(char[] sar, int l, int r) {
        if(l>=r) {
            return 1;
        }
        if(sar[l] == sar[r]) {
            return isPaliR(sar, l+1, r-1);
        } else {
            return 2;
        }
    }
    //!

    //! Memoization approach
    int countM = 0;
    public int countSubstringsM(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        char[] sar = s.toCharArray();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if(isPaliM(sar, i, j, dp) == 1) {
                    countM++;
                }
            }
        }
        return countM;
    }

    private int isPaliM(char[] sar, int l, int r, int[][] dp) {
        if(l>=r) {
            return 1;
        }
        if(sar[l] == sar[r]) {
            if(dp[l][r] == 0)
                dp[l][r] = isPaliM(sar, l+1, r-1, dp);
            return dp[l][r];
        } else {
            return 2;
        }
    }
    //!

    public static void main(String[] args) {
        System.out.println(new f_PalindromicSubstrings().countSubstringsM("aaa"));
    }
}
//Example 1:
//
//Input: s = "abc"
//Output: 3
//Explanation: Three palindromic strings: "a", "b", "c".

//Example 2:
//
//Input: s = "aaa"
//Output: 6
//Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".