package DataStructure.Practice.September2026._05.M1;

import java.util.*;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // Your implementation here
        int origColor = image[sr][sc];
        if(origColor==color) return image;
        int rc = image.length, cc = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        image[sr][sc] = color;

        var neighs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        while (!q.isEmpty()) {
            var cur = q.poll();
            int curRow=cur[0], curCol=cur[1];
            for (int[] neigh : neighs) {
                if(Math.min(curRow+neigh[0], curCol+neigh[1])<0 ||
                        curRow+neigh[0] >= rc ||
                        curCol+neigh[1] >= cc ||
                        image[curRow+neigh[0]][curCol+neigh[1]] != origColor
                ) {
                    continue;
                }
                q.add(new int[]{curRow+neigh[0], curCol+neigh[1]});
                image[curRow+neigh[0]][curCol+neigh[1]] = color;
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1, sc = 1, color = 2;
        System.out.println(Arrays.deepToString(new FloodFill().floodFill(image, sr, sc, color)));
    }
    /*
    int[][] image = {
    {1, 1, 1},
    {1, 1, 0},
    {1, 0, 1}
};
int sr = 1, sc = 1, color = 2;

O/P:
    // Modified image:
    {
        {2, 2, 2},
        {2, 2, 0},
        {2, 0, 1}
    }
     */
}