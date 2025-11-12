package DataStructure.Concepts.practise;

import DataStructure.Concepts.Graph.AdjacencyList.AdjListMap.AdjListMap;
import DataStructure.Concepts.Graph.AdjacencyList.AdjListMap.EdgeI;
import java.util.*;

public class TopoSort {
    public static void main(String[] args) {
        int V = 8;
//        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {4, 5}, {5, 1}, {5, 2}};
//        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {0,4}, {4,5}, {5,3}, {6,7}, {8}, {9}};
        int[][] edges = {{1, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}, {5, 6}, {7, 8}};

        List<Integer> res = topoSort(edges);
        System.out.println(res);
    }

    private static List<Integer> topoSort(int[][] edges) {
        var adjListMap = AdjListMap.createDirectedAdjList(edges);
        var visit = new LinkedHashSet<Integer>();
        for (Integer src : adjListMap.keySet()) {
            if(!visit.contains(src)) {
                dfs(visit, adjListMap, src);
                visit.add(src);
            }
        }
        return new ArrayList<>(visit.reversed());
    }

    private static void dfs(
            LinkedHashSet<Integer> visit,
            Map<Integer, Set<EdgeI>> adjListMap,
            Integer src) {
        if(!visit.contains(src)) {
            for (EdgeI edgeI : adjListMap.get(src)) {
                dfs(visit, adjListMap, edgeI.getDest());
            }
            visit.add(src);
        }
    }
}
