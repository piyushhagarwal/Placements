// Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).

// Assume a BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.

// Example 1:

// Input: root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
// Output: 20
// Explanation: Maximum sum in a valid Binary search tree is obtained in root node with key equal to 3.
// Example 2:

// Input: root = [4,3,null,1,2]
// Output: 2
// Explanation: Maximum sum in a valid Binary search tree is obtained in a single root node with key equal to 2.
// Example 3:

// Input: root = [-4,-2,-5]
// Output: 0
// Explanation: All values are negatives. Return an empty BST.

// Link : https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
// Solution : https://www.youtube.com/watch?v=fqx8z3VepMA

package BinarySearchTrees;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
};

class Solution {
    // Custom class to store information about each node in the tree
    public class NodeInfo {
        int max; // Maximum value in the subtree rooted at the current node
        int min; // Minimum value in the subtree rooted at the current node
        boolean isBST; // Whether the subtree rooted at the current node is a valid BST
        int sum; // Sum of values in the subtree rooted at the current node

        // Constructor to initialize default values
        public NodeInfo() {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            isBST = true;
            sum = 0;
        }
    }

    // Helper method to recursively traverse the tree and calculate information for
    // each node
    public NodeInfo solve(TreeNode root, int[] maxSum) {
        // Base Case: If the node is null, return default NodeInfo
        if (root == null) {
            return new NodeInfo();
        }

        // Recursively calculate information for left and right subtrees
        NodeInfo left = solve(root.left, maxSum);
        NodeInfo right = solve(root.right, maxSum);

        // Create NodeInfo for the current node
        NodeInfo currentNode = new NodeInfo();

        // Check if the current subtree is a valid BST
        if (left.isBST && right.isBST && root.val > left.max && root.val < right.min) {
            currentNode.isBST = true;
            currentNode.max = Math.max(root.val, right.max);
            currentNode.min = Math.min(root.val, left.min);
            currentNode.sum = root.val + left.sum + right.sum;
        } else {
            // If the current subtree is not a valid BST, mark it as such
            currentNode.isBST = false;
        }

        // If the current subtree is a valid BST, update the maximum sum
        if (currentNode.isBST) {
            maxSum[0] = Math.max(maxSum[0], currentNode.sum);
        }

        // Return information about the current node
        return currentNode;
    }

    // Main method to find the maximum sum of values in a BST within the given
    // binary tree
    public int maxSumBST(TreeNode root) {
        // Initialize an array to store the maximum sum
        int[] maxSum = { 0 };

        // Call the helper method to solve the problem and update the maxSum array
        solve(root, maxSum);

        // Return the maximum sum found
        return maxSum[0];
    }
}
