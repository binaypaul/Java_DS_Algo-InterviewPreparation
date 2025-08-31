package DataStructure.Concepts.Graph.AdjacencyList.AdjListMap;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
