package BinaryTrees;

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

    public static void main(String[] args) {

        int[] arr = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        Node root = binaryTreeCreation(arr);

        System.out.println(root.data);
        System.out.println(root.left.data);
        System.out.println(root.right.data);
        System.out.println(root.left.left.data);
        System.out.println(root.left.right.data);
        System.out.println(root.right.right.data);
    }
}
