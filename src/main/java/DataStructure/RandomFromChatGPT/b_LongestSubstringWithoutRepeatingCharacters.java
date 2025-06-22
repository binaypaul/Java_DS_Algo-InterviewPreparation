package DataStructure.RandomFromChatGPT;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Input: s = "abcabcbdefghi"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class b_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(new b_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abba"));
    }
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int left = 0, right = 0;
        char[] sar = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>(s.length());
        while (left <= right && right < sar.length){
            if(map.containsKey(sar[right])) {
                longest = Math.max(longest, (right-left));
                left = Math.max(map.get(sar[right]) + 1, left);
            }
            map.put(sar[right], right);
            right++;
        }
        longest = Math.max(longest, right-left);
        return longest;
    }
}
