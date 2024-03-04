package BinaryTrees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

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

    public static HashMap<Character, String> generateHuffmanCode(HashMap<Character, Integer> freq) {
        Node root = generateHuffmanTree(freq);
        HashMap<Character, String> prefixCodeTable = new HashMap<>();
        generatePrefixCodeTable(root, "", prefixCodeTable);
        return prefixCodeTable;
    }

    public static void generatePrefixCodeTable(Node root, String s, HashMap<Character, String> prefixCodeTable) {
        if (root.left == null && root.right == null) {
            prefixCodeTable.put(root.ch, s);
            return;
        }
        generatePrefixCodeTable(root.left, s + "0", prefixCodeTable);
        generatePrefixCodeTable(root.right, s + "1", prefixCodeTable);
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

        // HashMap<Character, String> prefixCodeTable = generateHuffmanCode(freq);

        // for (char ch : prefixCodeTable.keySet()) {
        // System.out.println(ch + " " + prefixCodeTable.get(ch));
        // }

        Node root = generateHuffmanTree(freq);
        String serialized = serialize(root);
        System.out.println(serialized);
        Node deserialized = deserialize(serialized);
        inorder(deserialized);
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.ch + " ");
        inorder(root.left);
        inorder(root.right);
    }

    public static String serialize(Node root) {
        Queue<Node> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr != null) {
                sb.append(curr.ch + " ");
                q.add(curr.left);
                q.add(curr.right);
            } else {
                sb.append("NONE ");
            }
        }
        return sb.toString();
    }

    public static Node deserialize(String data) {
        String[] nodes = data.split(" ");
        Node root = new Node(nodes[0].charAt(0), 0);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (i < nodes.length && !q.isEmpty()) {
            Node curr = q.poll();
            if (i + 1 < nodes.length && !nodes[i].equals("NONE")) {
                curr.left = new Node(nodes[i].charAt(0), 0);
                q.add(curr.left);
            }
            i++;
            if (i + 2 < nodes.length && !nodes[i].equals("NONE")) {
                curr.right = new Node(nodes[i].charAt(0), 0);
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

}
