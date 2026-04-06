package DataStructure.Neetcode150.a_a_Practice.March.Mock_27_03_26;

import java.util.*;
import lombok.*;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        var visited = new HashMap<Integer, Node>();
        return dfs(node, visited);

    }

    private Node dfs(Node node, HashMap<Integer, Node> visited) {
        if(null==node) return null;
        if(visited.containsKey(node.val)) return visited.get(node.getVal());

        Node cNode = new Node(node.val);
        visited.put(node.val, cNode);

        if(node.neighbors!=null) {
            var cNeighbors = new ArrayList<Node>(node.neighbors.size());
            cNode.neighbors = cNeighbors;
            if(!node.neighbors.isEmpty()) {
                for (Node neighbor : node.neighbors) {
                    Node cNeighbor = dfs(neighbor, visited);
                    if(null!=cNeighbor) {
                        cNeighbors.add(cNeighbor);
                    }
                }
            }
        }
        return cNode;
    }
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
