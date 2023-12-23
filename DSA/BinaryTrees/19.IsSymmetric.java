// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

// Example 1:

// Input: root = [1,2,2,3,4,4,3]
// Output: true

// Example 2:

// Input: root = [1,2,2,null,3,null,3]
// Output: false

// Link : https://leetcode.com/problems/symmetric-tree/

package BinaryTrees;

/**
 * Definition for a binary tree node.
 */
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
    // Helper function to check if two subtrees are symmetric
    public boolean helper(TreeNode left, TreeNode right) {
        // Base Case: If either subtree is null, they should both be null for symmetry
        if (left == null || right == null) {
            return left == right;
        }

        // Check if values of current nodes are equal
        if (left.val != right.val) {
            return false;
        }

        // Recursively check if the left subtree of the left node is symmetric to the
        // right subtree of the right node
        // and vice versa
        boolean leftCriteria = helper(left.left, right.right);
        boolean rightCriteria = helper(left.right, right.left);

        // If both left and right subtrees are symmetric, the tree is symmetric
        return leftCriteria && rightCriteria;
    }

    // Main function to check if the binary tree is symmetric
    public boolean isSymmetric(TreeNode root) {
        // Pass the left subtree of the root and the right subtree of the root to the
        // helper function
        return helper(root.left, root.right);
    }
}
