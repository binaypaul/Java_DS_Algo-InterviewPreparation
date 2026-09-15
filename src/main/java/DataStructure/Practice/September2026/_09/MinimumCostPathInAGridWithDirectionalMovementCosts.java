package DataStructure.Practice.September2026._09;

import java.util.*;

public class MinimumCostPathInAGridWithDirectionalMovementCosts {
    public static void main(String[] args) {
        int[][] grid = {
                            {0, 0, 0, 0, 0},
                            {0, 1, 0, 1, 0},
                            {0, 0, 0, 0, 0},
                            {1, 0, 1, 1, 1},
                            {0, 0, 0, 0, 0}
        };

        System.out.println(new MinimumCostPathInAGridWithDirectionalMovementCosts()
                .minCost(grid));
    }
    public int minCost(int[][] grid) {
        int rc = grid.length, cc = grid[0].length;
        int[][] neighs = new int[][]{{0,1, 1}, {1,0, 1}, {-1,0, 2}, {0,-1, 2}};

        var pq = new PriorityQueue<int[]>(Comparator.comparingInt(arr->arr[2]));
        pq.offer(new int[]{0,0,0});

        var visited = new HashSet<String>();


        while (!pq.isEmpty()) {
            int[] polled = pq.poll();
            int r = polled[0], c=polled[1], cost = polled[2];
            visited.add(r+","+c);

            if(r==rc-1 && c==cc-1) {
                return cost;
            }

            for (int[] neigh : neighs) {
                if(Math.min(r+neigh[0],c+neigh[1]) <0 ||
                        r+neigh[0]>=rc || c+neigh[1]>=cc ||
                        grid[r+neigh[0]][c+neigh[1]] == 1 ||
                        visited.contains((r+neigh[0])+","+(c+neigh[1]))) {
                    continue;
                }
                pq.offer(new int[]{r+neigh[0],c+neigh[1],cost+neigh[2]});
            }
        }
        return -1;
    }
}
