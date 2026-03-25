package DataStructure.Neetcode150.a_a_Practice.Mock14;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        System.out.println(new WordLadder().ladderLength("hit", "cog",
                List.of("hot","him","dog","lot","log","cog")));
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int minTrans = 0;
        var visited = new HashSet<String>();
        boolean found = false;

        if(wordList.contains(endWord)) {
            Queue<String> q = new LinkedList<>();
            q.offer(beginWord);
            visited.add(beginWord);

            outer:
            while (!q.isEmpty()) {
                minTrans++;

                int size = q.size();
                for (int i = 0; i < size; i++) {
                    var polledStr = q.poll();
                    System.out.println(polledStr);
                    if(polledStr.equals(endWord)) {
                        found = true;
                        break outer;
                    }

                    //pattern matching
                    int polStrLen = polledStr.length();
                    StringBuilder builder = new StringBuilder();
                    for (int j = 0; j < polStrLen; j++) {
                        builder.append("^")
                                .append(polledStr.substring(0,j))
                                .append(".")
                                .append(polledStr.substring(j+1))
                                .append((j==polStrLen-1)?"$":"$|");
                    }
                    System.out.println(builder);
                    //

                    wordList.stream()
                            .filter(w-> !visited.contains(w) && w.matches(builder.toString()))
                            .forEach((w)-> {
                                q.offer(w);
                                visited.add(w);
                            });
                }
            }
        }
        return found ? minTrans:0;
    }
}
