package DataStructure.Practice.Sept2026._17_2;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // "(nums[nums[i] - 1] != nums[i])"it checks below:
            // if current target (i th index value) and swap target (nums[i]-1 th index's value)  are same/equal,
            // then even though swapping keeps on happening but (i+1 == nums[i]) will never be true as both swap targets are same/equal.
            // Hence, "(nums[nums[i] - 1] != nums[i])" also avoids infinite while loop here.
            while (nums[i] >= 1 && nums[i] <= n
                    && (i+1 != nums[i]) && (nums[nums[i] - 1] != nums[i])) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if(nums[i]!=i+1) {
                return i+1;
            }
        }
        return n+1;
    }

    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int[] nums = {1, 1, 2, 2};
//        int[] nums = {3, 4, -1, 1};
        var ret = firstMissingPositive.firstMissingPositive(nums);
        System.out.println(ret);
    }
}
