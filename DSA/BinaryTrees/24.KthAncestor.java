// Given a binary tree of size  N, a node, and a positive integer k., Your task is to complete the function kthAncestor(), the function should return the kth ancestor of the given node in the binary tree. If there does not exist any such ancestor then return -1.
// Note:
// 1. It is guaranteed that the node exists in the tree.
// 2. All the nodes of the tree have distinct values.

// Example 1:

// Input:
// K = 2 Node = 4
// Output: 1
// Explanation:
// Since, K is 2 and node is 4, so we
// first need to locate the node and
// look k times its ancestors.
// Here in this Case node 4 has 1 as his
// 2nd Ancestor aka the Root of the tree.

// Example 2:

// Input:
// k=1 
// node=3
//       1
//     /   \
//     2     3

// Output:
// 1
// Explanation:
// K=1 and node=3 ,Kth ancestor of node 3 is 1.

package BinaryTrees;

import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {
    // Helper function to traverse the tree and find the k-th ancestor of a given
    // node
    public void helper(Node root, int k, int node, ArrayList<Integer> path, ArrayList<Integer> ans) {
        // Base Case: If the current node is null, return
        if (root == null) {
            return;
        }

        // Add the current node's data to the path
        path.add(root.data);

        // Check if the current node is the target node
        if (root.data == node) {
            // If the path is shorter than k, add -1 to the answer
            if (k > path.size() - 1) {
                ans.add(-1);
            } else {
                // Find the k-th ancestor index and add it to the answer
                int ancestorIndex = path.size() - k - 1;
                ans.add(path.get(ancestorIndex));
            }
            return;
        } else {
            // Recursively explore the left and right subtrees
            helper(root.left, k, node, path, ans);
            helper(root.right, k, node, path, ans);

            // Backtrack: Remove the last element from the path
            path.remove(path.size() - 1);
        }
    }

    // Main function to find the k-th ancestor of a given node
    public int kthAncestor(Node root, int k, int node) {
        // Initialize lists to store the path and the answer
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        // Call the helper function to traverse the tree and find the k-th ancestor
        helper(root, k, node, path, ans);

        // Return the first element of the answer list (or -1 if the list is empty)
        return ans.isEmpty() ? -1 : ans.get(0);
    }
}
