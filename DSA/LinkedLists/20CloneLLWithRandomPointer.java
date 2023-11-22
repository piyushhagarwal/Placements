// A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

// Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

// For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

// Return the head of the copied linked list.

// The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

// val: an integer representing Node.val
// random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
// Your code will only be given the head of the original linked list.

// Example 1:

// Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
// Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
// Example 2:

// Input: head = [[1,1],[2,1]]
// Output: [[1,1],[2,1]]
// Example 3:

// Input: head = [[3,null],[3,0],[3,null]]
// Output: [[3,null],[3,0],[3,null]]

// Link : https://leetcode.com/problems/copy-list-with-random-pointer/
// Solution : https://www.youtube.com/watch?v=83mPr0i56Gg&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=57&t=184s

package LinkedLists;

import java.util.HashMap;

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class CloneLLWithRandomPointer {

    // Approach 1: Using HashMap
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // Step 1: Clone the list based on only next pointer and create a map which maps
        // the original node with the respective clone node
        Node originalHead = head;
        Node cloneHead = new Node(originalHead.val);

        Node originalCurr = originalHead;
        Node cloneCurr = cloneHead;

        HashMap<Node, Node> map = new HashMap<>();
        map.put(originalCurr, cloneCurr);

        while (originalCurr.next != null) {
            cloneCurr.next = new Node(originalCurr.next.val);
            originalCurr = originalCurr.next;
            cloneCurr = cloneCurr.next;
            map.put(originalCurr, cloneCurr);
        }

        // Step 2: Clone the random pointers based on the map created in Step 1 and
        // return the cloneHead.
        originalCurr = originalHead;
        cloneCurr = cloneHead;

        while (cloneCurr != null) {
            cloneCurr.random = map.get(originalCurr.random);
            cloneCurr = cloneCurr.next;
            originalCurr = originalCurr.next;
        }
        return cloneHead;
    }
    // Time Complexity: O(n)
    // Space Complexity: O(n)

    // Approach 2: Without using HashMap (Optimal)
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        // Step 1: Clone the list based on only next pointer
        Node originalHead = head;
        Node cloneHead = new Node(originalHead.val);

        Node originalCurr = originalHead;
        Node cloneCurr = cloneHead;

        while (originalCurr.next != null) {
            cloneCurr.next = new Node(originalCurr.next.val);
            originalCurr = originalCurr.next;
            cloneCurr = cloneCurr.next;
        }

        // Step 2 Add clone list nodes in between original nodes
        originalCurr = originalHead;
        cloneCurr = cloneHead;

        while (originalCurr != null && cloneCurr != null) {
            Node originalNext = originalCurr.next;
            originalCurr.next = cloneCurr;
            originalCurr = originalNext;

            Node cloneNext = cloneCurr.next;
            cloneCurr.next = originalCurr;
            cloneCurr = cloneNext;
        }

        // Step 3: Copy random pointers
        originalCurr = originalHead;

        while (originalCurr != null) {
            if (originalCurr.random != null) {
                originalCurr.next.random = originalCurr.random.next;
            }
            originalCurr = originalCurr.next.next;
        }

        // Step 4: Revert the changes done in step 2
        originalCurr = originalHead;
        cloneCurr = cloneHead;

        while (originalCurr != null) {
            Node originalNext = originalCurr.next.next;
            Node cloneNext = (cloneCurr.next != null) ? cloneCurr.next.next : null;

            originalCurr.next = originalNext;
            cloneCurr.next = cloneNext;

            originalCurr = originalNext;
            cloneCurr = cloneNext;
        }

        // Step 5: Return the cloned head
        return cloneHead;
    }
    // Time Complexity: O(n)
    // Space Complexity: O(1)
}
