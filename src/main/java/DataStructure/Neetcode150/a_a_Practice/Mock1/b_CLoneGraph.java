package DataStructure.Neetcode150.a_a_Practice.Mock1;

import java.util.*;

public class b_CLoneGraph {

    Map<Integer, Node> visited = new HashMap<>();
    public Node cloneGraph(Node root) {
        Node clone = null;
        if(root == null) {
            return null;
        } else if(visited.containsKey(root.val)) {
            return visited.get(root.val);
        } else {
            clone = new Node();
            clone.val = root.val;
            visited.put(clone.val, clone);
            if(root.neighbors != null) {
                var neighbors = new ArrayList<Node>();
                for (Node neighbor : root.neighbors) {
                    neighbors.add(cloneGraph(neighbor));
                }
                clone.neighbors = neighbors;
            }
        }
        return clone;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
}