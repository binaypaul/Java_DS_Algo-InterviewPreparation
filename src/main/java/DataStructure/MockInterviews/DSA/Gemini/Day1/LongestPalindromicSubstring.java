package DataStructure.MockInterviews.DSA.Gemini.Day1;

/**
 * Given a string s, return the longest palindromic substring in s.
 * Example 1:
 * Input: s = "babad"
 * Output: "bab" (Note: "aba" is also a valid answer)
 */

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindromeR("bpabad"));
    }
    public String longestPalindromeR(String s) {
        if (s==null)
            return null;
        if(s.length() < 2)
            return s;
        var dp = new int[s.length()][s.length()];

        var maxlen = 1;
        var maxI = 0;
        var maxJ = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if(isPalindrome(s, i, j, dp) && j-i+1>maxlen) {
                    maxlen = j-i+1;
                    maxI = i;
                    maxJ = j;
                }
            }
        }
        return s.substring(maxI, maxJ+1);
    }

    private boolean isPalindrome(String s, int i, int j, int[][] dp) {
        if(i>=j) return true;
        if(dp[i][j] == 1) {
            return true;
        } else if (dp[i][j] == -1) {
            return false;
        }

        if(s.charAt(i) == s.charAt(j)) {
            boolean isPeli = isPalindrome(s, i + 1, j - 1, dp);
            dp[i][j] = isPeli ? 1 : -1;
            return isPeli;
        } else {
            dp[i][j] = -1;
            return false;
        }
    }
}
