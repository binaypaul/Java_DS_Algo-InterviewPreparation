package DataStructure.Topics.Graph.AdjacencyList.example;

import DataStructure.Topics.Graph.AdjacencyList.AdjListMap;

import java.util.*;

public class ShortestPath_BFS {

    public static void main(String[] args) {
        String sourceNode = "A";
        String targetNode = "E";
        String[][] edges = new String[][] {{"A","B"},{"B","C"},{"B","E"},{"C","E"},{"E","D"}};
        Map<String, Set<String>> adjListMap = AdjListMap.createAdjList(edges);
        System.out.println(adjListMap);
        System.out.println(new ShortestPath_BFS().lengthOfShortestPath(sourceNode, targetNode, adjListMap, new HashSet<>()));
    }

    private int lengthOfShortestPath(String sourceNode,
                                     String targetNode,
                                     Map<String, Set<String>> adjListMap,
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
                for (String neigh : adjListMap.get(node)) {
                    if (!visit.contains(neigh)) {
                        visit.add(neigh);
                        q.add(neigh);
                    }
                }
            }
            lengthOfSP++;
        }
        return lengthOfSP;
    }
}
