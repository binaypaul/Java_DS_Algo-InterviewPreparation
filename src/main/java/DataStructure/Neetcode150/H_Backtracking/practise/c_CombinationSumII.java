package DataStructure.Neetcode150.H_Backtracking.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class c_CombinationSumII {
    private List<Integer> cur = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

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
            if(i>start && can[i] == can[i-1])
                continue;
            if(target-can[i] < 0)
                continue;
            cur.add(can[i]);
            dfs(can, target-can[i], i+1);
            cur.remove(cur.size()-1);
        }
    }


    public static void main(String[] args) {
        System.out.println(new c_CombinationSumII()
                .combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}
