package DataStructure.Neetcode150.H_Backtracking;

import java.util.*;

public class b_CombinationSumII_DoubleRecursion {
    public static void main(String[] args) {
        System.out.println(new b_CombinationSumII_DoubleRecursion().combinationSum2(
                new int[]{10,1,2,7,6,1,5}, 8
        ));
    }
    private List<Integer> cur = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    // Input: candidates = [10,1,2,7,6,1,5], target = 8
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        // Input: candidates = [1,1,2,5,6,7,10], target = 8
        dfs(candidates, target, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, int i) {
        if(target<=0 || i > candidates.length-1) {
            if(target==0 && !res.contains(cur)) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        cur.add(candidates[i]);
        dfs(candidates, target-candidates[i], i+1);
        cur.removeLast();

        dfs(candidates, target, i+1);
    }
}
