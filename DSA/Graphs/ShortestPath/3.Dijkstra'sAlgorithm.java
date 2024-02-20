// Link : https://www.codingninjas.com/studio/problems/dijkstra's-shortest-path_985358
// Solution : https://www.youtube.com/watch?v=V6H1qAeB-l4
package Graphs.ShortestPath;

// Algorithm
// 1. Create an adjacency list for the graph.
// 2. Create a priority queue to store the nodes and their distances from the source node.(Min heap based on distance)
// 3. Create a list to store the shortest distances from the source node.
// 4. Initialize the list with a large value initially.
// 5. Add the source node to the priority queue with distance 0.
// 6. Perform Dijkstra's algorithm.
// 7. Explore neighbors of the current node.
// 8. Relax the edge if a shorter path is found.
// 9. Return the list of shortest distances from the source node.

import java.util.*;

class Solution {
    public static class Element {
        int node;
        int distance;

        public Element(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    // Function to perform Dijkstra's algorithm
    public static List<Integer> dijkstra(int[][] edge, int vertices, int edges, int source) {
        // Create an adjacency list for the graph
        List<Element>[] adj = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new ArrayList<>();
        }

        // Populate the adjacency list with the given edges
        for (int i = 0; i < edges; i++) {
            adj[edge[i][0]].add(new Element(edge[i][1], edge[i][2]));
            adj[edge[i][1]].add(new Element(edge[i][0], edge[i][2]));
        }

        // Priority Queue for the min-heap
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);

        // List to store the shortest distances from the source node
        List<Integer> ans = new ArrayList<>();

        // Initialize the list with a large value initially
        for (int i = 0; i < vertices; i++) {
            ans.add(1000000007);
        }

        // Add the source node to the priority queue with distance 0
        pq.add(new Element(source, 0));
        ans.set(source, 0);

        // Perform Dijkstra's algorithm
        while (!pq.isEmpty()) {
            Element poppedElement = pq.poll();
            int node = poppedElement.node;
            int distance = poppedElement.distance;

            // Explore neighbors of the current node
            for (int i = 0; i < adj[node].size(); i++) {
                Element neighbor = adj[node].get(i);
                int neighborNode = neighbor.node;
                int neighborDistance = neighbor.distance;

                // Relax the edge if a shorter path is found
                if (distance + neighborDistance < ans.get(neighborNode)) {
                    ans.set(neighborNode, distance + neighborDistance);
                    pq.add(new Element(neighborNode, distance + neighborDistance));
                }
            }
        }

        return ans;
    }
}
