// There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:

// There are no self-edges (graph[u] does not contain u).
// There are no parallel edges (graph[u] does not contain duplicate values).
// If v is in graph[u], then u is in graph[v] (the graph is undirected).
// The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
// A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.

// Return true if and only if it is bipartite.

// Example 1:

// Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
// Output: false
// Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.
// Example 2:

// Input: graph = [[1,3],[0,2],[1,3],[0,2]]
// Output: true
// Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.

// Link : https://leetcode.com/problems/is-graph-bipartite/
// Solution : https://www.youtube.com/watch?v=KG5YFfR0j8A

package Graphs.DFSBFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// The logic we use in this code is, we give a flag to the first node and then we give the opposite flag to its neighbours and then we give the opposite flag to the neighbours of the neighbours and so on.
// If we find a node which is already visited and has the same flag as the current node, then we return false.
// If we are able to traverse the whole graph without any conflicts, then we return true.

class Solution {
    // Function to check if the graph is bipartite
    public boolean isBipartite(int[][] graph) {
        // Map to store whether each node is visited and its assigned flag
        Map<Integer, Integer> isVisited = new HashMap<>(); // Node and flag
        isVisited.put(0, 0); // Assume the starting node (0) is in the first group (flag 0)

        // Iterate through all nodes in the graph
        for (int i = 0; i < graph.length; i++) {
            // Check if the node is not visited
            if (i == 0 || !isVisited.containsKey(i)) {
                // BFS traversal for each connected component
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[] { i, 0 }); // Add the current node and its flag to the queue
                while (!queue.isEmpty()) {
                    int[] element = queue.poll();
                    int node = element[0];
                    int flag = element[1];

                    // Iterate through the neighbors of the current node
                    for (int ii = 0; ii < graph[node].length; ii++) {
                        // Check if the neighbor is already visited
                        if (isVisited.containsKey(graph[node][ii])) {
                            // Check if the neighbor has the same or different flag
                            if ((flag == 0 && isVisited.get(graph[node][ii]) == 1)
                                    || (flag == 1 && isVisited.get(graph[node][ii]) == 0)) {
                                // If the flags are not compatible, return false
                                continue;
                            } else {
                                return false;
                            }
                        } else {
                            // If the neighbor is not visited, assign the opposite flag and add to the queue
                            int changedFlag = flag == 0 ? 1 : 0;
                            isVisited.put(graph[node][ii], changedFlag);
                            queue.add(new int[] { graph[node][ii], changedFlag });
                        }
                    }
                }
            }
        }

        // If all components are checked and no conflicts found, the graph is bipartite
        return true;
    }
}
