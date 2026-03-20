package DataStructure.Concepts.Graph.Algos.practise;

import DataStructure.Concepts.Graph.AdjacencyList.AdjListMap.*;
import java.util.*;

public class Dijkstras {
    public Map<Integer, Integer> findShortestPathOfWeightedGraph(Map<Integer, Set<EdgeI>> graph, int src) {
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
}
