package Graphs.TopologicalSort;

// It is basically Topological Sort using BFS.
// The algorithm steps are as follows:
// 1. First, we will calculate the indegree of each node and store it in the indegree array. We can iterate through the given adj list, and simply for every node u->v, we can increase the indegree of v by 1 in the indegree array. 
// 2. Initially, there will be always at least a single node whose indegree is 0. So, we will push the node(s) with indegree 0 into the queue.
// 3. Then, we will pop a node from the queue including the node in our answer array, and for all its adjacent nodes, we will decrease the indegree of that node by one. For example, if node u that has been popped out from the queue has an edge towards node v(u->v), we will decrease indegree[v] by 1.
// 4. After that, if for any node the indegree becomes 0, we will push that node again into the queue.
// 5. We will repeat steps 3 and 4 until the queue is completely empty. Finally, completing the BFS we will get the linear ordering of the nodes in the answer array.

// Link : https://www.codingninjas.com/studio/problems/topological-sorting_973003
// Solution : https://www.youtube.com/watch?v=73sneFXuTEg

import java.util.*;

class Solution {

    // Function to perform topological sorting of the directed graph
    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
        // Adjacency list representation of the directed graph
        List<Integer>[] adj = new ArrayList[v];
        // Indegree array to track the number of incoming edges for each node
        int[] indegree = new int[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }

        // Populate the adjacency list with the given edges and calculate the indegree
        // of each node
        for (int i = 0; i < edges.length; i++) {
            adj[edges[i][0]].add(edges[i][1]);
            indegree[edges[i][1]]++;
        }

        // Queue to store nodes with indegree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Create a list to store the result in topological order
        List<Integer> ans = new ArrayList<>();

        // Process nodes in the queue and update indegrees
        while (!queue.isEmpty()) {
            int poppedElement = queue.poll();
            ans.add(poppedElement);

            // Update indegrees of the neighbors and add to the queue if their indegree
            // becomes 0
            for (int i = 0; i < adj[poppedElement].size(); i++) {
                indegree[adj[poppedElement].get(i)]--;
                if (indegree[adj[poppedElement].get(i)] == 0) {
                    queue.add(adj[poppedElement].get(i));
                }
            }
        }

        return ans;
    }
}
