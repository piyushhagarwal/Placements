// Link : https://www.codingninjas.com/studio/problems/cycle-detection-in-undirected-graph_1062670
// Solution : https://www.youtube.com/watch?v=BPlrALf1LDU&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=11

package Graphs.DFSBFS;

import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    // Custom class to represent an element with a node and its previous node in the
    // traversal
    static class Element {
        int node;
        int prevNode;

        public Element(int node, int prevNode) {
            this.node = node;
            this.prevNode = prevNode;
        }
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
                // BFS traversal to check for cycles
                Queue<Element> queue = new LinkedList<>();
                queue.add(new Element(i, -1)); // Add the current node and its previous node to the queue
                isVisited.put(i, true);

                while (!queue.isEmpty()) {
                    Element poppedElement = queue.poll();
                    int currNode = poppedElement.node;
                    int prevNode = poppedElement.prevNode;

                    // Iterate through the neighbors of the current node
                    for (int index = 0; index < adj[currNode].size(); index++) {
                        // Skip the neighbor if it's the previous node (avoid going back)
                        if (adj[currNode].get(index) == prevNode) {
                            continue;
                        } else if (!isVisited.containsKey(adj[currNode].get(index))) {
                            // If the neighbor is not visited, add it to the queue and mark as visited
                            queue.add(new Element(adj[currNode].get(index), currNode));
                            isVisited.put(adj[currNode].get(index), true);
                        } else {
                            // If the neighbor is already visited, a cycle is detected
                            return "Yes".toString();
                        }
                    }
                }
            }
        }

        // If no cycles are detected after traversing all components, return "No"
        return "No".toString();
    }
}
