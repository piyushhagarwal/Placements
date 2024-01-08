// You have been given a Binary Search Tree (BST). Your task is to flatten the given BST to a sorted list. More formally, you have to make a right-skewed BST from the given BST, i.e., the left child of all the nodes must be NULL, and the value at the right child must be greater than the current node.
// A binary search tree (BST), also called an ordered or sorted binary tree, is a rooted binary tree whose internal nodes each store a value greater than all the values in the node's left subtree and less than those in its right subtree.
// Follow Up :
// Can you solve this in O(N) time and O(H)  space complexity?
// Detailed explanation ( Input/output format, Notes, Images )
// Constraints :
// 1 <= T <= 100
// 1 <= N <= 5000
// 0 <= node.data <= 10^9, (where node data != -1)

// Where 'N' denotes the number of nodes in the given tree.

// Time Limit: 1 second
// Sample Input 1
// 2
// 10 6 12 2 8 11 15 -1 -1 -1 -1 -1 -1 -1 -1
// 5 -5 8 -1 -1 -1 -1
// Sample Output 1
// 2 -1 6 -1 8 -1 10 -1 11 -1 12 -1 15 -1 -1
// -5 -1 5 -1 8 -1 -1
// Explanation for Sample Input 1
// For the first test case, the given BST is depicted below.
// So, after flattening, the BST is transposed as the below figure.
// For the second test case, the given BST is depicted below.
// So, after flattening, the BST is transposed as the below figure.
// Sample Input 2
// 2
// 5 3 7 -1 -1 6 8 -1 -1 -1 -1
// 2 1 -1 -1 -1
// Sample output 2
// 3 -1 5 -1 6 -1 7 -1 8 -1 -1
// 1 -1 2 -1 -1

// Link : https://www.codingninjas.com/studio/problems/flatten-bst-to-a-sorted-list_1169459?leftPanelTab=0&leftPanelTabValue=PROBLEM
package BinarySearchTrees;

import java.util.ArrayList;
import java.util.List;

class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
};

class Solution {
    // Helper method to perform inorder traversal and populate the list
    public static void inorder(TreeNode<Integer> root, List<Integer> list) {
        if (root == null) {
            return;
        }

        // Traverse left subtree
        inorder(root.left, list);

        // Add current node's data to the list
        list.add(root.data);

        // Traverse right subtree
        inorder(root.right, list);
    }

    // Method to flatten the binary tree into a linked list
    public static TreeNode<Integer> flatten(TreeNode<Integer> root) {
        // Create a list to store inorder traversal result
        List<Integer> list = new ArrayList<>();

        // Perform inorder traversal and populate the list
        inorder(root, list);

        // Modify the original tree to create a flattened linked list
        TreeNode<Integer> current = root;
        current.data = list.get(0);

        // Create linked list structure using the list
        for (int i = 1; i < list.size(); i++) {
            current.right = new TreeNode<>(list.get(i));
            current.left = null;
            current = current.right;
        }

        // Return the modified root
        return root;
    }
}
