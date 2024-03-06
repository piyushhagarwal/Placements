// Link : https://leetcode.com/problems/making-a-large-island/
// Solution : https://www.youtube.com/watch?v=lgiz0Oup6gM&t=48s

package Graphs.MSTDisjointSet;

import java.util.HashSet;
import java.util.Set;

class Solution {
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

    public int largestIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        DisjointSet ds = new DisjointSet(rows * cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 0) {
                    continue;
                }

                int node = (i * cols) + j;

                // Left
                if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                    int left = (i * cols) + (j - 1);
                    ds.union(node, left);
                }

                // Top
                if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                    int top = ((i - 1) * cols) + (j);
                    ds.union(node, top);
                }
            }
        }

        int maxSize = Integer.MIN_VALUE;
        for (int i = 0; i < rows * cols; i++) {
            maxSize = Math.max(ds.size[i], maxSize);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }

                int node = (i * cols) + j;

                Set<Integer> eventualParents = new HashSet<>();

                // Left
                if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                    int left = (i * cols) + (j - 1);
                    eventualParents.add(ds.findUltimateParent(left));
                }

                // Right
                if (j + 1 < cols && grid[i][j + 1] == 1) {
                    int right = (i * cols) + (j + 1);
                    eventualParents.add(ds.findUltimateParent(right));
                }

                // Top
                if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                    int top = ((i - 1) * cols) + (j);
                    eventualParents.add(ds.findUltimateParent(top));
                }

                // Bottom
                if (i + 1 < rows && grid[i + 1][j] == 1) {
                    int bottom = ((i + 1) * cols) + (j);
                    eventualParents.add(ds.findUltimateParent(bottom));
                }

                int size = 1;
                for (int ep : eventualParents) {
                    size += ds.size[ep];
                }
                maxSize = Math.max(maxSize, size);
            }
        }
        return maxSize;
    }
}
