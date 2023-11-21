// Given two decimal numbers represented by two linked lists of size N and M respectively. The task is to return a linked list that represents the sum of these two numbers.

// For example, the number 190 will be represented by the linked list, 1->9->0->null, similarly 25 by 2->5->null. Sum of these two numbers is 190 + 25 = 215, which will be represented by 2->1->5->null. You are required to return the head of the linked list 2->1->5->null.

// Example 1:

// Input:
// N = 2
// valueN[] = {4,5}
// M = 3
// valueM[] = {3,4,5}
// Output: 3 9 0  
// Explanation: For the given two linked
// list (4 5) and (3 4 5), after adding
// the two linked list resultant linked
// list will be (3 9 0).
// Example 2:

// Input:
// N = 2
// valueN[] = {6,3}
// M = 1
// valueM[] = {7}
// Output: 7 0
// Explanation: For the given two linked
// list (6 3) and (7), after adding the
// two linked list resultant linked list
// will be (7 0).

// Link : https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1
// Leetcode Link : https://leetcode.com/problems/add-two-numbers/
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