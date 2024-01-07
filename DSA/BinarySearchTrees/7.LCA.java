// Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

// Example 1:

// Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
// Output: 6
// Explanation: The LCA of nodes 2 and 8 is 6.

// Example 2:

// Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
// Output: 2
// Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

// Example 3:

// Input: root = [2,1], p = 2, q = 1
// Output: 2

// Link : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
// Solution : https://www.youtube.com/watch?v=pDURIj98e0I&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=76&t=1215s

package BinarySearchTrees;

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while (true) {
            // Case 1: If both nodes are less than root, then move to left part
            if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            }
            // Case 2: If both nodes are more than root, then move to right part
            else if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            }
            // Case 3: If one node is less and the other is more, return curr
            else {
                return curr;
            }
        }
    }
}
