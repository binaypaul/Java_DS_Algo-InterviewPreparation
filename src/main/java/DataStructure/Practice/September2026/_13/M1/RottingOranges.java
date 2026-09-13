package DataStructure.Practice.September2026._13.M1;

import java.util.*;

public class RottingOranges {
    public static void main(String[] args) {
        int[][] grid = {
                    {2, 1, 0},
                    {1, 1, 0},
                    {0, 0, 1}
        };
        //4
        System.out.println(new RottingOranges().orangesRotting(grid));
    }
    public int orangesRotting(int[][] grid) {
        int rc = grid.length, cc = grid[0].length;
        boolean[][] visited = new boolean[rc][cc];
        int mins = -1;
        int countFresh = 0;

        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < rc; r++) {
            for (int c = 0; c < cc; c++) {
                if(grid[r][c] == 2) {
                    queue.add(new int[]{r,c});
                } else if (grid[r][c]==1) {
                    countFresh++;
                }
            }
        }

        int[][] neighs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        while (!queue.isEmpty()) {
            mins++;
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] cur = queue.poll();
                for (int[] neigh : neighs) {
                    if(Math.min(cur[0]+neigh[0], cur[1]+neigh[1])<0 ||
                            cur[0]+neigh[0] >= rc || cur[1]+neigh[1] >= cc ||
                            visited[cur[0]+neigh[0]][cur[1]+neigh[1]] ||
                            grid[cur[0]+neigh[0]][cur[1]+neigh[1]] !=1
                    ) {
                        continue;
                    }
                    queue.offer(new int[]{cur[0]+neigh[0], cur[1]+neigh[1]});
                    visited[cur[0]+neigh[0]][cur[1]+neigh[1]] = true;
                    countFresh--;
                }
            }
        }

        return countFresh!=0?-1:mins==-1?0:mins;
    }
}
