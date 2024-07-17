package DataStructure.Neetcode.A_ArraysAndHashing;

import java.util.*;

public class d_Group_Anagrams {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(strs.length);
        for (String str : strs) {
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            String sortedStr = Arrays.toString(strChars);
            if(map.get(sortedStr) == null) {
                map.put(sortedStr, new ArrayList<String>(){{add(str);}});
            } else {
                map.get(sortedStr).add(str);
            }
        }

       return new ArrayList<List<String>>(map.values());
    }
}