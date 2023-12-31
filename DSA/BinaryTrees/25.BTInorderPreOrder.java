// Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

// Example 1:

// Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// Output: [3,9,20,null,null,15,7]
// Example 2:

// Input: preorder = [-1], inorder = [-1]
// Output: [-1]

// Link : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
// Solution : https://www.youtube.com/watch?v=ffE1xj51EBQ&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=72

package BinaryTrees;

import java.util.HashMap;
import java.util.Map;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode helper(int[] preorder, int preorderStartIndex[], int[] inorder, int inorderStartIndex,
            int inorderEndIndex, Map<Integer, Integer> map) {
        // Base Case
        if (preorderStartIndex[0] >= preorder.length || inorderStartIndex > inorderEndIndex) {
            return null;
        }

        // Step 1: The first node of preorder is the root node
        int element = preorder[preorderStartIndex[0]];
        TreeNode root = new TreeNode(element);

        // Step 2: Find position of root node in inorder
        int position = map.get(element);

        preorderStartIndex[0] += 1; // Increment the index

        // Left Tree
        root.left = helper(preorder, preorderStartIndex, inorder, inorderStartIndex, position - 1, map);

        // Right Tree
        root.right = helper(preorder, preorderStartIndex, inorder, position + 1, inorderEndIndex, map);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] preorderStartIndex = { 0 }; // Because we want to pass reference

        int inorderStartIndex = 0;
        int inorderEndIndex = inorder.length - 1;

        Map<Integer, Integer> map = new HashMap<>(); // To Store Values and inorder positions;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, preorderStartIndex, inorder, inorderStartIndex, inorderEndIndex, map);
    }
}