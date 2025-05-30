package DataStructure.Neetcode150.J_Heap_OR_PriorityQueue;

public class Heap {
    //order of heap is minHeap when reverseOrder is false
    //order of heap is maxHeap when reverseOrder is true
    public static Integer[] heapify(int [] nums, boolean reverseOrder) {
        Integer[] heap = new Integer[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            heap[i+1] = nums[i];

            //percolate up
            int j = i+1;
            while (j > 1 && (reverseOrder ? heap[j] > heap[j/2] : heap[j] < heap[j/2])) {
                //swap newly added elem with its parent elem.
                int temp = heap[j/2];
                heap[j/2] = heap[j];
                heap[j] = temp;
                j = j/2;
            }
        }
        return heap;
    }
}
