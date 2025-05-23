package DataStructure.Topics.Graph.AdjacencyList.AdjListMap;

import lombok.Data;

@Data
public class EdgeI {
    int src;
    int dest;
    int weight = 0;

    public EdgeI(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }

    public EdgeI(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}
