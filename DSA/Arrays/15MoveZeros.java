// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Note that you must do this in-place without making a copy of the array.

// Example 1:

// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]
// Example 2:

// Input: nums = [0]
// Output: [0]

// Link: https://leetcode.com/problems/move-zeroes/

package Arrays;

class Solution {
    public void moveZeroes(int[] nums) {
        // Initialize index i to track the position for placing non-zero elements.
        int i = 0;

        // Iterate over the array.
        for (int j = 0; j < nums.length; j++) {
            // If the current element at index j is non-zero.
            if (nums[j] != 0) {
                // Swap the non-zero element found at index j with the position indicated by
                // index i.
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                // Move to the next position for placing the next non-zero element.
                i++;
            }
        }
    }
}
