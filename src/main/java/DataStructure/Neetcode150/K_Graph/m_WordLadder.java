package DataStructure.Neetcode150.K_Graph;

import java.util.*;
//https://leetcode.com/problems/word-ladder/description/
public class m_WordLadder {
    public static void main(String[] args) {
        String beginWord3 = "red";
        String endWord3 = "tax";
        List<String> wordList3 = Arrays.asList("ted","tex","red","tax","tad","den","rex","pee");
        System.out.println(new m_WordLadder()
                .ladderLength_simple(beginWord3, endWord3, wordList3));
    }
    public int ladderLength_simple(String beginWord, String endWord, List<String> wordList) {
        var wordSet = new HashSet<String>(wordList);
        if(!wordSet.contains(endWord)) return 0;

        Set<String> visited = new HashSet<>();
        int count = 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        visited.add(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();
            count++;
            while (size>0) {
                String polledStr = q.poll();
                if(null!=polledStr && polledStr.equals(endWord)) return count;
                /*
                Why is this better than regex?
                            Regex Approach          Character Substitution
                Time        O(n² × L)               O(n × L × 26) = O(n × L)
                Clarity     Complex                 Simple
                 */
                for (int i = 0; i < polledStr.length(); i++) {
                    char[] chars = polledStr.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String newWord = new String(chars);
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            q.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
                size--;
            }
        }
        return count;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        var wordSet = new HashSet<String>(wordList);
        if(!wordSet.contains(endWord)) return 0;

        // Build pattern map
        Map<String, List<String>> patternMap = new HashMap<>();
        for (String word : wordSet) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = "^"+word.substring(0,i)+"."+word.substring(i+1)+"$";
                patternMap.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        Set<String> visited = new HashSet<>();
        int count = 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        visited.add(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();
            count++;
            while (size>0) {
                String cur = q.poll();
                if(null!=cur && cur.equals(endWord)) return count;

                for (int i = 0; i < cur.length(); i++) {
                    String curPattern = "^"+cur.substring(0,i)+"."+cur.substring(i+1)+"$";
                    for(String word : patternMap.getOrDefault(curPattern, new ArrayList<>())) {
                        if(!visited.contains(word)) {
                            visited.add(word);
                            q.add(word);
                        }
                    }
                }
                size--;
            }
        }
        return count;
    }
}
