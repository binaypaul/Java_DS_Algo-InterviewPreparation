package DataStructure.Neetcode150.a_a_Practice.Past.Mock11;

import java.util.*;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abba"));
    }
    //pwwkew
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int l = 0, r = 0;
        var map = new HashMap<Character, Integer>();
        while (r < s.length()) {
            if(map.containsKey(s.charAt(r))) {
                maxLen = Math.max(maxLen, r-l);
                if(map.get(s.charAt(r)) >= l) {
                    l = map.get(s.charAt(r)) + 1;
                }
            }
            map.put(s.charAt(r), r);
            r++;
        }
        maxLen = Math.max(maxLen, r-l);
        return maxLen;
    }
}
