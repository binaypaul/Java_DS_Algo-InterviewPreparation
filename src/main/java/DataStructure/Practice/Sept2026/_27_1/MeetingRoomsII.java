package DataStructure.Practice.Sept2026._27_1;

import java.util.*;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval->interval[0]));
        var pq = new PriorityQueue<Integer>();

        int max = 1;
        for (int[] interval : intervals) {
            while (!pq.isEmpty() && pq.peek()<=interval[0]) {
                pq.poll();
            }
            pq.offer(interval[1]);

            max = Math.max(max, pq.size());
        }
        return max;
    }

    public static void main(String[] args) {
        MeetingRoomsII meetingRoomsIi = new MeetingRoomsII();
        int[][] intervals = {{0, 30}, {5, 10}, {9,13}, {15, 20}, {18,25}, {32,40}, {41,43}};
        var ret = meetingRoomsIi.minMeetingRooms(intervals);
        System.out.println(ret);
    }
}
