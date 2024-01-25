// Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

// The distance between two adjacent cells is 1.

// Example 1:

// Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
// Output: [[0,0,0],[0,1,0],[0,0,0]]

// Example 2:

// Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
// Output: [[0,0,0],[0,1,0],[1,2,1]]

// Link : https://leetcode.com/problems/01-matrix/
// Solution : https://www.youtube.com/watch?v=edXdVwkYHF8

package Graphs.DFSBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Algorithm

// 1. Initialize a queue and mark '0' cells as visited in the matrix.
// 2. Enqueue the positions of '0' cells along with a distance of 0.
// 3. While the queue is not empty, dequeue an entry, update the distance in the result matrix, and explore neighboring cells.
// 4. For each unvisited neighboring cell, enqueue its position and update the distance.
// 5. Repeat until the queue is empty, and the result matrix is updated with minimum distances.

class Solution {

    // Helper class to represent position and distance
    class Entry {
        List<Integer> position;
        int distance;

        public Entry(List<Integer> position, int distance) {
            this.position = position;
            this.distance = distance;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] visited = new int[m][n];
        int[][] ans = new int[m][n];

        Queue<Entry> queue = new LinkedList<>();

        // Initialize the queue with '0' cells and mark them as visited
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    List<Integer> position = new ArrayList<>();
                    position.add(i);
                    position.add(j);
                    Entry entry = new Entry(position, 0);
                    queue.add(entry);
                    visited[i][j] = 1;
                }
            }
        }

        // Perform BFS
        while (!queue.isEmpty()) {
            Entry poppedEntry = queue.poll();
            List<Integer> position = poppedEntry.position;
            int i = position.get(0);
            int j = position.get(1);
            int distance = poppedEntry.distance;

            ans[i][j] = distance; // Update the distance in the result matrix

            // Explore neighboring cells

            // Top
            if (i - 1 >= 0 && mat[i - 1][j] == 1 && visited[i - 1][j] == 0) {
                List<Integer> tempPosition = new ArrayList<>();
                tempPosition.add(i - 1);
                tempPosition.add(j);
                Entry entry = new Entry(tempPosition, distance + 1);
                queue.add(entry);
                visited[i - 1][j] = 1; // Mark the cell as visited
            }
            // Left
            if (j - 1 >= 0 && mat[i][j - 1] == 1 && visited[i][j - 1] == 0) {
                List<Integer> tempPosition = new ArrayList<>();
                tempPosition.add(i);
                tempPosition.add(j - 1);
                Entry entry = new Entry(tempPosition, distance + 1);
                queue.add(entry);
                visited[i][j - 1] = 1; // Mark the cell as visited
            }
            // Bottom
            if (i + 1 < m && mat[i + 1][j] == 1 && visited[i + 1][j] == 0) {
                List<Integer> tempPosition = new ArrayList<>();
                tempPosition.add(i + 1);
                tempPosition.add(j);
                Entry entry = new Entry(tempPosition, distance + 1);
                queue.add(entry);
                visited[i + 1][j] = 1; // Mark the cell as visited
            }
            // Right
            if (j + 1 < n && mat[i][j + 1] == 1 && visited[i][j + 1] == 0) {
                List<Integer> tempPosition = new ArrayList<>();
                tempPosition.add(i);
                tempPosition.add(j + 1);
                Entry entry = new Entry(tempPosition, distance + 1);
                queue.add(entry);
                visited[i][j + 1] = 1; // Mark the cell as visited
            }
        }
        return ans;
    }
}
