// Link to the problem: https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1
// Link to the solution: https://www.youtube.com/watch?v=mJcZjjKzeqk

package Graphs.MSTDisjointSet;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    static class Element {
        int node;
        int weight;
        int parent;

        public Element(int node, int weight, int parent) {
            this.node = node;
            this.weight = weight;
            this.parent = parent;
        }
    }

    static int spanningTree(int V, int E, int edges[][]) {

        // Step1: Make adjacency list
        List<int[]>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            adj[u].add(new int[] { v, wt });
            adj[v].add(new int[] { u, wt });
        }

        // Create array to store parents and initialize it with -1
        int[] parentArr = new int[V];
        for (int i = 0; i < V; i++) {
            parentArr[i] = -1;
        }

        // Create visited Array and initially all elements to 0
        int[] visited = new int[V];

        // Create a priority queue of type Element which stores element on the basis of
        // minimum weights
        PriorityQueue<Element> pq = new PriorityQueue<Element>((a, b) -> a.weight - b.weight);

        // Sum to store the Minimum spanning tree ans
        int sum = 0;

        // Initially add 0
        pq.add(new Element(0, 0, -1));

        while (!pq.isEmpty()) {
            Element popped = pq.poll();
            int node = popped.node;
            int wt = popped.weight;
            int parent = popped.parent;

            // If the node is already visited
            if (visited[node] == 1) {
                continue;
            }

            visited[node] = 1;
            sum += wt;
            parentArr[node] = parent;

            // Traverse through its neighboring nodes
            for (int[] neighbor : adj[node]) {
                if (visited[neighbor[0]] != 1) {
                    pq.add(new Element(neighbor[0], neighbor[1], parent));
                }
            }
        }
        return sum;
    }
}
