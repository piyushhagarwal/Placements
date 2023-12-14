// Link : https://leetcode.com/problems/binary-tree-preorder-traversal/

package BinaryTrees;

import java.util.Stack;

// Node -> Left -> Right

class PreOrederTraversal {

    // Recursion
    public static void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // Iterative
    public static void preOrderTraversalIterative(Node root) {

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node poppedElement = stack.pop();
            System.out.print(poppedElement.data + " ");

            if (poppedElement.right != null) {
                stack.push(poppedElement.right);
            }

            if (poppedElement.left != null) {
                stack.push(poppedElement.left);
            }
        }
    }

}
