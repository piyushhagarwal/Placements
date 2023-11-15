// Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

// Do not modify the linked list.

// Example 1:

// Input: head = [3,2,0,-4], pos = 1
// Output: tail connects to node index 1
// Explanation: There is a cycle in the linked list, where tail connects to the second node.
// Example 2:

// Input: head = [1,2], pos = 0
// Output: tail connects to node index 0
// Explanation: There is a cycle in the linked list, where tail connects to the first node.
// Example 3:

// Input: head = [1], pos = -1
// Output: no cycle
// Explanation: There is no cycle in the linked list.

// Link : https://leetcode.com/problems/linked-list-cycle-ii/
// Solution : https://www.youtube.com/watch?v=VxOFflTXlXo&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=52

package LinkedLists;

import java.util.HashMap;

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

class LoopStartingPoint {
    // Naive Approach
    public boolean hasCycleMap(ListNode head) {
        ListNode curr = head;
        HashMap<ListNode, Integer> visited = new HashMap<>();
        while (curr != null) {
            if (visited.containsKey(curr.next)) {
                return true;
            }
            visited.put(curr, 1);
            curr = curr.next;
        }
        return false;
    }
    // This approach is done in
    // 0(n) - time complexity
    // O(n) - space complexity

    // Floyd's Cycle Detection Algorithm
    // This function detects and returns the starting node of a cycle in a linked
    // list, if present.
    public ListNode detectCycle(ListNode head) {
        // Initialize two pointers, 'slow' and 'fast', both starting at the head of the
        // linked list.
        ListNode slow = head;
        ListNode fast = head;

        // Move 'fast' and 'slow' pointers until they either meet (indicating a cycle)
        // or reach the end of the list.
        while (slow != null && fast != null) {
            fast = fast.next; // Move 'fast' one step

            // Check if 'fast' is not null before moving it again to avoid null pointer
            // exception.
            if (fast != null) {
                fast = fast.next; // Move 'fast' an additional step

            } else {
                return null; // If 'fast' reaches the end (null), there is no cycle, so return null.
            }

            slow = slow.next; // Move 'slow' one step

            // If 'slow' and 'fast' pointers meet, it indicates the presence of a cycle.
            // Break the loop.
            if (slow == fast) {
                break;
            }
        }

        // If either 'slow' or 'fast' becomes null, there is no cycle. Return null.
        if (slow == null || fast == null) {
            return null;
        }

        // Reset one pointer to the head and move both pointers one step at a time until
        // they meet again.
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // The meeting point is the start of the cycle. Return the reference to this
        // node.
        return slow;
    }
}
