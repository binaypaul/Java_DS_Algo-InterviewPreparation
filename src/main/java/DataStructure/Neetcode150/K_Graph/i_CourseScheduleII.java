package DataStructure.Neetcode150.K_Graph;

import java.util.*;

public class i_CourseScheduleII {
    public static void main(String[] args) {
        int[][] preReqs = new int[][] {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(new i_CourseScheduleII().findOrder(4, preReqs)));
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        var srcDestsMap = new HashMap<Integer, HashSet<Integer>>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            srcDestsMap.put(i, new HashSet<>());
        }

        for (int[] prerequisite : prerequisites) {
            srcDestsMap.get(prerequisite[1]).add(prerequisite[0]);
        }
        System.out.println(srcDestsMap);

        var visit = new HashSet<Integer>();
        var recStack = new HashSet<Integer>();
        var res = new LinkedHashSet<Integer>();
        boolean flag = false;
        for (Integer src : srcDestsMap.keySet()) {
            if(!visit.contains(src)) {
                if (!dfs(src, srcDestsMap, visit, recStack, res)) {
                    flag = false;
                    break;
                } else {
                    flag = true;
                }
            }
        }
        System.out.println(flag);
        System.out.println(res);

        if (flag) {
            return res.stream().mapToInt(i -> i).toArray(); //converting Integer collection to int arr.
        }
        return new int[0];
    }

    private boolean dfs(Integer src, HashMap<Integer, HashSet<Integer>> srcDestsMap, HashSet<Integer> visit, HashSet<Integer> recStack, LinkedHashSet<Integer> res) {
        visit.add(src);
        recStack.add(src);

        var dests = srcDestsMap.get(src);
        if(dests!=null) {
            for (Integer dest : dests) {
                if(recStack.contains(dest)) {
                    return false; //cycle detected
                } else if(!visit.contains(dest)) {
                    if(!dfs(dest, srcDestsMap, visit, recStack, res)) {
                        return false;
                    }
                }
            }
        }

        recStack.remove(src);
        res.addFirst(src);
        return true;
    }
}
