package DataStructure.Topics.Graph.AdjacencyList.AdjListMap;

/**
 * Path and edge are used for better understanding. <p/>
 * Path :
 *       "src" node is the first edge's src node.
 *       "dest" node is last edge's dest node.
 *       "weight" is the sum of weight of all the edges in the path.
 */
public class PathS extends EdgeS{
    public PathS(String src, String dest) {
        super(src, dest);
    }
    public PathS(String src, String dest, int weight) {
        super(src, dest, weight);
    }
}
