package DataStructure.Neetcode150.K_Graph;

import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Data;
//https://leetcode.com/problems/pacific-atlantic-water-flow/description/
//fails after 63 test cases
public class f_PacificAtlanticWaterFlow_DFS {
    public static void main(String[] args) {
        int[][] heights = new int[][]
        {
            {1,2,2,3,5},
            {3,2,3,4,4},
            {2,4,5,3,1},
            {6,7,1,4,5},
            {5,1,1,2,4}
        };
        var res = new f_PacificAtlanticWaterFlow_DFS().pacificAtlantic(heights);
        System.out.println(res);
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rl = heights.length;
        int cl = heights[0].length;

        var srcCells = new ArrayList<Cell>();
        var destCells = new ArrayList<Cell>();

        for (int i = 0; i < cl; i++) {
            srcCells.add(new Cell(0,i));
            destCells.add(new Cell(rl-1,i));
            srcCells.add(new Cell(i,0));
            destCells.add(new Cell(i,cl-1));
        }
        for (Cell srcCell : srcCells) {
            dfs(true, heights, srcCell, Integer.MIN_VALUE);
        }
        for (Cell destCell : destCells) {
            dfs(false, heights, destCell, Integer.MIN_VALUE);
        }
        return res;
    }

    Set<Cell> pVisit = new HashSet<>();
    Set<Cell> aVisit = new HashSet<>();

    // pacific = ture will mark cell as -1, atlantic will mark as -2
    private void dfs(boolean pacific, int[][] heights, Cell cur, int prevVal) {
        int rl = heights.length, cl = heights[0].length;

        if(
                (cur.r < 0 || cur.c < 0) ||
                (cur.r > rl-1 || cur.c > cl-1) ||
                ((pacific && pVisit.contains(cur)) || (!pacific && aVisit.contains(cur))) ||
                (heights[cur.r][cur.c] < prevVal)
        ) {
            return;
        }
        prevVal = heights[cur.r][cur.c];
        if(pacific) {
            pVisit.add(cur);
        } else {
            if(pVisit.contains(cur)) {
                res.add(new ArrayList<>(){{add(cur.r); add(cur.c);}});
            }
            aVisit.add(cur);
        }

        //recurse
        dfs(pacific, heights, new Cell(cur.r,cur.c+1), prevVal);
        dfs(pacific, heights, new Cell(cur.r+1,cur.c), prevVal);
        dfs(pacific, heights, new Cell(cur.r-1,cur.c), prevVal);
        dfs(pacific, heights, new Cell(cur.r,cur.c-1), prevVal);
    }

    class Cell{
        int r, c;
        public Cell(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return r == cell.r && c == cell.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }
}
