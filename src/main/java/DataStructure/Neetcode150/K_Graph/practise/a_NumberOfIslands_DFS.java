package DataStructure.Neetcode150.K_Graph.practise;

//https://leetcode.com/problems/number-of-islands/description/
public class a_NumberOfIslands_DFS {
    int count = 0;
    public int numIslands(char[][] grid) {
        int count = 0;
        int rl = grid.length;
        int cl = grid[0].length;
        for (int r = 0; r < rl; r++) {
            for (int c = 0; c < cl; c++) {
                if(grid[r][c] == '1') {
                    dfs(grid, rl, cl, r, c);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int rl, int cl, int r, int c) {
        if((r==rl) ||
        (c==cl)||
        (Math.min(r,c) < 0) ||
        (grid[r][c] == '0')) {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, rl, cl, r+1, c);
        dfs(grid, rl, cl, r-1, c);
        dfs(grid, rl, cl, r, c+1);
        dfs(grid, rl, cl, r, c-1);
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
