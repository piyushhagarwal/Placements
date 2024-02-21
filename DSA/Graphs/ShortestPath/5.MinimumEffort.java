// You are a hiker preparing for an upcoming hike.You are given heights,a 2D array of size rows x columns,where heights[row][col]represents the height of cell(row,col).You are situated in the top-left cell,(0,0),and you hope to travel to the bottom-right cell,(rows-1,columns-1)(i.e.,0-indexed).You can move up,down,left,or right,and you wish to find a route that requires the minimum effort.

// A route'seffort is the maximum absolute difference in heights between two consecutive cells of the route.

// Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

// Example 1:

// Input:heights=[[1,2,2],[3,8,2],[5,3,5]]Output:2 Explanation:The route of[1,3,5,3,5]has a maximum absolute difference of 2 in consecutive cells.This is better than the route of[1,2,2,2,5],where the maximum absolute difference is 3. Example 2:

// Input:heights=[[1,2,3],[3,8,4],[5,3,5]]Output:1 Explanation:The route of[1,2,3,4,5]has a maximum absolute difference of 1 in consecutive cells,which is better than route[1,3,5,3,5].Example 3:

// Input:heights=[[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]Output:0 Explanation:This route does not require any effort.

// Link: https://leetcode.com/problems/path-with-minimum-effort/
// Solution : https://www.youtube.com/watch?v=0ytpZyiZFhA

package Graphs.ShortestPath;

import java.util.PriorityQueue;

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

    // Function to find the minimum effort path in a 2D grid of heights
    public int minimumEffortPath(int[][] heights) {
        // Priority queue for Dijkstra's algorithm
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);

        int rows = heights.length;
        int cols = heights[0].length;

        // Distance matrix to store the minimum effort to reach each cell
        int[][] dist = new int[rows][cols];

        // Initialize the distance matrix with a large value initially
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dist[i][j] = (int) 10e9;
            }
        }

        // Set the starting cell's distance to 0 and add it to the priority queue
        dist[0][0] = 0;
        pq.add(new Element(0, 0, 0));

        // Arrays for possible directions (up, down, left, right)
        int[] drow = { -1, 1, 0, 0 };
        int[] dcol = { 0, 0, -1, 1 };

        // Perform Dijkstra's algorithm
        while (!pq.isEmpty()) {
            Element poppedElement = pq.poll();
            int distance = poppedElement.distance;
            int i = poppedElement.row;
            int j = poppedElement.col;

            // Explore all possible directions
            for (int k = 0; k < 4; k++) {
                int ni = i + drow[k];
                int nj = j + dcol[k];

                // Check if the neighbor cell is within the grid bounds
                if (ni >= 0 && ni < rows && nj >= 0 && nj < cols) {
                    int effort = Math.max(distance, Math.abs(heights[i][j] - heights[ni][nj]));

                    // If the new effort is less than the previously recorded effort to reach the
                    // neighbor cell
                    if (effort < dist[ni][nj]) {
                        pq.add(new Element(effort, ni, nj));
                        dist[ni][nj] = effort;
                    }
                }
            }
        }

        // Return the minimum effort to reach the bottom-right cell
        return dist[rows - 1][cols - 1];
    }
}
