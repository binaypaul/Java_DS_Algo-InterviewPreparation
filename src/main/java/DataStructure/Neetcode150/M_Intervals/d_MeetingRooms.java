package DataStructure.Neetcode150.M_Intervals;
//https://neetcode.io/problems/meeting-schedule

import java.util.ArrayList;
import java.util.List;

public class d_MeetingRooms {
    public static void main(String[] args) {
        System.out.println(
                new d_MeetingRooms().canAttendMeetings(new ArrayList<Interval>(){{
                    add(new Interval(0,30));
                    add(new Interval(5,10));
                    add(new Interval(15,20));
                }})
        );
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((o1,o2)-> Integer.compare(o1.start, o2.start));
        for (int i = 1; i < intervals.size(); i++) {
            if(intervals.get(i-1).end > intervals.get(i).start)
                return false;
        }
        return true;
    }
}