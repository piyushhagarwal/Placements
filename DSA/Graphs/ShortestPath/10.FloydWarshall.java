// Link : https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1
// Solution : https://www.youtube.com/watch?v=YbY8cVwWAvw

package Graphs.ShortestPath;

class Solution {
    // Method to find the shortest distances between all pairs of vertices in a
    // given graph
    public void shortest_distance(int[][] matrix) {
        // Get the number of vertices in the graph
        int n = matrix.length;

        // Iterate over all vertices (via) to find the shortest paths
        for (int via = 0; via < n; via++) {
            // Iterate over all pairs of vertices (i, j)
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    // Skip if the vertex 'via' is the same as either 'i' or 'j'
                    // or if there is no direct edge between 'i' and 'j'
                    if (i == via || j == via || matrix[i][j] == 0) {
                        continue;
                    }

                    // Skip if there is no path from 'i' to 'via' or from 'via' to 'j'
                    if (matrix[i][via] == -1 || matrix[via][j] == -1) {
                        continue;
                    }

                    // If there is no direct path from 'i' to 'j' or
                    // the path via 'via' is shorter than the current known path,
                    // update the shortest path from 'i' to 'j'
                    if (matrix[i][j] == -1 || matrix[i][via] + matrix[via][j] < matrix[i][j]) {
                        matrix[i][j] = matrix[i][via] + matrix[via][j];
                    }

                }
            }
        }
    }
}
