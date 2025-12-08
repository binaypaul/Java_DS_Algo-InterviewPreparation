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
        for (int i = 0; i < numCourses; i++) {
             srcDestsMap.put(i, new HashSet<>());
        }
        for (int[] prerequisite : prerequisites) {
            srcDestsMap.get(prerequisite[1]).add(prerequisite[0]);
        }

        //to check if this node was previously visited
        var visit = new HashSet<Integer>();
        //to check if there is a cycle in the path from src to leaf
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
