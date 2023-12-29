
// Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

// Example 1:

// Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
// Output: 3
// Explanation: The LCA of nodes 5 and 1 is 3.
// Example 2:

// Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
// Output: 5
// Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
// Example 3:

// Input: root = [1,2], p = 1, q = 2
// Output: 1

// Link : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
// Solution : https://www.youtube.com/watch?v=QG0hE0R_ng4&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=71&t=30s

package BinaryTrees;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // Function to find the lowest common ancestor of nodes p and q in the binary
    // tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base Case: If the root is null, return null
        if (root == null) {
            return null;
        }

        // Check if the current node is either p or q
        if (root.val == p.val || root.val == q.val) {
            return root; // This node is the lowest common ancestor
        }

        // Recursively search for the lowest common ancestor in the left subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        // Recursively search for the lowest common ancestor in the right subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both p and q are found in different subtrees, the current root is the LCA
        if (left != null && right != null) {
            return root;
        }

        // If only the left subtree contains the LCA, return it
        if (left != null && right == null) {
            return left;
        }

        // If only the right subtree contains the LCA, return it
        if (right != null && left == null) {
            return right;
        }

        // If neither the left nor the right subtree contains the LCA, return null
        if (left == null && right == null) {
            return null;
        }

        return root; // This is just for the sake of it
    }
}
