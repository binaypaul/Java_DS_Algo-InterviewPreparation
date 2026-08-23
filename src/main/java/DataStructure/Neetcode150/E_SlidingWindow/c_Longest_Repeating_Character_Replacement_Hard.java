package DataStructure.Neetcode150.E_SlidingWindow;

/**
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
 *
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 *
 * Example 1:
 * Input: s = "ABAB", k = 2  => Output: 4
 * Example 2:
 * Input: s = "AABABBA", k = 1 => Output: 4
 *
 * This implementation recomputes the current window's maximum character frequency for clarity.
 * Complexity: O(26 * n) time, O(26) space (counts for 'A'..'Z').
 */
//https://leetcode.com/problems/longest-repeating-character-replacement/description/
public class c_Longest_Repeating_Character_Replacement_Hard {
    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 1));
    }
                                                                                    //   0123456
    public static int characterReplacement(String s, int k) {
        var counts = new int[26];
        int l=0, maxLen=0, maxCount=0, sl=s.length();
        for (int r = 0; r < sl; r++) {
            counts[s.charAt(r)-'A']++;
            for (int count : counts) {
                maxCount = Math.max(maxCount, count);
            }
            while ((r-l+1)-maxCount > k) {
                counts[s.charAt(l)-'A']--;
                l++;
                for (int count : counts) {
                    maxCount = Math.max(maxCount, count);
                }
            }
            maxLen=Math.max(maxLen, (r-l+1));
        }
        return maxLen;
    }
}