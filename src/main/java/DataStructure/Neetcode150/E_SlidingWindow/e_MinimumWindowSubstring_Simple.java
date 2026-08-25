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
                .minWindow("ADOBECODEBANC", "ABC")); //BANC
    }
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> needMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        for (char c : t.toCharArray())
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);

        int haveCount = 0, needCount = needMap.size();
        int l = 0, minl = 0, minr = 0, minLen = Integer.MAX_VALUE;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            // Check if current char satisfies the needMap
            if (needMap.containsKey(c) && windowMap.get(c).equals(needMap.get(c)))
                haveCount++;

            // Try to shrink windowMap from left
            while (haveCount == needCount) {
                int len = r - l + 1;
                if (len < minLen) {
                    minLen = len;
                    minl = l;
                    minr = r;
                }
                char lc = s.charAt(l);
                windowMap.put(lc, windowMap.get(lc) - 1);
                if (needMap.containsKey(lc) && windowMap.get(lc) < needMap.get(lc))
                    haveCount--;
                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minl, minr + 1);
    }
}