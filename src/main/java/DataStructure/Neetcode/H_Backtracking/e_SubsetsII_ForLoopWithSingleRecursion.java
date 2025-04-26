package DataStructure.Neetcode.H_Backtracking;

import java.util.*;

//https://leetcode.com/problems/subsets-ii/description/
public class e_SubsetsII_ForLoopWithSingleRecursion {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(0, nums);
        return new ArrayList<>(res);
    }

    private void dfs(int start, int[] nums) {
        for (int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1])
                continue;
            cur.add(nums[i]);
            dfs(i+1, nums);
            cur.remove(cur.size()-1);
        }
        res.add(new ArrayList<>(cur));
    }

    public static void main(String[] args) {
        System.out.println(new e_SubsetsII_ForLoopWithSingleRecursion()
                .subsetsWithDup(new int[] {1,2,2})); //[[],[1],[1,2],[1,2,2],[2],[2,2]]
    }
}
