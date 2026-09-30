package DataStructure.Practice.Sept2026._27_2;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();

        for (int i = 0; i<strs.length; i++) {
            if(strs[i]==null) continue;
            List<String> cur = new ArrayList<>();
            cur.add(strs[i]);

            int[] lookup = new int[26];
            for (char c : strs[i].toCharArray()) {
                lookup[c-'a']++;
            }
            for (int j = i+1; j < strs.length; j++) {
                if(strs[j]==null) continue;
                if(strs[i].length()!=strs[j].length()) continue;

                int[] tempLookup = Arrays.copyOf(lookup, 26);
                boolean flag = true;
                for (char c : strs[j].toCharArray()) {
                    tempLookup[c-'a']--;
                    if(tempLookup[c-'a']<0) {
                        flag=false;
                        break;
                    }
                }
                if(flag) {
                    cur.add(strs[j]);
                    strs[j]=null;
                }
            }
            ret.add(cur);
        }
        return ret;
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat", "aab", "a"};
        var ret = groupAnagrams.groupAnagrams(strs);
        System.out.println(ret);
    }
}
