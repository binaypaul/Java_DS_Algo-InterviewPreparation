package DataStructure.Neetcode150.a_a_Practice.May.Mock_12_05;

public class NumberOfIslands {
    public static void main() {
        char[][] board = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        System.out.println(new NumberOfIslands().numIslands(board));
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if(grid[r][c]=='1') {
                    count++;
                    dfs(grid, r, c);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        if(Math.min(r,c)<0 ||
        r>grid.length-1 ||
        c>grid[0].length-1 ||
        grid[r][c]!='1')
            return;
        grid[r][c]='0';
        dfs(grid, r+1, c);
        dfs(grid, r, c+1);
        dfs(grid, r-1, c);
        dfs(grid, r, c-1);
    }
}
