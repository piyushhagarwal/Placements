package LinkedLists;

class CircularLinkedList {
    public static Node head = new Node();

    public static void InsertAtBeginning(int data) {
        // If the LinkedList is Empty
        if (head.data == -1) {
            head.data = data;
            head.next = head;
        } else {
            Node newNode = new Node(data);
            newNode.next = head;
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            head = newNode;
        }
    }

    public static void InsertAtEnd(int data) {
        // If the LinkedList is Empty
        if (head.data == -1) {
            head.data = data;
            head.next = head;
        } else {
            Node newNode = new Node(data);
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
        }
    }

    public static void insertAtPosition(int data, int position) {
        // If the LinkedList is Empty
        if (head.data == -1) {
            head.data = data;
            head.next = head;
        } else {
            Node newNode = new Node(data);
            Node current = head;
            int count = 1;
            while (count < position - 1) {
                current = current.next;
                count++;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public static void deleteAtBeginning() {
        if (head.data == -1) {
            System.out.println("LinkedList is Empty");
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = head.next;
            head = head.next;
        }
    }

    public static void deleteAtEnd() {
        if (head.data == -1) {
            System.out.println("LinkedList is Empty");
        } else {
            Node current = head;
            while (current.next.next != head) {
                current = current.next;
            }
            current.next = head;
        }
    }

    public static void deleteAtPosition(int position) {
        if (head.data == -1) {
            System.out.println("LinkedList is Empty");
        } else {
            Node current = head;
            int count = 1;
            while (count < position - 1) {
                current = current.next;
                count++;
            }
            current.next = current.next.next;
        }
    }

}
