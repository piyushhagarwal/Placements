// Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
// Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell.

// Example 1:

// Input:
// N = 4
// m[][] = {{1, 0, 0, 0},
//          {1, 1, 0, 1}, 
//          {1, 1, 0, 0},
//          {0, 1, 1, 1}}
// Output:
// DDRDRR DRDDRR
// Explanation:
// The rat can reach the destination at 
// (3, 3) from (0, 0) by two paths - DRDDRR 
// and DDRDRR, when printed in sorted order 
// we get DDRDRR DRDDRR.
// Example 2:
// Input:
// N = 2
// m[][] = {{1, 0},
//          {1, 0}}
// Output:
// -1
// Explanation:
// No path exists and destination cell is 
// blocked.

// Link: https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
// Solution Link: https://www.youtube.com/watch?v=GqtyVD-x_jY&list=PLDzeHZWIZsTqBmRGnsCOGNDG5FY0G04Td&index=10&t=882s

package Recursion.BackTracking.Hard;

import java.util.ArrayList;

class Solution {

    // Recursive function to find paths in the grid
    public static void solve(int[][] m, int n, int x, int y, StringBuffer subAns, int[][] isVisited,
            ArrayList<String> result) {
        // Base Case: Reached the destination
        if ((x == n - 1) && (y == n - 1)) {
            result.add((new StringBuffer(subAns)).toString());
            return;
        }

        // Explore Downward
        if (((x + 1) < n) && (isVisited[x + 1][y] == 0) && (m[x + 1][y] == 1)) {
            isVisited[x + 1][y] = 1;
            subAns.append('D');
            solve(m, n, x + 1, y, subAns, isVisited, result);
            isVisited[x + 1][y] = 0;
            subAns.deleteCharAt(subAns.length() - 1);
        }

        // Explore Rightward
        if (((y + 1) < n) && (isVisited[x][y + 1] == 0) && (m[x][y + 1] == 1)) {
            isVisited[x][y + 1] = 1;
            subAns.append('R');
            solve(m, n, x, y + 1, subAns, isVisited, result);
            isVisited[x][y + 1] = 0;
            subAns.deleteCharAt(subAns.length() - 1);
        }

        // Explore Leftward
        if (((y - 1) >= 0) && (isVisited[x][y - 1] == 0) && (m[x][y - 1] == 1)) {
            isVisited[x][y - 1] = 1;
            subAns.append('L');
            solve(m, n, x, y - 1, subAns, isVisited, result);
            isVisited[x][y - 1] = 0;
            subAns.deleteCharAt(subAns.length() - 1);
        }

        // Explore Upward
        if (((x - 1) >= 0) && (isVisited[x - 1][y] == 0) && (m[x - 1][y] == 1)) {
            isVisited[x - 1][y] = 1;
            subAns.append('U');
            solve(m, n, x - 1, y, subAns, isVisited, result);
            isVisited[x - 1][y] = 0;
            subAns.deleteCharAt(subAns.length() - 1);
        }
    }

    // Main function to find paths in the grid
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Resultant list to store valid paths
        ArrayList<String> result = new ArrayList<>();

        // StringBuffer to store the current path
        StringBuffer subAns = new StringBuffer();

        // 2D array to keep track of visited cells
        int[][] isVisited = new int[n][n];

        // Initialize isVisited array to 0 (not visited) for all cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                isVisited[i][j] = 0;
            }
        }

        // Starting cell coordinates
        int x = 0;
        int y = 0;

        // Mark the starting cell as visited
        isVisited[x][y] = 1;

        // Check if starting or ending cell is blocked, return empty result if true
        if (m[0][0] == 0 || m[n - 1][n - 1] == 0) {
            return result;
        }

        // Call the solve function to find paths recursively
        solve(m, n, x, y, subAns, isVisited, result);

        // Return the list of valid paths
        return result;
    }
}
