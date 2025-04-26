package DataStructure.Neetcode.H_Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum-ii/description/
//double recursion is god level hard :)
public class c_CombinationSumII_ForLoopWithSingleRecursion {
    List<Integer> cur = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        dfs(candidates, target, 0);
        return res;
    }

    private void dfs(int[] can, int target, int start) {
        if(target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < can.length; i++) {
            //to skip duplicate combinations
            if(i>start && can[i] == can[i-1])
                continue;
            //to skip "add in cur", compare "target-can[i]<0" then "remove from cur" operations
            if(can[i] > target)
                return;
            cur.add(can[i]);
            dfs(can, target-can[i], i+1);
            cur.remove(cur.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[50];
        for (int i = 0; i < 50; i++) {
            arr[i] = 1;
        }

        System.out.println(new c_CombinationSumII_ForLoopWithSingleRecursion()
                .combinationSum2(arr, 50));
    }
}
