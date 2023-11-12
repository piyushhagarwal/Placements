// Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

// The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
// frequency
//  of at least one of the chosen numbers is different.

// The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

// Example 1:

// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]
// Explanation:
// 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
// 7 is a candidate, and 7 = 7.
// These are the only two combinations.
// Example 2:

// Input: candidates = [2,3,5], target = 8
// Output: [[2,2,2,2],[2,3,3],[3,5]]
// Example 3:

// Input: candidates = [2], target = 1
// Output: []

// Constraints:

// 1 <= candidates.length <= 30

// Question link: https://leetcode.com/problems/combination-sum/description/

// Solution link: https://www.youtube.com/watch?v=OyZFFqQtu98

package Recursion.BackTracking.Medium;

import java.util.ArrayList;
import java.util.List;

class Solution {

    // Helper function to find combinations that sum up to the target
    public static void helper(int[] candidates, int index, List<Integer> subset, List<List<Integer>> result,
            int target) {
        // If the target is achieved, add the current subset to the result
        if (target == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }

        // If the target becomes negative or we reach the end of candidates array, stop
        // recursion
        if (target < 0 || index >= candidates.length) {
            return;
        }

        // Include the current element and recursively search for combinations
        int element = candidates[index];
        subset.add(element);
        helper(candidates, index, subset, result, target - element);
        subset.remove(subset.size() - 1); // Backtrack: remove the last element to explore other possibilities

        // Exclude the current element and move on to the next index
        helper(candidates, index + 1, subset, result, target);
    }

    // Main function to find combinations that sum up to the target
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Initialize the result list and an empty subset
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        // Start the recursive process from the beginning of the candidates array
        helper(candidates, 0, subset, result, target);

        // Return the final result
        return result;
    }
}
