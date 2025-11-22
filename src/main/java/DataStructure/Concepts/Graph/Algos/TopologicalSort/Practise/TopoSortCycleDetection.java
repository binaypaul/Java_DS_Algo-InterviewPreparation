package DataStructure.Concepts.Graph.Algos.TopologicalSort.Practise;

import DataStructure.Concepts.Graph.AdjacencyList.AdjListMap.AdjListMap;
import DataStructure.Concepts.Graph.AdjacencyList.AdjListMap.EdgeI;
import java.util.*;

public class TopoSortCycleDetection {
    public static void main(String[] args) {
        int[][] preReqs = new int[][] {{0,1},{0,2},{1,3},{2,3}};
        List<Integer> res = new TopoSortCycleDetection().topoSort(preReqs);
        System.out.println(res);
    }

    private List<Integer> topoSort(int[][] edges) {
        Map<Integer, Set<EdgeI>> adj = AdjListMap.createDirectedAdjList(edges);
        var visit = new HashSet<Integer>();
        var recStack = new HashSet<Integer>();
        var res = new LinkedList<Integer>();
        for(Integer src : adj.keySet()) {
            if(!visit.contains(src)) {
                dfs(src, adj, visit, recStack, res);
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(
            Integer src,
            Map<Integer, Set<EdgeI>> adj,
            HashSet<Integer> visit,
            HashSet<Integer> recStack,
            LinkedList<Integer> res
    ) {
        visit.add(src);
        recStack.add(src);

        var edges = adj.get(src);
        if(edges!=null) {
            for (EdgeI edge : edges) {
                if(recStack.contains(edge.getDest()))
                    throw new IllegalArgumentException("Contains cycle!");
                else if(!visit.contains(edge.getDest())) {
                    dfs(edge.getDest(), adj, visit, recStack, res);
                }
            }
        }
        recStack.remove(src);
        res.addFirst(src);
    }
}
