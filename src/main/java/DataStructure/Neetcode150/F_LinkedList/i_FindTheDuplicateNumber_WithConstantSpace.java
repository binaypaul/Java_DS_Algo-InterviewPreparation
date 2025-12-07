package DataStructure.Neetcode150.F_LinkedList;
/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and using only constant extra space.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2

Example 2:
Input: nums = [3,1,3,4,2]
Output: 3

Example 3:
Input: nums = [3,3,3,3,3]
Output: 3
 */
public class i_FindTheDuplicateNumber_WithConstantSpace {
    public static void main(String[] args) {
        int[] nums = {2,5,9,6,5,3,8,5,7,1};
        System.out.println(
                new i_FindTheDuplicateNumber_WithConstantSpace()
                .findDuplicate(nums)
        );
    }
    public int findDuplicate(int[] nums) {
        // Phase 1: Detect the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];

//                  Ex  nums={2,5,9,6,9,3,8,9,7,1};
//        List representation: 2-9-1-5-3-6-8-7
//                               ^-----------'
//!        NOTE: Given the list, to construct array from the list, apply rule:
//!              "cur node val is the index of the next node"

        // Advance tortoise by one step and hare by two steps until they meet.
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);
//      slow and fast pointer meet at 6 value, not index 6.

        // Phase 2: Find the "entrance" to the cycle.
        // Reset one pointer to the beginning (index 0).
        int ptr1 = nums[0];
        int ptr2 = tortoise; // Keep the other pointer at the meeting point.
        // Advance both pointers one step at a time until they meet.
        // This meeting point is the start of the cycle, which is the duplicate number.
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1; // Or ptr2, as they point to the same duplicate number.
    }
}
