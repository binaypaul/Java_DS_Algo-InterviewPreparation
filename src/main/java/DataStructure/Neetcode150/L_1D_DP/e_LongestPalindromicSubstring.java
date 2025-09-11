package DataStructure.Neetcode150.L_1D_DP;

//https://leetcode.com/problems/longest-palindromic-substring/description/
//There is also expand around center approach to solve this which is not dp, but simple and efficient.
//https://www.youtube.com/watch?v=XYQecbcd6_c
public class e_LongestPalindromicSubstring {
    //! Recursion approach
    public String longestPalindromeR(String s) {
        int maxLen = 0;
        int startIndex = 0;
        int len = s.length();
//        "babad"
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if(isPalindrome(s, i, j)==1 && ((j-i+1) > maxLen)) {
                    maxLen = (j-i+1);
                    startIndex = i;
                }
            }
        }
        return s.substring(startIndex, startIndex + maxLen);
    }

    //if s is Palindrome, return 1 else return 2
    private int isPalindrome(String s, int l, int r) {
        if(l>=r)
            return 1;
        if(s.charAt(l) == s.charAt(r)) {
            return isPalindrome(s, l + 1, r - 1);
        } else {
            return 2;
        }
    }
    //!


    //! Memoization approach
    public String longestPalindromeM(String s) {
        int maxLen = 0;
        int startIndex = 0;
        int len = s.length();

        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if(isPalindrome(s, i, j, dp)==1 && ((j-i+1) > maxLen)) {
                    maxLen = (j-i+1);
                    startIndex = i;
                }
            }
        }
        return s.substring(startIndex, startIndex + maxLen);
    }

    //if s is Palindrome, return 1 else return 2
    private int isPalindrome(String s, int l, int r, int[][] dp) {
        if(l>=r)
            return 1;
        if(s.charAt(l) == s.charAt(r)) {
            if(dp[l][r]==0) {
                dp[l][r] = isPalindrome(s, l + 1, r - 1, dp);
            }
            return dp[l][r];
        } else {
            return 2;
        }
    }
    //!

    //There is also expand around center approach to solve this which is not dp, but simple and efficient.
    //https://www.youtube.com/watch?v=XYQecbcd6_c
    public static void main(String[] args) {
        System.out.println(new e_LongestPalindromicSubstring().longestPalindromeR("acivilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }
}
