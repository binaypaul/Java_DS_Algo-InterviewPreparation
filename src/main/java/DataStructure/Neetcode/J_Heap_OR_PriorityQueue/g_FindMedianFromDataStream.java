package DataStructure.Neetcode.J_Heap_OR_PriorityQueue;

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
        System.out.println(num);
        int minc = minHeap.size();
        int maxc = maxHeap.size();
        int count = minc + maxc;
        if(count < 2) {
            if(count == 0) {
                minHeap.add(num);
            } else {
                if(num < minHeap.peek()) {
                    maxHeap.add(num);
                } else {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(num);
                }
            }
        } else {
            if(num > maxHeap.peek()) {
                if(num > minHeap.peek()) {
                    if(minc > maxc) {
                        maxHeap.add(minHeap.poll());
                    }
                    minHeap.add(num);
                } else {
                    if(minc <= maxc) {
                        minHeap.add(num);
                    } else {
                        maxHeap.add(num);
                    }
                }
            } else if(num < maxHeap.peek()) {
                if (maxc > minc) {
                    minHeap.add(maxHeap.poll());
                }
                maxHeap.add(num);
            } else if (num > minHeap.peek()) {
                if(minc > maxc) {
                    maxHeap.add(minHeap.poll());
                }
                minHeap.add(num);
            } else if (num < minHeap.peek()) {
                if(num < maxHeap.peek()) {
                    if(maxc > minc) {
                        minHeap.add(maxHeap.poll());
                    }
                    maxHeap.add(num);
                } else {
                    if(minc <= maxc) {
                        minHeap.add(num);
                    } else {
                        maxHeap.add(num);
                    }
                }
            }
        }
    }

    public double findMedian() {
        if(maxHeap.size() == minHeap.size()) {
            return (((double) (minHeap.peek() + (double)maxHeap.peek())) /2);
        } else if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }
}

public class g_FindMedianFromDataStream {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        MedianFinder mf = new MedianFinder(); sb.append("[null,");
        mf.addNum(78);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(14);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(50);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(20);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(13);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(9);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(25);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(8);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(13);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(37);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(29);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(33);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(55);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(52);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(6);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(17);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(65);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(23);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(74);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(43);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(5);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(29);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(29);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(72);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(7);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(13);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(56);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(21);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(31);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(66);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(69);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(69);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(74);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(12);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(77);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(23);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(10);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(6);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(27);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(63);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(77);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(21);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(40);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(10);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(19);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(59);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(35);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(40);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(44);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(4);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(15);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(29);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(63);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(27);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(46);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(56);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(0);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(60);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(72);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(35);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(54);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(50);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(14);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(29);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(62);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(24);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(18);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(79);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(16);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(19);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(8);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(77);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(10);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(21);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(66);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(42);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(76);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(14);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(58);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(20);
        sb.append(mf.findMedian()); sb.append("000,");
        mf.addNum(0);
        sb.append(mf.findMedian()); sb.append("000]");

        System.out.println(sb);
    }
}
//8,2,7,4,9,5,1,3,6,6
//1,2,3,4,5,6,6,6,7,8,9