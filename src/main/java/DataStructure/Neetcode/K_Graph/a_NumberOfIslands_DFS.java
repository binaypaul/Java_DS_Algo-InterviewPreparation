package DataStructure.Neetcode.K_Graph;

//https://leetcode.com/problems/number-of-islands/description/
public class a_NumberOfIslands_DFS {
    int count = 0;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length==0 || grid[0].length == 0) return 0;

        int rl = grid.length, cl = grid[0].length;
        for (int r = 0; r < rl; r++) {
            for (int c = 0; c < cl; c++) {
                if(grid[r][c] == '1') {
                    dfs(grid, r, rl, c, cl);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int r, int rl, int c, int cl) {
        if((Math.min(r,c) < 0) ||
                (r >= rl) ||
                (c >= cl) ||
                (grid[r][c] == '0')) {
            return;
        }

        if(grid[r][c] == '1') {
            grid[r][c] = '0';
            dfs(grid, r+1, rl, c, cl);
            dfs(grid, r-1, rl, c, cl);
            dfs(grid, r, rl, c+1, cl);
            dfs(grid, r, rl, c-1, cl);
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][] {
                {'1','1','0','1','1'},
                {'1','1','0','0','0'},
                {'0','0','0','1','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(new a_NumberOfIslands_DFS().numIslands(grid));
    }
}
