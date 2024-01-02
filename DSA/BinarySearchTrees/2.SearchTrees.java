// You are given the root of a binary search tree (BST) and an integer val.

// Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

// Example 1:

// Input: root = [4,2,7,1,3], val = 2
// Output: [2,1,3]

// Example 2:

// Input: root = [4,2,7,1,3], val = 5
// Output: []

// Link : https://leetcode.com/problems/search-in-a-binary-search-tree/
// Solution : https://www.youtube.com/watch?v=UeRUKRJvPa4&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=75

package BinarySearchTrees;

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }

        if (val > root.val) {
            return searchBST(root.right, val);

        } else {
            return searchBST(root.left, val);
        }

    }
}

// Time Complexity: O(log N) for balanced BST
// Time Complexity: O(N) for skewed BST