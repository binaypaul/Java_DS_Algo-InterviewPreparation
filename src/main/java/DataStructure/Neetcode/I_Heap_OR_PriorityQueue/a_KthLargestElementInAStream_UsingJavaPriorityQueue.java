package DataStructure.Neetcode.I_Heap_OR_PriorityQueue;

import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
public class a_KthLargestElementInAStream_UsingJavaPriorityQueue {

    private int k;
    private int[] nums;
    private PriorityQueue<Integer> minHeap = null;

    public a_KthLargestElementInAStream_UsingJavaPriorityQueue(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        this.minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            this.add(num);
        }
    }

    public int add(int val) {
        if(this.minHeap.size() < k) {
            this.minHeap.add(val);
        } else {
            if(val > this.minHeap.peek()) {
                this.minHeap.poll();
                this.minHeap.add(val);
            }
        }
        return this.minHeap.peek();
    }

    public static void main(String[] args) {
        a_KthLargestElementInAStream_UsingJavaPriorityQueue kthLargest
                = new a_KthLargestElementInAStream_UsingJavaPriorityQueue(4, new int[]{7,7,7,7,8,3});
        System.out.println(kthLargest.add(2));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(9));
    }
}
