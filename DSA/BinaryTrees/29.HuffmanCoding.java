package BinaryTrees;

import java.util.HashMap;
import java.util.PriorityQueue;

class HuffmanCoding {
    static class Node {
        int weight;
        char ch;
        Node left = null;
        Node right = null;

        public Node(char ch, int weight) {
            this.ch = ch;
            this.weight = weight;
        }

        public Node(char ch, int weight, Node left, Node right) {
            this.ch = ch;
            this.weight = weight;
            this.left = left;
            this.right = right;
        }
    }

    public static Node generateHuffmanTree(HashMap<Character, Integer> freq) {
        // Create a priority queue of type Element which stores element on the basis of
        // minimum weights
        PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> a.weight - b.weight);

        // Add all the nodes to the priority queue
        for (char ch : freq.keySet()) {
            pq.add(new Node(ch, freq.get(ch)));
        }

        // Run the loop until the size of the priority queue is greater than 1
        while (pq.size() > 1) {
            // Remove the two nodes of the highest priority (the lowest frequency) from the
            // priority queue
            Node left = pq.poll();
            Node right = pq.poll();

            // Create a new internal node with these two nodes as children and with a
            // frequency equal to the sum of the two nodes' frequencies. Add the new node to
            // the priority queue.
            int sum = left.weight + right.weight;
            pq.add(new Node('\0', sum, left, right));
        }

        Node root = pq.poll();
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        if (root.ch != '\0') {
            System.out.println(root.ch);
        }
        inorder(root.left);
        inorder(root.right);
    }

    public static void main(String[] args) {
        // Create a HashMap to store the frequency of each character
        HashMap<Character, Integer> freq = new HashMap<>();
        freq.put('c', 32);
        freq.put('d', 42);
        freq.put('e', 120);
        freq.put('k', 7);
        freq.put('l', 42);
        freq.put('m', 24);
        freq.put('u', 37);
        freq.put('z', 2);

        Node root = generateHuffmanTree(freq);
        inorder(root);

    }

}
