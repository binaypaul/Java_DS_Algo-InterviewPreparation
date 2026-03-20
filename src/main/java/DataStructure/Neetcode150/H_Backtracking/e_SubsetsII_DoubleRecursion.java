package DataStructure.Neetcode150.H_Backtracking;

import java.util.*;

//https://leetcode.com/problems/subsets-ii/description/
public class e_SubsetsII_DoubleRecursion {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> cur = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int i) {
        if(i == nums.length) {
            if(!res.contains(cur))
                res.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        dfs(nums, i+1);
        cur.removeLast();

        dfs(nums, i+1);
    }

    public static void main(String[] args) {
        System.out.println(new a_Subsets_DoubleRecursion().subsets(new int[]{1,2,2}));
    }
}
