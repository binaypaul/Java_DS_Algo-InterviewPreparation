package DataStructure.Concepts.Matrix;

import java.util.Arrays;

/**** Unique_Paths_Covering_Every_NonObstacle_Block_Exactly_Once_In_A_Grid
 * Given a grid grid[][] with 4 types of blocks:
 *
 ** 1 represents the starting block. There is exactly one starting block.
 ** 2 represents the ending block. There is exactly one ending block.
 ** 0 represents empty block we can walk over.
 ** -1 represents obstacles that we cannot walk over.
 * Input:
 * grid[][] = {{1, 0, 0, 0},
 *             {0, 0, 0, 0},
 *             {0, 0, 2, -1}}
 * Output: 2
 *
 * Input:
 * grid[][] = {{1, 0, 0, 0},
 *             {0, 0, 0, 0},
 *             {0, 0, 0, 2}}
 * Output: 4
 *
 * Approach:
 * We can use simple DFS here with backtracking.
 * We can check that a particular path has covered all the non-obstacle blocks by counting all the blocks
 * encountered in the way and finally comparing it with the total number of blocks available and if they match, then we add it as a valid solution.
 */

public class Unique_Paths_Covering_Every_NonObstacle_Block_Exactly_Once_In_A_Grid {

    // ans ==> Final Result
    private static int ans = 0;

    private static void uniquePaths(int[][] grid) {
        int rowCount = grid.length;
        int columnCount = grid[0].length;

        boolean[][] visitTrack = new boolean[rowCount][columnCount];
        for (int rowI = 0; rowI < rowCount; rowI++) {
            Arrays.fill(visitTrack[rowI], false);
        }

        int totalCountOf0 = 0, currentDFS0Count = 0;
        int startRowIndex = 0, startColumnIndex = 0;
        for (int rowI = 0; rowI < rowCount; ++rowI) {    //looping through the rows.
            for (int columnJ = 0; columnJ < columnCount; ++columnJ) {    //looping through the columns.
                // Count non-obstacle blocks
                if (grid[rowI][columnJ] == 0) {
                    totalCountOf0++;
                }
                else if (grid[rowI][columnJ] == 1) {
                    startRowIndex = rowI;
                    startColumnIndex = columnJ;
                }
            }
        }
        dfs(grid, visitTrack, startRowIndex, startColumnIndex, totalCountOf0, currentDFS0Count);
    }

    /**
     * DFS movement from start position in Up, Down, Left, Right direction.
     * @param grid Input grid
     * @param visitTrack To mark visited cells
     * @param rowIndex Current cell row index
     * @param columnIndex Current cell column index
     * @param totalCountOf0 Total 0s present
     * @param currentDFS0Count Current count 0s visited
     */
    private static void dfs(int[][] grid, boolean[][] visitTrack, int rowIndex, int columnIndex, int totalCountOf0, int currentDFS0Count) {
        int rowCount = grid.length;
        int columnCount = grid[0].length;

        // Mark the block as visited
        visitTrack[rowIndex][columnIndex] = true;

        if (grid[rowIndex][columnIndex] == 0)
            currentDFS0Count++;

        // If end block reached
        if (grid[rowIndex][columnIndex] == 2) {
            if (totalCountOf0 == currentDFS0Count)
                ans++;
            visitTrack[rowIndex][columnIndex] = false;
            return;
        }

        //Up
        //(rowIndex > 0): If current cell position is not in topmost row.
        //(!visitTrack[rowIndex - 1][columnIndex]): Upward cell isn't visited or is "false".
        //(grid[rowIndex - 1][columnIndex] != -1): Upward cell isn't an obstacle or isn't "-1".
        if (rowIndex > 0 && !visitTrack[rowIndex - 1][columnIndex] && grid[rowIndex - 1][columnIndex] != -1) {
            dfs(grid, visitTrack, rowIndex - 1, columnIndex, totalCountOf0, currentDFS0Count);
        }

        //Down
        if (rowIndex < rowCount - 1 && !visitTrack[rowIndex + 1][columnIndex] && grid[rowIndex + 1][columnIndex] != -1) {
            dfs(grid, visitTrack, rowIndex + 1, columnIndex, totalCountOf0, currentDFS0Count);
        }

        //Left
        if (columnIndex > 0 && !visitTrack[rowIndex][columnIndex - 1] && grid[rowIndex][columnIndex - 1] != -1) {
            dfs(grid, visitTrack, rowIndex, columnIndex - 1, totalCountOf0, currentDFS0Count);
        }

        //Right
        if (columnIndex < columnCount - 1 && !visitTrack[rowIndex][columnIndex + 1] && grid[rowIndex][columnIndex + 1] != -1) {
            dfs(grid, visitTrack, rowIndex, columnIndex + 1, totalCountOf0, currentDFS0Count);
        }

        // Un-mark the block as unvisited.
        visitTrack[rowIndex][columnIndex] = false;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };
        uniquePaths(grid);
        System.out.println(ans);
    }
}
