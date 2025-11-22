package DataStructure.Concepts.Graph.Algos.TopologicalSort;

import DataStructure.Concepts.Graph.AdjacencyList.AdjListMap.AdjListMap;
import DataStructure.Concepts.Graph.AdjacencyList.AdjListMap.EdgeI;
import java.util.*;

//post order dfs
public class TopoSortDFS_withCycleDetection {
    int V = 8; // vertices count
    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}, {5, 6}, {7, 8}};
//        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {4, 5}, {5, 1}, {5, 2}};
//        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {0,4}, {4,5}, {5,3}, {6,7}, {8}, {9}};
        List<Integer> res = new TopoSortDFS_withCycleDetection().topoSort(edges);
        System.out.println(res);
    }

    public ArrayList<Integer> topoSort(int[][] edges) {
        Map<Integer, Set<EdgeI>> adj = AdjListMap.createDirectedAdjList(edges);
        Set<Integer> visited = new HashSet<>();
        Set<Integer> recStack = new HashSet<>();
        LinkedList<Integer> result = new LinkedList<>();

        for(Integer src : adj.keySet()) {
            if(!visited.contains(src)) {
                dfs(src, adj, visited, recStack, result);
            }
        }

        return new ArrayList<>(result);
    }

    private void dfs(Integer src, Map<Integer, Set<EdgeI>> adj, Set<Integer> visited, Set<Integer> recStack, LinkedList<Integer> result) {
        visited.add(src);
        recStack.add(src);

        var edges = adj.get(src);
        if(edges != null) {
            for (EdgeI edge : edges) {
                Integer dest = edge.getDest();
                if(recStack.contains(dest)) {
                    throw new IllegalArgumentException("Cycle detected in graph");
                }
                if(!visited.contains(dest)) {
                    dfs(dest, adj, visited, recStack, result);
                }
            }
        }

        recStack.remove(src);
        result.addFirst(src);
    }
}