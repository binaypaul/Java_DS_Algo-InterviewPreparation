package DataStructure.Neetcode.K_Graph;

import java.util.*;

//https://leetcode.com/problems/clone-graph/description/
public class c_CloneGraph_DFS {
    Map<Integer, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        Node curNode = null;
        if(node == null) {
            return null;
        } else if (visited.containsKey(node.val)) {
            return visited.get(node.val);
        } else {
            curNode = new Node(node.val);
            visited.put(node.val, curNode);
            if(node.neighbors != null) {
                List<Node> neighbors = new ArrayList<>(node.neighbors.size());
                for (Node neigh : node.neighbors) {
                    Node retNode = cloneGraph(neigh);
                    if (retNode != null) {
                        neighbors.add(retNode);
                    }
                }
                curNode.neighbors = neighbors;
            }
        }
        return curNode;
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        one.neighbors = Arrays.asList(two, four);
        two.neighbors = Arrays.asList(one, three);
        three.neighbors = Arrays.asList(four, two);
        four.neighbors = Arrays.asList(one, three);

        Node clonedGraph = new c_CloneGraph_DFS().cloneGraph(one);
        System.out.println(clonedGraph.val);
    }
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}