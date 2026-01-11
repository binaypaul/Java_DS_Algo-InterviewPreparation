package DataStructure.Neetcode150.a_a_Practice.Mock8;

import java.util.*;
import java.util.stream.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        //Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
        System.out.println(new GroupAnagrams().groupAnagrams(strs));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> stringIntSetHashMap = new HashMap<>();
        for (String str : strs) {
            var sorted = Arrays.stream(str.split("")).sorted().collect(Collectors.joining());
            var strList = stringIntSetHashMap.getOrDefault(sorted, new ArrayList<String>());
            strList.add(str);
            stringIntSetHashMap.put(sorted, strList);
        }
        return new ArrayList<>(stringIntSetHashMap.values());
    }
}
