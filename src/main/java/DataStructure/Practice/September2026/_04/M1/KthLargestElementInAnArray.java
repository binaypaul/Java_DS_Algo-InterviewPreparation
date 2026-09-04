package DataStructure.Practice.September2026._04.M1;

import java.util.*;

public class KthLargestElementInAnArray {
    /*
    int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
    int k = 4;
     */
    public int findKthLargest(int[] nums, int k) {
        // Your implementation here
        if(nums.length<k) return -1;

        var pq = new PriorityQueue<Integer>(k);
        for (int num : nums) {
            if(pq.size()==k){
                if(num<pq.peek()) {
                    continue;
                } else {
                    pq.poll();
                }
            }
            pq.offer(num);
        }
        return !pq.isEmpty()?pq.peek():-1;
    }
    public static void main(String[] args) {
        System.out.println(new KthLargestElementInAnArray().findKthLargest(new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
