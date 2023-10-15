package Recursion;

import java.util.ArrayList;
import java.util.List;

class Solution {

    // Helper function to generate subsets using backtracking
    public static void helper(int[] nums, int index, List<Integer> subset, List<List<Integer>> result) {
        // Base case: if the index is beyond the array length, add the current subset to
        // the result
        if (index >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        // Exclude the current element
        helper(nums, index + 1, subset, result);

        // Include the current element
        int element = nums[index];
        subset.add(element);
        helper(nums, index + 1, subset, result);

        // Backtrack: remove the last added element to explore other possibilities
        subset.remove(subset.size() - 1);
    }

    // Main function to generate all subsets of an array
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        helper(nums, 0, subset, result);
        return result;
    }
}
