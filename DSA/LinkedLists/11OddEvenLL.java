// Given the head of a singly linked list, group all the nodes with odd indices
// together followed by the nodes with even indices, and return the reordered
// list.

// The first node is considered odd, and the second node is even, and so on.

// Note that the relative order inside both the even and odd groups should
// remain as it was in the input.

// You must solve the problem in O(1) extra space complexity and O(n) time
// complexity.

// Example 1:

// Input: head = [1,2,3,4,5]
// Output: [1,3,5,2,4]
// Example 2:

// Input: head = [2,1,3,5,6,4,7]
// Output: [2,3,6,7,1,5,4]

// Link : https://leetcode.com/problems/odd-even-linked-list/
// Solution Link : https://www.youtube.com/watch?v=TaNfBSbpX_o

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

class OddEven {
    public ListNode oddEvenList(ListNode head) {
        // Check if the list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize pointers for odd and even nodes
        ListNode odd = head;
        ListNode even = head.next;

        // Save the starting node of even list to later connect with the odd list
        ListNode evenStart = head.next;

        // Iterate through the list until either odd or even pointer reaches the end
        while (odd.next != null && even.next != null) {
            // Connect odd node to the next odd node
            odd.next = even.next;
            odd = odd.next;

            // Check if there is another odd node to connect even node to
            if (odd.next != null) {
                even.next = odd.next;
                even = even.next;
            } else {
                // If no more odd nodes, set even.next to null to break the loop
                even.next = null;
            }
        }

        // Connect the odd list with the even list
        odd.next = evenStart;

        // Return the modified head of the list
        return head;
    }

}
