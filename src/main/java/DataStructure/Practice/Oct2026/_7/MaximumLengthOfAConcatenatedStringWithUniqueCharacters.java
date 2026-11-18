package DataStructure.Practice.Oct2026._7;

import java.util.*;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
    public static void main(String[] args) {
        MaximumLengthOfAConcatenatedStringWithUniqueCharacters maximumLengthOfAConcatenatedStringWithUniqueCharacters = new MaximumLengthOfAConcatenatedStringWithUniqueCharacters();
        List<String> arr = Arrays.asList("cha", "r", "act", "ers");
        var ret = maximumLengthOfAConcatenatedStringWithUniqueCharacters.maxLength(arr);
        System.out.println(ret);
    }
    int maxLen;
    Set<Character> set = null;
    public int maxLength(List<String> arr) {
        maxLen = Integer.MIN_VALUE;
        set = new HashSet<>();

        dfs(arr, 0);
        return maxLen;
    }


    private void dfs(List<String> arr, int i) {
        if(i==arr.size()) {
            maxLen = Math.max(maxLen, set.size());
            return;
        }
        if(!setContains(arr.get(i))) {
            addToSet(arr.get(i));
            dfs(arr, i + 1);
            removeFromSet(arr.get(i));
        }
        dfs(arr, i+1);
    }
    private boolean setContains(String s) {
        HashSet<Character> chs = new HashSet<>();

        for (char c : s.toCharArray()) {
            if(set.contains(c) || chs.contains(c)){
                return true;
            }
            chs.add(c);
        }
        return false;
    }

    private void addToSet(String s) {
        for (char c : s.toCharArray()) {
            set.add(c);
        }
    }

    private void removeFromSet(String s) {
        for (char c : s.toCharArray()) {
            set.remove(c);
        }
    }
}
