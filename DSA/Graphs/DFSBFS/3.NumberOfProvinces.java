// There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

// A province is a group of directly or indirectly connected cities and no other cities outside of the group.

// You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

// Return the total number of provinces.

// Example 1:

// Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
// Output: 2
// Example 2:

// Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
// Output: 3

// Link : https://leetcode.com/problems/number-of-provinces/

package Graphs.DFSBFS;

class Solution {
    // Function to find the number of connected components using DFS
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n]; // Array to track visited vertices
        int count = 0; // Counter for the number of connected components

        // Iterate through each vertex
        for (int i = 0; i < n; i++) {
            // If the current vertex is not visited, start a new connected component
            if (visited[i] == 0) {
                count++;
                dfs(i, visited, isConnected);
            }
        }
        return count;
    }

    // DFS function to traverse the graph and mark connected components
    public void dfs(int i, int[] visited, int[][] isConnected) {
        visited[i] = 1; // Mark the current vertex as visited

        // Iterate through neighbors of the current vertex
        for (int j = 0; j < isConnected.length; j++) {
            // Check if the neighbor is not the current vertex, not visited, and connected
            if (j != i && visited[j] == 0 && isConnected[i][j] == 1) {
                // Recursive call to DFS on the neighbor
                dfs(j, visited, isConnected);
            }
        }
    }
}
