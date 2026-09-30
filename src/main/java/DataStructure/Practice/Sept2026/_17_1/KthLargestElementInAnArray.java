package DataStructure.Practice.Sept2026._17_1;

import java.util.*;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length==0 || k>nums.length) return -1;
        if(nums.length==1) return nums[0];

        var pq = new PriorityQueue<Integer>();
        for (int num : nums) {
            if(pq.size()<k) {
                pq.offer(num);
            } else if(pq.size()==k && num > pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray kthLargestElementInAnArray = new KthLargestElementInAnArray();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        var ret = kthLargestElementInAnArray.findKthLargest(nums, k);
        System.out.println(ret);
    }
}
