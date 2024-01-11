// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

// Note: You can only move either down or right at any point in time.

// Example 1:
// Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
// Output: 7
// Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

// Example 2:
// Input: grid = [[1,2,3],[4,5,6]]
// Output: 12

package DynamicProgramming.TwoDimention;

// By recursive approach
class Solution {
    public int solve(int i, int j, int m, int n, int[][] grid) {
        // Base Case
        // If we have reached the target
        if (i == m - 1 && j == n - 1) {
            return grid[i][j]; // Return the value of bottom right grid;
        }

        // If we move out of the grid
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        int right = solve(i, j + 1, m, n, grid);
        int down = solve(i + 1, j, m, n, grid);

        return Math.min(right, down) + grid[i][j];
    }

    public int minPathSum(int[][] grid) {
        int i = 0;
        int j = 0;

        int m = grid.length;
        int n = grid[0].length;

        return solve(i, j, m, n, grid);
    }
}
// Time Complexity : O(2^(m*n))
// Space Complexity : O(m + n)

// By memoization
class Solution2 {
    public int solve(int i, int j, int m, int n, int[][] grid, int[][] dp) {
        // Base Case
        // If we have reached the target
        if (i == m - 1 && j == n - 1) {
            return grid[i][j]; // Return the value of bottom right grid;
        }

        // If we move out of the grid
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = solve(i, j + 1, m, n, grid, dp);
        int down = solve(i + 1, j, m, n, grid, dp);

        dp[i][j] = Math.min(right, down) + grid[i][j];
        return dp[i][j];
    }

    public int minPathSum(int[][] grid) {
        int i = 0;
        int j = 0;

        int m = grid.length;
        int n = grid[0].length;

        int dp[][] = new int[m][n];
        for (int ii = 0; ii < m; ii++) {
            for (int jj = 0; jj < n; jj++) {
                dp[ii][jj] = -1;
            }
        }

        return solve(i, j, m, n, grid, dp);
    }
}
// Time Complexity : O(m * n)
// Space Complexity : O(m*n + m + n)
