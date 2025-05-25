package DataStructure.Topics.Graph.AdjacencyList.AdjListMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//GraphUsingMap
public class AdjListMap {
    static Map<Integer, Set<EdgeI>> adjListInt;
    static Map<String, Set<EdgeS>> adjListString;

    public static Map<Integer, Set<EdgeI>> createDirectedAdjList(EdgeI[] edges) {
        adjListInt = new HashMap<>();
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

    public static Map<Integer, Set<EdgeI>> createUndirectedAdjList(EdgeI[] edges) {
        adjListInt = new HashMap<>();
        for(EdgeI edge : edges) {
            if(!adjListInt.containsKey(edge.src)) {
                adjListInt.put(edge.src, new HashSet<>());
            }
            if(!adjListInt.containsKey(edge.dest)) {
                adjListInt.put(edge.dest, new HashSet<>());
            }
            adjListInt.get(edge.src).add(edge);
            adjListInt.get(edge.dest).add(new EdgeI(edge.dest, edge.src, edge.weight));
        }
        return adjListInt;
    }

    public static Map<String, Set<EdgeS>> createDirectedAdjList(EdgeS[] edges) {
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

    public static Map<String, Set<EdgeS>> createUndirectedAdjList(EdgeS[] edges) {
        adjListString = new HashMap<>();
        for(EdgeS edge : edges) {
            if(!adjListString.containsKey(edge.src)) {
                adjListString.put(edge.src, new HashSet<>());
            }
            if(!adjListString.containsKey(edge.dest)) {
                adjListString.put(edge.dest, new HashSet<>());
            }
            adjListString.get(edge.src).add(edge);
            adjListString.get(edge.dest).add(new EdgeS(edge.dest, edge.src, edge.weight));
        }
        return adjListString;
    }
}

