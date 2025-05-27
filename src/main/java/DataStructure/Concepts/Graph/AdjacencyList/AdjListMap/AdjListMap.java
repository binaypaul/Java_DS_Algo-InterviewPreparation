package DataStructure.Concepts.Graph.AdjacencyList.AdjListMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//GraphUsingMap
public class AdjListMap {
    static Map<Integer, Set<EdgeI>> adjListInt;
    static Map<String, Set<EdgeS>> adjListString;

    public static Map<Integer, Set<EdgeI>> createDirectedAdjList(int[][] edges) {
        adjListInt = new HashMap<>();
        for(int[] edge : edges) {
            if(!adjListInt.containsKey(edge[0])) {
                adjListInt.put(edge[0], new HashSet<>());
            }
            if(!adjListInt.containsKey(edge[1])) {
                adjListInt.put(edge[1], new HashSet<>());
            }
            adjListInt.get(edge[0]).add(new EdgeI(edge[0], edge[1], edge.length==3?edge[2]:0));
        }
        return adjListInt;
    }

    public static Map<Integer, Set<EdgeI>> createUndirectedAdjList(int[][] edges) {
        adjListInt = new HashMap<>();
        adjListInt = new HashMap<>();
        for(int[] edge : edges) {
            if(!adjListInt.containsKey(edge[0])) {
                adjListInt.put(edge[0], new HashSet<>());
            }
            if(!adjListInt.containsKey(edge[1])) {
                adjListInt.put(edge[1], new HashSet<>());
            }
            adjListInt.get(edge[0]).add(new EdgeI(edge[0], edge[1], edge.length==3?edge[2]:0));
            adjListInt.get(edge[0]).add(new EdgeI(edge[1], edge[0], edge.length==3?edge[2]:0));
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

