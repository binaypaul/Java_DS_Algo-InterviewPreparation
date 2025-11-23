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
        //maxHeap to store smaller half of total elements
        //minHeap to store greater half of total elements
        if(maxHeap.isEmpty()) {
            maxHeap.add(num);
        } else if(num > maxHeap.peek()) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }
        //rebalancing heap
        //minHeap can be equal or 1 less than maxHeap
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.remove());
        }
        //maxHeap size can be equal or 1 greater than minHeap
        if(maxHeap.size()-minHeap.size() > 1) {
            minHeap.add(maxHeap.remove());
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
    }
}