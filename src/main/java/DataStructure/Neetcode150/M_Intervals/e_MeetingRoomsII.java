package DataStructure.Neetcode150.M_Intervals;

import java.util.ArrayList;
import java.util.List;
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
        intervals.sort((x,y)->Integer.compare(x.start, y.start));
        var count = 0;
        while (!intervals.isEmpty()) {
            count++;
            var conflictMeets = new ArrayList<Interval>();
            for (int i = 1; i < intervals.size(); ) {
                if(intervals.get(i-1).end > intervals.get(i).start) {
                    int conflictIndex = (intervals.get(i - 1).end > intervals.get(i).end) ? (i - 1) : (i);
                    conflictMeets.add(intervals.get(conflictIndex));
                    intervals.remove(conflictIndex);
                } else {
                    i++;
                }
            }
            intervals = conflictMeets;
        }
        return count;
    }
}
