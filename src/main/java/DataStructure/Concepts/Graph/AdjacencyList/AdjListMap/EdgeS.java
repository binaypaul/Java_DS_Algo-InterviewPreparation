package DataStructure.Concepts.Graph.AdjacencyList.AdjListMap;

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

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
