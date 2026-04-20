package DataStructure.Neetcode150.a_a_Practice.April.Mock_17_04_26;

import java.util.*;

public class KthLargestElementInAnArray {
    public static int findKthLargest(int[] nums, int k) {
        var pq = new PriorityQueue<Integer>();
        for (int num : nums) {
            if(pq.size()>k)
                pq.remove();
            pq.add(num);
        }
        int ret = 0;
        for (int i = 0; i < k; i++) {
            ret = pq.remove();
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(KthLargestElementInAnArray.findKthLargest(
                new int[]{3,2,1,5,6,4} ,2
        ));
    }
}
/*
Example 1:

Input: nums = [3,2,1,5,6,4], k = 2

Output: 5
 */