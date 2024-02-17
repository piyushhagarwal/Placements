// Given a Directed Acyclic Graph of N vertices from 0 to N-1 and a 2D Integer array(or vector) edges[ ][ ] of length M, where there is a directed edge from edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i.

// Find the shortest path from src(0) vertex to all the vertices and if it is impossible to reach any vertex, then return -1 for that vertex.

// Example1:

// Input:
// N = 4, M = 2
// edge = [[0,1,2],[0,2,1]]
// Output:
// 0 2 1 -1
// Explanation:
// Shortest path from 0 to 1 is 0->1 with edge weight 2. 
// Shortest path from 0 to 2 is 0->2 with edge weight 1.
// There is no way we can reach 3, so it's -1 for 3.

// Example2:

// Input:
// N = 6, M = 7
// edge = [[0,1,2],[0,4,1],[4,5,4],[4,2,2],[1,2,3],[2,3,6],[5,3,1]]
// Output:
// 0 2 3 6 1 5
// Explanation:
// Shortest path from 0 to 1 is 0->1 with edge weight 2. 
// Shortest path from 0 to 2 is 0->4->2 with edge weight 1+2=3.
// Shortest path from 0 to 3 is 0->4->5->3 with edge weight 1+4+1=6.
// Shortest path from 0 to 4 is 0->4 with edge weight 1.
// Shortest path from 0 to 5 is 0->4->5 with edge weight 1+4=5.

// Link : https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1
// Solution : https://www.youtube.com/watch?v=C4gxoTaI71U

package Graphs.ShortestPath;

import java.util.*;

class Solution {
    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        // Create an adjacency list for the graph
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        // Populate the adjacency list with the given edges
        for (int i = 0; i < m; i++) {
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }

        // Array to store the shortest path distances from the source node
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = -1; // Initialize distances to -1 (unreachable initially)
        }

        // Map to track whether a node is visited during BFS
        Map<Integer, Boolean> isVisited = new HashMap<>();
        // Queue to store nodes for BFS traversal
        Queue<Integer> queue = new LinkedList<>();

        // Initialize BFS with the source node
        queue.add(src);
        isVisited.put(src, true);
        ans[src] = 0; // Distance from source to itself is 0

        // Perform BFS traversal
        while (!queue.isEmpty()) {
            int poppedNode = queue.poll();
            int distance = ans[poppedNode];

            // Explore neighbors of the current node
            for (int neighbour : adj[poppedNode]) {
                int currentDistance = ans[neighbour];

                // Update distance if not visited or if a shorter path is found
                if (currentDistance == -1) {
                    ans[neighbour] = distance + 1;
                } else {
                    ans[neighbour] = Math.min(ans[neighbour], distance + 1);
                }

                // Enqueue unvisited neighbors
                if (!isVisited.containsKey(neighbour)) {
                    isVisited.put(neighbour, true);
                    queue.add(neighbour);
                }
            }
        }

        return ans;
    }
}
