
// Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

// A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

// Example 1:

// Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
// Output: 13
// Explanation: There are two falling paths with a minimum sum as shown.

// Example 2:

// Input: matrix = [[-19,57],[-40,-5]]
// Output: -59
// Explanation: The falling path with a minimum sum is shown.

// Link : https://leetcode.com/problems/minimum-falling-path-sum/

package DynamicProgramming.TwoDimention;

// By recursive approach
class Solution {
    // Helper method to recursively calculate the minimum falling path sum
    public int solve(int row, int col, int n, int[][] matrix) {
        // Base cases:

        // If the column is out of bounds, return Integer.MAX_VALUE
        if (col < 0 || col >= n) {
            return Integer.MAX_VALUE;
        }

        // If at the last row, return the value at the current position
        if (row == n - 1) {
            return matrix[row][col];
        }

        // Recursive cases:

        // Calculate the minimum falling path sum by considering three possible moves
        int leftDiagonal = solve(row + 1, col - 1, n, matrix);
        int bottom = solve(row + 1, col, n, matrix);
        int rightDiagonal = solve(row + 1, col + 1, n, matrix);

        // Return the minimum of the three moves plus the value at the current position
        return Math.min(leftDiagonal, Math.min(bottom, rightDiagonal)) + matrix[row][col];
    }

    // Main method to find the minimum falling path sum in the matrix
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int row = 0;
        int col = 0;
        int min = Integer.MAX_VALUE;

        // Iterate through the first row and calculate the minimum falling path sum for
        // each starting position
        for (col = 0; col < n; col++) {
            int value = solve(row, col, n, matrix);
            min = Math.min(min, value);
        }

        // Return the overall minimum falling path sum
        return min;
    }
}
// Time Complexity : O(3^n)
// Space Complexity : O(n)

// By memoization
class Solution2 {
    public int solve(int row, int col, int n, int[][] matrix, int[][] dp) {
        if (col < 0 || col >= n) {
            return Integer.MAX_VALUE;
        }
        if (row == n - 1) {
            return matrix[row][col];
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int leftDiagonal = solve(row + 1, col - 1, n, matrix, dp);
        int bottom = solve(row + 1, col, n, matrix, dp);
        int rightDiagonal = solve(row + 1, col + 1, n, matrix, dp);

        dp[row][col] = Math.min(leftDiagonal, Math.min(bottom, rightDiagonal)) + matrix[row][col];
        return dp[row][col];
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int row = 0;
        int col = 0;

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        int min = Integer.MAX_VALUE;
        for (col = 0; col < n; col++) {
            int value = solve(row, col, n, matrix, dp);
            min = Math.min(min, value);
        }
        return min;
    }
}
// Time Complexity : O(n * n)
// Space Complexity : O(n * n)