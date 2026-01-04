package DataStructure.Neetcode150.M_Intervals;

import java.util.*;

//https://neetcode.io/problems/meeting-schedule-ii
public class e_MeetingRoomsII {
    public static void main(String[] args) {
        System.out.println(
                new e_MeetingRoomsII().minMeetingRooms(new ArrayList<Interval>(){{
                    add(new Interval(1,5));
                    add(new Interval(2,6));
                    add(new Interval(3,7));
                    add(new Interval(4,8));
                    add(new Interval(5,9));
                }})
        );
    }
    public int minMeetingRooms(List<Interval> intervals) {
        int minRooms = 1;
        var pq = new PriorityQueue<Integer>(); //min heap containing end time of intervals
        pq.add(intervals.getFirst().end);

        for (int i = 1; i < intervals.size(); i++) {
            while (!pq.isEmpty() && pq.peek() <= intervals.get(i).start) {
                pq.poll();
            }
            pq.add(intervals.get(i).end);

            minRooms = Math.max(minRooms, pq.size());
        }
        return minRooms;
    }
}
