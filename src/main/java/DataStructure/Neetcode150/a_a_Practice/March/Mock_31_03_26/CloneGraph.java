package DataStructure.Neetcode150.a_a_Practice.March.Mock_31_03_26;

import java.util.*;
import lombok.*;

public class CloneGraph {
    public static void main(String[] args) {
        var adjList = new int[][] {{2,4},{1,3},{2,4},{1,3}};
        Node one = new Node(1, new ArrayList<>());
        Node two = new Node(2, new ArrayList<>());
        Node three = new Node(3, new ArrayList<>());
        Node four = new Node(4, new ArrayList<>());
        one.neighbors.addAll(List.of(two,four));
        two.neighbors.addAll(List.of(one,three));
        three.neighbors.addAll(List.of(two,four));
        four.neighbors.addAll(List.of(one,three));

        System.out.println(new CloneGraph().cloneGraph(one));
    }
    public Node cloneGraph(Node node) {
        var visited = new HashMap<Integer, Node>();
        return dfs(node, visited);
    }

    private Node dfs(Node node, HashMap<Integer, Node> visited) {
        if(node==null)
            return null;
        if(visited.containsKey(node.val))
            return visited.get(node.val);

        var newNode = new Node(node.val);
        visited.put(node.val, newNode);

        if(null != node.neighbors && !node.neighbors.isEmpty()) {
            for (Node neighbor : node.neighbors) {
                if (newNode.neighbors == null) {
                    newNode.neighbors = new ArrayList<>();
                }
                newNode.neighbors.add(dfs(neighbor, visited));
            }
        }
        return newNode;
    }
/*

**Example 1:**
```
Input: adjList = {{2,4},{1,3},{2,4},{1,3}}
Output: {{2,4},{1,3},{2,4},{1,3}}
```
 */
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Node {
    public int val;
    public List<Node> neighbors;
    public Node(int val) {
        this.val=val;
    }
}