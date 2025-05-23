package DataStructure.Topics.Graph;

import DataStructure.Topics.Graph.AdjacencyList.AdjListMap.AdjListMap;
import DataStructure.Topics.Graph.AdjacencyList.AdjListMap.EdgeI;
import DataStructure.Topics.Graph.AdjacencyList.AdjListMap.PathI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Path and edge are used for better understanding. <p/>
 * Path :
 *       "src" node is the first edge's src node.
 *       "dest" node is last edge's dest node.
 *       "weight" is the sum of weight of all the edges in the path.
 */

public class DijkstrasAlgo_FindShortestPathOfWeightedGraph {
    public Map<Integer, Integer> findShortestPathOfWeightedGraph(Map<Integer, Set<EdgeI>> graph, int src) {
        var shortestPaths = new LinkedHashMap<Integer, Integer>();
        var minHeap = new PriorityQueue<PathI>((PathI x, PathI y) -> Integer.compare(x.getWeight(), y.getWeight()));
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
        var edges = new EdgeI[] {
                new EdgeI(1,2,10),
                new EdgeI(1,3,3),
                new EdgeI(2,4,2),
                new EdgeI(3,2,4),
                new EdgeI(3,4,8),
                new EdgeI(3,5,2),
                new EdgeI(4,5,5),
        };
        Map<Integer, Set<EdgeI>> graph = AdjListMap.createAdjList(edges, 5);

        Map<Integer, Integer> shortest = new DijkstrasAlgo_FindShortestPathOfWeightedGraph()
                .findShortestPathOfWeightedGraph(graph, src);

        for (Map.Entry<Integer, Integer> entry : shortest.entrySet()) {
            System.out.println("Shortest path from " + src +" to " + entry.getKey() + " is " + entry.getValue());
        }
    }
}