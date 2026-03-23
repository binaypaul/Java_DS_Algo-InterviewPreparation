package DataStructure.Neetcode150.E_SlidingWindow;

import java.util.*;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 * Example 1:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 *
 * Example 2:
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 */

public class e_MinimumWindowSubstring_Simple {
    public static void main(String[] args) {
        System.out.println(new e_MinimumWindowSubstring_Simple()
                .minWindow("ZADABOBEAHCODEBANC", "ABCB")); //BOBEAHC
    }
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray())
            need.put(c, need.getOrDefault(c, 0) + 1);

        int haveCount = 0, needCount = need.size();
        int l = 0, minl = 0, minr = 0, minLen = Integer.MAX_VALUE;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            // Check if current char satisfies the need
            if (need.containsKey(c) && window.get(c).equals(need.get(c)))
                haveCount++;

            // Try to shrink window from left
            while (haveCount == needCount) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    minl = l;
                    minr = r;
                }
                char lc = s.charAt(l);
                window.put(lc, window.get(lc) - 1);
                if (need.containsKey(lc) && window.get(lc) < need.get(lc))
                    haveCount--;
                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minl, minr + 1);
    }
}