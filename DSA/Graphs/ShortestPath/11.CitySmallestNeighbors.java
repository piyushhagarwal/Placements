// Link : https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
// Solution : https://www.youtube.com/watch?v=PwMVNSJ5SLI

package Graphs.ShortestPath;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Step 1: By Floyd Warshall populate matrix

        // Initialize a matrix to store distances between cities
        int matrix[][] = new int[n][n];

        // Populate matrix with edge weights from the given edges
        for (int i = 0; i < edges.length; i++) {
            matrix[edges[i][0]][edges[i][1]] = edges[i][2];
            matrix[edges[i][1]][edges[i][0]] = edges[i][2];
        }

        // Mark diagonal elements as 0 and unreachable elements as a large value
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && matrix[i][j] == 0) {
                    matrix[i][j] = (int) 1e8; // Using a large value to represent infinity
                }
            }
        }

        // Apply Floyd Warshall algorithm to find shortest distances
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == via || j == via || matrix[i][j] == 0) {
                        continue;
                    }
                    if (matrix[i][via] == (int) 1e8 || matrix[via][j] == (int) 1e8) {
                        continue;
                    }
                    if (matrix[i][j] == (int) 1e8 || matrix[i][via] + matrix[via][j] < matrix[i][j]) {
                        matrix[i][j] = matrix[i][via] + matrix[via][j];
                    }
                }
            }
        }

        // Step 2: Now check the matrix elements to find the city with the fewest
        // neighbors within the threshold

        int city = 0;
        int minNeighbors = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                // Count neighbors within the distance threshold
                if (matrix[i][j] != 0 && matrix[i][j] != (int) 1e8 && matrix[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            // Update the city if it has fewer neighbors within the threshold
            if (minNeighbors >= count) {
                minNeighbors = count;
                city = i;
            }
        }

        // Return the city with the fewest neighbors within the threshold
        return city;
    }
}
