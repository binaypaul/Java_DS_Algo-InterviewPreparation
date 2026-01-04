package DataStructure.Neetcode150.a_a_Practice.Mock5_4Q90Min;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(new NumberOfIslands().numberOfIsland(grid));
    }
    private int numberOfIsland(char[][] grid) {
        int rl = grid.length;
        int cl = grid[0].length;
        int count = 0;
        for (int r = 0; r < rl; r++) {
            for (int c = 0; c < cl; c++) {
                if(grid[r][c] == '1') {
                    count++;
                    dfs(grid, r, c);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        int rl = grid.length;
        int cl = grid[0].length;
        if(r < 0 || c < 0 ||
        r == rl || c == cl ||
        grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r, c+1);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
        dfs(grid, r-1, c);
    }
}
