package DataStructure.Neetcode150.J_Heap_OR_PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
//https://leetcode.com/problems/kth-largest-element-in-an-array/description/
public class f_KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums) {
            pq.offer(num);
        }
        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            ret = pq.poll();
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new f_KthLargestElementInAnArray().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
