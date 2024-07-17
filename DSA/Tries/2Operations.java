// A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

// Implement the Trie class:

// Trie() Initializes the trie object.
// void insert(String word) Inserts the string word into the trie.
// boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
// boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.

// Example 1:

// Input
// ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
// [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
// Output
// [null, null, true, false, true, null, true]

// Explanation
// Trie trie = new Trie();
// trie.insert("apple");
// trie.search("apple");   // return True
// trie.search("app");     // return False
// trie.startsWith("app"); // return True
// trie.insert("app");
// trie.search("app");     // return True

// Constraints:

// 1 <= word.length, prefix.length <= 2000
// word and prefix consist only of lowercase English letters.
// At most 3 * 104 calls in total will be made to insert, search, and startsWith.

// Link: https://leetcode.com/problems/implement-trie-prefix-tree/
// Solution: https://www.youtube.com/watch?v=m9zawMC6QAI

package Tries;

class Trie {

    // Node class represents each node in the Trie
    public static class Node {
        Node[] children; // Array of child nodes
        boolean endOfWord; // Indicates if the node represents the end of a word

        // Constructor to initialize a node
        public Node() {
            children = new Node[26]; // Initialize children array for 26 letters (a to z)
            for (int i = 0; i < 26; i++) {
                children[i] = null; // Set each child to null initially
            }
            endOfWord = false; // Initially, no word ends at this node
        }
    }

    public static Node root; // Root node of the Trie

    // Constructor to initialize the Trie
    public Trie() {
        root = new Node(); // Create the root node
    }

    // Method to insert a word into the Trie
    public void insert(String word) {
        Node curr = root; // Start from the root node
        for (int i = 0; i < word.length(); i++) {
            int charIndex = word.charAt(i) - 'a'; // Calculate the index for the character
            if (curr.children[charIndex] == null) {
                // If the child node does not exist, create a new node
                Node newNode = new Node();
                curr.children[charIndex] = newNode;
                curr = newNode;
            } else {
                // If the child node exists, move to the child node
                curr = curr.children[charIndex];
            }
        }
        curr.endOfWord = true; // Mark the end of the word
    }

    // Method to search for a word in the Trie
    public boolean search(String word) {
        Node curr = root; // Start from the root node
        for (int i = 0; i < word.length(); i++) {
            int charIndex = word.charAt(i) - 'a'; // Calculate the index for the character
            if (curr.children[charIndex] == null) {
                // If the child node does not exist, the word is not present
                return false;
            } else {
                // If the child node exists, move to the child node
                curr = curr.children[charIndex];
            }
        }
        // Check if the current node marks the end of the word
        if (!curr.endOfWord) {
            return false;
        }
        return true;
    }

    // Method to check if there is any word in the Trie that starts with the given
    // prefix
    public boolean startsWith(String prefix) {
        Node curr = root; // Start from the root node
        for (int i = 0; i < prefix.length(); i++) {
            int charIndex = prefix.charAt(i) - 'a'; // Calculate the index for the character
            if (curr.children[charIndex] == null) {
                // If the child node does not exist, no word starts with the prefix
                return false;
            } else {
                // If the child node exists, move to the child node
                curr = curr.children[charIndex];
            }
        }
        return true; // All characters in the prefix were found
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
