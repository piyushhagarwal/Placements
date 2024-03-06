// Link : https://www.geeksforgeeks.org/problems/number-of-islands/1
// Solution : https://www.youtube.com/watch?v=Rn6B-Q4SNyA

package Graphs.MSTDisjointSet;

import java.util.ArrayList;
import java.util.List;

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

    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        // Your code here
        DisjointSet ds = new DisjointSet(rows * cols);

        List<Integer> ans = new ArrayList<>();

        int operations = 0;

        int matrix[][] = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = 0;
            }
        }

        for (int i = 0; i < operators.length; i++) {
            int x = operators[i][0];
            int y = operators[i][1];

            int node = (x * cols) + y;

            if (matrix[x][y] == 1) {
                ans.add(operations);
                continue;
            }

            matrix[x][y] = 1;

            operations++;

            // Left
            if (y - 1 >= 0 && matrix[x][y - 1] == 1) {
                int left = (x * cols) + (y - 1);
                if (ds.findUltimateParent(left) != ds.findUltimateParent(node)) {
                    ds.union(node, left);
                    operations--;
                }
            }

            // Bottom
            if (x + 1 < rows && matrix[x + 1][y] == 1) {
                int bottom = ((x + 1) * cols) + (y);
                if (ds.findUltimateParent(bottom) != ds.findUltimateParent(node)) {
                    ds.union(node, bottom);
                    operations--;
                }
            }

            // Top
            if (x - 1 >= 0 && matrix[x - 1][y] == 1) {
                int top = ((x - 1) * cols) + (y);
                if (ds.findUltimateParent(top) != ds.findUltimateParent(node)) {
                    ds.union(node, top);
                    operations--;
                }
            }

            // Right
            if (y + 1 < cols && matrix[x][y + 1] == 1) {
                int right = (x * cols) + (y + 1);
                if (ds.findUltimateParent(right) != ds.findUltimateParent(node)) {
                    ds.union(node, right);
                    operations--;
                }
            }

            ans.add(operations);
        }

        return ans;
    }

}
