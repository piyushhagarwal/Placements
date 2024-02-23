// Link : https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/
// Solution : https://www.youtube.com/watch?v=_-0mx0SmYxA
package Graphs.ShortestPath;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    class Element {
        int node;
        int distance;

        public Element(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public int countPaths(int n, int[][] roads) {
        List<Element>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < roads.length; i++) {
            adj[roads[i][0]].add(new Element(roads[i][1], roads[i][2]));
            adj[roads[i][1]].add(new Element(roads[i][0], roads[i][2]));
        }

        PriorityQueue<Element> pq = new PriorityQueue<Element>((a, b) -> a.distance - b.distance);
        pq.add(new Element(0, 0));

        int dist[] = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = (int) 1e9;
        }
        dist[0] = 0;

        int ways[] = new int[n];
        for (int i = 0; i < n; i++) {
            ways[i] = -1;
        }
        ways[0] = 1;

        while (!pq.isEmpty()) {
            Element poppedElement = pq.poll();
            int node = poppedElement.node;
            int distance = poppedElement.distance;
            int poppedWays = ways[node];

            for (int i = 0; i < adj[node].size(); i++) {
                if (dist[adj[node].get(i).node] > distance + adj[node].get(i).distance) {
                    dist[adj[node].get(i).node] = distance + adj[node].get(i).distance;
                    pq.add(new Element(adj[node].get(i).node, dist[adj[node].get(i).node]));
                    ways[adj[node].get(i).node] = poppedWays % 1000000007;
                } else if (dist[adj[node].get(i).node] == distance + adj[node].get(i).distance) {
                    ways[adj[node].get(i).node] = (ways[adj[node].get(i).node] + poppedWays) % 1000000007;
                }
            }
        }

        return ways[n - 1] % 1000000007;
    }
}
