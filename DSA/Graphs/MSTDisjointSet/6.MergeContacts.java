// Link: https://leetcode.com/problems/accounts-merge/
// Solution: https://www.youtube.com/watch?v=FMwpt_aQOGw

package Graphs.MSTDisjointSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Solution {
    // Inner class representing Disjoint Set data structure
    class DisjointSet {
        int parent[]; // To store the parent of each node
        int size[]; // To store the size of each set

        // Constructor to initialize the Disjoint Set
        public DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i; // Initially, each node is the parent of itself
                size[i] = 1; // Initially, each set has only one node
            }
        }

        // Method to find ultimate parent of a node with path compression
        public int findUltimateParent(int node) {
            if (parent[node] == node) {
                return node;
            }

            // Path compression
            int ultimateParent = findUltimateParent(parent[node]);
            parent[node] = ultimateParent;
            return parent[node];
        }

        // Method to merge two sets
        public void union(int node1, int node2) {
            int ultimateParent1 = findUltimateParent(node1);
            int ultimateParent2 = findUltimateParent(node2);

            // If both nodes are already in the same set, return
            if (ultimateParent1 == ultimateParent2) {
                return;
            }

            // Merge the smaller set into the larger set
            if (size[ultimateParent1] < size[ultimateParent2]) {
                parent[ultimateParent1] = ultimateParent2;
                size[ultimateParent2] += size[ultimateParent1];
            } else {
                parent[ultimateParent2] = ultimateParent1;
                size[ultimateParent1] += size[ultimateParent2];
            }
        }
    }

    // Main method to merge accounts using Disjoint Set
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // Create a Disjoint Set instance with the size of the accounts
        DisjointSet ds = new DisjointSet(accounts.size());

        // Map to store email to account index mapping
        HashMap<String, Integer> map = new HashMap<>();

        // Iterate through accounts to build disjoint sets and map emails to accounts
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                if (!map.containsKey(accounts.get(i).get(j))) {
                    map.put(accounts.get(i).get(j), i);
                } else {
                    // If the email is already mapped, union the current account with the mapped one
                    ds.union(i, map.get(accounts.get(i).get(j)));
                }
            }
        }

        // Array of Sets to store merged accounts
        Set<String>[] ansSet = new TreeSet[accounts.size()];
        for (int i = 0; i < accounts.size(); i++) {
            ansSet[i] = new TreeSet<>();
        }

        // Iterate through the map to find the ultimate parent of each account and add
        // emails to sets
        for (String key : map.keySet()) {
            int eventualParent = ds.findUltimateParent(map.get(key));
            ansSet[eventualParent].add(key);
        }

        // Convert the result sets to a List of Lists
        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < accounts.size(); i++) {
            // Skip empty sets
            if (ansSet[i].size() == 0) {
                continue;
            }

            // Create a sublist with account name and merged emails
            List<String> subAns = new ArrayList();
            subAns.add(accounts.get(i).get(0));
            for (String str : ansSet[i]) {
                subAns.add(str);
            }
            ans.add(subAns);
        }

        return ans;
    }
}
