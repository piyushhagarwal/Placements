// Link : https://www.codingninjas.com/studio/problems/cycle-detection-in-undirected-graph_1062670
// Solution : https://www.youtube.com/watch?v=zQ3zgFypzX4&embeds_referring_euri=https%3A%2F%2Ftakeuforward.org%2F&source_ve_path=OTY3MTQ&feature=emb_imp_woyt
package Graphs.DFSBFS;

import java.util.Map;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    // Function to perform DFS and detect cycles
    public static String dfs(int node, int prevNode, Map<Integer, Boolean> isVisited, List<Integer>[] adj) {
        // Mark the current node as visited
        isVisited.put(node, true);
        String ans = "No";

        // Iterate through the neighbors of the current node
        for (int i = 0; i < adj[node].size(); i++) {
            // Skip the neighbor if it's the previous node (avoid going back)
            if (adj[node].get(i) == prevNode) {
                continue;
            } else if (!isVisited.containsKey(adj[node].get(i))) {
                // If the neighbor is not visited, recursively call DFS on it
                ans = dfs(adj[node].get(i), node, isVisited, adj);
            } else {
                // If the neighbor is already visited, a cycle is detected
                ans = "Yes".toString();
                return ans;
            }
        }
        return ans;
    }

    // Function to detect cycles in an undirected graph
    public static String cycleDetection(int[][] edges, int n, int m) {
        // Adjacency list representation of the graph
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        // Populate the adjacency list with the given edges
        for (int i = 0; i < edges.length; i++) {
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }

        // Map to track whether a node is visited during traversal
        Map<Integer, Boolean> isVisited = new HashMap<>();

        // Iterate through all nodes in the graph
        for (int i = 1; i <= n; i++) {
            // Check if the current node is not visited
            if (!isVisited.containsKey(i)) {
                // If DFS detects a cycle, return "Yes"
                if (dfs(i, -1, isVisited, adj).equals("Yes")) {
                    return "Yes".toString();
                }
            }
        }

        // If no cycles are detected after traversing all components, return "No"
        return "No".toString();
    }
}
