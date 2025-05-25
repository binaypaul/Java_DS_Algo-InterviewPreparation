package DataStructure.Topics.Graph.Algos;

import DataStructure.Topics.Graph.AdjacencyList.AdjListMap.AdjListMap;
import DataStructure.Topics.Graph.AdjacencyList.AdjListMap.EdgeI;

import java.util.*;

/**
 * MinimumSpanningTree: <p/>
 *      Not cyclic / Acyclic.
 *      Undirected.
 *      Shortest path from root to leaf and must include/span all nodes of the graph.
 */

public class Prims_MinimumSpanningTree {
    public static void main(String[] args) {
        int src = 1;
        var edges = new EdgeI[] {
                new EdgeI(1,2,10),
                new EdgeI(1,3,3),
                new EdgeI(2,3,4),
                new EdgeI(2,4,1),
                new EdgeI(3,4,4),
                new EdgeI(3,5,4),
                new EdgeI(4,5,2),
        };
        /**   Below graph is undirected.
         *             1
         *       2 -------- 4
         *  10 / |        / |
         *   /   |      /   |
         * 1   4 |  4 /     | 2
         *   \   |  /       |
         *  3 \  |/         |
         *      3 --------- 5
         *            4
         */

        var mst = new Prims_MinimumSpanningTree().minimumSpanningTree(AdjListMap.createUndirectedAdjList(edges));

        for (Map.Entry<Integer, Integer> entry : mst.entrySet()) {
            System.out.println("src " + entry.getKey() + " to node " + entry.getValue());
        }
    }

    public Map<Integer, Integer> minimumSpanningTree(Map<Integer, Set<EdgeI>> graph) {
        var mst = new LinkedHashMap<Integer, Integer>(); //src->dest
        var minHeap = new PriorityQueue<EdgeI>((EdgeI x, EdgeI y) -> Integer.compare(x.getWeight(), y.getWeight()));
        var visit = new HashSet<Integer>();

        //randomly taking the first element from the graph
        Integer firstSrcNode = graph.keySet().stream().findFirst().get();
        graph.get(firstSrcNode).forEach(edgeI -> minHeap.add(edgeI));
        visit.add(firstSrcNode);

        while (!minHeap.isEmpty()) {
            EdgeI minW8Edge = minHeap.poll();
            if(visit.contains(minW8Edge.getDest()))
               continue;
            mst.put(minW8Edge.getSrc(), minW8Edge.getDest());
            visit.add(minW8Edge.getDest());

            for(EdgeI neighOfMinW8Edge : graph.get(minW8Edge.getDest())) {
                if(!visit.contains(neighOfMinW8Edge.getDest()))
                    minHeap.add(neighOfMinW8Edge);
            }
        }

        return mst;
    }
}
