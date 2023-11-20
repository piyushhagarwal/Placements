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

class FindIntersection {
    // Naive Approach
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == headB) {
            return headA;
        }
        ListNode tempA = new ListNode(-1, headA);

        while (tempA != null) {
            ListNode tempB = new ListNode(-1, headB);
            while (tempB != null) {
                if (tempA.next == tempB.next) {
                    return tempB.next;
                }
                tempB = tempB.next;
            }
            tempA = tempA.next;
        }
        return null;
    }
    // Time Complexity : O(n*m)
    // Space Complexity : O(1)

    // Better Approach
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;

    }
    // Time Complexity : O(n+m)
    // Space Complexity : O(1)
}
