package DataStructure.Concepts.Graph.AdjacencyList.AdjListMap;

import lombok.Data;

@Data
public class EdgeS {
    String src;
    String dest;
    int weight = 0;

    public EdgeS(String src, String dest) {
        this.src = src;
        this.dest = dest;
    }

    public EdgeS(String src, String dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}
