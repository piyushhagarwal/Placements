// You are given an m x n grid where each cell can have one of three values:

// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

// Example 1:

// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4

// Example 2:

// Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1
// Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

// Example 3:

// Input: grid = [[0,2]]
// Output: 0
// Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

// Link : https://leetcode.com/problems/rotting-oranges/

package Graphs.DFSBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// The algorithm initializes a queue to perform BFS and counts the number of fresh oranges.
// It iterates through the grid, enqueues the coordinates of rotten oranges into the queue, and counts the number of fresh oranges.
// If there are no fresh oranges initially, the grid is already in the desired state, so the algorithm returns 0.
// It enters a BFS loop, where it dequeues each rotten orange, examines its adjacent oranges, rots them if they are fresh, and enqueues their coordinates.
// The loop continues until all possible oranges are rotten, and the time required is tracked.
// Finally, the algorithm returns the minimum time required. If there are remaining fresh oranges after the BFS loop, it returns -1, indicating that not all oranges can become rotten.

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        int freshOranges = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    ArrayList<Integer> location = new ArrayList<>();
                    location.add(i);
                    location.add(j);
                    queue.add(location);
                }
                if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0) {
            return 0;
        }

        int ans = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int ii = 0; ii < size; ii++) {
                ArrayList<Integer> poppedLocation = queue.poll();
                int i = poppedLocation.get(0);
                int j = poppedLocation.get(1);

                // Top
                if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                    ArrayList<Integer> location = new ArrayList<>();
                    location.add(i - 1);
                    location.add(j);
                    queue.add(location);
                    grid[i - 1][j] = 2;
                    freshOranges--;
                }

                // Bottom
                if (i + 1 < m && grid[i + 1][j] == 1) {
                    ArrayList<Integer> location = new ArrayList<>();
                    location.add(i + 1);
                    location.add(j);
                    queue.add(location);
                    grid[i + 1][j] = 2;
                    freshOranges--;
                }

                // Left
                if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                    ArrayList<Integer> location = new ArrayList<>();
                    location.add(i);
                    location.add(j - 1);
                    queue.add(location);
                    grid[i][j - 1] = 2;
                    freshOranges--;
                }

                // Right
                if (j + 1 < n && grid[i][j + 1] == 1) {
                    ArrayList<Integer> location = new ArrayList<>();
                    location.add(i);
                    location.add(j + 1);
                    queue.add(location);
                    grid[i][j + 1] = 2;
                    freshOranges--;
                }
            }
            if (queue.size() != 0) {
                ans++;
            }
        }
        if (freshOranges > 0) {
            return -1;
        }

        return ans;
    }
}
