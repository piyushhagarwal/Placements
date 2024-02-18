// Given a Directed Acyclic Graph of N vertices from 0 to N-1 and a 2D Integer array(or vector) edges[ ][ ] of length M, where there is a directed edge from edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i.

// Find the shortest path from src(0) vertex to all the vertices and if it is impossible to reach any vertex, then return -1 for that vertex.

// Example1:

// Input:
// N = 4, M = 2
// edge = [[0,1,2],[0,2,1]]
// Output:
// 0 2 1 -1
// Explanation:
// Shortest path from 0 to 1 is 0->1 with edge weight 2. 
// Shortest path from 0 to 2 is 0->2 with edge weight 1.
// There is no way we can reach 3, so it's -1 for 3.
// Example2:

// Input:
// N = 6, M = 7
// edge = [[0,1,2],[0,4,1],[4,5,4],[4,2,2],[1,2,3],[2,3,6],[5,3,1]]
// Output:
// 0 2 3 6 1 5
// Explanation:
// Shortest path from 0 to 1 is 0->1 with edge weight 2. 
// Shortest path from 0 to 2 is 0->4->2 with edge weight 1+2=3.
// Shortest path from 0 to 3 is 0->4->5->3 with edge weight 1+4+1=6.
// Shortest path from 0 to 4 is 0->4 with edge weight 1.
// Shortest path from 0 to 5 is 0->4->5 with edge weight 1+4=5.

// Link : https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1
// Solution : https://www.youtube.com/watch?v=ZUFQfFaU-8U

package Graphs.ShortestPath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class Solution {
    class Element {
        int node;
        int distance;

        public Element(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    // Helper function for depth-first search (DFS) and topological sorting
    public void dfs(int i, Map<Integer, Boolean> isVisited, List<Element>[] adj, Stack<Integer> stack) {
        isVisited.put(i, true);
        for (int index = 0; index < adj[i].size(); index++) {
            if (!isVisited.containsKey(adj[i].get(index).node)) {
                dfs(adj[i].get(index).node, isVisited, adj, stack);
            }
        }
        stack.push(i);
    }

    public int[] shortestPath(int N, int M, int[][] edges) {
        // Step 1: Construct an adjacency list (Array of ArrayList<Element>)
        List<Element>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        // Populate the adjacency list with the given edges
        for (int i = 0; i < edges.length; i++) {
            adj[edges[i][0]].add(new Element(edges[i][1], edges[i][2]));
        }

        // Step 2: Do a topological sort using DFS
        Map<Integer, Boolean> isVisited = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (!isVisited.containsKey(i)) {
                dfs(i, isVisited, adj, stack);
            }
        }

        // Step 3: Remove elements from the stack and relax the edges

        // 1. Make a distance array
        int dist[] = new int[N];
        for (int i = 0; i < N; i++) {
            dist[i] = (int) (1e9); // Initialize distances to a large value initially
        }

        // 2. Make the source node distance 0
        dist[0] = 0;

        // Process nodes in topologically sorted order and update distances
        while (!stack.isEmpty()) {
            int poppedNode = stack.pop();
            int distance = dist[poppedNode];

            for (int i = 0; i < adj[poppedNode].size(); i++) {
                int neighbor = adj[poppedNode].get(i).node;
                int weight = adj[poppedNode].get(i).distance;

                int overallDistance = distance + weight;
                dist[neighbor] = Math.min(dist[neighbor], overallDistance);
            }
        }

        // Convert unreachable nodes to -1 in the distance array
        for (int i = 0; i < N; i++) {
            if (dist[i] == (int) (1e9)) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}
