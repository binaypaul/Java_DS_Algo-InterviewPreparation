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
        int[] nums = {2,6,5,3,8,5,7,1};
        System.out.println(
                new i_FindTheDuplicateNumber_WithConstantSpace()
                .findDuplicate(nums)
        );
    }
    //Its easy, its typical Floyd's Cycle Detection Algorithm (phase 1) and then find the entrance in the cycle (phase 2).
    //Both phase 1 and phase 2 are part by Floyd's Cycle Detection Algorithm.
    public int findDuplicate(int[] nums) {
        // Phase 1: Detect the intersection point of the two runners.
        int slow = nums[0];
        int fast = nums[0];

//                  Ex  nums={2,5,9,6,5,3,8,5,7,1};
//                            0,1,2,3,4,5,6,7,8,9
//        List representation: 2-9-1-5-3-6-8-7
//                                   ^-------'
//!        NOTE: Given the list, to construct array from the list, apply rule:
//!              "cur node val is the index of the next node"

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
//      slow and fast pointer meet at 6 value, not index 6.

        // Phase 2: Find the "entrance" to the cycle.
        // Reset one pointer (fast) to the beginning (index 0).
        // Keep the other pointer(slow) at the meeting point.
        fast = nums[0];
        // Advance both pointers one step at a time until they meet.
        // This meeting point is the entrance of the cycle, which is the duplicate number.
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // Or fast, as they point to the same duplicate number.
    }
}
