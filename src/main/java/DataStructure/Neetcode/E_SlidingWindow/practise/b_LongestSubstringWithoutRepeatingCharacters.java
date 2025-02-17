package DataStructure.Neetcode.E_SlidingWindow.practise;

import java.util.HashMap;
import java.util.Map;

public class b_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(longestSubstrDistinctChars("geeeeffeksforgeeeeks"));
    }                                                  // 01234567890123456789

    public static int longestSubstrDistinctChars(String s) {
        char[] sCharArr = s.toCharArray();

        int i=0,j=0,longestLen=0;
        String longestSubStr = "";
        Map<Character, Integer> sCharIndexMap = new HashMap<>();

        while (j<sCharArr.length) {
            if(sCharIndexMap.get(sCharArr[j])==null || sCharIndexMap.get(sCharArr[j])<i) {
                sCharIndexMap.put(sCharArr[j], j);
            } else {
                if(j-i > longestLen) {
                    longestLen = j-i;
                    longestSubStr = s.substring(i, j);
                }
                i = sCharIndexMap.get(sCharArr[j]) + 1;

                sCharIndexMap.put(sCharArr[j], j);
            }
            j++;
        }
        if(j-i > longestLen) {
            longestLen = j-i;
            longestSubStr = s.substring(i, j);
        }
        return longestLen;
    }
}
