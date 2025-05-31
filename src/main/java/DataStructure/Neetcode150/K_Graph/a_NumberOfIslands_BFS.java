package DataStructure.Neetcode150.K_Graph;

import DataStructure.Concepts.Graph.MatrixOrGrid.GridRowCol;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
//https://leetcode.com/problems/number-of-islands/
public class a_NumberOfIslands_BFS {
    int count = 0;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length==0 || grid[0].length == 0) return 0;

        int rl = grid.length, cl = grid[0].length;
        for (int r = 0; r < rl; r++) {
            for (int c = 0; c < cl; c++) {
                if(grid[r][c] == '1') {
                    bfs(grid, r, rl, c, cl);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int r, int rl, int c, int cl) {
        Queue<GridRowCol> q = new LinkedList<>();
        Set<GridRowCol> neighs = new HashSet<GridRowCol>(){{
            add(new GridRowCol(1, 0));
            add(new GridRowCol(-1, 0));
            add(new GridRowCol(0, 1));
            add(new GridRowCol(0, -1));
        }};

        q.add(new GridRowCol(r,c));
        
        while (!q.isEmpty()) {
            GridRowCol grc = q.poll();

            for(GridRowCol grcn : neighs) {
                if((Math.min(grc.row()+grcn.row(), grc.col()+grcn.col())<0) ||
                        (grc.row()+grcn.row() >= rl) ||
                        (grc.col()+grcn.col() >= cl) ||
                        (grid[grc.row()+grcn.row()][grc.col()+grcn.col()]=='0'))
                    continue;
                grid[grc.row()+grcn.row()][grc.col()+grcn.col()]='0';
                q.add(new GridRowCol(grc.row()+grcn.row(), grc.col()+grcn.col()));
            }
        }
    }


    public static void main(String[] args) {
        char[][] grid = new char[][] {
                {'1','1','0','1','1'},
                {'1','1','0','0','0'},
                {'0','0','0','1','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(new a_NumberOfIslands_BFS().numIslands(grid));
    }
}
