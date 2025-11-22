package DataStructure.Neetcode150.K_Graph;

import java.util.Arrays;
import java.util.HashSet;
import lombok.AllArgsConstructor;
import lombok.Data;

public class g_SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        new g_SurroundedRegions().solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    public void solve(char[][] board) {
        var invalidCells = new HashSet<Cell>();
        int rl = board.length, cl = board[0].length;
        for (int r = 0; r < rl; r++) {
            for (int c = 0; c < cl; c++) {
                Cell cur = new Cell(r,c);
                if((r==0 || r== rl-1 || c == 0 || c == cl-1) && (board[cur.r][cur.c] == 'O')) {
                    dfs(cur, board, invalidCells);
                }
            }
        }
        System.out.println(invalidCells);

        for (int r = 0; r < rl; r++) {
            for (int c = 0; c < cl; c++) {
                Cell cur = new Cell(r,c);
                if((board[cur.r][cur.c] == 'O') && (!invalidCells.contains(cur)))
                    board[cur.r][cur.c] = 'X';
            }
        }
    }

    private void dfs(Cell cur, char[][] board, HashSet<Cell> invalidCells) {
        int rl = board.length, cl = board[0].length;
        if((Math.min(cur.r, cur.c) < 0) ||
                (cur.r > rl-1 || cur.c > cl-1) ||
                (board[cur.r][cur.c] == 'X') ||
                (invalidCells.contains(cur))) {
            return;
        }
        invalidCells.add(cur);
        dfs(new Cell(cur.r+1, cur.c), board, invalidCells);
        dfs(new Cell(cur.r, cur.c+1), board, invalidCells);
        dfs(new Cell(cur.r, cur.c-1), board, invalidCells);
        dfs(new Cell(cur.r-1, cur.c), board, invalidCells);
    }

    @Data
    @AllArgsConstructor
    class Cell {
        int r, c;
    }
}
