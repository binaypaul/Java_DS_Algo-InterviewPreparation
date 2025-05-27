package DataStructure.Concepts.Graph.MatrixOrGrid.example;

import DataStructure.Concepts.Graph.MatrixOrGrid.GridRowCol;

import java.util.*;

public class LengthOfShortestPathFromTopLeftToBottomRight_BFS {

    public static void main(String[] args) {
        //'0' represents valid path
        //'1' represents blocked path
        System.out.println(
                new LengthOfShortestPathFromTopLeftToBottomRight_BFS()
                .findPaths(new int[][]{
                    {0,0,0,0},
                    {1,1,0,0},
                    {0,0,0,1},
                    {0,1,0,0}
                }));
        //shortest path is: (1,0)->(0,1)->(0,2)->(1,2)->(2,2)->(3,2)->(3,3)
    }

    private int findPaths(int[][] grid) {
        Set<GridRowCol> visited = new LinkedHashSet<>();
        int rl = grid.length, cl = grid[0].length;
        Queue<GridRowCol> q = new LinkedList<>();

        GridRowCol grc = new GridRowCol(0,0);
        q.add(grc);
        visited.add(grc);
        int length = 0;
        Set<GridRowCol> neighbours = new LinkedHashSet<>(Arrays.asList(
                new GridRowCol(-1,0),                           //{0,0,0,0},
                new GridRowCol(0,-1),                           //{1,1,0,0},
                new GridRowCol(1,0),                            //{0,0,0,1},
                new GridRowCol(0,1)                             //{0,1,0,0},
        ));

        outer:
        while (!q.isEmpty()) {
            length++;
            for (int i = 0; i < q.size(); i++) {
                GridRowCol grcc = q.poll();
                if(grcc.row() == rl-1 && grcc.col() == cl-1) {
                    break outer;
                }

                for(GridRowCol grcNeigh : neighbours) {
                    int rn = grcc.row() + grcNeigh.row(), cn = grcc.col() + grcNeigh.col();
                    GridRowCol grcn = new GridRowCol(rn, cn);

                    if((Math.min(rn, cn) < 0)
                            || (rn == rl)
                            || (cn == cl)
                            || (visited.contains(grcn))
                            || (grid[rn][cn] == 1)) {
                        continue;
                    }
                    q.add(grcn);
                    visited.add(grcn);
                }
            }
        }
        return length;
    }
}
