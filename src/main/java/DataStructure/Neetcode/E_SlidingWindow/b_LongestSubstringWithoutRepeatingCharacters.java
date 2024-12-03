package DataStructure.Neetcode.E_SlidingWindow;
//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
import java.util.HashMap;
import java.util.Map;

public class b_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }                                                // 0123456

    public static int lengthOfLongestSubstring(String s) {
        char[] sar = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        String maxSub = "", curSub = "";

        while (right < s.length()) {
            Integer indxchar = map.get(sar[right]);
            if (indxchar != null) {
                left = indxchar < left ? left : indxchar + 1;
            }
            curSub = s.substring(left, right+1);
            if(curSub.length() > maxSub.length()) {
                maxSub = curSub;
            }
            map.put(sar[right], right);
            right++;
        }

        return  maxSub.length();
    }
}
