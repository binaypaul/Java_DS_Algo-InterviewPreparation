package DataStructure.Topics.Graph.AdjacencyList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//DirectionalGraphUsingMap
public class AdjListMap {
    //    also can be represented using a map:
    static Map<Integer, Set<Integer>> adjListInt;
    static Map<Character, Set<Character>> adjListChar;
    static Map<String, Set<String>> adjListString;

    public static Map<Integer, Set<Integer>> createAdjList (Integer[][] edges) {
        adjListInt = new HashMap<>();
        for(Integer[] edge : edges) {
            if(!adjListInt.containsKey(edge[0])) {
                adjListInt.put(edge[0], new HashSet<>());
            } if(!adjListInt.containsKey(edge[1])) {
                adjListInt.put(edge[1], new HashSet<>());
            }
            adjListInt.get(edge[0]).add(edge[1]);
        }
        return adjListInt;
    }

    public static Map<Character, Set<Character>> createAdjList (char[][] edges) {
        adjListChar = new HashMap<>();
        for(char[] edge : edges) {
            if(!adjListChar.containsKey(edge[0])) {
                adjListChar.put(edge[0], new HashSet<>());
            } if(!adjListChar.containsKey(edge[1])) {
                adjListChar.put(edge[1], new HashSet<>());
            }
            adjListChar.get(edge[0]).add(edge[1]);
        }
        return adjListChar;
    }

    public static Map<String, Set<String>> createAdjList (String[][] edges) {
        adjListString = new HashMap<>();
        for(String[] edge : edges) {
            if(!adjListString.containsKey(edge[0])) {
                adjListString.put(edge[0], new HashSet<>());
            } if(!adjListString.containsKey(edge[1])) {
                adjListString.put(edge[1], new HashSet<>());
            }
            adjListString.get(edge[0]).add(edge[1]);
        }
        return adjListString;
    }
}
