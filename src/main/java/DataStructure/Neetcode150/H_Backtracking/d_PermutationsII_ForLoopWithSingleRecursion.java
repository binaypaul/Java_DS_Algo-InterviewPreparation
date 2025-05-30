package DataStructure.Neetcode150.H_Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/permutations-ii/description/
//https://www.youtube.com/watch?v=YW5F0WqBBWY
public class d_PermutationsII_ForLoopWithSingleRecursion {

    List<Integer> cur = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, new boolean[nums.length]);
        return res;
    }

    private void dfs(int[] nums, boolean[] used) {
        if(nums.length == cur.size()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i] //this check is important when dfs is called recursively.
                ||
            (i>0 && nums[i] == nums[i-1] && !used[i-1])) //this is important when for loop is executing for the original sorted array.
                continue;
            cur.add(nums[i]);
            used[i] = true;
            dfs(nums, used);
            cur.remove(cur.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new d_PermutationsII_ForLoopWithSingleRecursion()
                        .permuteUnique(new int[]{1,1,2}) //[[1,1,2],[1,2,1],[2,1,1]]
        );
    }
}
