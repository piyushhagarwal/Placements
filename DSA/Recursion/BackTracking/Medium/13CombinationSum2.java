// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

// Each number in candidates may only be used once in the combination.

// Note: The solution set must not contain duplicate combinations.

// Example 1:

// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output: 
// [
// [1,1,6],
// [1,2,5],
// [1,7],
// [2,6]
// ]
// Example 2:

// Input: candidates = [2,5,2,1,2], target = 5
// Output: 
// [
// [1,2,2],
// [5]
// ]

//Question Link: https://leetcode.com/problems/combination-sum-ii/description/
//Solution Link: https://www.youtube.com/watch?v=G1fRTGRxXU8

package Recursion.BackTracking.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    // Helper function for backtracking
    public static void helper(int[] candidates, int index, List<Integer> subset, List<List<Integer>> result,
            int target) {
        // If the target is achieved, add the current subset to the result
        if (target == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }

        // If the target becomes negative or we reach the end of candidates array,
        // backtrack
        if (target < 0 || index >= candidates.length) {
            return;
        }

        // Iterate through the candidates starting from the current index
        for (int i = index; i < candidates.length; i++) {
            // Skip duplicates to avoid duplicate subsets
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // Include the current candidate in the subset
            subset.add(candidates[i]);
            // Recursively call the helper function with the updated index and target
            helper(candidates, i + 1, subset, result, target - candidates[i]);
            // Backtrack by removing the last element to explore other possibilities
            subset.remove(subset.size() - 1);
        }
    }

    // Main function to find combination sums
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // List to store the final result
        List<List<Integer>> result = new ArrayList<>();
        // Sort the candidates to handle duplicates efficiently
        Arrays.sort(candidates);
        // List to store the current subset
        List<Integer> subset = new ArrayList<>();
        // Call the helper function to start the backtracking process
        helper(candidates, 0, subset, result, target);
        // Return the final result
        return result;
    }
}
