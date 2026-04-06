package DataStructure.Neetcode150.a_a_Practice.Past.Mock15;

import java.util.*;

public class LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        System.out.println(new LongestIncreasingPathInAMatrix()
                .longestIncreasingPath(new int[][]
                        {
                                {9,2,3},
                                {8,1,4},
                                {7,6,5}
                        }
                        ));
    }
    int maxCount = Integer.MIN_VALUE;
    public int longestIncreasingPath(int[][] matrix) {
        int[][] memo = new int[matrix.length][matrix[0].length];
        var visited = new HashSet<String>();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                dfs(matrix, r, c, visited, 1, Integer.MIN_VALUE);
            }
        }
        return maxCount;
    }

    private void dfs(int[][] matrix, int r, int c, HashSet<String> visited, int count, int prev) {
        int rl = matrix.length, cl = matrix[0].length;
        if(Math.min(r,c)<0 ||
        r > rl-1 || c > cl-1 ||
        visited.contains(r+","+c) ||
        matrix[r][c] <= prev) {
            return;
        }

        maxCount=Math.max(count, maxCount);
        visited.add(r+","+c);
        dfs(matrix, r, c+1, visited, count+1, matrix[r][c]);
        dfs(matrix, r+1, c, visited, count+1, matrix[r][c]);
        dfs(matrix, r, c-1, visited, count+1, matrix[r][c]);
        dfs(matrix, r-1, c, visited, count+1, matrix[r][c]);
        visited.remove(r+","+c);
    }
    /*
    Input: matrix =
    {
      {9,2,3},
      {8,1,4},
      {7,6,5}
    }
    Output: 9
    Explanation: 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9
     */
}
