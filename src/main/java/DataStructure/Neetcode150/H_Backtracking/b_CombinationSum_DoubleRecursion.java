package DataStructure.Neetcode150.H_Backtracking;


import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/description/
public class b_CombinationSum_DoubleRecursion {
    private List<Integer> cur = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0);
        return res;
    }

    private void dfs(int[] can, int target, int i) {
        if(i == can.length || target <= 0) {
            if(target == 0)
                res.add(new ArrayList<>(cur));
            return;
        }

        if(target-can[i] >= 0) {
            cur.add(can[i]);
            dfs(can, target - can[i], i);
            cur.remove(cur.size() - 1);
        }

        dfs(can, target, i+1);
    }

    public static void main(String[] args) {
        System.out.println(
                new b_CombinationSum_DoubleRecursion()
                        .combinationSum(new int[]{10,2,3,6,7}, 6)); //Output: [[2,2,3],[7]]
    }
}
