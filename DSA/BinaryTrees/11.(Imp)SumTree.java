// Given a Binary Tree. Return true if, for every node X in the tree other than the leaves, its value is equal to the sum of its left subtree's value and its right subtree's value. Else return false.

// An empty tree is also a Sum Tree as the sum of an empty tree can be considered to be 0. A leaf node is also considered a Sum Tree.

// Example 1:

// Input:
//     3
//   /   \    
//  1     2

// Output: 1
// Explanation:
// The sum of left subtree and right subtree is
// 1 + 2 = 3, which is the value of the root node.
// Therefore,the given binary tree is a sum tree.
// Example 2:

// Input:

//           10
//         /    \
//       20      30
//     /   \ 
//    10    10

// Output: 0
// Explanation:
// The given tree is not a sum tree.
// For the root node, sum of elements
// in left subtree is 40 and sum of elements
// in right subtree is 30. Root element = 10
// which is not equal to 30+40.

// Your Task: 
// You don't need to read input or print anything. Complete the function isSumTree() which takes root node as input parameter and returns true if the tree is a SumTree else it returns false.

// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(Height of the Tree)

// Link: https://practice.geeksforgeeks.org/problems/sum-tree/1
// Solution : https://www.youtube.com/watch?v=nHMQ33LZ6oA&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=69&t=2250s

package BinaryTrees;

// A Binary Tree node
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    // Inner class Pair to store information about the subtree
    class Pair {
        boolean isSum; // Indicates whether the subtree is a Sum Tree
        int total; // Total sum of the subtree

        // Default constructor
        public Pair() {
            this.isSum = false;
            this.total = 0;
        }

        // Parameterized constructor
        public Pair(boolean isSum, int total) {
            this.isSum = isSum;
            this.total = total;
        }
    }

    // Method to check if a subtree is a Sum Tree (optimized with Pair class)
    public Pair isSumTreeOptimized(Node root) {
        // Base case: If the root is null, return a Pair indicating a Sum Tree with
        // total 0
        if (root == null) {
            return new Pair(true, 0);
        }

        // If the node is a leaf node, return a Pair indicating a Sum Tree with the leaf
        // node's value
        if (root.left == null && root.right == null) {
            return new Pair(true, root.data);
        }

        // Recursively check if the left and right subtrees are Sum Trees
        Pair left = isSumTreeOptimized(root.left);
        Pair right = isSumTreeOptimized(root.right);

        // Conditions for a Sum Tree
        boolean leftCondition = left.isSum;
        boolean rightCondition = right.isSum;
        boolean isSumCondition = root.data == left.total + right.total;

        // Create a new Pair to store the result
        Pair ans = new Pair();

        // Check if the current subtree is a Sum Tree based on the conditions
        if (leftCondition && rightCondition && isSumCondition) {
            ans.isSum = true;
            ans.total = root.data + left.total + right.total;
        } else {
            ans.isSum = false;
        }

        // Return the result Pair
        return ans;
    }

    // Method to check if the entire tree is a Sum Tree (final result)
    boolean isSumTree(Node root) {
        // Return the isSum property from the result Pair obtained from the optimized
        // method
        return isSumTreeOptimized(root).isSum;
    }
}
