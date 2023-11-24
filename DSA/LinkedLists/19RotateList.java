// Given the head of a linked list, rotate the list to the right by k places.

// Example 1:

// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]
// Example 2:

// Input: head = [0,1,2], k = 4
// Output: [2,0,1]

// Link : https://leetcode.com/problems/rotate-list/

package LinkedLists;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }
}

class RotateList {
    // This method rotates a linked list to the right by k positions.

    public ListNode rotateRight(ListNode head, int k) {
        // Check if the linked list is empty or has only one node, in which case
        // rotation is unnecessary.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Initialize a pointer to traverse the linked list and a variable to store the
        // length of the list.
        ListNode curr = head;
        int len = 0;

        // Calculate the length of the linked list.
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        // Calculate the effective rotation value, as rotating by the length of the list
        // has no effect. This is done to reduce the number of rotations. For example,
        // rotating a list of length 5 by 5 positions is the same as rotating it by 0
        // positions. Similarly, rotating a list of length 5 by 6 positions is the same
        // as rotating it by 1 position.
        k = k % len;

        // Initialize a counter for the rotations.
        int count = 0;

        // Perform the rotations.
        while (count != k) {
            // Initialize pointers to keep track of the previous and current nodes.
            ListNode prev = null;
            curr = head;

            // Traverse to the last node of the linked list.
            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
            }

            // Disconnect the last node and connect it to the head, effectively rotating the
            // list.
            prev.next = null;
            curr.next = head;
            head = curr;

            // Increment the rotation counter.
            count++;
        }

        // Return the rotated linked list.
        return head;
    }

}
