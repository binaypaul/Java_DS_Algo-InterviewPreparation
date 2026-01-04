package DataStructure.Neetcode150.a_a_Practice.Mock5_4Q90Min;

import java.util.*;

public class MeetingRoomsII {
    public static void main(String[] args) {
        int[][] intervals = {{7,10}, {2,4}};
        System.out.println(new MeetingRoomsII().countMeetingRooms(intervals));
    }

    private int countMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((x) -> x[0]));
        int maxSize = 1;
        var pq = new PriorityQueue<Integer>();
        pq.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            while (!pq.isEmpty() && intervals[i][0] >= pq.peek()) {
                    pq.poll();
            }
            pq.add(intervals[i][1]);
            maxSize = Math.max(maxSize, pq.size());
        }
        return maxSize;
    }
}
