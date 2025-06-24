package DataStructure.Neetcode150.H_Backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/permutations/description/
public class d_Permutations_ForLoopWithSingleRecursion {
    List<Integer> cur = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums);
        return res;
    }

    private void dfs(int[] nums) {
        if(cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(!cur.contains(nums[i])) {
                cur.add(nums[i]);
                dfs(nums);
                cur.remove(cur.size()-1);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(
                new d_Permutations_ForLoopWithSingleRecursion()
                        .permute(new int[]{1,2,3}) //[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        );
    }
}
