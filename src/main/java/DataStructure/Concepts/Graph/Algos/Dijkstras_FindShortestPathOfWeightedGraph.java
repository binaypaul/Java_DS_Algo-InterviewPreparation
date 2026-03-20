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
        var shortestPathMap = new HashMap<Integer, Integer>();
        var pq = new PriorityQueue<PathI>(Comparator.comparing(PathI::getWeight));

        pq.add(new PathI(src, src, 0));
        while (!pq.isEmpty()) {
            var polledPath = pq.poll();
            if(!shortestPathMap.containsKey(polledPath.getDest())) {
                shortestPathMap.put(polledPath.getDest(), polledPath.getWeight());

                var destEdges = graph.get(polledPath.getDest());
                if(null != destEdges && !destEdges.isEmpty()) {
                    for (EdgeI destEdge : destEdges) {
                        if(!shortestPathMap.containsKey(destEdge.getDest())) {
                            PathI path = new PathI(src, destEdge.getDest(), polledPath.getWeight() + destEdge.getWeight());
                            pq.add(path);
                        }
                    }
                }
            }
        }
        return shortestPathMap;
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