// Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

// Only numbers 1 through 9 are used.
// Each number is used at most once.
// Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

// Example 1:

// Input: k = 3, n = 7
// Output: [[1,2,4]]
// Explanation:
// 1 + 2 + 4 = 7
// There are no other valid combinations.
// Example 2:

// Input: k = 3, n = 9
// Output: [[1,2,6],[1,3,5],[2,3,4]]
// Explanation:
// 1 + 2 + 6 = 9
// 1 + 3 + 5 = 9
// 2 + 3 + 4 = 9
// There are no other valid combinations.
// Example 3:

// Input: k = 4, n = 1
// Output: []
// Explanation: There are no valid combinations.
// Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.

// Link : https://leetcode.com/problems/combination-sum-iii/

package Recursion.BackTracking.Medium;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // Main helper function for backtracking
    public void helper(int index, int arr[], int count, List<Integer> subset, int target, List<List<Integer>> ans) {
        // Base Case: If we have found a valid combination
        if (count == 0 && target == 0) {
            ans.add(new ArrayList<>(subset)); // Add the current subset to the answer list
            return;
        }

        // Base Cases to stop recursion
        if (count == 0 || target < 0 || index >= arr.length) {
            return;
        }

        // Exclude current element and move to the next index
        helper(index + 1, arr, count, subset, target, ans);

        // Include current element in the subset
        subset.add(arr[index]);
        // Recursively call the helper function with reduced count and updated target
        helper(index + 1, arr, count - 1, subset, target - arr[index], ans);
        subset.remove(subset.size() - 1); // Backtrack: Remove the last element for backtracking
    }

    // Main function to find combinations that sum up to the given values
    public List<List<Integer>> combinationSum3(int k, int n) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 }; // Array of possible elements to choose from
        int index = 0; // Starting index for backtracking
        List<List<Integer>> ans = new ArrayList<>(); // List to store the final combinations
        List<Integer> subset = new ArrayList<>(); // Temporary list to store current subset
        helper(index, arr, k, subset, n, ans); // Call the helper function to start the backtracking
        return ans; // Return the final answer list
    }

    // Time Complexity: O(2^n * k)
}
