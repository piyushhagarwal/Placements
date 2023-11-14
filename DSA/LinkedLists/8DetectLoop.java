// Given head, the head of a linked list, determine if the linked list has a cycle in it.

// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

// Return true if there is a cycle in the linked list. Otherwise, return false.

// Example 1:

// Input: head = [3,2,0,-4], pos = 1
// Output: true
// Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
// Example 2:

// Input: head = [1,2], pos = 0
// Output: true
// Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
// Example 3:

// Input: head = [1], pos = -1
// Output: false
// Explanation: There is no cycle in the linked list.

// Link : https://leetcode.com/problems/linked-list-cycle/
// Solution : https://www.youtube.com/watch?v=VxOFflTXlXo&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=52
package LinkedLists;

import java.util.ArrayList;

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class DetectLoop {
    // Naive Approach
    public boolean hasCycleNaive(ListNode head) {
        ListNode curr = head;
        ArrayList<ListNode> visited = new ArrayList();
        while (curr != null) {
            if (visited.contains(curr.next)) {
                return true;
            }
            visited.add(curr);
            curr = curr.next;
        }
        return false;
    }
    // Time Complexity : O(n^2)
    // Space Complexity : O(n)

    // Optimized Approach : Floyd's Cycle Detection Algorithm
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null) {
            // Move 'fast' two steps
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            } else {
                // If 'fast' reaches the end (null), there is no cycle
                return false;
            }

            // Move 'slow' one step
            slow = slow.next;

            // Check if 'slow' and 'fast' pointers meet, indicating a cycle
            if (slow == fast) {
                return true;
            }
        }

        // If the loop completes without finding a cycle, return false
        return false;
    }
    // Time Complexity : O(n)
    // Space Complexity : O(1)

}
