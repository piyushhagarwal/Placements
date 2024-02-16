// Link : https://www.codingninjas.com/studio/problems/alien-dictionary_630423
// Solution : https://www.youtube.com/watch?v=U3N_je7tWAs&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=26

package Graphs.TopologicalSort;

import java.util.*;

class Solution {
    // Helper function for depth-first search (DFS)
    public static void dfs(Character key, Map<Character, ArrayList<Character>> adj, Stack<Character> stack,
            Map<Character, Boolean> isVisited) {
        isVisited.put(key, true);

        // Traverse neighbors of the current character in the graph
        if (adj.containsKey(key)) {
            for (int i = 0; i < adj.get(key).size(); i++) {
                if (!isVisited.containsKey(adj.get(key).get(i))) {
                    dfs(adj.get(key).get(i), adj, stack, isVisited);
                }
            }
        }

        // Push the current character onto the stack after processing its neighbors
        stack.push(key);
    }

    // Function to get the lexicographically smallest alien language
    public static String getAlienLanguage(String[] dict, int k) {
        // Create a directed graph (adjacency list) based on the given dictionary
        Map<Character, ArrayList<Character>> adj = new HashMap<>();

        for (int i = 0; i < dict.length - 1; i++) {
            for (int j = 0; j < dict[i].length(); j++) {
                if (j < dict[i + 1].length() && dict[i].charAt(j) != dict[i + 1].charAt(j)) {
                    char currentChar = dict[i].charAt(j);
                    char nextChar = dict[i + 1].charAt(j);

                    // Add an edge to the graph
                    if (!adj.containsKey(currentChar)) {
                        adj.put(currentChar, new ArrayList<>());
                    }

                    adj.get(currentChar).add(nextChar);
                    break;
                }
            }
        }

        // Map to track whether a character is visited during DFS
        Map<Character, Boolean> isVisited = new HashMap<>();
        // Stack to store the topological ordering of characters
        Stack<Character> stack = new Stack<>();

        // Perform DFS on the graph starting from each unvisited character
        for (char key : adj.keySet()) {
            if (!isVisited.containsKey(key)) {
                dfs(key, adj, stack, isVisited);
            }
        }

        // Construct the lexicographically smallest alien language from the stack
        StringBuffer ans = new StringBuffer();

        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.toString();
    }
}
