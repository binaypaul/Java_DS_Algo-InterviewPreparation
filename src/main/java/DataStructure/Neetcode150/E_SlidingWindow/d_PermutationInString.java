package DataStructure.Neetcode150.E_SlidingWindow;

import java.util.Arrays;
/*
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.

Example 1:
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 */
public class d_PermutationInString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("adc", "dcda"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        String[] s1ArrSorted = s1.split("");
        Arrays.sort(s1ArrSorted);

        int s1Len = s1.length();
        int s2Len = s2.length();
        int i = 0;

        while (i <= (s2Len - s1Len)) {
            String sub = s2.substring(i, i + s1Len);
            String[] subArrSorted = sub.split("");
            Arrays.sort(subArrSorted);
            if(Arrays.equals(s1ArrSorted, subArrSorted)) {
                return true;
            }
            i++;
        }
        return false;
    }
}
