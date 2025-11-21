package DataStructure.Concepts.Graph.Algos.TopologicalSort;

import DataStructure.Concepts.Graph.AdjacencyList.AdjListMap.AdjListMap;
import DataStructure.Concepts.Graph.AdjacencyList.AdjListMap.EdgeI;
import java.util.*;

//post order dfs
public class TopoSortDFS {
    int V = 8; // vertices count
    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}, {5, 6}, {7, 8}};
//        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {4, 5}, {5, 1}, {5, 2}};
//        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {0,4}, {4,5}, {5,3}, {6,7}, {8}, {9}};
        List<Integer> res = new TopoSortDFS().topoSort(edges);
        System.out.println(res);
    }

    public ArrayList<Integer> topoSort(int[][] edges) {
        Map<Integer, Set<EdgeI>> adj = AdjListMap.createDirectedAdjList(edges);
        Set<Integer> visited = new HashSet<>();
        LinkedList<Integer> result = new LinkedList<>();

        for(Integer src : adj.keySet()) {
            if(!visited.contains(src)) {
                dfsPath(src, adj, visited, result);
            }
        }

        return new ArrayList<>(result);
    }

    private void dfsPath(Integer src, Map<Integer, Set<EdgeI>> adj, Set<Integer> visited, LinkedList<Integer> result) {
        visited.add(src);
        var edges = adj.get(src);

        if(edges != null) {
            for (EdgeI edge : edges) {
                if(!visited.contains(edge.getDest())) {
                    dfsPath(edge.getDest(), adj, visited, result);
                }
            }
        }

        result.addFirst(src);
    }
}