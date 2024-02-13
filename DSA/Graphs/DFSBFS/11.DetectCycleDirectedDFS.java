//Link : https://www.codingninjas.com/studio/problems/detect-cycle-in-a-directed-graph-_920545
// Solution : https://www.youtube.com/watch?v=9twcmtQj4DU
package Graphs.DFSBFS;

import java.util.*;

class Solution {
    // DFS function to detect cycles in a directed graph
    public static Boolean dfs(int node, Map<Integer, Boolean> visited, Map<Integer, Boolean> pathVisited,
            List<Integer>[] adj) {
        // Mark the current node as visited and part of the current path
        visited.put(node, true);
        pathVisited.put(node, true);

        boolean ans = false;

        // Iterate through the neighbors of the current node
        for (int i = 0; i < adj[node].size(); i++) {
            // If the neighbor is not visited, recursively call DFS on it
            if (!visited.containsKey(adj[node].get(i))) {
                ans = dfs(adj[node].get(i), visited, pathVisited, adj);
            } else if (visited.containsKey(adj[node].get(i)) && !pathVisited.containsKey(adj[node].get(i))) {
                // If the neighbor is visited but not part of the current path, continue to the
                // next neighbor
                continue;
            } else {
                // The neighboring node is visited as well as part of the current path,
                // indicating a cycle
                return true;
            }
        }

        // Remove the current node from the path to backtrack
        pathVisited.remove(node);
        return ans;
    }

    // Function to check if the directed graph contains a cycle
    public static Boolean isCyclic(int[][] edges, int v, int e) {
        // Adjacency list representation of the directed graph
        List<Integer>[] adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }

        // Populate the adjacency list with the given edges
        for (int i = 0; i < e; i++) {
            adj[edges[i][0]].add(edges[i][1]);
        }

        // Map to track whether a node is visited during traversal
        Map<Integer, Boolean> visited = new HashMap<>();
        // Map to track whether a node is part of the current path during traversal
        Map<Integer, Boolean> pathVisited = new HashMap<>();

        // Iterate through all nodes in the graph
        for (int i = 0; i < v; i++) {
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
}
