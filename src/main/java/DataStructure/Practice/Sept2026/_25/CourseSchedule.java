package DataStructure.Practice.Sept2026._25;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var adjMap = new HashMap<Integer, ArrayList<Integer>>();
        for (int[] pr : prerequisites) {
            adjMap.computeIfAbsent(pr[1], k-> new ArrayList<>()).add(pr[0]);
        }
        System.out.println(adjMap);

        var visited = new HashSet<Integer>();
        var recStack = new HashSet<Integer>();

        for (Integer src : adjMap.keySet()) {
            if(!visited.contains(src)) {
                if(!topo(src, adjMap, visited, recStack))
                    return false;
            }
        }
        return visited.size() <= numCourses;
    }

    private boolean topo(Integer src, HashMap<Integer, ArrayList<Integer>> adjMap, HashSet<Integer> visited, HashSet<Integer> recStack) {
        visited.add(src);
        recStack.add(src);

        var dests = adjMap.get(src);
        if(dests!=null) {
            for (Integer dest : dests) {
                if (recStack.contains(dest))
                    return false;
                if (!visited.contains(dest)) {
                    if (!topo(dest, adjMap, visited, recStack))
                        return false;
                }
            }
        }
        recStack.remove(src);
        return true;
    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {3, 2}, {2, 3}};
        var ret = courseSchedule.canFinish(numCourses, prerequisites);
        System.out.println(ret);
    }
}
