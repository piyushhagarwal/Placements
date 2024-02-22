// Link : https://leetcode.com/problems/cheapest-flights-within-k-stops/
// Solution : https://www.youtube.com/watch?v=9XybHVqTHcQ

package Graphs.ShortestPath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    // Class to represent a pair of integers
    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    // Class to represent an element with stops, node, and distance
    class Element {
        int stops;
        int node;
        int distance;

        public Element(int stops, int node, int distance) {
            this.stops = stops;
            this.node = node;
            this.distance = distance;
        }
    }

    // Function to find the cheapest price within k stops from src to dst
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Adjacency list representation of the graph
        List<Pair>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        // Populate the adjacency list with flights information
        for (int i = 0; i < flights.length; i++) {
            adj[flights[i][0]].add(new Pair(flights[i][1], flights[i][2]));
        }

        // Array to store the minimum distance to reach each node
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = (int) 1e9;
        }

        // Queue for BFS traversal
        Queue<Element> queue = new LinkedList<>();
        queue.add(new Element(0, src, 0));

        // Perform BFS with a modification for stops
        while (!queue.isEmpty()) {
            Element poppedElement = queue.poll();
            int stops = poppedElement.stops;
            int node = poppedElement.node;
            int distance = poppedElement.distance;

            for (int i = 0; i < adj[node].size(); i++) {
                if (stops + 1 <= k + 1 && distance + adj[node].get(i).second < dist[adj[node].get(i).first]) {
                    dist[adj[node].get(i).first] = distance + adj[node].get(i).second;
                    queue.add(new Element(stops + 1, adj[node].get(i).first, dist[adj[node].get(i).first]));
                }
            }
        }

        // If the final destination is not reachable, return -1
        if (dist[dst] == (int) 1e9) {
            return -1;
        }

        // Return the minimum distance to reach the destination
        return dist[dst];
    }
}
