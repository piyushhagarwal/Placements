// There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].

// A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).

// Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

// Example 1:

// Illustration of graph
// Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
// Output: [2,4,5,6]
// Explanation: The given graph is shown above.
// Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
// Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
// Example 2:

// Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
// Output: [4]
// Explanation:
// Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.

// Link : https://leetcode.com/problems/find-eventual-safe-states/
// Solution : https://www.youtube.com/watch?v=2gtg3VsDGyc

package Graphs.TopologicalSort;

// Reverse the graph and then find the topological sort of the graph.
import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); // Reverse graph
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Create a reversed graph (reverse edges)
        for (int i = 0; i < graph.length; i++) {
            for (int neighbor : graph[i]) {
                adj.get(neighbor).add(i);
            }
        }

        // Indegree array to track the number of incoming edges for each node
        int[] indegree = new int[V];

        // Calculate the indegree of each node in the reversed graph
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

        List<Integer> safeStates = new ArrayList<>();

        // Process nodes in the queue and update indegrees
        while (!queue.isEmpty()) {
            int poppedElement = queue.poll();
            safeStates.add(poppedElement);

            for (int neighbor : adj.get(poppedElement)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        Collections.sort(safeStates);
        return safeStates;
    }
}
