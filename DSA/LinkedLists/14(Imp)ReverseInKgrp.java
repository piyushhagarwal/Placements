// Hard

// Topics
// Companies
// Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

// You may not alter the values in the list's nodes, only nodes themselves may be changed.

// Example 1:

// Input: head = [1,2,3,4,5], k = 2
// Output: [2,1,4,3,5]
// Example 2:

// Input: head = [1,2,3,4,5], k = 3
// Output: [3,2,1,4,5]

// Link : https://leetcode.com/problems/reverse-nodes-in-k-group/

// Solution : https://www.youtube.com/watch?v=fi2vh0nQLi0&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=51

package LinkedLists;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class ReverseInKgrp {
    public ListNode reverseKGroup(ListNode head, int k) {

        // base case
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        int c = 0;
        while (temp != null) {
            c++;
            temp = temp.next;
        }
        if (c < k)
            return head;

        // step-1
        // first k reverse

        ListNode curr = head;
        ListNode prev = null;
        ListNode after = null;
        int count = 0;
        while (count < k) { // curr != null &&
            after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;

            count++;

        }

        // recursion

        if (after != null) {
            head.next = reverseKGroup(after, k);
        }

        // step 3
        // return head of reversed list
        return prev;

    }
}
