package DataStructure.Topics.Graph.AdjacencyList;

import java.util.HashSet;

public class AdjList {
    public static void main(String[] args) {
        //         ----
        //        |   |
        // 0  --- 1---
        //        |
        //        |
        // 2 ---  3
        //Above graph can be craeted as:
        AdjListNode zero  = new AdjListNode(0, new HashSet(){{add(1);}});
        AdjListNode one   = new AdjListNode(1, new HashSet(){{add(1);add(0);add(3);}});
        AdjListNode two   = new AdjListNode(2, new HashSet(){{add(3);}});
        AdjListNode three = new AdjListNode(3, new HashSet(){{add(1);add(2);}});

        String[][] edges = new String[][] {{"A","B"},{"B","C"},{"B","E"},{"C","E"},{"E","D"}};
        System.out.println(AdjListMap.createAdjList(edges));
    }
}

