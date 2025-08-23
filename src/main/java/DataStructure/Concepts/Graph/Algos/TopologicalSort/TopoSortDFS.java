package DataStructure.Concepts.Graph.Algos.TopologicalSort;

import DataStructure.Concepts.Graph.AdjacencyList.AdjListMap.AdjListMap;
import DataStructure.Concepts.Graph.AdjacencyList.AdjListMap.EdgeI;
import java.util.*;

//post order dfs
public class TopoSortDFS {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        Map<Integer, Set<EdgeI>> adj = AdjListMap.createDirectedAdjList(edges);
        var visit = new LinkedHashSet<Integer>();

        for(Integer src : adj.keySet()) {
            if(!visit.contains(src)) {
                dfsPath(src, adj, visit);
                visit.add(src);
            }
        }

        return new ArrayList<>(visit.reversed());
    }

    private static void dfsPath(Integer src, Map<Integer, Set<EdgeI>> adj, LinkedHashSet<Integer> visitReverseSorted) {
        if(!visitReverseSorted.contains(src)) {
            var edges = adj.get(src);
            for (EdgeI edge : edges) {
                dfsPath(edge.getDest(), adj, visitReverseSorted);
                visitReverseSorted.add(edge.getDest());
            }
        }
    }

    public static void main(String[] args) {
        int V = 8;
//        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {4, 5}, {5, 1}, {5, 2}};
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {0,4}, {4,5}, {5,3}, {6,7}, {8}, {9}};
        List<Integer> res = topoSort(V, edges);
        System.out.println(res);
    }
}