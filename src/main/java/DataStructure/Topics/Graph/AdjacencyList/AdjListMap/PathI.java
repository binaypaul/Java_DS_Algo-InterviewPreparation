package DataStructure.Topics.Graph.AdjacencyList.AdjListMap;

/**
 * Path and edge are used for better understanding. <p/>
 * Path :
 *       "src" node is the first edge's src node.
 *       "dest" node is last edge's dest node.
 *       "weight" is the sum of weight of all the edges in the path.
 */

public class PathI extends EdgeI{
    public PathI(int src, int dest) {
        super(src, dest);
    }
    public PathI(int src, int dest, int weight) {
        super(src, dest, weight);
    }
}
