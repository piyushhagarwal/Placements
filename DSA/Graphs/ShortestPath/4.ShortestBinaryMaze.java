// Given an n x n binary matrix grid,return the length of the shortest clear path in the matrix.If there is no clear path,return-1.

// A clear path in a binary matrix is a path from the top-left cell(i.e.,(0,0))to the bottom-right cell(i.e.,(n-1,n-1))such that:

// All the visited cells of the path are 0. All the adjacent cells of the path are 8-directionally connected(i.e.,they are different and they share an edge or a corner).The length of a clear path is the number of visited cells of this path.

// Example 1:

// Input:grid=[[0,1],[1,0]]Output:2 Example 2:

// Input:grid=[[0,0,0],[1,1,0],[1,1,0]]Output:4 Example 3:

// Input:grid=[[1,0,0],[1,1,0],[1,1,0]]Output:-1

// Link : https://leetcode.com/problems/shortest-path-in-binary-matrix/
// Solution : https://www.youtube.com/watch?v=U5Mw4eyUmw4

package Graphs.ShortestPath;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // Class to represent an element with distance, row, and column
    class Element {
        int distance;
        int row;
        int col;

        public Element(int distance, int row, int col) {
            this.distance = distance;
            this.row = row;
            this.col = col;
        }
    }

    // Function to find the shortest path in a binary matrix
    public int shortestPathBinaryMatrix(int[][] grid) {
        // Check if the starting and ending points are valid
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }

        // Check if the matrix is a single cell with a value of 0
        if (grid.length == 1 && grid[0].length == 1 && grid[0][0] == 0) {
            return 1;
        }

        // Queue for BFS traversal
        Queue<Element> queue = new LinkedList<>();
        int dist[][] = new int[grid.length][grid[0].length];

        // Initialize distance matrix with a large value initially
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[0].length; j++) {
                dist[i][j] = (int) 10e9;
            }
        }

        // Add the starting point to the queue and set its distance to 1
        queue.add(new Element(1, 0, 0));
        dist[0][0] = 1;

        // Arrays for possible directions
        int[] drow = { -1, -1, 0, 1, 1, 1, 0, -1 };
        int[] dcol = { 0, 1, 1, 1, 0, -1, -1, -1 };

        // Perform BFS traversal
        while (!queue.isEmpty()) {
            Element poppedElement = queue.poll();
            int poppedDistance = poppedElement.distance;
            int poppedRow = poppedElement.row;
            int poppedCol = poppedElement.col;

            // Explore all 8 possible directions
            for (int i = 0; i < 8; i++) {
                if (poppedRow + drow[i] < grid.length && poppedRow + drow[i] >= 0
                        && poppedCol + dcol[i] < grid[0].length && poppedCol + dcol[i] >= 0
                        && grid[poppedRow + drow[i]][poppedCol + dcol[i]] == 0
                        && dist[poppedRow + drow[i]][poppedCol + dcol[i]] > poppedDistance + 1) {
                    // If the neighbor cell is valid and has not been visited
                    queue.add(new Element(poppedDistance + 1, poppedRow + drow[i], poppedCol + dcol[i]));
                    dist[poppedRow + drow[i]][poppedCol + dcol[i]] = poppedDistance + 1;

                    // Check if the destination is reached
                    if (poppedRow + drow[i] == grid.length - 1 && poppedCol + dcol[i] == grid[0].length - 1) {
                        return dist[poppedRow + drow[i]][poppedCol + dcol[i]];
                    }
                }
            }
        }

        return -1; // If there is no valid path to the destination
    }
}
