// Given the head of a singly linked list, return true if it is a 
// palindrome
//  or false otherwise.

// Example 1:

// Input: head = [1,2,2,1]
// Output: true
// Example 2:

// Input: head = [1,2]
// Output: false

// Constraints:

// The number of nodes in the list is in the range [1, 105].
// 0 <= Node.val <= 9

// Follow up: Could you do it in O(n) time and O(1) space?

// Link : https://leetcode.com/problems/palindrome-linked-list/
// Solution : https://www.youtube.com/watch?v=-DtNInqFUXs

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

class CheckPalindrome {

    // Naive Approach: Store the values in an ArrayList and then check if the
    // ArrayList is a palindrome.
    public boolean isPalindromeNaive(ListNode head) {
        // Store the values in an ArrayList.
        ListNode curr = head;
        ArrayList<Integer> values = new ArrayList<>();
        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }

        // Check if the ArrayList is a palindrome.
        int start = 0;
        int end = values.size() - 1;
        while (start < end) {
            if (values.get(start) != values.get(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    // Optimized approach :
    // Reverse the second half of the linked list and then
    // compare the first half and the reversed second half.

    public boolean isPalindrome(ListNode head) {
        // Check if the linked list has only one node, in which case it is trivially a
        // palindrome.
        if (head.next == null) {
            return true;
        }

        // Find the middle node of the linked list.
        ListNode mid = middle(head);

        // Reverse the second half of the linked list starting from the node next to the
        // middle.
        ListNode reverseStart = reverse(mid.next);

        // Initialize pointers for comparing the first half and the reversed second
        // half.
        ListNode curr = head;

        // Compare corresponding nodes in the first half and reversed second half for
        // palindrome check.
        while (reverseStart != null) {
            if (curr.val != reverseStart.val) {
                return false; // If values don't match, it's not a palindrome.
            }
            curr = curr.next;
            reverseStart = reverseStart.next;
        }

        return true; // If all values matched, it's a palindrome.
    }

    public ListNode middle(ListNode head) {
        // Initialize two pointers, 'slow' and 'fast', both starting at the head of the
        // linked list.
        ListNode slow = head;
        ListNode fast = head;

        // Move 'fast' and 'slow' pointers until 'fast' reaches the end or null is
        // encountered.
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next; // Move 'slow' one step
            fast = fast.next.next; // Move 'fast' two steps
        }

        return slow; // 'slow' now points to the middle node of the linked list
    }

    public ListNode reverse(ListNode head) {
        // Initialize pointers for reversing the linked list.
        ListNode prev = null;
        ListNode curr = head;
        ListNode forward = curr.next;

        // Iterate through the list, reversing the direction of pointers.
        while (forward != null) {
            curr.next = prev; // Reverse the next pointer
            prev = curr; // Move 'prev' to the current node
            curr = forward; // Move 'curr' to the next node
            forward = forward.next; // Move 'forward' to the next node
        }

        curr.next = prev; // 'curr' is now the new head of the reversed list
        return curr; // Return the new head of the reversed list
    }

}
