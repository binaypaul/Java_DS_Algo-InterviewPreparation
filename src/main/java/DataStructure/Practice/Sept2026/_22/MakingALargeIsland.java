package DataStructure.Practice.Sept2026._22;

public class MakingALargeIsland {
    int max = Integer.MIN_VALUE, count = 0;
    public int largestIsland(int[][] grid) {
        int rc = grid.length, cc = grid[0].length;

        for (int r = 0; r < rc; r++) {
            for (int c = 0; c < cc; c++) {
                if(grid[r][c]==0) {
                    var visited = new boolean[rc][cc];
                    count = 0;
                    grid[r][c]=1;
                    dfs(grid, r, c, visited);
                    grid[r][c]=0;
                }
            }
        }
        return max==Integer.MIN_VALUE ? rc*cc : max;
    }

    private void dfs(int[][] grid, int r, int c, boolean[][] visited) {
        int rc = grid.length, cc = grid[0].length;

        if(Math.min(r,c)<0 ||
        r == rc || c == cc ||
        grid[r][c]==0 ||
        visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        count++;
        dfs(grid, r, c+1, visited);
        dfs(grid, r+1, c, visited);
        dfs(grid, r-1, c, visited);
        dfs(grid, r, c-1, visited);
        max = Math.max(max, count);
    }

    public static void main(String[] args) {
        MakingALargeIsland makingALargeIsland = new MakingALargeIsland();
        int[][] grid = {
                {1, 0, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        var ret = makingALargeIsland.largestIsland(grid);
        System.out.println(ret);
    }
}
