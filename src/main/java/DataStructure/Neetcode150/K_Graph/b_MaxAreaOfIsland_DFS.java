package DataStructure.Neetcode150.K_Graph;
//https://leetcode.com/problems/max-area-of-island/
public class b_MaxAreaOfIsland_DFS {
    int maxArea = 0, curMaxArea;
    public int maxAreaOfIsland(int[][] grid) {
        int rl = grid.length, cl = grid[0].length;
        for (int r = 0; r < rl; r++) {
            for (int c = 0; c < cl; c++) {
                if(grid[r][c] == 1) {
                    curMaxArea = 0;
                    dfs(grid, r, rl, c, cl);
                    maxArea = Math.max(maxArea, curMaxArea);
                }
            }
        }
        return maxArea;
    }

    private void dfs(int[][] grid, int r, int rl, int c, int cl) {
        if((Math.min(r,c) < 0) ||
                (r == rl) ||
                (c == cl) ||
                (grid[r][c] == 0)) {
            return;
        } else if (grid[r][c] == 1)
        {
            grid[r][c] = 0;
            curMaxArea++;
        }
        dfs(grid, r+1, rl, c, cl);
        dfs(grid, r-1, rl, c, cl);
        dfs(grid, r, rl, c+1, cl);
        dfs(grid, r, rl, c-1, cl);
    }

    public static void main(String[] args) {
        int [][] grid = new int[][]
        {
            {0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        System.out.println(new b_MaxAreaOfIsland_DFS().maxAreaOfIsland(grid));
    }
}