package DataStructure.Practice.Sept2026._29;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int rc = board.length, cc = board[0].length;
        var visited = new boolean[rc][cc];
        for (int r = 0; r < rc; r++) {
            for (int c = 0; c < cc; c++) {
                if(board[r][c]==word.charAt(0)) {
                    if(dfs(board, word, r, c, 0, visited)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int cur, boolean[][] visited) {
        int rc = board.length, cc = board[0].length;

        if(Math.min(r,c)<0 ||
        r==rc || c==cc ||
        board[r][c]!=word.charAt(cur) ||
        visited[r][c]) {
            return false;
        }

        if(cur==word.length()-1)
            return true;

        visited[r][c] = true;
        var ret = dfs(board, word, r, c+1, cur+1, visited) ||
                    dfs(board, word, r+1, c, cur+1, visited) ||
                    dfs(board, word, r-1, c, cur+1, visited) ||
                    dfs(board, word, r, c-1, cur+1, visited);
        visited[r][c] = false;
        return ret;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        var ret = wordSearch.exist(board, word);
        System.out.println(ret);
    }
}
