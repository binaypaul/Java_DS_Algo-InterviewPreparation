package DataStructure.Concepts.Graph.Algos;

import DataStructure.Concepts.Graph.AdjacencyList.AdjListMap.AdjListMap;
import DataStructure.Concepts.Graph.AdjacencyList.AdjListMap.EdgeI;
import DataStructure.Concepts.Graph.AdjacencyList.AdjListMap.PathI;
import java.util.*;

/**
 * Path and edge are used for better understanding. <p/>
 * Path :
 *       "src" node is the first edge's src node.
 *       "dest" node is last edge's dest node.
 *       "weight" is the sum of weight of all the edges in the path.
 */

public class Dijkstras_FindShortestPathOfWeightedGraph {
    public Map<Integer, Integer> findShortestPathOfWeightedGraph(Map<Integer, Set<EdgeI>> graph, int src) {
        //k:vertex, v:path weight to reach the vertex from src.
        var shortestPaths = new LinkedHashMap<Integer, Integer>();
        var minHeap = new PriorityQueue<PathI>(Comparator.comparingInt(PathI::getWeight));

        minHeap.add(new PathI(src, src, 0));

        while (!minHeap.isEmpty()) {
            PathI prevMinW8Path = minHeap.poll();
            if(shortestPaths.containsKey(prevMinW8Path.getDest()))
                continue;
            shortestPaths.put(prevMinW8Path.getDest(), prevMinW8Path.getWeight());

            for (EdgeI edgeFromDestOfPrevMinW8Edge : graph.get(prevMinW8Path.getDest())) {
                if (!shortestPaths.containsKey(edgeFromDestOfPrevMinW8Edge.getDest())){
                    PathI path = new PathI(src, edgeFromDestOfPrevMinW8Edge.getDest(), (edgeFromDestOfPrevMinW8Edge.getWeight() + prevMinW8Path.getWeight()));
                    minHeap.add(path);
                }
            }
        }
        return shortestPaths;
    }

    public static void main(String[] args) {
        int src = 1;
        int[][] edges = new int[][]
                {
                        {1,2,10},
                        {1,3,3},
                        {2,4,2},
                        {3,2,4},
                        {3,4,8},
                        {3,5,2},
                        {4,5,5}
                };
        /**   Below graph is directed or unidirected.
         *             2
         *       2 -------- 4
         *  10 /|         / |
         *   /  |       /   |
         * 1    |4  8 /     | 5
         *   \  |   /       |
         *  3 \ | /         |
         *      3 --------- 5
         *             2
         */
        Map<Integer, Set<EdgeI>> graph = AdjListMap.createDirectedAdjList(edges);

        Map<Integer, Integer> shortest = new Dijkstras_FindShortestPathOfWeightedGraph()
                .findShortestPathOfWeightedGraph(graph, src);

        for (Map.Entry<Integer, Integer> entry : shortest.entrySet()) {
            System.out.println("Shortest path from " + src +" to " + entry.getKey() + " is " + entry.getValue());
        }
    }
}