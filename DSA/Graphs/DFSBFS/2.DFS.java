// You are given a connected undirected graph. Perform a Depth First Traversal of the graph.
// Note: Use the recursive approach to find the DFS traversal of the graph starting from the 0th vertex from left to right according to the graph.

// Example 1:

// Input: V = 5 , adj = [[2,3,1] , [0], [0,4], [0], [2]]

// Output: 0 2 4 3 1
// Explanation: 
// 0 is connected to 2, 3, 1.
// 1 is connected to 0.
// 2 is connected to 0 and 4.
// 3 is connected to 0.
// 4 is connected to 2.
// so starting from 0, it will go to 2 then 4,
// and then 3 and 1.
// Thus dfs will be 0 2 4 3 1.

// Example 2:

// Input: V = 4, adj = [[1,3], [2,0], [1], [0]]

// Output: 0 1 2 3
// Explanation:
// 0 is connected to 1 , 3.
// 1 is connected to 0, 2. 
// 2 is connected to 1.
// 3 is connected to 0. 
// so starting from 0, it will go to 1 then 2
// then back to 0 then 0 to 3
// thus dfs will be 0 1 2 3. 

// Expected Time Complexity: O(V + E)
// Expected Auxiliary Space: O(V)

// Link : https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1#
// Solution : https://www.youtube.com/watch?v=aJa3U-hydXc

package Graphs.DFSBFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    // Function to perform DFS traversal starting from a given vertex
    public void dfs(int startVertex, ArrayList<ArrayList<Integer>> adj, Map<Integer, Boolean> isVisited,
            ArrayList<Integer> ans) {
        // Add the current vertex to the result list
        ans.add(startVertex);
        // Mark the current vertex as visited
        isVisited.put(startVertex, true);

        // Get the neighbors of the current vertex
        ArrayList<Integer> neighbors = adj.get(startVertex);

        // Iterate through the neighbors
        for (int i = 0; i < neighbors.size(); i++) {
            // Check if the neighbor is not visited
            if (!isVisited.containsKey(neighbors.get(i))) {
                // Recursive call to perform DFS on the neighbor
                dfs(neighbors.get(i), adj, isVisited, ans);
            }
        }
    }

    // Function to return a list containing the DFS traversal of the graph
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Result list to store the DFS traversal
        ArrayList<Integer> ans = new ArrayList<>();
        // Map to track visited vertices
        Map<Integer, Boolean> isVisited = new HashMap<>();

        // Starting vertex for DFS traversal (in this case, starting from vertex 0)
        int startVertex = 0;

        // Perform DFS traversal starting from the specified vertex
        dfs(startVertex, adj, isVisited, ans);

        // Return the DFS traversal result
        return ans;
    }
}

// Time Complexity : O(V + E)
// Space Complexity : O(V + E)