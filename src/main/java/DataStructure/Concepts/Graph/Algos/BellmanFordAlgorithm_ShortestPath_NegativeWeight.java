package DataStructure.Concepts.Graph.Algos;

import java.util.*;

/*
https://www.youtube.com/watch?v=0vVofAhAYjc

Given a weighted graph with V vertices and E edges, along with a source vertex src, the task is to compute the shortest distances from the source to all other vertices. If a vertex is unreachable from the source, its distance should be marked as 10^8 (10 to the power 8)
In the presence of a negative weight cycle, return -1 to signify that shortest path calculations are not feasible.
 */
public class BellmanFordAlgorithm_ShortestPath_NegativeWeight {
    public static void main(String[] args) {
        // Number of vertices in the graph
        int V = 6;

        // Edge list representation: {source, destination, weight}
        int[][] edges = new int[][] {
                {5, 3, 1},
                {3, 4, -2},
                {2, 3, 6},
                {1, 5, -3},
                {2, 4, 3},
                {1, 2, -2}
                //uncomment below to add a -ve cycle
//                ,
//                {3, 1, 1}
        };
/*

             5        -2
        0-------->1-------->2-------\
                  |         ^        \ 3
                  |         |         ⌄
               -3 |         | 6        4
                  |         |         ^
                  ⌄         |        / -2
                  5-------->3-------/
                       1
 */

        // Source vertex for Bellman-Ford algorithm
        int src = 0;

        // Run Bellman-Ford algorithm from the source vertex
        int[] ans = bellmanFord(V, edges, src);

        // Print shortest distances from the source to all vertices
        for (int dist : ans)
            System.out.print(dist + " ");

    }

    private static int[] bellmanFord(int v, int[][] edges, int src) {
        int[] ans = new int[v];
//        Arrays.fill(ans, (int) Math.pow(10,8)); //Math.pow(10,8) means 10^8
        Arrays.fill(ans, (int) 1e8); //1e8 means 1*10^8 = 10^8
        //To find shortest path from src to every other node
        ans[0] = 0;
//        iteration for relaxation of edges
        for (int i = 0; i < v; i++) {
            for (int[] edge : edges) {
                int curSrc = edge[0];
                int curDest = edge[1];
                int curW8 = edge[2];

                if(ans[curSrc] != (int)1e8 && ans[curSrc] + curW8 < ans[curDest]) {
                    ans[curDest] = ans[curSrc] + curW8;
                }
            }
        }

        //To detect -ve cycle, do 1 more iteration for relaxation of edges
        for (int[] edge : edges) {
            int curSrc = edge[0];
            int curDest = edge[1];
            int curW8 = edge[2];

            if(ans[curSrc] == (int)1e8 && ans[curSrc] + curW8 < ans[curDest]) {
                return new int[]{-1};
            }
        }
        return ans;
    }
}
/*

     5        -2
0-------->1-------->2-------\
          |         ^        \ 3
          |         |         ⌄
       -3 |         | 6        4
          |         |         ^
          ⌄         |        / -2
          5-------->3-------/
               1
 */