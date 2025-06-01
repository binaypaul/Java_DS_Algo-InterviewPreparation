package DataStructure.Neetcode150.H_Backtracking.practise;

import java.util.ArrayList;
import java.util.List;

public class a_Subsets_ForLoopWithSingleRecursion {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();

    private List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            dfs(nums, i+1);
            cur.remove(cur.size()-1);
        }
        res.add(new ArrayList<>(cur));
    }

    public static void main(String[] args) {
        System.out.println(new DataStructure.Neetcode150.H_Backtracking.practise.a_Subsets_ForLoopWithSingleRecursion()
                .subsets(new int[] {0,1,2}));
    }
}
