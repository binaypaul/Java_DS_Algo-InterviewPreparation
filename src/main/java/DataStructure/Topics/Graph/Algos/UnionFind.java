package DataStructure.Topics.Graph.Algos;

public class UnionFind {
    private int[] parent;
    private int[] rank;

    // Constructor to initialize the UnionFind data structure
    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];

        // Initially, each node is its own parent, and rank is 0
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Find operation with path compression
    public int find(int p) {
        if (parent[p] != p) {
            parent[p] = find(parent[p]);  // Path compression
        }
        return parent[p];
    }

    // Union operation with union by rank
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        // If they are already in the same set, do nothing
        if (rootP == rootQ) return;

        // Union by rank: attach the smaller tree under the larger tree
        if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        } else if (rank[rootP] > rank[rootQ]) {
            parent[rootQ] = rootP;
        } else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
    }

    // Check if two elements are in the same set
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}