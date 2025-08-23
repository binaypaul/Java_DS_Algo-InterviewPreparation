package DataStructure.Concepts.Graph.Algos.TopologicalSort;

import DataStructure.Concepts.Graph.AdjacencyList.AdjListMap.AdjListMap;
import DataStructure.Concepts.Graph.AdjacencyList.AdjListMap.EdgeI;
import java.util.*;

public class TopoSortBFS_KahnAlgorithm {
    // Function to return list containing vertices in Topological order
    int[] sort(int V, int[][] edges) {
        Map<Integer, Set<EdgeI>> adj = AdjListMap.createDirectedAdjList(edges);
        var indegree = new HashMap<Integer, Integer>(V);

        // Calculate indegree of each vertex
        for(Set<EdgeI> edgeISet : adj.values()) {
            for(EdgeI edgeI : edgeISet) {
                indegree.compute(edgeI.getSrc(), (k,v)-> v==null ? 0 : v);
                indegree.compute(edgeI.getDest(), (k,v) -> v==null ? 1 : v+1);
            }
        }

        // Queue to store vertices with indegree 0
        Queue<Integer> q = new LinkedList<>();
        for (Integer vertex : indegree.keySet()) {
            if (indegree.get(vertex) == 0) {
                q.offer(vertex);
            }
        }

        int[] result = new int[V];
        int index = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            // Check for cycle
            if (index == V) {
                System.out.println("Graph contains a cycle!");
                return new int[0];
            }
            result[index] = node;
            for (EdgeI edge : adj.get(node)) {
                indegree.compute(edge.getDest(), (k,v)->v==null ? null : v - 1);
                if (indegree.get(edge.getDest()) == 0) {
                    q.offer(edge.getDest());
                }
            }
            index+=1;
        }

        return result;
    }

    public static void main(String[] args) {
        int V = 6;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {4, 5}, {5, 1}, {5, 2}};

        int[] result = new TopoSortBFS_KahnAlgorithm().sort(V, edges);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
