// Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.
// Note: One can move from node u to node v only if there's an edge from u to v. Find the BFS traversal of the graph starting from the 0th vertex, from left to right according to the input graph. Also, you should only take nodes directly or indirectly connected from Node 0 in consideration.

// Example 1:

// Input:
// V = 5, E = 4
// adj = {{1,2,3},{},{4},{},{}}

// Output: 
// 0 1 2 3 4
// Explanation: 
// 0 is connected to 1 , 2 , 3.
// 2 is connected to 4.
// so starting from 0, it will go to 1 then 2
// then 3. After this 2 to 4, thus bfs will be
// 0 1 2 3 4.
// Example 2:

// Input:
// V = 3, E = 2
// adj = {{1,2},{},{}}

// Output: 
// 0 1 2
// Explanation:
// 0 is connected to 1 , 2.
// so starting from 0, it will go to 1 then 2,
// thus bfs will be 0 1 2. 

// Link : https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1#
// Solution : https://www.youtube.com/watch?v=b5kij1Akf9I&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=94

package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Initialize a queue for BFS traversal
        Queue<Integer> queue = new LinkedList<>();

        // Initialize a list to store the result of BFS traversal
        ArrayList<Integer> ans = new ArrayList<>();

        // Map to keep track of visited nodes
        Map<Integer, Boolean> isVisited = new HashMap<>();

        // Start BFS from the first node (0 in this case)
        queue.add(0);
        isVisited.put(0, true);

        // Perform BFS traversal
        while (!queue.isEmpty()) {
            // Remove and process the front element of the queue
            int poppedElement = queue.poll();
            ans.add(poppedElement);

            // Get the adjacent nodes of the current element
            ArrayList<Integer> list = adj.get(poppedElement);

            // Iterate through the adjacent nodes
            for (int i = 0; i < list.size(); i++) {
                // Check if the node is not visited
                if (!isVisited.containsKey(list.get(i))) {
                    // Add the unvisited node to the queue and mark it as visited
                    queue.add(list.get(i));
                    isVisited.put(list.get(i), true);
                }
            }
        }

        // Return the result of BFS traversal
        return ans;
    }
}
// Time Complexity : O(V + E)
// Space Complexity : O(V + E)