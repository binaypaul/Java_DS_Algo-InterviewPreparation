package DataStructure.Neetcode150.a_a_Practice.May.Mock_12_05;

import java.util.HashSet;

public class WordSearch {
    public static void main() {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        String word = "ABCB";
        System.out.println(new WordSearch().exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        if(word.isEmpty()) return false;

        var visited = new HashSet<String>();
        char[] wordsChArr = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==wordsChArr[0] && !visited.contains(i+","+j)) {
                    if(dfs(board, wordsChArr, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(
            char[][] board,
            char[] words,
            int r,
            int c,
            int cur,
            HashSet<String> visited
    ) {
        if(Math.min(r,c) < 0 ||
                r > board.length-1 ||
                c > board[0].length-1 ||
                visited.contains(r+","+c) ||
                board[r][c]!=words[cur]) {
            return false;
        }
        if(cur== words.length-1)
            return true;
        visited.add(r+","+c);
        if(dfs(board, words, r, c+1, cur+1, visited)) return true;
        if(dfs(board, words, r+1, c, cur+1, visited)) return true;
        if(dfs(board, words, r-1, c, cur+1, visited)) return true;
        if(dfs(board, words, r, c-1, cur+1, visited)) return true;
        visited.remove(r+","+c);
        return false;
    }
}
