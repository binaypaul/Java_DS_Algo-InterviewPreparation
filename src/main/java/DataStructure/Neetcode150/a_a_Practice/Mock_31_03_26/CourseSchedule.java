package DataStructure.Neetcode150.a_a_Practice.Mock_31_03_26;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        System.out.println(new CourseSchedule().canFinish(
                2, new int[][]{}
        ));
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0) return true;

        var adjMap = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            adjMap.put(i, new HashSet<>());
        }
        for (int[] preq : prerequisites) {
            adjMap.get(preq[1]).add(preq[0]);
        }

        var visited = new HashSet<Integer>();
        var recstack = new HashSet<Integer>();
        for (Integer src : adjMap.keySet()) {
            if(!visited.contains(src)) {
                if(!dfs(adjMap, src, visited, recstack)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(
            HashMap<Integer, Set<Integer>> adjMap,
            Integer src,
            HashSet<Integer> visited,
            HashSet<Integer> recstack
    ) {
        visited.add(src);
        recstack.add(src);
        var dests = adjMap.get(src);
        for (Integer dest : dests) {
            if(recstack.contains(dest)) {
                return false;
            }
            if(!visited.contains(dest)) {
                if(!dfs(adjMap, dest, visited, recstack)) {
                    return false;
                }
            }
        }
        recstack.remove(src);
        return true;
    }
/*
        **Constraints:**
- `1 <= numCourses <= 2000`
- `0 <= prerequisites.length <= 5000`
- `prerequisites[i].length == 2`
- `0 <= ai, bi < numCourses`
- All the pairs `prerequisites[i]` are unique

**Example 1:**
```
Input: numCourses = 2, prerequisites = {{1,0}}
Output: true
Explanation: Take course 0 first, then course 1.
```

**Example 2:**
```
Input: numCourses = 2, prerequisites = {{1,0},{0,1}}
Output: false
Explanation: To take course 1 you need course 0, and to take course 0 you need course 1 → cycle!
```

**Visual:**
```
Example 1:  0 → 1       (no cycle, valid)
Example 2:  0 → 1 → 0   (cycle, invalid)
*/
}
