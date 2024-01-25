// Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

// A region is captured by flipping all 'O's into 'X's in that surrounded region.

// Example 1:

// Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
// Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
// Explanation: Notice that an 'O' should not be flipped if:
// - It is on the border, or
// - It is adjacent to an 'O' that should not be flipped.
// The bottom 'O' is on the border, so it is not flipped.
// The other three 'O' form a surrounded region, so they are flipped.

// Example 2:

// Input: board = [["X"]]
// Output: [["X"]]

// Link : https://leetcode.com/problems/surrounded-regions/
// Solution : https://www.youtube.com/watch?v=BtdgAys4yMk

package Graphs.DFSBFS;

class Solution {
    // Helper method to perform Depth-First Search (DFS)
    public void dfs(int i, int j, char[][] board, int[][] visited) {
        int m = board.length;
        int n = board[0].length;
        visited[i][j] = 1;

        // Explore neighboring cells

        // Top
        if (i - 1 >= 0 && board[i - 1][j] == 'O' && visited[i - 1][j] == 0) {
            dfs(i - 1, j, board, visited);
        }

        // Bottom
        if (i + 1 < m && board[i + 1][j] == 'O' && visited[i + 1][j] == 0) {
            dfs(i + 1, j, board, visited);
        }

        // Left
        if (j - 1 >= 0 && board[i][j - 1] == 'O' && visited[i][j - 1] == 0) {
            dfs(i, j - 1, board, visited);
        }

        // Right
        if (j + 1 < n && board[i][j + 1] == 'O' && visited[i][j + 1] == 0) {
            dfs(i, j + 1, board, visited);
        }
    }

    // Main method to solve the Surrounded Regions problem
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] visited = new int[m][n];

        // Step 1: Check for 'O' on the boundaries and perform DFS
        // 1st row
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O' && visited[0][j] == 0) {
                dfs(0, j, board, visited);
            }
        }

        // 1st col
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O' && visited[i][0] == 0) {
                dfs(i, 0, board, visited);
            }
        }

        // Last row
        for (int j = 0; j < n; j++) {
            if (board[m - 1][j] == 'O' && visited[m - 1][j] == 0) {
                dfs(m - 1, j, board, visited);
            }
        }

        // Last col
        for (int i = 0; i < m; i++) {
            if (board[i][n - 1] == 'O' && visited[i][n - 1] == 0) {
                dfs(i, n - 1, board, visited);
            }
        }

        // Step 2: Change unvisited 'O' cells to 'X'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && visited[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
