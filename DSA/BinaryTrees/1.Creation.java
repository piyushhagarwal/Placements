package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Creation {

    static int i = -1; // This is used to traverse the array

    public static Node binaryTreeCreation(int[] arr) {

        i++; // Every time the function is called i is incremented

        // Base Case
        if (arr[i] == -1) {
            return null;
        }

        Node newNode = new Node(arr[i]);
        newNode.left = binaryTreeCreation(arr);
        newNode.right = binaryTreeCreation(arr);

        return newNode;
    }

    // Creation by Level Order Traversal
    public static Node binaryTreeCreationLevelOrder(int[] arr) {

        Node root = new Node(arr[0]);

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            Node poppedElement = queue.poll();

            if (arr[i] != -1) {
                poppedElement.left = new Node(arr[i]);
                queue.add(poppedElement.left);
            }
            i++;

            if (arr[i] != -1) {
                poppedElement.right = new Node(arr[i]);
                queue.add(poppedElement.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        Node root = binaryTreeCreation(arr);

        System.out.println(root.data);
        System.out.println(root.left.data);
        System.out.println(root.right.data);
        System.out.println(root.left.left.data);
        System.out.println(root.left.right.data);
        System.out.println(root.right.right.data);

        Node root2 = binaryTreeCreationLevelOrder(arr);

        System.out.println(root2.data);
        System.out.println(root2.left.data);
        System.out.println(root2.right.data);
        System.out.println(root2.left.left.data);
        System.out.println(root2.left.right.data);
        System.out.println(root2.right.right.data);

    }
}
