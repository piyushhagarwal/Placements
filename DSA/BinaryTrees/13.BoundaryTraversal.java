// Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order: 

// Left boundary nodes: defined as the path from the root to the left-most node ie- the leaf node you could reach when you always travel preferring the left subtree over the right subtree. 
// Leaf nodes: All the leaf nodes except for the ones that are part of left or right boundary.
// Reverse right boundary nodes: defined as the path from the right-most node to the root. The right-most node is the leaf node you could reach when you always travel preferring the right subtree over the left subtree. Exclude the root from this as it was already included in the traversal of left boundary nodes.
// Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary. 

// Example 1:

// Input:
//         1 
//       /   \
//      2     3  
//     / \   / \ 
//    4   5 6   7
//       / \
//      8   9

// Output: 1 2 4 8 9 6 7 3
// Explanation:

// Example 2:

// Input:
//             1
//            /
//           2
//         /  \
//        4    9
//      /  \    \
//     6    5    3
//              /  \
//             7     8

// Output: 1 2 4 6 5 7 8
// Explanation:

// As you can see we have not taken the right subtree. 
// Your Task:
// This is a function problem. You don't have to take input. Just complete the function boundary() that takes the root node as input and returns an array containing the boundary values in anti-clockwise.

// Expected Time Complexity: O(N). 
// Expected Auxiliary Space: O(Height of the Tree).

// Link: https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
// Solution : https://www.youtube.com/watch?v=s1d8UGDCCN8&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=70

package BinaryTrees;

import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class Solution {

    // Helper method to find and add left boundary nodes to the ArrayList
    public void leftBoundaryNode(Node node, ArrayList<Integer> ans) {
        // Base case: If the node is null or a leaf node, return
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }

        // Add the current node's data to the ArrayList
        ans.add(node.data);

        // Recursively explore the left subtree for left boundary nodes
        if (node.left != null) {
            leftBoundaryNode(node.left, ans);
        } else {
            leftBoundaryNode(node.right, ans);
        }
    }

    // Helper method to find and add leaf nodes to the ArrayList
    public void leafNodes(Node node, ArrayList<Integer> ans) {
        // Base case: If the node is null, return
        if (node == null) {
            return;
        }

        // If the node is a leaf node, add its data to the ArrayList
        if (node.left == null && node.right == null) {
            ans.add(node.data);
        }

        // Recursively explore the left and right subtrees for leaf nodes
        leafNodes(node.left, ans);
        leafNodes(node.right, ans);
    }

    // Helper method to find and add right boundary nodes to the ArrayList
    public void rightBoundaryNode(Node node, ArrayList<Integer> ans) {
        // Base case: If the node is null or a leaf node, return
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }

        // Recursively explore the right subtree for right boundary nodes
        if (node.right != null) {
            rightBoundaryNode(node.right, ans);
        } else {
            rightBoundaryNode(node.left, ans);
        }

        // Add the current node's data to the ArrayList
        ans.add(node.data);
    }

    // Main method to find the boundary nodes of the binary tree
    ArrayList<Integer> boundary(Node node) {
        // ArrayList to store the boundary nodes
        ArrayList<Integer> ans = new ArrayList<>();

        // Adding the root node to the ArrayList
        ans.add(node.data);

        // If only the root node is present, return the ArrayList
        if (node.left == null && node.right == null) {
            return ans;
        }

        // Add left boundary nodes
        if (node.left != null) {
            leftBoundaryNode(node.left, ans);
        }

        // Add leaf nodes
        leafNodes(node, ans);

        // Add right boundary nodes
        if (node.right != null) {
            rightBoundaryNode(node.right, ans);
        }

        return ans;
    }
}
