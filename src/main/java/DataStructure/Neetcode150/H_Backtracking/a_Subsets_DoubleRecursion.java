package DataStructure.Neetcode150.H_Backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/subsets/description/
public class a_Subsets_DoubleRecursion {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return res;
    }

    private void dfs(int i, int[] nums) {
        if(i == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        dfs(i+1, nums);
        cur.remove(cur.size()-1);

        dfs(i+1, nums);
    }

    public static void main(String[] args) {
        System.out.println(new a_Subsets_DoubleRecursion().subsets(new int[] {1,2,3}));
    }
}
