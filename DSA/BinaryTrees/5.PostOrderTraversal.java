// Link : https://leetcode.com/problems/binary-tree-postorder-traversal/

package BinaryTrees;

import java.util.Stack;

class PostOrderTraversal {

    // Recursion
    public static void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    // Iterative Using 2 Stacks
    public static void postOrderTraversalIterative(Node root) {

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {
            Node poppedElement = stack1.pop();
            stack2.push(poppedElement);

            if (poppedElement.left != null) {
                stack1.push(poppedElement.left);
            }

            if (poppedElement.right != null) {
                stack1.push(poppedElement.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data + " ");
        }
    }

    // Iterative Using 1 Stack
    public static void postOrderTraversalIterative1(Node root) {

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

                if (stack.peek().right == null) {
                    node = stack.pop();
                    System.out.print(node.data + " ");

                    while (!stack.isEmpty() && stack.peek().right == node) {
                        node = stack.pop();
                        System.out.print(node.data + " ");
                    }
                }

                if (!stack.isEmpty()) {
                    node = stack.peek().right;
                } else {
                    node = null;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        Node root = Creation.binaryTreeCreation(arr);

        postOrderTraversal(root);
        System.out.println();
        postOrderTraversalIterative(root);
    }
}
