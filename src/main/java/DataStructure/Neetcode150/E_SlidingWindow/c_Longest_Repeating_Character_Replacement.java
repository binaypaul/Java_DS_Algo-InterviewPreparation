package DataStructure.Neetcode150.E_SlidingWindow;

/**
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
 *
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * Example 2:
 *
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * There may exists other ways to achieve this answer too.
 */
//https://leetcode.com/problems/longest-repeating-character-replacement/description/
public class c_Longest_Repeating_Character_Replacement {
    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 1));
    }

    public static int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxFreq = 0;
        int l=0, maxLen=0;

        for (int r = 0; r < s.length(); r++) {
            char rchar = s.charAt(r);
            int charDif = rchar - 'A';
            count[charDif]++;
            maxFreq = Math.max(maxFreq, count[rchar-'A']);
            while(r - l + 1 - maxFreq > k) {
                count[s.charAt(l)-'A']--;
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}


//Given a string "s" and an integer "k".
//We can replace any character in the string "s" with any english character at most "k" times.
//Return the length of the longest substring containing the repeated consecutive letters after performing the above operations.