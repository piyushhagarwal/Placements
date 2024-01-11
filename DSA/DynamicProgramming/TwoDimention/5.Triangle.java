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
    public int solve(int row, int col, List<List<Integer>> triangle) {
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }

        int sameIndex = solve(row + 1, col, triangle);
        int nextIndex = solve(row + 1, col + 1, triangle);

        int ans = Math.min(sameIndex, nextIndex) + triangle.get(row).get(col);
        return ans;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int row = 0;
        int col = 0;
        return solve(row, col, triangle);
    }
}

// By memoization

class Solution2 {
    // Helper method to recursively calculate the minimum path sum
    public int solve(int row, int col, List<List<Integer>> triangle, List<List<Integer>> dp) {
        // Base case: If at the col row of the triangle, return the value at that
        // position
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }

        // If the result for the current position is already calculated, return it
        if (dp.get(row).get(col) != -1) {
            return dp.get(row).get(col);
        }

        // Recursive cases:

        // Calculate the minimum path sum by considering the current position and moving
        // to the next row
        int sameIndex = solve(row + 1, col, triangle, dp);
        int nextIndex = solve(row + 1, col + 1, triangle, dp);

        // Update the DP array with the minimum path sum for the current position
        dp.get(row).set(col, Math.min(sameIndex, nextIndex) + triangle.get(row).get(col));

        // Return the calculated minimum path sum for the current position
        return dp.get(row).get(col);
    }

    // Main method to find the minimum path sum for the given triangle
    public int minimumTotal(List<List<Integer>> triangle) {
        // Initialize row and col position
        int row = 0;
        int col = 0;

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
        return solve(row, col, triangle, dp);
    }
}
