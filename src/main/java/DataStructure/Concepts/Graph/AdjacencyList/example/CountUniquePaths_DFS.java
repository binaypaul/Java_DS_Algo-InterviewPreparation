package DataStructure.Concepts.Graph.AdjacencyList.example;

import DataStructure.Concepts.Graph.AdjacencyList.AdjListMap.AdjListMap;
import DataStructure.Concepts.Graph.AdjacencyList.AdjListMap.EdgeS;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountUniquePaths_DFS {
    static int count = 0;

    public static void main(String[] args) {
        String sourceNode = "A";
        String targetNode = "E";
        EdgeS[] edges = new EdgeS[] {
                new EdgeS("A","B"),
                new EdgeS("B","C"),
                new EdgeS("B","E"),
                new EdgeS("C","E"),
                new EdgeS("E","D")
        };
        Map<String, Set<EdgeS>> adjListMap = AdjListMap.createDirectedAdjList(edges);
        System.out.println(adjListMap);
        new CountUniquePaths_DFS().countPaths(sourceNode, targetNode, adjListMap, new HashSet<>());
        System.out.println(count);
    }

    private void countPaths(String sourceNode, String targetNode, Map<String, Set<EdgeS>> adjListMap, Set<String> visit) {
        if(null == sourceNode || visit.contains(sourceNode)) {
            return;
        } else if(sourceNode.equals(targetNode)) {
            count++;
            return;
        }
        for(EdgeS neigh : adjListMap.get(sourceNode)) {
            visit.add(sourceNode);
            countPaths(neigh.getDest(), targetNode, adjListMap, visit);
            visit.remove(sourceNode);
        }
    }
}
