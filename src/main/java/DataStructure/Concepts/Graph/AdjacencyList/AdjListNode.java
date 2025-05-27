package DataStructure.Concepts.Graph.AdjacencyList;

import java.util.Set;

//UnDirectionalGraphUsingNode
public class AdjListNode {
    int val;
    Set<Integer> neighbours;
    public AdjListNode(int val, Set<Integer> neighbours) {
        this.val = val;
        this.neighbours = neighbours;
    }
}
