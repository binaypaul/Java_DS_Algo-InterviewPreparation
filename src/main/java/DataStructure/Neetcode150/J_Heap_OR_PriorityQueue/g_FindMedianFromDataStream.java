package DataStructure.Neetcode150.J_Heap_OR_PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/find-median-from-data-stream/description/
class MedianFinder {
    private Queue<Integer> minHeap = null;
    private Queue<Integer> maxHeap = null;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        if(maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        if(maxHeap.size() > minHeap.size()+1) {
            minHeap.offer(maxHeap.poll());
        }
        if(minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
         if(maxHeap.size() == minHeap.size()) {
             return (maxHeap.peek()+ minHeap.peek())/2.0;
         } else {
             return maxHeap.peek();
         }
    }
}

public class g_FindMedianFromDataStream {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        System.out.println(mf.findMedian());
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
        mf.addNum(4);
        System.out.println(mf.findMedian());
        mf.addNum(5);
        System.out.println(mf.findMedian());
        System.out.println("Hello");
        System.out.println("Hello");
        int max = 6;
        int i = max + 1;
        double time = 12.44;
    }
}