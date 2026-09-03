package DataStructure.Neetcode150.K_Graph;

import DataStructure.Practice.September2026._03.M2.*;
import java.util.*;
import lombok.*;

public class d_WallsAndGates {
    public static void main(String[] args) {
        int INF = 2147483647;
        int[][] rooms = {
                {INF, -1,  0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {  0, -1, INF, INF}
        };
        new d_WallsAndGates().wallsAndGates(rooms);
        System.out.println(Arrays.deepToString(rooms));
    }

    public void wallsAndGates(int[][] rooms) {
        int INF = 2147483647;
        // Your implementation here
        for (int r = 0; r < rooms.length; r++) {
            for (int c = 0; c < rooms[0].length; c++) {
                if(rooms[r][c]==0) {
                    bfs(rooms, INF, new Celll(r,c));
                }
            }
        }
        
    }
    private void bfs(int[][] rooms, int INF, Celll cell) {
        var rCount = rooms.length;
        var cCount = rooms[0].length;
        var visited = new HashSet<Celll>();

        Queue<Celll> q = new LinkedList<>();
        q.offer(cell);
        visited.add(cell);

        int count = 0;
        while (!q.isEmpty()) {
            count++;
            var size = q.size();
            for (int i = 0; i < size; i++) {
                var cur = q.poll();

                //to east
                cell = new Celll(cur.r, cur.c + 1);
                if ((cur.c + 1 < cCount) && (rooms[cur.r][cur.c + 1] != -1) && (rooms[cur.r][cur.c + 1] != 0) && !visited.contains(cell)) {
                    rooms[cur.r][cur.c + 1] = Math.min(count, rooms[cur.r][cur.c + 1]);
                    q.offer(cell);
                    visited.add(cell);
                }
                //to west
                cell = new Celll(cur.r, cur.c - 1);
                if ((cur.c - 1 > -1) && (rooms[cur.r][cur.c - 1] != -1) && (rooms[cur.r][cur.c - 1] != 0) && !visited.contains(cell)) {
                    rooms[cur.r][cur.c - 1] = Math.min(count, rooms[cur.r][cur.c - 1]);
                    q.offer(cell);
                    visited.add(cell);
                }
                //to north
                cell = new Celll(cur.r-1, cur.c);
                if ((cur.r - 1 > -1) && (rooms[cur.r - 1][cur.c] != -1) && (rooms[cur.r - 1][cur.c] != 0) && !visited.contains(cell)) {
                    rooms[cur.r - 1][cur.c] = Math.min(count, rooms[cur.r - 1][cur.c]);
                    q.offer(cell);
                    visited.add(cell);
                }
                //to south
                cell = new Celll(cur.r + 1, cur.c);
                if ((cur.r + 1 < rCount) && (rooms[cur.r + 1][cur.c] != -1) && (rooms[cur.r + 1][cur.c] != 0) && !visited.contains(cell)) {
                    rooms[cur.r + 1][cur.c] = Math.min(count, rooms[cur.r + 1][cur.c]);
                    q.offer(cell);
                    visited.add(cell);
                }
            }
        }
    }
}

@Data
@AllArgsConstructor
class Celll {
    int r,c;
}