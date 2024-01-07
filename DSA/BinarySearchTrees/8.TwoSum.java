// Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.

// Example 1:

// Input: root = [5,3,6,2,4,null,7], k = 9
// Output: true
// Example 2:

// Input: root = [5,3,6,2,4,null,7], k = 28
// Output: false

// Link: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

package BinarySearchTrees;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    // Helper method for pre-order traversal of the binary tree and populating the
    // map
    public void preorder(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }

        // Add the current node's value to the map
        map.put(root.val, 1);

        // Recursively traverse the left and right subtrees
        preorder(root.left, map);
        preorder(root.right, map);
    }

    // Main method to find if there exists a pair of distinct nodes with sum equal
    // to k
    public boolean findTarget(TreeNode root, int k) {
        // Create a map to store the values encountered during pre-order traversal
        Map<Integer, Integer> map = new HashMap<>();

        // Populate the map using pre-order traversal
        preorder(root, map);

        // Iterate through the map to check for a pair with sum equal to k
        for (int num : map.keySet()) {
            if ((k - num != num) && (map.containsKey(k - num))) {
                // Found a pair with sum equal to k
                return true;
            }
        }

        // No such pair found
        return false;
    }
}
