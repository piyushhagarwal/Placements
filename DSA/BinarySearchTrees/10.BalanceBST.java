// Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.

// A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.

// Example 1:
// Input: root = [1,null,2,null,3,null,4,null,null]
// Output: [2,1,3,null,null,null,4]
// Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.

// Example 2:
// Input: root = [2,1,3]
// Output: [2,1,3]

// Link : https://leetcode.com/problems/balance-a-binary-search-tree/
// Solution : https://www.youtube.com/watch?v=IGHyX15fLI8&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=78&t=1325s

package BinarySearchTrees;

import java.util.ArrayList;
import java.util.List;

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
    // Helper method for inorder traversal to populate the list
    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        // Traverse left subtree
        inorder(root.left, list);

        // Add current node's value to the list
        list.add(root.val);

        // Traverse right subtree
        inorder(root.right, list);
    }

    // Helper method to construct a balanced BST from a sorted list
    public TreeNode constructBalanceBST(List<Integer> list, int startIndex, int endIndex) {
        // Base case: startIndex exceeds endIndex
        if (startIndex > endIndex) {
            return null;
        }

        // Calculate the middle index
        int midIndex = startIndex + (endIndex - startIndex) / 2;

        // Create the root node with the value at the middle index
        TreeNode root = new TreeNode(list.get(midIndex));

        // Recursively construct left and right subtrees
        root.left = constructBalanceBST(list, startIndex, midIndex - 1);
        root.right = constructBalanceBST(list, midIndex + 1, endIndex);

        // Return the root of the constructed balanced BST
        return root;
    }

    // Main method to balance a given binary search tree (BST)
    public TreeNode balanceBST(TreeNode root) {
        // Create a list to store inorder traversal result
        List<Integer> list = new ArrayList<>();

        // Perform inorder traversal and populate the list
        inorder(root, list);

        // Construct a balanced BST from the sorted list
        TreeNode balancedBST = constructBalanceBST(list, 0, list.size() - 1);

        // Return the root of the balanced BST
        return balancedBST;
    }
}
