// You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

// An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

// Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

// The testcases are generated so that the answer will be less than or equal to 2 * 109.

// Example 1:

// Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
// Output: 2
// Explanation: There is one obstacle in the middle of the 3x3 grid above.
// There are two ways to reach the bottom-right corner:
// 1. Right -> Right -> Down -> Down
// 2. Down -> Down -> Right -> Right
// Example 2:

// Input: obstacleGrid = [[0,1],[0,0]]
// Output: 1

// Link : https://leetcode.com/problems/unique-paths-ii/

package DynamicProgramming.TwoDimention;

// By recursion
class Solution {
    // Helper method to recursively calculate unique paths
    public int solve(int i, int j, int m, int n, int[][] obstacleGrid) {
        // Base Case:

        // If you have reached the bottom-right corner, return 1 as you've found a
        // unique path
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        // If you are out of the matrix bounds, return 0 as you cannot proceed further
        if (i >= m || j >= n || obstacleGrid[i][j] == 1) {
            return 0;
        }

        // Recursive cases:

        // Move down and calculate the number of unique paths
        int down = solve(i + 1, j, m, n, obstacleGrid);

        // Move right and calculate the number of unique paths
        int right = solve(i, j + 1, m, n, obstacleGrid);

        return down + right;

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Starting position (top-left corner)
        int i = 0;
        int j = 0;

        // length
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If obstacle at destination point
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        // Call the recursive solve method to find the number of unique paths
        return solve(i, j, m, n, obstacleGrid);
    }
}

// By memoization
class Solution2 {
    // Helper method to recursively calculate unique paths
    public int solve(int i, int j, int m, int n, int[][] obstacleGrid, int dp[][]) {
        // Base Case:

        // If you have reached the bottom-right corner, return 1 as you've found a
        // unique path
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        // If you are out of the matrix bounds, return 0 as you cannot proceed further
        if (i >= m || j >= n || obstacleGrid[i][j] == 1) {
            return 0;
        }

        // If the result for the current position is already calculated, return it
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Recursive cases:

        // Move down and calculate the number of unique paths
        int down = solve(i + 1, j, m, n, obstacleGrid, dp);

        // Move right and calculate the number of unique paths
        int right = solve(i, j + 1, m, n, obstacleGrid, dp);

        // Memoize the result for the current position
        dp[i][j] = down + right;

        // Return the total number of unique paths from the current position to the
        // bottom-right corner
        return dp[i][j];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Starting position (top-left corner)
        int i = 0;
        int j = 0;

        // length
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If obstacle at destination point
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

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
        return solve(i, j, m, n, obstacleGrid, dp);
    }
}