package DataStructure.Neetcode150.M_Intervals;

import DataStructure.Neetcode150.L_1D_DP.practise.*;
import java.util.*;

//https://neetcode.io/problems/meeting-schedule-ii
public class e_MeetingRoomsII {
    public static void main(String[] args) {
        var al = new ArrayList<Interval>(){{
            add(new Interval(0,50));
            add(new Interval(10,60));
            add(new Interval(60,110));
            add(new Interval(70,120));
            add(new Interval(20,70));
            add(new Interval(30,80));
            add(new Interval(40,90));
            add(new Interval(50,100));
            add(new Interval(80,130));
            add(new Interval(90,140));
            add(new Interval(100,150));
        }};

        System.out.println(new e_MeetingRoomsII().minMeetingRooms(al));
    }
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals==null || intervals.isEmpty()) return 0;
        intervals.sort(Comparator.comparingInt(x->x.start));
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
