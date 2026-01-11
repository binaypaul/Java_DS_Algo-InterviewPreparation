package DataStructure.Neetcode150.a_a_Practice.Mock6_4Q90Min;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(new WordSearch().search(board, "ABCCEDS"));
    }

    private boolean search(char[][] board, String word) {
        int rl = board.length, cl = board[0].length;
        boolean[][] visited = new boolean[rl][cl];
        int wordCharIdx = 0;
        for (int r = 0; r < rl; r++) {
            for (int c = 0; c < cl; c++) {
                if(board[r][c] == word.charAt(wordCharIdx)
                        && dfs(board, word, wordCharIdx,r,c,visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int wordCharIdx, int r, int c, boolean[][] visited) {
        int rl = board.length, cl = board[0].length;

        if(r < 0 || c < 0 ||
        r>=rl || c >= cl ||
        visited[r][c] ||
        board[r][c] != word.charAt(wordCharIdx)) {
            return false;
        }
        visited[r][c] = true;

        if(word.length()-1 == wordCharIdx)
            return true;

        if(dfs(board, word, wordCharIdx+1, r, c+1, visited)) return true;
        if(dfs(board, word, wordCharIdx+1, r+1, c, visited)) return true;
        if(dfs(board, word, wordCharIdx+1, r-1, c, visited)) return true;
        if(dfs(board, word, wordCharIdx+1, r, c-1, visited)) return true;
        visited[r][c] = false;
        return false;
    }
}