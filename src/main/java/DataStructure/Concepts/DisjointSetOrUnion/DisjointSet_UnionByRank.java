package DataStructure.Concepts.DisjointSetOrUnion;

import java.util.*;
// Rank acts as an upper bound on its tree's height
// "upper bound" on the tree's height means: the tree's actual height will never be greater than the rank, but it can sometimes be smaller (after path compression.)
public class DisjointSet_UnionByRank {
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();
    
    public DisjointSet_UnionByRank(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findUPar(int node) {
        if(parent.get(node)==node) {
            return node;
        }

        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return ulp;
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u==ulp_v) return;

        if(rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if(rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u)+1);
        }
    }

    public static void main(String[] args) {
        DisjointSet_UnionByRank ds = new DisjointSet_UnionByRank(7);
        ds.unionByRank(1,2);
        ds.unionByRank(2,3);
        ds.unionByRank(4,5);
        ds.unionByRank(6,7);
        ds.unionByRank(5,6);
        //if 3 and 7 belong to same tree or not
        System.out.println(ds.findUPar(3) == ds.findUPar(7));
        ds.unionByRank(3,7);
        System.out.println(ds.findUPar(3) == ds.findUPar(7));
    }
}
