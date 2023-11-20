// Given the head of a linked list, return the list after sorting it in ascending order.
// Link : https://leetcode.com/problems/sort-list/
// Solution : https://www.youtube.com/watch?v=rM5EEA_rbNY&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=58

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

class SortLL {

    // BubbleSort
    public ListNode BubbleSort(ListNode head) {

        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        if (len <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        for (int i = 0; i < len; i++) {
            ListNode prev = dummy;
            curr = prev.next;
            ListNode nex = curr.next;
            for (int j = 0; j < len - 1 - i; j++) {
                if (nex != null && curr.val > nex.val) {
                    prev.next = nex;
                    curr.next = nex.next;
                    nex.next = curr;
                }
                prev = prev.next;
                curr = prev.next;
                nex = curr.next;
            }
        }
        return dummy.next;
    }
    // Time Complexity : O(n^2)
    // Space Complexity : O(1)

    // MergeSort
    public static ListNode findMiddleNode(ListNode start) {
        ListNode slow = start;
        ListNode fast = start.next; // if we do fast = start the mergeSort function will go into infinite loop as in
                                    // case of linked list of size 2, the mid will be the second node and the
                                    // mergeSort function will be called again and again as it wont be able to meet
                                    // the base case

        while (fast != null && fast.next != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            slow = slow.next;
        }

        return slow;
    }

    public static ListNode mergeTwoSortedLL(ListNode leftPart, ListNode rightPart) {
        if (leftPart == null) {
            return rightPart;
        }

        if (rightPart == null) {
            return leftPart;
        }

        ListNode temp = new ListNode(-1);
        ListNode dummy = temp;

        while (leftPart != null && rightPart != null) {
            if (leftPart.val < rightPart.val) {
                dummy.next = leftPart;
                dummy = dummy.next;
                leftPart = leftPart.next;
            } else {
                dummy.next = rightPart;
                dummy = dummy.next;
                rightPart = rightPart.next;
            }
        }

        while (leftPart != null) {
            dummy.next = leftPart;
            dummy = dummy.next;
            leftPart = leftPart.next;
        }

        while (rightPart != null) {
            dummy.next = rightPart;
            dummy = dummy.next;
            rightPart = rightPart.next;
        }

        return temp.next;
    }

    public static ListNode mergeSort(ListNode start) {
        if (start == null || start.next == null) {
            return start;
        }

        ListNode mid = findMiddleNode(start);

        ListNode left = start;
        ListNode right = mid.next;
        mid.next = null;

        left = mergeSort(left);
        right = mergeSort(right);

        return mergeTwoSortedLL(left, right);
    }

    // Time Complexity : O(nlogn)
    // Space Complexity : O(1)
}
