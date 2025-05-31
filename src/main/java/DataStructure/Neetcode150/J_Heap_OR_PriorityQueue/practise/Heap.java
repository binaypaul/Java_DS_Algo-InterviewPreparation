package DataStructure.Neetcode150.J_Heap_OR_PriorityQueue.practise;

import java.util.Arrays;

/**
 * default order: minHeap
 * reverseOrder == true: maxHeap
 * reverseOrder == false: minHeap
 */
public class Heap {
    Integer[] heap = null;
    boolean reverseOrder;
    int curSize;
    int maxSize;

    public Heap(int maxSize) {
        this.heap = new Integer[maxSize+1];
        this.maxSize = maxSize;
    }
    public Heap(int maxSize, boolean reverseOrder) {
        this.heap = new Integer[maxSize+1];
        this.reverseOrder = reverseOrder;
        this.maxSize = maxSize;
    }

    public Integer[] heapify(int [] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(curSize==maxSize) return this.heap;
            this.heap[i+1] = nums[i];
            curSize++;
            //percolate up, as new element is added towards the end
            int j = i+1;
            while ((j > 1) && (this.reverseOrder ? (this.heap[j/2] < this.heap[j]) : (this.heap[j/2] > this.heap[j]))) {
                int temp = this.heap[j/2];
                this.heap[j/2] = this.heap[j];
                this.heap[j] = temp;

                j=j/2;
            }
        }
        return heap;
    }

    public boolean add(int num) {
        if(curSize==maxSize) return false;
        this.heap[++curSize] = num;

        int j = curSize;
        while ((j > 1) && (this.reverseOrder ? (this.heap[j/2] < this.heap[j]) : (this.heap[j/2] > this.heap[j]))) {
            int temp = this.heap[j/2];
            this.heap[j/2] = this.heap[j];
            this.heap[j] = temp;

            j=j/2;
        }
        return true;
    }

    public int remove() {
        if(curSize==0) return -1;
        int ret = this.heap[1];
        //percolate down, since value is returned form index 1.
        int j = 1;
        while ((j*2) <= curSize) {
            int swapElem, swapElemIdx;
            if((j*2)+1 > curSize) {
                swapElem = this.heap[j*2];
                swapElemIdx = j*2;
            } else if (!this.reverseOrder) {
                //minHeap
                if(this.heap[j*2] <= this.heap[(j*2)+1]) {
                    swapElem = this.heap[j*2];
                    swapElemIdx = j*2;
                } else {
                    swapElem = this.heap[(j*2)+1];
                    swapElemIdx = (j*2)+1;
                }
            } else {
                // TODO: maxHeap - not correctly implemented
                if(this.heap[j*2] >= this.heap[(j*2)+1]) {
                    swapElem = this.heap[j*2];
                    swapElemIdx = j*2;
                } else {
                    swapElem = this.heap[(j*2)+1];
                    swapElemIdx = (j*2)+1;
                }
            }
            this.heap[j] = swapElem;
            j = swapElemIdx;
        }
        this.heap[j] = null;
        curSize--;
        return ret;
    }

    public static void main(String[] args) {
        Heap minHeap = new Heap(16, true);
        System.out.println(Arrays.toString(minHeap.heapify(new int[] {16,15,14,13,12,11,10,9,8,7,6,5,4,3})));
        System.out.println(minHeap.add(1));
        System.out.println(Arrays.toString(minHeap.heap));
        System.out.println(minHeap.add(2));
        System.out.println(Arrays.toString(minHeap.heap));
        System.out.println(minHeap.add(3));
        System.out.println(Arrays.toString(minHeap.heap));
        System.out.println(minHeap.remove());
        System.out.println(Arrays.toString(minHeap.heap));
        System.out.println(minHeap.remove());
        System.out.println(Arrays.toString(minHeap.heap));
    }
}
