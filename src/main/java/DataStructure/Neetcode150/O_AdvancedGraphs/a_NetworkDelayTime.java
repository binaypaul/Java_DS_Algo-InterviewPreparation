package DataStructure.Neetcode150.O_AdvancedGraphs;
//https://leetcode.com/problems/network-delay-time/description/

import java.util.*;

/**
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 *
 * We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 *
 * Example 1:
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 *
 * Example 2:
 * Input: times = [[1,2,1]], n = 2, k = 1
 * Output: 1
 *
 * Example 3:
 * Input: times = [[1,2,1]], n = 2, k = 2
 * Output: -1
 */
public class a_NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        //adjList Map: {k:src, v: [[dest,weight]]}
        var adjList = createAdjList(times);
        var maxPathWeight = 0;

        var visit = new HashSet<Integer>(n);
        //minHeap: [destNode, pathWeight from k to destNode]
        var minHeap = new PriorityQueue<int[]>(Comparator.comparingInt(path -> path[1]));
        minHeap.add(new int[]{k,0});

        while (visit.size()!=n && !minHeap.isEmpty()) {
            int[] path = minHeap.poll();
            if(!visit.contains(path[0])) {
                visit.add(path[0]);
                maxPathWeight = Math.max(maxPathWeight, path[1]);
                List<int[]> edges = adjList.get(path[0]);
                if(null != edges) {
                    for (int[] edge : edges) {
                        minHeap.add(new int[]{edge[1], path[1] + edge[2]});
                    }
                }
            }
        }
        return visit.size() == n ? maxPathWeight : -1;
    }

    /**
     * create simple adj list
     * @param times [{src,dest,weight}]
     * @return k:src, v: [{dest,weight}]
     */
    private LinkedHashMap<Integer, List<int[]>> createAdjList(int [][] times) {
        var adjList = new LinkedHashMap<Integer, List<int[]>>();
        for (int[] edge : times) {
            adjList.compute(edge[0], (src,destList) -> {
                if(destList == null)
                    destList = new ArrayList<>();
                destList.add(edge);
                return destList;
            });
        }
        return adjList;
    }

    public static void main(String[] args) {
        System.out.println(new a_NetworkDelayTime().networkDelayTime(
                new int[][]{{2,1,1},{2,3,1},{3,4,1}},
//                new int[][]{{1,2,1}},
                2,
                2
        ));
    }
}
