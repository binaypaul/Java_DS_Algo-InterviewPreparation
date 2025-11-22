package DataStructure.Neetcode150.K_Graph;

import java.util.*;

public class h_CourseSchedule {
    public static void main(String[] args) {
        int[][] preReqs = new int[][] {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(new h_CourseSchedule().canFinish(4, preReqs));
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;
        var srcDestsMap = new HashMap<Integer, Set<Integer>>(numCourses);
        for (int[] prerequisite : prerequisites) {
            if(!srcDestsMap.containsKey(prerequisite[1])) {
                var destsSet = new HashSet<Integer>();
                destsSet.add(prerequisite[0]);
                srcDestsMap.put(prerequisite[1], destsSet);
            } else {
                srcDestsMap.get(prerequisite[1]).add(prerequisite[0]);
            }
        }
        var visit = new HashSet<Integer>();
        var recStack = new HashSet<Integer>();
        for(Integer src : srcDestsMap.keySet()) {
            if(!visit.contains(src)) {
                if (!dfs(src, srcDestsMap, visit, recStack)) {
                    return false;
                }
            }
        }
        return visit.size()<=numCourses;
    }

    private boolean dfs(Integer src, HashMap<Integer, Set<Integer>> srcDestsMap, HashSet<Integer> visit, HashSet<Integer> recStack) {
        visit.add(src);
        recStack.add(src);
        var dests = srcDestsMap.get(src);
        if(dests!=null) {
            for (Integer dest : dests) {
                if(recStack.contains(dest))
                    return false;
                if(!visit.contains(dest)) {
                    if(!dfs(dest, srcDestsMap, visit, recStack)) {
                        return false;
                    }
                }
            }
        }
        recStack.remove(src);
        return true;
    }
}
