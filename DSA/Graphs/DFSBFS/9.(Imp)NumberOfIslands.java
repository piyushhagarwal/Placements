// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

// Example 1:

// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1

// Example 2:

// Input: grid = [
//   ["1","1","0","0","0"],
//   ["1","1","0","0","0"],
//   ["0","0","1","0","0"],
//   ["0","0","0","1","1"]
// ]
// Output: 3

// Link: https://leetcode.com/problems/number-of-islands/

package Graphs.DFSBFS;

class Solution {
    public void dfs(int i, int j, char[][] grid, int[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        visited[i][j] = 1;

        // Top
        if (i - 1 >= 0 && grid[i - 1][j] == '1' && visited[i - 1][j] == 0) {
            dfs(i - 1, j, grid, visited);
        }

        // Bottom
        if (i + 1 < m && grid[i + 1][j] == '1' && visited[i + 1][j] == 0) {
            dfs(i + 1, j, grid, visited);
        }

        // Left
        if (j - 1 >= 0 && grid[i][j - 1] == '1' && visited[i][j - 1] == 0) {
            dfs(i, j - 1, grid, visited);
        }

        // Right
        if (j + 1 < n && grid[i][j + 1] == '1' && visited[i][j + 1] == 0) {
            dfs(i, j + 1, grid, visited);
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] visited = new int[m][n];

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    ans++;
                    dfs(i, j, grid, visited);
                }
            }
        }

        return ans;
    }
}