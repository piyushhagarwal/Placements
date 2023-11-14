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

class ReverseLL {
    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode prevNode = null;
        ListNode currNode = head;
        ListNode nextNode = currNode.next;

        while (nextNode != null) {
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            nextNode = nextNode.next;
        }

        currNode.next = prevNode;

        return currNode;
    }

    public ListNode Recursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = Recursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
