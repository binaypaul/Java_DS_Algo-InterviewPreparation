package DataStructure.Neetcode150.H_Backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/description/
public class b_CombinationSum_ForLoopWithSingleRecursion {
    private List<Integer> cur = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0);
        return res;
    }

    private void dfs(int[] can, int target, int start) {
        if(target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < can.length; i++) {
            if(target-can[i] < 0) {
                continue;
            } else {
                cur.add(can[i]);
                dfs(can, target - can[i], i);
                cur.remove(cur.size()-1);
            }
        }
    }

    private void dfs1(int[] can, int target, int start) {
        if(target <= 0) {
            if(target==0)
                res.add(new ArrayList<>(cur));
            return;
        }
        for (int j = start; j < can.length; j++) {
            if(j > start && can[j] == can[j-1])
                continue;
            if(target-can[j] < 0)
                continue;
            cur.add(can[j]);
            dfs1(can, target-can[j], j);
            cur.remove(cur.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new b_CombinationSum_ForLoopWithSingleRecursion()
                        .combinationSum(new int[]{2,3,6,7}, 7)); //Output: [[2,2,3],[7]]
    }
}
