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

public class e_MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(new e_MinimumWindowSubstring()
                .minWindow("ZADABOBEAHCODEBANC", "ABCA"));
    }
    public String minWindowQueue(String s, String t) {
        Map<Character, Integer> tStrCountMap = new HashMap<>(t.length());
        List<Character> tCharList = new ArrayList<>(t.length());
        for (Character tc : t.toCharArray()) {
            tStrCountMap.compute(tc, (k, v) -> v == null ? 1 : v + 1);
            tCharList.add(tc);
        }
        int minLen = Integer.MAX_VALUE, lminIdx = 0, rminIdx = 0;
        Queue<CharIdx> q = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char sCharAtI = s.charAt(i);
            if(tStrCountMap.containsKey(sCharAtI)) {
                q.offer(new CharIdx(sCharAtI, i));
                tStrCountMap.put(sCharAtI, tStrCountMap.get(sCharAtI)-1);
                tCharList.remove((Character) sCharAtI);

                while(tCharList.isEmpty() && !q.isEmpty()) {
                    CharIdx ci = q.poll();
                    if(minLen > (i-ci.getI()+1)) {
                        minLen = (i-ci.getI()+1);
                        lminIdx = ci.getI();
                        rminIdx = i;
                    }
                    int countOfCIcInTStrCountMap = tStrCountMap.get(ci.getC());
                    tStrCountMap.put(ci.getC(), ++countOfCIcInTStrCountMap);
                    if(countOfCIcInTStrCountMap > 0) {
                        tCharList.add(ci.getC());
                    }
                }
            }
        }
        return minLen == Integer.MAX_VALUE?"":s.substring(lminIdx, rminIdx+1);
    }

    //optimised -- https://youtu.be/WJaij9ffOIY?t=732
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        var tCharCountMap = new HashMap<Character, Integer>();
        for (char ch : t.toCharArray()) {
            tCharCountMap.put(ch, tCharCountMap.getOrDefault(ch, 0) + 1);
        }

        int targetCharsRemaining = t.length();
        int[] minWindow = {0, Integer.MAX_VALUE};
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (tCharCountMap.containsKey(ch) && tCharCountMap.get(ch) > 0) {
                targetCharsRemaining--;
            }
            tCharCountMap.put(ch, tCharCountMap.getOrDefault(ch, 0) - 1);

            if (targetCharsRemaining == 0) {
                while (true) {
                    char charAtStart = s.charAt(l);
                    if (tCharCountMap.containsKey(charAtStart) && tCharCountMap.get(charAtStart) == 0) {
                        break;
                    }
                    tCharCountMap.put(charAtStart, tCharCountMap.getOrDefault(charAtStart, 0) + 1);
                    l++;
                }

                if (r - l < minWindow[1] - minWindow[0]) {
                    minWindow[0] = l;
                    minWindow[1] = r;
                }

                tCharCountMap.put(s.charAt(l), tCharCountMap.getOrDefault(s.charAt(l), 0) + 1);
                targetCharsRemaining++;
                l++;
            }
        }

        return minWindow[1] >= s.length() ? "" : s.substring(minWindow[0], minWindow[1] + 1);
    }
}

class CharIdx {
    char c;
    int i;

    public CharIdx(char c, int i) {
        this.c = c;
        this.i = i;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "CharIdx{" +
                "c=" + c +
                ", i=" + i +
                '}';
    }
}