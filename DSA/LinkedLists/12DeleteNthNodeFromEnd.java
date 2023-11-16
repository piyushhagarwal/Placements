// Given the head of a linked list, remove the nth node from the end of the list and return its head.

// Example 1:

// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]
// Example 2:

// Input: head = [1], n = 1
// Output: []
// Example 3:

// Input: head = [1,2], n = 1
// Output: [1]

// Constraints:

// The number of nodes in the list is sz.
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz

// Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
// Solution Link : https://www.youtube.com/watch?v=Lhu3MsXZy-Q

package LinkedLists;

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

class DeleteNthNodeFromEnd {

    // Naive solution with two passes
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Calculate the length of the linked list
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        // Calculate the position from the start to delete the Nth node
        int delPosFromStart = length - n + 1;

        // Initialize pointers for previous, current, and forward nodes
        ListNode prev = null;
        ListNode curr = head;
        ListNode forward = curr.next;

        // Check if the node to be deleted is the first node
        if (delPosFromStart == 1) {
            // Update the head to the next node
            head = forward;
            // Disconnect the current node
            curr.next = null;
            // Return the modified head
            return head;
        }

        // Iterate to the node to be deleted
        int position = 1;
        while (position != delPosFromStart) {
            prev = curr;
            curr = forward;
            if (forward != null) {
                forward = forward.next;
            }
            position++;
        }

        // Connect the previous node to the next node, effectively removing the current
        // node
        prev.next = forward;
        // Disconnect the current node
        curr.next = null;

        // Return the modified head of the linked list
        return head;
    }

    // Optimized solution with only one pass
    public ListNode removeNthFromEndOptimized(ListNode head, int n) {
        ListNode start = new ListNode();
        start.next = head;
        ListNode slow = start;
        ListNode fast = start;

        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return start.next;
    }

}
