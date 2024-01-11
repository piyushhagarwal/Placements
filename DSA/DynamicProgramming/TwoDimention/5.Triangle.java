// Given a triangle array, return the minimum path sum from top to bottom.

// For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

// Example 1:

// Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
// Output: 11
// Explanation: The triangle looks like:
//    2
//   3 4
//  6 5 7
// 4 1 8 3
// The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
// Example 2:

// Input: triangle = [[-10]]
// Output: -10

// Link : https://leetcode.com/problems/triangle/

package DynamicProgramming.TwoDimention;

import java.util.ArrayList;
import java.util.List;

// By recursive approach
class Solution {
    public int solve(int level, int last, List<List<Integer>> triangle) {
        if (level == triangle.size() - 1) {
            return triangle.get(level).get(last);
        }

        int sameIndex = solve(level + 1, last, triangle);
        int nextIndex = solve(level + 1, last + 1, triangle);

        int ans = Math.min(sameIndex, nextIndex) + triangle.get(level).get(last);
        return ans;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int level = 0;
        int last = 0;
        return solve(level, last, triangle);
    }
}

// By memoization

class Solution2 {
    // Helper method to recursively calculate the minimum path sum
    public int solve(int level, int last, List<List<Integer>> triangle, List<List<Integer>> dp) {
        // Base case: If at the last level of the triangle, return the value at that
        // position
        if (level == triangle.size() - 1) {
            return triangle.get(level).get(last);
        }

        // If the result for the current position is already calculated, return it
        if (dp.get(level).get(last) != -1) {
            return dp.get(level).get(last);
        }

        // Recursive cases:

        // Calculate the minimum path sum by considering the current position and moving
        // to the next level
        int sameIndex = solve(level + 1, last, triangle, dp);
        int nextIndex = solve(level + 1, last + 1, triangle, dp);

        // Update the DP array with the minimum path sum for the current position
        dp.get(level).set(last, Math.min(sameIndex, nextIndex) + triangle.get(level).get(last));

        // Return the calculated minimum path sum for the current position
        return dp.get(level).get(last);
    }

    // Main method to find the minimum path sum for the given triangle
    public int minimumTotal(List<List<Integer>> triangle) {
        // Initialize level and last position
        int level = 0;
        int last = 0;

        // Initialize a 2D array for dynamic programming memoization
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> subDp = new ArrayList<>();
            for (int j = 0; j < triangle.get(i).size(); j++) {
                subDp.add(-1);
            }
            dp.add(subDp);
        }

        // Call the recursive solve method to find the minimum path sum
        return solve(level, last, triangle, dp);
    }
}
