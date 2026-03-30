package DataStructure.Neetcode150.a_a_Practice.Mock_30_03_26;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        System.out.println(new WordBreak()
                .wordBreak("catsandog",  List.of("cats","dog","sand","and","cat")));
    }                        //012345678
    public boolean wordBreak(String s, List<String> wordDict) {
        var memo = new HashMap<String, Boolean>();
        Set<String> wordDistSet = new HashSet<>(wordDict);
        boolean ret =  dfs(s, wordDistSet, memo);
        System.out.println(memo);
        return ret;
    }

    private boolean dfs(String s, Set<String> wordDict, HashMap<String, Boolean> memo) {
        if(s.isEmpty())
            return true;

        if(memo.containsKey(s))
            return memo.get(s);

        for (int i = 1; i < s.length()+1; i++) {
            if(wordDict.contains(s.substring(0,i))) {
                if(dfs(s.substring(i), wordDict, memo)) {
                    memo.put(s,true);
                    return true;
                }
            }
        }
        memo.put(s,false);
        return false;
    }
    /*
    **Example 1:**
Input: s = "leetcode", wordDict = {"leet","code"}
Output: true
Explanation: "leetcode" can be segmented as "leet code"

**Example 2:**
Input: s = "applepenapple", wordDict = {"apple","pen"}
Output: true
Explanation: "applepenapple" can be segmented as "apple pen apple"

**Example 3:**
Input: s = "catsandog", wordDict = {"cats","dog","sand","and","cat"}
Output: false
     */
}
