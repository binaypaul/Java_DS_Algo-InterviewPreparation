package DataStructure.Practice.September2026._03.M1;

import java.util.*;

public class MaximumConcurrentStreamingSessions {
    public Map<String, Integer> maxConcurrentSessions(List<Session> sessions) {
        // Your implementation here
        if(sessions==null) return null;

        var map = new HashMap<String, Integer>();
        if(sessions.isEmpty()) return map;

        sessions.sort(Comparator
                .<Session, String>comparing(session -> session.region)
                .thenComparing(session -> session.startTime));

        var pq = new PriorityQueue<Session>(Comparator
                .comparing(session -> session.endTime)); //tracking the endtime for a region

        Session firstSession = sessions.getFirst();
        pq.offer(firstSession);
        map.put(firstSession.region, 1);

        for (int i = 1; i < sessions.size(); i++) {
            Session cur = sessions.get(i);
            if(!pq.isEmpty() && !cur.region.equals(pq.peek().region)) {
                pq.clear();
                map.put(cur.region, 1);
                pq.offer(cur);
                continue;
            }

            while (!pq.isEmpty() && pq.peek().endTime < cur.startTime) {
                pq.poll();
            }
            pq.offer(cur);
            map.put(cur.region, Math.max(map.get(cur.region), pq.size()));
        }
        return map;
    }

    public static void main(String[] args) {
        List<Session> sessions = Arrays.asList(
                new Session("u1", "NA", 10, 20),
                new Session("u2", "NA", 15, 25),
                new Session("u3", "NA", 30, 40),
                new Session("u3", "NA", 35, 45),
                new Session("u4", "EU", 15, 30),
                new Session("u5", "EU", 35, 45)
        );
        /*
        {
          "NA": 3,
          "EU": 1
        }
         */
        System.out.println(new MaximumConcurrentStreamingSessions().maxConcurrentSessions(sessions));
    }
}

class Session {
    String userId;
    String region;
    int startTime;
    int endTime;

    public Session(String userId, String region, int startTime, int endTime) {
        this.userId = userId;
        this.region = region;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}