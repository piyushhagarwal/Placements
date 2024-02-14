// Link : https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
// Solution : https://www.youtube.com/watch?v=9twcmtQj4DU
package Graphs.DFSBFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {

    // DFS function to detect cycles in a directed graph
    public Boolean dfs(int node, Map<Integer, Boolean> visited, Map<Integer, Boolean> pathVisited,
            ArrayList<ArrayList<Integer>> adj) {
        // Mark the current node as visited and part of the current path
        visited.put(node, true);
        pathVisited.put(node, true);

        boolean ans = false;

        // Iterate through the neighbors of the current node
        for (int i = 0; i < adj.get(node).size(); i++) {
            if (!visited.containsKey(adj.get(node).get(i))) {
                // If the neighbor is not visited, recursively call DFS on it
                ans = dfs(adj.get(node).get(i), visited, pathVisited, adj);

                // Update ans and check for cycles
                if (ans) {
                    return true;
                }
            } else if (pathVisited.containsKey(adj.get(node).get(i))) {
                // If the neighbor is part of the current path, indicating a cycle
                return true;
            }
            // Do not return false here, as it would terminate the loop prematurely
        }

        // Remove the current node from the path to backtrack
        pathVisited.remove(node);
        return false; // No cycle found from the current node
    }

    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

        // Map to track whether a node is visited during traversal
        Map<Integer, Boolean> visited = new HashMap<>();
        // Map to track whether a node is part of the current path during traversal
        Map<Integer, Boolean> pathVisited = new HashMap<>();

        // Iterate through all nodes in the graph
        for (int i = 0; i < V; i++) {
            // If DFS detects a cycle, return true
            if (!visited.containsKey(i)) {
                boolean temp = dfs(i, visited, pathVisited, adj);
                if (temp) {
                    return true;
                }
            }
        }

        // If no cycles are detected after traversing all nodes, return false
        return false;
    }

    public static void main(String[] args) {
        // Example usage
        int V = 4; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the directed graph
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(1).add(3);

        Solution solution = new Solution();
        boolean cyclic = solution.isCyclic(V, adj);

        System.out.println("Graph contains a cycle: " + cyclic);
    }
}
