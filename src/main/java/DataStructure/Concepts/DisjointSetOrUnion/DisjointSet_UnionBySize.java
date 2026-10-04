package DataStructure.Concepts.DisjointSetOrUnion;

import java.util.*;

public class DisjointSet_UnionBySize {
    ArrayList<Integer> size = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();

    public DisjointSet_UnionBySize(int n) {
        for (int i = 0; i <= n; i++) {
            size.add(1);
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

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u==ulp_v) return;

        int ulp_u_size = size.get(ulp_u);
        int ulp_v_size = size.get(ulp_v);

        if(ulp_u_size < ulp_v_size) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, ulp_v_size+ulp_u_size);
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, ulp_v_size+ulp_u_size);
        }
    }

    public static void main(String[] args) {
        DisjointSet_UnionBySize ds = new DisjointSet_UnionBySize(7);
        ds.unionBySize(1,2);
        ds.unionBySize(2,3);
        ds.unionBySize(4,5);
        ds.unionBySize(6,7);
        ds.unionBySize(5,6);
        //if 3 and 7 belong to same tree or not
        System.out.println(ds.findUPar(3) == ds.findUPar(7));
        ds.unionBySize(3,7);
        System.out.println(ds.findUPar(3) == ds.findUPar(7));
    }
}