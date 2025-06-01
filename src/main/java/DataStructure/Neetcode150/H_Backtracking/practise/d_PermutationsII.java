package DataStructure.Neetcode150.H_Backtracking.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class d_PermutationsII {

    List<Integer> cur = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, new boolean[nums.length]);
        return res;
    }

    private void dfs(int[] nums, boolean[] used) {
        if(cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(used[i] || (i>0 && nums[i] == nums[i-1] && !used[i-1]))
                continue;
            cur.add(nums[i]);
            used[i] = true;
            dfs(nums, used);
            used[i] = false;
            cur.remove(cur.size() - 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(
                new d_PermutationsII()
                        .permuteUnique(new int[]{1,1,2}) //[[1,1,2],[1,2,1],[2,1,1]]
        );
    }
}
