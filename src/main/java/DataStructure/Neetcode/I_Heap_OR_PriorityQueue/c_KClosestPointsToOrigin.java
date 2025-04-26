package DataStructure.Neetcode.I_Heap_OR_PriorityQueue;

import lombok.Data;

import java.util.Comparator;
import java.util.PriorityQueue;
//https://leetcode.com/problems/k-closest-points-to-origin/description/
public class c_KClosestPointsToOrigin {
    private PriorityQueue<DistancePoint> maxHeap = null;
    private int[][] res;

    public int[][] kClosest(int[][] points, int k) {
        res = new int[k][2];
        maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int[] point : points) {
            if(maxHeap.size()<k) {
                maxHeap.add(new DistancePoint(point));
            } else if(maxHeap.peek().distance > DistancePoint.euclideanDistance(point)){
                maxHeap.poll();
                maxHeap.add(new DistancePoint(point));
            }
        }
        System.out.println(maxHeap);
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll().xy;
        }
        return res;
    }

    public static void main(String[] args) {
        new c_KClosestPointsToOrigin().kClosest(new int[][]{{1,3},{-2,2}}, 1);
    }
}

@Data
class DistancePoint implements Comparable {
    double distance;
    int[] xy;

    public DistancePoint(int[] xy) {
        this.xy = xy;
        this.distance =  euclideanDistance(xy);
    }

    @Override
    public int compareTo(Object o) {
        if(this.distance == ((DistancePoint)o).distance) return 0;
        else if (this.distance < ((DistancePoint)o).distance) return -1;
        else return 1;
    }

    public static double euclideanDistance(int[] xy) {
        return Math.sqrt(Math.pow((xy[0]-0),2) + Math.pow((xy[1]-0), 2));
    }
}
