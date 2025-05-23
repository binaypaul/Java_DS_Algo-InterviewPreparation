package DataStructure.Topics.Graph.AdjacencyList.example;

import DataStructure.Topics.Graph.AdjacencyList.AdjListMap.AdjListMap;
import DataStructure.Topics.Graph.AdjacencyList.AdjListMap.EdgeS;

import java.util.*;

public class ShortestPath_BFS {

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
        Map<String, Set<EdgeS>> adjListMap = AdjListMap.createAdjList(edges);
        System.out.println(adjListMap);
        System.out.println(new ShortestPath_BFS().lengthOfShortestPath(sourceNode, targetNode, adjListMap, new HashSet<>()));
    }

    private int lengthOfShortestPath(String sourceNode,
                                     String targetNode,
                                     Map<String, Set<EdgeS>> adjListMap,
                                     HashSet<Object> visit) {
        Queue<String> q = new LinkedList<>();
        q.add(sourceNode);
        visit.add(sourceNode);
        int lengthOfSP = 0;

        outer:
        while (!q.isEmpty()) {
            int qsize= q.size();
            for (int i = 0; i < qsize; i++) {
                String node = q.poll();
                if (node.equals(targetNode)) {
                    break outer;
                }
                for (EdgeS neigh : adjListMap.get(node)) {
                    if (!visit.contains(neigh)) {
                        visit.add(neigh);
                        q.add(neigh.getDest());
                    }
                }
            }
            lengthOfSP++;
        }
        return lengthOfSP;
    }
}
