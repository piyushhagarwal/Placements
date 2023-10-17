// Given an array nums of distinct integers, return all the possible permutations.
// You can return the answer in any order.

// Example 1:

// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2:

// Input: nums = [0,1]
// Output: [[0,1],[1,0]]
// Example 3:

// Input: nums = [1]
// Output: [[1]]

// Link : https://leetcode.com/problems/permutations/description/

package Recursion.BackTracking.Medium;

import java.util.ArrayList;
import java.util.List;

class Solution {

    // Helper method to swap elements at indices i and j in the array nums
    public static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Recursive method to generate permutations of the array nums
    public static void solve(int[] nums, int index, List<List<Integer>> result) {
        // If index is equal to the length of the array, a permutation is complete
        if (index >= nums.length) {
            // Create a new list to store the current permutation
            List<Integer> possiblePermutation = new ArrayList<>();

            // Add each element of the array to the permutation list
            for (int num : nums) {
                possiblePermutation.add(num);
            }

            // Add the current permutation list to the result list
            result.add(possiblePermutation);
            return;
        }

        // Iterate through the array starting from the current index
        for (int i = index; i < nums.length; i++) {
            // Swap the current element with the element at the current index
            swap(i, index, nums);

            // Recursively generate permutations for the remaining elements
            solve(nums, index + 1, result);

            // Backtrack by swapping back to the original state
            swap(i, index, nums);
        }
    }

    // Main method to generate permutations
    public List<List<Integer>> permute(int[] nums) {
        // Initialize the result list
        List<List<Integer>> result = new ArrayList<>();

        // Start generating permutations from index 0
        int index = 0;
        solve(nums, index, result);

        // Return the list of permutations
        return result;
    }
}
