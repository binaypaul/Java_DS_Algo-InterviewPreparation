package DataStructure.Concepts.Graph.MatrixOrGrid.example;

import DataStructure.Concepts.Graph.MatrixOrGrid.GridRowCol;

import java.util.HashSet;
import java.util.Set;

public class CountUniquePathsFromTopLeftToBottomRight_DFS {

    private int findPaths(int [][] grid, int r, int c, Set<GridRowCol> visited) {
        int rl = grid.length, cl = grid[0].length;
        GridRowCol grc = new GridRowCol(r,c);

        //base conditions -- start
        if((Math.min(r,c) < 0) ||
                (r >= rl) ||
                (c >= cl) ||
                (grid[r][c] == 1) ||
                (visited.contains(grc))) {
            return 0;
        }
        if(r == rl-1 &&
                c == cl-1) {
            return 1;
        }
        //base condition -- end

        int count = 0;
        visited.add(grc);
        count += findPaths(grid, r, c+1, visited);
        count += findPaths(grid, r, c-1, visited);
        count += findPaths(grid, r+1, c, visited);
        count += findPaths(grid, r-1, c, visited);
        visited.remove(grc);

        return count;
    }

    public static void main(String[] args) {
        //'0' represents valid path
        //'1' represents blocked path
        System.out.println(
                new CountUniquePathsFromTopLeftToBottomRight_DFS()
                .findPaths(new int[][]{
                    {0,0,0,0},
                    {1,1,0,0},
                    {0,0,0,1},
                    {0,1,0,0}
        }, 0, 0, new HashSet<GridRowCol>()));
        //shortest path is: (1,0)->(0,1)->(0,2)->(1,2)->(2,2)->(3,2)->(3,3)
    }
}
