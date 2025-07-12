package DataStructure.Neetcode150.L_1D_DP;

import java.util.*;

public class j_WordBreak {
    //! performance of this solution is also quite good!
    public boolean wordBreak_NormalSolution(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        var segEndIdxs = new LinkedList<Integer>();
        segEndIdxs.add(0);
        boolean[] dp = new boolean[s.length()];
        boolean flag = false;
        for (int i = 1; i <= s.length(); i++) {
            flag = false;
            for(int endIdx : segEndIdxs) {
                String sub = s.substring(endIdx, i);
                if(wordSet.contains(sub)) {
                    segEndIdxs.addFirst(i);
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    //! top down recursion with memoization (quite difficult to come up in an interview).
    public boolean wordBreak_booleanArrayMemo(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length()];
        return dpHelper(s, 0, wordSet, dp);
    }

    private boolean dpHelper(String s, int start, Set<String> wordSet, Boolean[] dp) {
        if (start == s.length()) {
            return true;
        }

        if (dp[start] != null) {
            return dp[start];
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (wordSet.contains(word) && dpHelper(s, end, wordSet, dp)) {
                return dp[start] = true;
            }
        }

        return dp[start] = false;
    }
    //!

    public static void main(String[] args) {
        System.out.println(new j_WordBreak().wordBreak_booleanArrayMemo(
            "catsandog", Arrays.asList(
            // [012345678]9
            "cats","dog","sand","and","cat")));
    }
}
