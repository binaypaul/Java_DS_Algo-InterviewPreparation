package DataStructure.Neetcode150.a_a_Practice.Mock2;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().longestSubstring("abbcabcbb"));//abcabcbb
    }

    private int longestSubstring(String str) {
        var map = new HashMap<Character, Integer>();
        int l = 0, r=0, res=0;
        while (l<=r && r<str.length()) {
            if(map.containsKey(str.charAt(r)) && map.get(str.charAt(r)) >= l) {
                res = Math.max(res, r-l);
                l = map.get(str.charAt(r))+1;
            }
            map.put(str.charAt(r), r);
            r++;
        }
        res = Math.max(res, r-l);
        return res;
    }
}
