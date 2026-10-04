package DataStructure.Practice.Oct2026;

import java.util.*;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Node, Node> visited = new HashMap<>();
        return dfs(node, visited);
    }

    private Node dfs(Node node, HashMap<Node, Node> visited) {
        if(node==null) return null;
        if(visited.containsKey(node)) return visited.get(node);

        Node clonedNode = new Node(node.val);
        visited.put(node, clonedNode);
        for (Node neighbor : node.neighbors) {
            if(clonedNode.neighbors==null) {
                clonedNode.neighbors = new ArrayList<>(node.neighbors.size());
            }
            clonedNode.neighbors.add(dfs(neighbor, visited));
        }
        return clonedNode;
    }

    public static void main(String[] args) {
        CloneGraph cloneGraph = new CloneGraph();
        // Graph structure (adjacency list representation, 1-indexed):
        // 1 -- 2
        // |    |
        // 4 -- 3
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        one.neighbors = Arrays.asList(two, four);
        two.neighbors = Arrays.asList(one, three);
        three.neighbors = Arrays.asList(two, four);
        four.neighbors = Arrays.asList(one, three);
        Node node = one; // starting node passed to cloneGraph
        var ret = cloneGraph.cloneGraph(node);
        System.out.println(ret);
    }
}
class Node {
    public int val;
    public List<Node> neighbors;
    public Node(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }
}