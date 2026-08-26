import java.util.*;
import lombok.*;

public class Test {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Test().findOrder(
                4,
                new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}} //[0,2,1,3]
        )));
    }


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        var adjMap = createAdjMap(numCourses, prerequisites);
        var visited = new HashSet<Integer>();
        var recStack = new HashSet<Integer>();
        var res = new ArrayList<Integer>();
        for (Integer src : adjMap.keySet()) {
            if(!visited.contains(src)) {
                if(!dfs(src, adjMap, visited, recStack, res)) {
                    return new int[]{};
                }
            }
        }
        if(res.size()!=numCourses) return new int[]{};

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean dfs(
            Integer src,
            Map<Integer, Set<Integer>> adjMap,
            HashSet<Integer> visited,
            HashSet<Integer> recStack,
            ArrayList<Integer> res
    ) {
        visited.add(src);
        recStack.add(src);
        var dests = adjMap.get(src);
        if(dests!=null) {
            for (Integer dest : dests) {
                if(recStack.contains(dest)) {
                    return false;
                }
                if(!visited.contains(dest)) {
                    if(!dfs(dest, adjMap, visited, recStack, res)) {
                        return false;
                    }
                }
            }
        }
        recStack.remove(src);
        res.addFirst(src);
        return true;
    }

    private Map<Integer, Set<Integer>> createAdjMap(int n, int[][] pres) {
        Map<Integer, Set<Integer>> map = new HashMap<>(n);
        for (int[] pre : pres) {
            if(map.containsKey(pre[1])) {
                map.get(pre[1]).add(pre[0]);
            } else {
                var set = new HashSet<Integer>();
                set.add(pre[0]);
                map.put(pre[1],set);
            }
        }
        return map;
    }
}