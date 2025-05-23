package DataStructure.Topics.Graph.AdjacencyList.AdjListMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//DirectionalGraphUsingMap
public class AdjListMap {
    //    also can be represented using a map:
    static Map<Integer, Set<EdgeI>> adjListInt;
    static Map<String, Set<EdgeS>> adjListString;

    public static Map<Integer, Set<EdgeI>> createAdjList (EdgeI[] edges, int noOfNodes) {
        adjListInt = new HashMap<>(noOfNodes);
        for(EdgeI edge : edges) {
            if(!adjListInt.containsKey(edge.src)) {
                adjListInt.put(edge.src, new HashSet<>());
            }
            if(!adjListInt.containsKey(edge.dest)) {
                adjListInt.put(edge.dest, new HashSet<>());
            }
            adjListInt.get(edge.src).add(edge);
        }
        return adjListInt;
    }

    public static Map<String, Set<EdgeS>> createAdjList (EdgeS[] edges) {
        adjListString = new HashMap<>();
        for(EdgeS edge : edges) {
            if(!adjListString.containsKey(edge.src)) {
                adjListString.put(edge.src, new HashSet<>());
            }
            if(!adjListString.containsKey(edge.dest)) {
                adjListString.put(edge.dest, new HashSet<>());
            }
            adjListString.get(edge.src).add(edge);
        }
        return adjListString;
    }
}

