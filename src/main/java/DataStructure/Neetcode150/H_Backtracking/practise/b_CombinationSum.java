package DataStructure.Neetcode150.H_Backtracking.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class b_CombinationSum {
    private List<Integer> cur = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] can, int target) {
        Arrays.sort(can);
        dfs(can, target, 0);
        return res;
    }

    private void dfs(int[] can, int target, int i) {
        if(target==0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int j = i; j < can.length; j++) {
            if(j > i && can[j] == can[j-1])
                continue;
            if(target-can[j] < 0)
                continue;
            cur.add(can[j]);
            dfs(can, target-can[j], j);
            cur.remove(cur.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new b_CombinationSum()
                        .combinationSum(new int[]{5,2,3,2,6,7}, 7)); //Output: [[2,2,3],[7]]
    }
}
