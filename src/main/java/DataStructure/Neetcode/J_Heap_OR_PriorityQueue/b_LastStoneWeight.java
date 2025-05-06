package DataStructure.Neetcode.J_Heap_OR_PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
//https://leetcode.com/problems/last-stone-weight/

public class b_LastStoneWeight {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public int lastStoneWeight(int[] stones) {
        for (int stone : stones) {
            maxHeap.add(stone);
        }
        while (maxHeap.size() >= 2) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if(y > x) {
                maxHeap.add(y-x);
            }
        }

        return maxHeap.size() == 0 ? 0 : maxHeap.poll();
    }

    public static void main(String[] args) {
        b_LastStoneWeight stoneWeight = new b_LastStoneWeight();
        System.out.println(stoneWeight.lastStoneWeight(new int[]{1}));
    }
}
//[8,7,4,2,1,1]
//[4,2,1,1,1]
//[2,1,1,1]
//[1,1,1]
//[1]