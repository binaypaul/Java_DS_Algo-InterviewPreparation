package DataStructure.Neetcode.K_Graph;

import java.util.*;

public class e_RottingOranges {
    public static void main(String[] args) {
        System.out.println(new e_RottingOranges().orangesRotting(
                new int[][]{
                        {2,1,1},
                        {0,1,1},
                        {1,0,1}
                }
        ));
    }

    int count = 0;
    Set<Cell> visited = new HashSet<>();
    Queue<Cell> queue = new LinkedList<>();

    public int orangesRotting(int[][] grid) {
        var directions = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};

        //initial add to the queue
        addAllRottingOrangeToQ(grid);

        while (!queue.isEmpty()) {
            var qsize = queue.size();
            boolean flag = false;
            for (var i = 0; i < qsize; i++) {
                Cell cur = queue.poll();

                for (var direction : directions) {
                    var nr = cur.row + direction[0];
                    var nc = cur.col + direction[1];
                    Cell curneigh = new Cell(nr, nc);
                    if ((Math.min(nr, nc) < 0) ||
                            (nr == grid.length) ||
                            (nc == grid[0].length) ||
                            (grid[nr][nc] == 0) ||
                            (visited.contains(curneigh))) {
                        continue;
                    }
                    grid[nr][nc] = 2;
                    queue.offer(curneigh);
                    visited.add(curneigh);
                    flag = true;
                }
            }
            if(flag)
                count++;
        }

        for (var r = 0; r < grid.length; r++) {
            for (var c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 1)
                    return -1;
            }
        }

        return count;
    }

    public void addAllRottingOrangeToQ(int[][] grid) {
        Cell cur = null;
        for (var r = 0; r < grid.length; r++) {
            for (var c = 0; c < grid[0].length; c++) {
                cur = new Cell(r, c);
                if (grid[r][c] == 2 && !visited.contains(cur)){
                    queue.offer(cur);
                    visited.add(cur);
                }
            }
        }
    }
}


class Cell {
    int row;
    int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return row == cell.row && col == cell.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}