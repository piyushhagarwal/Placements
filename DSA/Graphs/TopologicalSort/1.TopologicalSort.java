// In topological sorting, node u will always appear before node v if there is a directed edge from node u towards node v(u -> v).
// Example 1:
// Input: V = 6, E = 6

// Output: 5, 4, 2, 3, 1, 0
// Explanation: A graph may have multiple topological sortings. 
// The result is one of them. The necessary conditions 
// for the ordering are:
// According to edge 5 -> 0, node 5 must appear before node 0 in the ordering.
// According to edge 4 -> 0, node 4 must appear before node 0 in the ordering.
// According to edge 5 -> 2, node 5 must appear before node 2 in the ordering.
// According to edge 2 -> 3, node 2 must appear before node 3 in the ordering.
// According to edge 3 -> 1, node 3 must appear before node 1 in the ordering.
// According to edge 4 -> 1, node 4 must appear before node 1 in the ordering.

// The above result satisfies all the necessary conditions. 
// [4, 5, 2, 3, 1, 0] is also one such topological sorting 
// that satisfies all the conditions.
// Example 2:
// Input: V = 4, E = 3

// Result: 3, 2, 1, 0
// Explanation: The necessary conditions for the ordering are:
// For edge 1 -> 0 node 1 must appear before node 0.
// For edge 2 -> 0 node 1 must appear before node 0.
// For edge 3 -> 0 node 1 must appear before node 0.

// [2, 3, 1, 0] is also another topological sorting for the graph.

// Topological sorting only exists in Directed Acyclic Graph (DAG). If the nodes of a graph are connected through directed edges and the graph does not contain a cycle, it is called a directed acyclic graph(DAG). 

// Link : https://www.codingninjas.com/studio/problems/topological-sorting_973003
// Solution : https://www.youtube.com/watch?v=5lZ0iJMrUMk

package Graphs.TopologicalSort;

// Algorithm:

// 1. We must traverse all components of the graph.
// 2. Make sure to carry a visited array(all elements are initialized to 0) and a stack data structure, where we are going to store the nodes after completing the DFS call.
// 3. In the DFS call, first, the current node is marked as visited. Then DFS call is made for all its adjacent nodes.
// 4. After visiting all its adjacent nodes, DFS will backtrack to the previous node and meanwhile, the current node is pushed into the stack.
// 5. Finally, we will get the stack containing one of the topological sortings of the graph.

import java.util.*;

class Solution {

    // DFS function to perform topological sorting and push nodes onto the stack
    public static void dfs(int node, Map<Integer, Boolean> visited, List<Integer>[] adj, Stack<Integer> stack) {
        // Mark the current node as visited
        visited.put(node, true);

        // Iterate through the neighbors of the current node
        for (int i = 0; i < adj[node].size(); i++) {
            // If the neighbor is not visited, recursively call DFS on it
            if (!visited.containsKey(adj[node].get(i))) {
                dfs(adj[node].get(i), visited, adj, stack);
            }
        }

        // Push the current node onto the stack after all its neighbors are processed
        stack.push(node);
    }

    // Function to perform topological sorting of the directed graph
    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
        // Adjacency list representation of the directed graph
        List<Integer>[] adj = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }

        // Populate the adjacency list with the given edges
        for (int i = 0; i < edges.length; i++) {
            adj[edges[i][0]].add(edges[i][1]);
        }

        // Stack to store the topological ordering of the nodes
        Stack<Integer> stack = new Stack<>();
        // Map to track whether a node is visited during traversal
        Map<Integer, Boolean> visited = new HashMap<>();

        // Iterate through all nodes in the graph
        for (int i = 0; i < v; i++) {
            // If the node is not visited, perform DFS to get the topological ordering
            if (!visited.containsKey(i)) {
                dfs(i, visited, adj, stack);
            }
        }

        // Create a list to store the result in topological order
        List<Integer> ans = new ArrayList<>();

        // Pop elements from the stack to get the topological order
        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }

        return ans;
    }

}
