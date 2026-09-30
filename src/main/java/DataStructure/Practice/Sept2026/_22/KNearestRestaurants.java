package DataStructure.Practice.Sept2026._22;

import java.util.*;

public class KNearestRestaurants {
    public int[][] kNearestRestaurants(int[][] restaurants, int customerX, int customerY, int k) {
        var map = new HashMap<Double, List<int[]>>();
        var pq = new PriorityQueue<Double>(Comparator.reverseOrder());
        for (int[] restaurant : restaurants) {
            double dis = Math.sqrt(Math.pow(customerX-restaurant[0] ,2) + Math.pow(customerY-restaurant[1] ,2));

            while (!pq.isEmpty() && pq.size()>=k && dis < pq.peek()) {
                map.remove(pq.poll());
            }
            if(pq.size()<k) {
                pq.offer(dis);
                map.computeIfAbsent(dis, key -> new ArrayList<>()).add(restaurant);
            }
        }
        return map.values().stream().flatMap(corL -> corL.stream()).toArray(size->new int[size][]);
    }

    public static void main(String[] args) {
        KNearestRestaurants kNearestRestaurants = new KNearestRestaurants();
        int[][] restaurants = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int customerX = 0;
        int customerY = 0;
        int k = 2;
        var ret = kNearestRestaurants.kNearestRestaurants(restaurants, customerX, customerY, k);
        System.out.println(Arrays.deepToString(ret));
    }
}
