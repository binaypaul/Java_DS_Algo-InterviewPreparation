package DataStructure.Practice.Oct2026._7;

import java.util.*;

public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rc = heights.length, cc = heights[0].length;
        List<List<Integer>> ret = new ArrayList<>();
        //pacific border cells
        boolean[][] pVisited = new boolean[rc][cc];
        for (int r = 0; r < rc; r++) {
            pdfs(heights, r, 0, Integer.MIN_VALUE, pVisited);
        }
        for (int c = 0; c < cc; c++) {
            pdfs(heights, 0, c, Integer.MIN_VALUE, pVisited);
        }

        //atlantic border cells
        boolean[][] aVisited = new boolean[rc][cc];
        for (int r = 0; r < rc; r++) {
            adfs(heights, r, heights[0].length-1, Integer.MIN_VALUE, pVisited, aVisited, ret);
        }
        for (int c = 0; c < cc; c++) {
            adfs(heights, heights.length-1, c, Integer.MIN_VALUE, pVisited, aVisited, ret);
        }
        return ret;
    }

    private void adfs(int[][] heights, int r, int c, int prev, boolean[][] pVisited, boolean[][] aVisited, List<List<Integer>> ret) {
        if(Math.min(r,c) == -1 ||
                r == heights.length ||
                c == heights[0].length ||
                heights[r][c] < prev ||
                aVisited[r][c])
            return;

        if(pVisited[r][c]) {
            ret.add(List.of(r,c));
        }

        aVisited[r][c] = true;
        adfs(heights, r-1, c, heights[r][c], pVisited, aVisited, ret);
        adfs(heights, r, c-1, heights[r][c], pVisited, aVisited, ret);
        adfs(heights, r+1, c, heights[r][c], pVisited, aVisited, ret);
        adfs(heights, r, c+1, heights[r][c], pVisited, aVisited, ret);
    }

    private void pdfs(int[][] heights, int r, int c, int prev, boolean[][] pVisited) {
        if(Math.min(r,c) == -1 ||
                r == heights.length ||
                c == heights[0].length ||
                heights[r][c] < prev ||
                pVisited[r][c])
            return;

        pVisited[r][c] = true;

        pdfs(heights, r+1, c, heights[r][c], pVisited);
        pdfs(heights, r, c+1, heights[r][c], pVisited);
        pdfs(heights, r-1, c, heights[r][c], pVisited);
        pdfs(heights, r, c-1, heights[r][c], pVisited);
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow pacificAtlanticWaterFlow = new PacificAtlanticWaterFlow();
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        var ret = pacificAtlanticWaterFlow.pacificAtlantic(heights);
        System.out.println(ret);
    }
}
