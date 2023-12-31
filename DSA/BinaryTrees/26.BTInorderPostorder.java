// Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

// Example 1:

// Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
// Output: [3,9,20,null,null,15,7]
// Example 2:

// Input: inorder = [-1], postorder = [-1]
// Output: [-1]

// Link : https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
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
    public TreeNode helper(int[] postorder, int[] postorderStartIndex, int[] inorder, int inorderStartIndex,
            int inorderEndIndex, Map<Integer, Integer> map) {
        // Base Case
        if (postorderStartIndex[0] < 0 || inorderStartIndex > inorderEndIndex) {
            return null;
        }

        // Step 1: The Last node of postorder is the root node
        int element = postorder[postorderStartIndex[0]];
        TreeNode root = new TreeNode(element);

        // Step 2: Find position of root node in inorder
        int position = map.get(element);
        postorderStartIndex[0]--;

        // Right Tree
        root.right = helper(postorder, postorderStartIndex, inorder, position + 1, inorderEndIndex, map);

        // Left Tree
        root.left = helper(postorder, postorderStartIndex, inorder, inorderStartIndex, position - 1, map);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int[] postorderStartIndex = { postorder.length - 1 };

        int inorderStartIndex = 0;
        int inorderEndIndex = inorder.length - 1;

        Map<Integer, Integer> map = new HashMap<>(); // To Store Values and inorder positions;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(postorder, postorderStartIndex, inorder, inorderStartIndex, inorderEndIndex, map);
    }
}