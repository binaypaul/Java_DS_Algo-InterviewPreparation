package DataStructure.Topics.Graph.practise;

import DataStructure.Topics.Graph.AdjacencyList.AdjListMap.AdjListMap;
import DataStructure.Topics.Graph.AdjacencyList.AdjListMap.EdgeI;
import DataStructure.Topics.Graph.AdjacencyList.AdjListMap.PathI;

import java.util.HashMap;
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

public class FindShortestPathOfWeightedGraph {
    public static void main(String[] args) {
        int srcNode = 1;
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

        Map<Integer, Integer> shortest = new FindShortestPathOfWeightedGraph()
                .findShortestPathOfWeightedGraph(graph, srcNode);

        for (Map.Entry<Integer, Integer> entry : shortest.entrySet()) {
            System.out.println("Shortest path from " + srcNode +" to " + entry.getKey() + " is " + entry.getValue());
        }
    }

    private Map<Integer, Integer> findShortestPathOfWeightedGraph(Map<Integer, Set<EdgeI>> graph, int srcNode) {
        var map = new HashMap<Integer, Integer>();
        var minHeap = new PriorityQueue<PathI>((PathI x, PathI y)-> Integer.compare(x.getWeight(), y.getWeight()));
        minHeap.add(new PathI(srcNode, srcNode));

        while (!minHeap.isEmpty()) {
            PathI minW8PrevPath = minHeap.poll();
            if(map.containsKey(minW8PrevPath.getDest()))
                continue;
            map.put(minW8PrevPath.getDest(), minW8PrevPath.getWeight());

            for(EdgeI edgeFromDestNodeOfMinW8PrevPath : graph.get(minW8PrevPath.getDest())) {
                if(!map.containsKey(edgeFromDestNodeOfMinW8PrevPath.getDest()))
                    minHeap.add(new PathI(srcNode, edgeFromDestNodeOfMinW8PrevPath.getDest(), (minW8PrevPath.getWeight() + edgeFromDestNodeOfMinW8PrevPath.getWeight())));
            }
        }
        return map;
    }
}
