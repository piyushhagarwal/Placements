// You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

// We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

// Example 1:

// Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
// Output: 2
// Example 2:

// Input: times = [[1,2,1]], n = 2, k = 1
// Output: 1
// Example 3:

// Input: times = [[1,2,1]], n = 2, k = 2
// Output: -1

// Link : https://leetcode.com/problems/network-delay-time/

package Graphs.ShortestPath;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// Can also be solved using BFS

class Solution {
    // Class to represent a node with distance information
    class Element {
        int node;
        int distance;

        public Element(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    // Function to find the minimum network delay time
    public int networkDelayTime(int[][] times, int n, int k) {
        // Adjacency list representation of the graph
        List<Element>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        // Populate the adjacency list with travel times
        for (int i = 0; i < times.length; i++) {
            adj[times[i][0]].add(new Element(times[i][1], times[i][2]));
        }

        // Array to store the minimum distance to each node
        int[] dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dist[i] = (int) 1e9;
        }
        dist[k] = 0;

        // Priority queue for Dijkstra's algorithm
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.add(new Element(k, 0));

        // Perform Dijkstra's algorithm
        while (!pq.isEmpty()) {
            Element poppedElement = pq.poll();
            int node = poppedElement.node;
            int distance = poppedElement.distance;

            for (int i = 0; i < adj[node].size(); i++) {
                if (adj[node].get(i).distance + distance < dist[adj[node].get(i).node]) {
                    dist[adj[node].get(i).node] = adj[node].get(i).distance + distance;
                    pq.add(new Element(adj[node].get(i).node, dist[adj[node].get(i).node]));
                }
            }
        }

        // Find the maximum distance to any node
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == (int) 1e9) {
                return -1; // If any node is not reachable, return -1
            }
            max = Math.max(max, dist[i]);
        }

        return max; // Return the maximum distance
    }
}
