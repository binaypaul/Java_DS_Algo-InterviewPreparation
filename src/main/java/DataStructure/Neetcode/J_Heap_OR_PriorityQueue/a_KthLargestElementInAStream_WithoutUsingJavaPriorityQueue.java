package DataStructure.Neetcode.J_Heap_OR_PriorityQueue;
//https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
public class a_KthLargestElementInAStream_WithoutUsingJavaPriorityQueue {
    private int k;
    private int[] nums;
    private Integer[] minHeap;

    int prevElemIdx;

    public a_KthLargestElementInAStream_WithoutUsingJavaPriorityQueue(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        this.minHeap = new Integer[k+1];
        this.prevElemIdx = 0;

        for(int num : nums) {
            this.add(num);
        }
    }

    public int add(int val) {
        if(this.prevElemIdx < this.k) {
            this.minHeap[++prevElemIdx] = val;

            //percolate up
            int l = this.prevElemIdx;
            while (l > 1 && this.minHeap[l] < this.minHeap[l/2]) {
                //swap
                int temp = this.minHeap[l];
                this.minHeap[l] = this.minHeap[l/2];
                this.minHeap[l/2] = temp;

                l = l/2;
            }
        } else if(val > this.minHeap[1]) {
            int i = 1;
            this.minHeap[i] = val;

            //percolate down
            while((i*2 < this.minHeap.length && this.minHeap[i] > this.minHeap[i*2])
                    || ((i*2+1) < this.minHeap.length && this.minHeap[i] > this.minHeap[(i*2)+1])) {

                //if (i*2)+1 is out of bound, then swap with i*2
                //swap with smaller elem among i*2 and (i*2)+1
                int j = ((((i*2)+1) >= this.minHeap.length) || (this.minHeap[i*2] < this.minHeap[(i*2)+1]) ? (i*2) : ((i*2) + 1));
                int temp = this.minHeap[j];
                this.minHeap[j] = this.minHeap[i];
                this.minHeap[i] = temp;
                i=j;
            }
        }
        return this.minHeap[1];
    }

    public static void main(String[] args) {
        a_KthLargestElementInAStream_WithoutUsingJavaPriorityQueue kthLargest
                = new a_KthLargestElementInAStream_WithoutUsingJavaPriorityQueue(4, new int[]{7,7,7,7,8,3});
        System.out.println(kthLargest.add(2));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(9));
    }
}
