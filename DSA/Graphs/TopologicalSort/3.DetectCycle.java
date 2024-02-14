// Link : https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
// Solution : https://www.youtube.com/watch?v=iTBaI90lpDQ

package Graphs.TopologicalSort;

import java.util.*;

// First find the topological sort form KahnsAlgo.java and then check if the number of nodes in the topological sort is equal to the number of nodes in the graph.
// If yes, then the graph is acyclic, else cyclic.

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // Indegree array to track the number of incoming edges for each node
        int[] indegree = new int[V];

        // Calculate the indegree of each node in the graph
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                indegree[neighbor]++;
            }
        }

        // Queue to store nodes with indegree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Count of nodes with indegree 0
        int count = 0;

        // Process nodes in the queue and update indegrees
        while (!queue.isEmpty()) {
            int poppedElement = queue.poll();
            count++;

            for (int neighbor : adj.get(poppedElement)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // If all nodes are processed, there is no cycle (graph is acyclic)
        return count != V;
    }
}
