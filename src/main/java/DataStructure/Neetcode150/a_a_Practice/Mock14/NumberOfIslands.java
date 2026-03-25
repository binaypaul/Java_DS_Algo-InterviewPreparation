package DataStructure.Neetcode150.a_a_Practice.Mock14;

public class NumberOfIslands {
    public static void main(String[] args) {
        System.out.println(new NumberOfIslands().numIslands(new char[][]
                        {
                                {'1','1','1','1','0'},
                                {'1','1','0','1','0'},
                                {'1','1','0','0','0'},
                                {'0','0','0','0','0'}
                        }
                ));
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if(grid[r][c]=='1') {
                    dfs(grid, r, c);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        if(Math.min(r,c) < 0 ||
                r > grid.length-1 ||
                c > grid[0].length-1 ||
                grid[r][c]=='0')
            return;
        grid[r][c] = '0';
        dfs(grid, r, c+1);
        dfs(grid, r+1, c);
        dfs(grid, r-1, c);
        dfs(grid, r, c-1);
    }
}
