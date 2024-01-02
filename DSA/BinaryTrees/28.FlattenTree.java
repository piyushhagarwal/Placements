// Given the root of a binary tree, flatten the tree into a "linked list":

// The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
// The "linked list" should be in the same order as a pre-order traversal of the binary tree.

// Example 1:

// Input: root = [1,2,5,3,4,null,6]
// Output: [1,null,2,null,3,null,4,null,5,null,6]

// Example 2:

// Input: root = []
// Output: []
// Example 3:

// Input: root = [0]
// Output: [0]

// Link : https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

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
    public void preorder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        ans.add(root.val);
        preorder(root.left, ans);
        preorder(root.right, ans);

    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<Integer> ans = new ArrayList<>();

        preorder(root, ans);

        TreeNode current = root;

        for (int i = 1; i < ans.size(); i++) {
            current.left = null; // Remove left subtree
            current.right = new TreeNode(ans.get(i));
            current = current.right;
        }

    }
}