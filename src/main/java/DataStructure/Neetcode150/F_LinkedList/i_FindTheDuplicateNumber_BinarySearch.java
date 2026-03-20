package DataStructure.Neetcode150.F_LinkedList;

/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and using only constant extra space.

Binary Search Approach: O(n log n) time, O(1) space
- Intuition: Binary search on the value range [1, n] instead of array indices.
- For a mid value, count how many elements in nums are <= mid.
- If count > mid, the duplicate is in [low, mid] (since in a normal array, count should be mid).
- Else, it's in [mid+1, high].
- This finds the smallest number where the count exceeds the expected.
*/

public class i_FindTheDuplicateNumber_BinarySearch {
    public static void main(String[] args) {
        int[] nums = {2,5,9,6,5,3,8,5,7,1};
        System.out.println(
                new i_FindTheDuplicateNumber_BinarySearch()
                .findDuplicate(nums)
        );
    }

    public int findDuplicate(int[] nums) {
        int n = nums.length - 1; // Since n+1 elements, range [1, n]
        int low = 1;
        int high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;

            // Count numbers <= mid
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            if (count > mid) {
                // Duplicate is in [low, mid]
                high = mid;
            } else {
                // Duplicate is in [mid+1, high]
                low = mid + 1;
            }
        }

        return low; // low == high, the duplicate
    }
}
