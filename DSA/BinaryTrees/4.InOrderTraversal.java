// Link : https://leetcode.com/problems/binary-tree-inorder-traversal/

package BinaryTrees;

import java.util.Stack;

// Left -> Node -> Right
class InOrderTraversal {

    // Recursion
    public static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    // Iterative
    public static void inOrderTraversalIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        Node node = root;

        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                Node poppedNode = stack.pop();
                System.out.println(poppedNode.data);

                node = poppedNode.right;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        Node root = Creation.binaryTreeCreation(arr);

        inOrderTraversal(root);
        System.out.println();
        inOrderTraversalIterative(root);
    }
}
