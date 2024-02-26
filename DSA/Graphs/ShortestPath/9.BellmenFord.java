// Given a weighted and directed graph of V vertices and E edges, Find the shortest distance of all the vertex's from the source vertex S. If a vertices can't be reach from the S then mark the distance as 10^8. Note: If the Graph contains a negative cycle then return an array consisting of only -1.

// Example 1:

// Input:

// E = [[0,1,9]]
// S = 0
// Output:
// 0 9
// Explanation:
// Shortest distance of all nodes from
// source is printed.
// Example 2:

// Input:

// E = [[0,1,5],[1,0,3],[1,2,-1],[2,0,1]]
// S = 2
// Output:
// 1 6 0
// Explanation:
// For nodes 2 to 0, we can follow the path-
// 2-0. This has a distance of 1.
// For nodes 2 to 1, we cam follow the path-
// 2-0-1, which has a distance of 1+5 = 6,

// Link: https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1
// Solution: https://www.youtube.com/watch?v=0vVofAhAYjc

package Graphs.ShortestPath;

import java.util.ArrayList;

// algorithm

// 1. Create an array dist[] of size V with all values as infinite except dist[src] = 0 where src is the source vertex.
// 2. Run a loop V-1 times and in each iteration, update the value of dist[] for all the edges. 
// The update is done by comparing the current value of dist[] with the sum of weight of the edge and dist[] of the source vertex.
// 3. After V-1 iterations, check for negative weight cycles.
// 4. If there is a negative weight cycle, then there is no shortest path. If there is no negative weight cycle, then dist[] array will contain the shortest paths.

import java.util.ArrayList;

class Solution {
    // Function to perform Bellman-Ford algorithm
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Initialize an array to store minimum distances
        int dist[] = new int[V];

        // Set initial distances to a large value
        for (int i = 0; i < V; i++) {
            dist[i] = (int) 1e8;
        }

        // Mark source node distance to be 0
        dist[S] = 0;

        // Outer loop runs V - 1 times
        for (int i = 0; i < V - 1; i++) {
            // Inner loop relaxes edges
            for (ArrayList<Integer> edge : edges) {
                int u = edge.get(0); // source vertex
                int v = edge.get(1); // destination vertex
                int w = edge.get(2); // edge weight

                // If a shorter path is found, update the distance
                if (dist[u] != (int) 1e8 && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        // Checking for negative cycle
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);

            // If relaxation is still possible, there is a negative cycle
            if (dist[u] != (int) 1e8 && dist[u] + w < dist[v]) {
                int[] negativeCycle = { -1 };
                return negativeCycle;
            }
        }

        return dist;
    }
}
