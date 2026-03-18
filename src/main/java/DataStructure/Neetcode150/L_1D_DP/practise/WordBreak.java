package DataStructure.Neetcode150.L_1D_DP.practise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {
    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
    }

    Map<String, Boolean> memo = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty())
            return true;

        var fromMemo = memo.get(s);
        if (fromMemo != null)
            return fromMemo;

        for (String word : wordDict) {
            if (s.length() >= word.length() && s.substring(0, word.length()).equals(word)) {
                var res = wordBreak(s.substring(word.length()), wordDict);
                if (res) {
                    memo.put(s, true);
                    return true;
                }
            }
        }
        memo.put(s, false);
        return false;
    }
}