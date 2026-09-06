package DataStructure.Practice.September2026._05.M1;

import java.util.*;
import lombok.*;

public class FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // Your implementation here
        var pq = new PriorityQueue<SumPair>(Comparator.comparingInt(sp->sp.sum));
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                pq.add(new SumPair(n1+n2, List.of(n1,n2)));
            }
        }

        List<List<Integer>> listList = new ArrayList<>();
        while (listList.size()<k && !pq.isEmpty()) {
            listList.add(pq.poll().pair);
        }
        return listList;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        //OP: // [[1, 2], [1, 4], [1, 6]]
        // Explanation: The first 3 pairs are returned in order of smallest sum.
        System.out.println(new FindKPairsWithSmallestSums().kSmallestPairs(nums1, nums2, k));
    }
}


@AllArgsConstructor
class SumPair {
    int sum;
    List<Integer> pair;
}