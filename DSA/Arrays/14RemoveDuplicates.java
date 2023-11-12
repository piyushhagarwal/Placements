// Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

// Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

// Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
// Return k.
// Custom Judge:

// The judge will test your solution with the following code:

// int[] nums = [...]; // Input array
// int[] expectedNums = [...]; // The expected answer with correct length

// int k = removeDuplicates(nums); // Calls your implementation

// assert k == expectedNums.length;
// for (int i = 0; i < k; i++) {
//     assert nums[i] == expectedNums[i];
// }
// If all assertions pass, then your solution will be accepted.

// Example 1:

// Input: nums = [1,1,2]
// Output: 2, nums = [1,2,_]
// Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
// It does not matter what you leave beyond the returned k (hence they are underscores).
// Example 2:

// Input: nums = [0,0,1,1,1,2,2,3,3,4]
// Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
// Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
// It does not matter what you leave beyond the returned k (hence they are underscores).

// Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// Solution: https://www.youtube.com/watch?v=37E9ckMDdTk

package Arrays;

import java.util.TreeSet;

class Solution {
    public int removeDuplicates1(int[] nums) {
        // Brute force method
        TreeSet<Integer> set = new TreeSet<>(); // For storing elements in sorted order we use TreeSet instead of
                                                // HashSet
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int k = set.size();
        int j = 0;
        for (int x : set) {
            nums[j++] = x;
        }
        return k;
    }

    public int removeDuplicates(int[] nums) {
        // Initialize the index i to track the position of unique elements in the array.
        int i = 0;

        // Iterate over the array starting from index 1 (j).
        for (int j = 1; j < nums.length; j++) {
            // Check if the current element at index j is different from the element at
            // index i.
            if (nums[j] != nums[i]) {
                // Increment the index i to move to the next position for a unique element.
                i++;

                // Swap the unique element found at index j with the position indicated by index
                // i.
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }

        // The length of the modified array is (i + 1) since i represents the last index
        // of unique elements.
        return i + 1;
    }

}