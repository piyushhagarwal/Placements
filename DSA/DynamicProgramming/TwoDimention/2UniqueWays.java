// There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

// Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

// The test cases are generated so that the answer will be less than or equal to 2 * 109.

// Example 1:

// Input: m = 3, n = 7
// Output: 28
// Example 2:

// Input: m = 3, n = 2
// Output: 3
// Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
// 1. Right -> Down -> Down
// 2. Down -> Down -> Right
// 3. Down -> Right -> Down

// Link : https://leetcode.com/problems/unique-paths/
// Solution : https://www.youtube.com/watch?v=sdE0A2Oxofw&t=3s

package DynamicProgramming.TwoDimention;

// By recursive approach
class Solution {
    // Helper method to recursively calculate unique paths
    public int solve(int i, int j, int m, int n) {
        // Base Case:

        // If you have reached the bottom-right corner, return 1 as you've found a
        // unique path
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        // If you are out of the matrix bounds, return 0 as you cannot proceed further
        if (i >= m || j >= n) {
            return 0;
        }

        // Recursive cases:

        // Move down and calculate the number of unique paths
        int down = solve(i + 1, j, m, n);

        // Move right and calculate the number of unique paths
        int right = solve(i, j + 1, m, n);

        // Return the total number of unique paths from the current position to the
        // bottom-right corner
        return down + right;
    }

    // Main method to find the number of unique paths in a grid
    public int uniquePaths(int m, int n) {
        // Starting position (top-left corner)
        int i = 0;
        int j = 0;

        // Call the recursive solve method to find the number of unique paths
        return solve(i, j, m, n);
    }

    // Time Complexity: O(2^(m*n))
    // Space Complexity: O(m+n)
}

// By recursive approach with memoization
class Solution2 {
    // Helper method to recursively calculate unique paths
    public int solve(int i, int j, int m, int n, int dp[][]) {
        // Base Case:

        // If you have reached the bottom-right corner, return 1 as you've found a
        // unique path
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        // If you are out of the matrix bounds, return 0 as you cannot proceed further
        if (i >= m || j >= n) {
            return 0;
        }

        // If the result for the current position is already calculated, return it
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Recursive cases:

        // Move down and calculate the number of unique paths
        int down = solve(i + 1, j, m, n, dp);

        // Move right and calculate the number of unique paths
        int right = solve(i, j + 1, m, n, dp);

        // Memoize the result for the current position
        dp[i][j] = down + right;

        // Return the total number of unique paths from the current position to the
        // bottom-right corner
        return dp[i][j];
    }

    // Main method to find the number of unique paths in a grid
    public int uniquePaths(int m, int n) {
        // Starting position (top-left corner)
        int i = 0;
        int j = 0;

        // Initialize a 2D array for dynamic programming memoization
        int[][] dp = new int[m][n];

        // Initialize the array with -1 to indicate that the result is not yet
        // calculated
        for (int ii = 0; ii < m; ii++) {
            for (int jj = 0; jj < n; jj++) {
                dp[ii][jj] = -1;
            }
        }

        // Call the recursive solve method to find the number of unique paths
        return solve(i, j, m, n, dp);
    }
}
// Time Complexity: O(m*n)
// Space Complexity: O(m*n + m + n)

// By tabulation approach
class Solution3 {
    public int uniquePaths(int m, int n) {
        // Create a 2D array to store the number of unique paths at each position
        int[][] dp = new int[m][n];

        // Initialize the DP array with -1 to indicate that the result is not yet
        // calculated
        for (int ii = 0; ii < m; ii++) {
            for (int jj = 0; jj < n; jj++) {
                dp[ii][jj] = -1;
            }
        }

        // Base case: There is only one way to reach the bottom-right corner
        dp[m - 1][n - 1] = 1;

        // Iterate through the grid, starting from the bottom-right corner
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // Skip initialization cell, as it's already set in the base case
                if (i == m - 1 && j == n - 1) {
                    continue;
                }

                // Calculate the number of unique paths from the current position
                int down = 0;
                int right = 0;

                // Check if moving down is within the bounds of the array
                if (i + 1 < m) {
                    down = dp[i + 1][j];
                }

                // Check if moving right is within the bounds of the array
                if (j + 1 < n) {
                    right = dp[i][j + 1];
                }

                // Update the DP array with the sum of paths from below and to the right
                dp[i][j] = down + right;
            }
        }

        // The top-left corner now contains the total number of unique paths
        return dp[0][0];
    }
}
// Time Complexity: O(m*n)
// Space Complexity: O(m*n)
