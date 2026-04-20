package DataStructure.Neetcode150.a_a_Practice.April.Mock_16_04_26;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(GroupAnagrams.groupAnagrams
                (new String[] {"eat","tea","tan","ate","nat","bat"}));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        var map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            var arr = new int[26];
            for (char c : s.toCharArray()) {
                arr[c-'a']++;
            }
            var sArr = Arrays.toString(arr);
            var slist = map.getOrDefault(sArr, new ArrayList<String>());
            slist.add(s);
            map.put(sArr, slist);
        }
        return new ArrayList<>(map.values());
    }
    /*
    Input: strs = ["eat","tea","tan","ate","nat","bat"]
    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     */
}
