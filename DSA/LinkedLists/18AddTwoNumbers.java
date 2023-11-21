// You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Example 1:

// Input: l1 = [7,2,4,3], l2 = [5,6,4]
// Output: [7,8,0,7]
// Example 2:

// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [8,0,7]
// Example 3:

// Input: l1 = [0], l2 = [0]
// Output: [0]

// Link : https://leetcode.com/problems/add-two-numbers-ii
// Solution Link : https://www.youtube.com/watch?v=HiRlTPf9aCg&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=56&t=1287s

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

class AddTwoNumbers {

    public ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode nex = null;
        while (curr != null) {
            nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }
        return prev;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        l1 = reverseLL(l1); // Reverse the Linked List 1
        l2 = reverseLL(l2); // Reverse the Linked List 2

        ListNode dummy = new ListNode(-1); // Create a dummy node
        ListNode temp = dummy; // Create a temp node
        int carry = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int digit = sum % 10; // Get the digit
            carry = sum / 10; // Get the carry
            temp.next = new ListNode(digit);
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        // If elements are left in Linked List 1
        while (l1 != null) {
            int sum = l1.val + carry;
            int digit = sum % 10;
            carry = sum / 10;
            temp.next = new ListNode(digit);
            temp = temp.next;
            l1 = l1.next;
        }

        // If elements are left in Linked List 2
        while (l2 != null) {
            int sum = l2.val + carry;
            int digit = sum % 10;
            carry = sum / 10;
            temp.next = new ListNode(digit);
            temp = temp.next;
            l2 = l2.next;
        }

        // If carry is left
        if (carry != 0) {
            int sum = carry;
            int digit = sum % 10;
            carry = sum / 10;
            temp.next = new ListNode(digit);
            temp = temp.next;
        }

        return reverseLL(dummy.next); // Reverse the Linked List and return the head
    }
}