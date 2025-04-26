package DataStructure.Topics.Graph.AdjacencyList.example;

import DataStructure.Topics.Graph.AdjacencyList.AdjListMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountUniquePaths_DFS {
    static int count = 0;

    public static void main(String[] args) {
        String sourceNode = "A";
        String targetNode = "E";
        String[][] edges = new String[][] {{"A","B"},{"B","C"},{"B","E"},{"C","E"},{"E","D"}};
        Map<String, Set<String>> adjListMap = AdjListMap.createAdjList(edges);
        System.out.println(adjListMap);
        new CountUniquePaths_DFS().countPaths(sourceNode, targetNode, adjListMap, new HashSet<>());
        System.out.println(count);
    }

    private void countPaths(String sourceNode, String targetNode, Map<String, Set<String>> adjListMap, Set<String> visit) {
        if(null == sourceNode || visit.contains(sourceNode)) {
            return;
        } else if(sourceNode.equals(targetNode)) {
            count++;
            return;
        }
        for(String neigh : adjListMap.get(sourceNode)) {
            visit.add(sourceNode);
            countPaths(neigh, targetNode, adjListMap, visit);
            visit.remove(sourceNode);
        }
    }
}
