// This program implements Doubly Linked List in Java
// 1. Insertion at the beginning
// 2. Insertion at the end
// 3. Insertion at a given position
// 4. Deletion at the beginning
// 5. Deletion at the end
// 6. Deletion at a given position
// 7. Reverse a Doubly Linked List

package LinkedLists;

class Node {
    public int data;
    public Node next;
    public Node prev;

    Node() {
        data = -1;
        next = null;
        prev = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    public static Node head = new Node();

    public static void InsertAtBeginning(int data) {
        // If the LinkedList is Empty
        if (head.data == -1) {
            head.data = data;
        } else {
            Node newNode = new Node(data);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public static void InsertAtEnd(int data) {
        // If the LinkedList is Empty
        if (head.data == -1) {
            head.data = data;
        } else {
            Node newNode = new Node(data);
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    public static void insertAtPosition(int data, int position) {
        // If the LinkedList is Empty
        if (head.data == -1) {
            head.data = data;
        } else {
            Node newNode = new Node(data);
            Node current = head;
            int count = 1;
            while (count < position - 1) {
                current = current.next;
                count++;
            }
            newNode.next = current.next;
            current.next.prev = newNode;
            current.next = newNode;
            newNode.prev = current;
        }
    }

    public static void deleteAtBeginning() {
        if (head.data == -1) {
            System.out.println("LinkedList is Empty");
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public static void deleteAtEnd() {
        if (head.data == -1) {
            System.out.println("LinkedList is Empty");
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
    }

    public static void deleteAtPosition(int position) {
        if (head.data == -1) {
            System.out.println("LinkedList is Empty");
        } else {
            Node current = head;
            int count = 1;
            while (count < position) {
                current = current.next;
                count++;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }

    public static void reversDLL() {
        if (head.data == -1) {
            System.out.println("LinkedList is Empty");
        } else {
            Node current = head;
            Node temp = null;
            while (current != null) {
                temp = current.prev;
                current.prev = current.next;
                current.next = temp;
                current = current.prev;
            }
            head = temp.prev;
        }
    }
}
