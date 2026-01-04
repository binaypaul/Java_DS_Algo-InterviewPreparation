package DataStructure.Neetcode150.a_a_Practice.Mock5_4Q90Min;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        int[][] prerequisites = {{0,0}};
        System.out.println(new CourseSchedule().finishCourses(1, prerequisites));
    }

    public boolean finishCourses(int numCourses, int[][] prerequisites) {
        var adjList = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < prerequisites.length; i++) {
            int[] prereq = prerequisites[i];

            adjList.compute(prereq[1], (k,v)-> {
               if(v==null) {
                   v = new HashSet<Integer>();
               }
                v.add(prereq[0]);
               return v;
            });
        }
        for (int i = 0; i < numCourses; i++) {
            adjList.computeIfAbsent(i, (v) -> null);
        }

        var visited = new HashSet<Integer>();
        var recstack = new HashSet<Integer>();

        for (Integer src : adjList.keySet()) {
            if(!visited.contains(src)) {
                if(!toposort(src, adjList, visited, recstack)) {
                    return false;
                }
            }
        }
        return visited.size() <= numCourses;
    }

    private boolean toposort(Integer src, HashMap<Integer, Set<Integer>> adjList, HashSet<Integer> visited, HashSet<Integer> recstack) {
        visited.add(src);
        recstack.add(src);
        var dests = adjList.get(src);
        if(null != dests) {
            for (Integer dest : dests) {
                if (recstack.contains(dest)) {
                    return false;
                }
                if(!visited.contains(dest)) {
                    if(!toposort(dest, adjList, visited, recstack)) {
                        return false;
                    }
                }

            }
        }
        recstack.remove(src);
        return true;
    }
}
