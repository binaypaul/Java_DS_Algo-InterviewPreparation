package DataStructure.Neetcode150.O_AdvancedGraphs;
//https://leetcode.com/problems/min-cost-to-connect-all-points/

import java.util.*;

/**
 * You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
 * Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
 *
 * Example 1:
 * Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * Output: 20
 * Explanation:
 * We can connect the points as shown above to get the minimum cost of 20.
 * Notice that there is a unique path between every pair of points.
 *
 * Example 2:
 * Input: points = [[3,12],[-2,5],[-4,1]]
 * Output: 18
 */

public class c_MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        if(points.length < 2) return 0;

        int res = 0;

        var adj = adjListConnectingAllVertices(points);
        var visit = new HashSet<Integer>();
        var minHeap = new PriorityQueue<int[]>(Comparator.comparingInt(arr -> arr[1]));
        minHeap.add(new int[]{0,0});

        while (visit.size() != points.length && !minHeap.isEmpty()) {
            int[] smallestEdge = minHeap.poll();
            if(!visit.contains(smallestEdge[0])) {
                visit.add(smallestEdge[0]);
                res += smallestEdge[1];

                List<int[]> edges = adj.get(smallestEdge[0]);
                minHeap.addAll(edges);
            }
        }
        return res;
    }

    private LinkedHashMap<Integer, List<int[]>> adjListConnectingAllVertices(int[][] points) {
        var adj = new LinkedHashMap<Integer, List<int[]>>();
        for (int i = 0; i < points.length; i++) {
            adj.putIfAbsent(i, new ArrayList<>());
            for (int j = i+1; j < points.length; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adj.get(i).add(new int[]{j, dist});
                adj.putIfAbsent(j, new ArrayList<>());
                adj.get(j).add(new int[]{i, dist});
            }
        }
        return adj;
    }

    public static void main(String[] args) {
        System.out.println(new c_MinCostToConnectAllPoints().minCostConnectPoints(
//                new int [][] {{0,0},{2,2},{3,10},{5,2},{7,0}}
                new int [][] {{0,0},{1,1},{1,0},{-1,1}}
        ));
    }
}