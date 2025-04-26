package DataStructure.Neetcode.H_Backtracking;

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
            int canI = can[i];
            if(target-canI < 0)
                continue;
            else {
                cur.add(canI);
                dfs(can, target - canI, i);
                cur.remove(cur.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new b_CombinationSum_ForLoopWithSingleRecursion()
                        .combinationSum(new int[]{2,3,6,7}, 7)); //Output: [[2,2,3],[7]]
    }
}
