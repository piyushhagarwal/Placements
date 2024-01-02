// ou are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

// Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
// Example 1:

// Input: root = [4,2,7,1,3], val = 5
// Output: [4,2,7,1,3,5]
// Explanation: Another accepted tree is:

// Example 2:

// Input: root = [40,20,60,10,30,50,70], val = 25
// Output: [40,20,60,10,30,50,70,null,null,25]

// Example 3:

// Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
// Output: [4,2,7,1,3,5]

// Link: https://leetcode.com/problems/insert-into-a-binary-search-tree/
// Solution : https://www.youtube.com/watch?v=UeRUKRJvPa4&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=75

package BinarySearchTrees;

// Definition for a binary tree node.
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            TreeNode newNode = new TreeNode(val);
            return newNode;
        }

        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }

    // Iterative Solution
    public TreeNode insertIntoBSTIterative(TreeNode root, int val) {
        if (root == null) {
            TreeNode newNode = new TreeNode(val);
            return newNode;
        }

        TreeNode curr = root;
        while (true) {
            if (val > curr.val) {
                if (curr.right == null) {
                    TreeNode newNode = new TreeNode(val);
                    curr.right = newNode;
                    break;
                } else {
                    curr = curr.right;
                }
            } else {
                if (curr.left == null) {
                    TreeNode newNode = new TreeNode(val);
                    curr.left = newNode;
                    break;
                } else {
                    curr = curr.left;
                }
            }
        }

        return root;
    }
}

// Time Complexity: O(log N) for balanced BST
// Time Complexity: O(N) for skewed BST
