package DataStructure.Practice.Sept2026._15;

import java.util.*;

public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        int rc= rooms.length, cc=rooms[0].length;
        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < rc; r++) {
            for (int c = 0; c < cc; c++) {
                if(rooms[r][c]==0) {
                    q.offer(new int[]{r,c});
                }
            }
        }
        int[][] neighs = {{1,0},{0,1},{-1,0},{0,-1}};
        int dis = 0;
        while (!q.isEmpty()) {
            var size = q.size();
            dis++;
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int[] neigh : neighs) {
                    if(Math.min(cur[0]+neigh[0], cur[1]+neigh[1])<0 ||
                            cur[0]+neigh[0] >= rc || cur[1]+neigh[1] >= cc ||
                            rooms[cur[0]+neigh[0]][cur[1]+neigh[1]] != Integer.MAX_VALUE
                    ) {
                        continue;
                    }
                    rooms[cur[0]+neigh[0]][cur[1]+neigh[1]] = dis;
                    q.add(new int[]{cur[0]+neigh[0], cur[1]+neigh[1]});
                }
            }
        }
    }

    public static void main(String[] args) {
        WallsAndGates wallsAndGates = new WallsAndGates();
        int[][] rooms = {
                {2147483647,    -1,             0,              2147483647},
                {2147483647,    2147483647,     2147483647,     -1},
                {2147483647,    -1,             2147483647,     -1},
                {0,             -1,             2147483647,     2147483647}
        };
        wallsAndGates.wallsAndGates(rooms);
        System.out.println(Arrays.deepToString(rooms));
    }
}