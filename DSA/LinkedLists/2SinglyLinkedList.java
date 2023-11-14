package LinkedLists;

class Node {
    public int data;
    public Node next;

    Node() {
        data = -1;
        next = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SSL {
    public static Node head = new Node();

    public static void InsertAtBeginning(int data) {
        // If the LinkedList is Empty
        if (head.data == -1) {
            head.data = data;
        } else {
            Node newNode = new Node(data);
            newNode.next = head;
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
            current.next = newNode;
        }
    }

    public static void DeleteFromBeginning() {
        // If the LinkedList is Empty
        if (head.data == -1) {
            System.out.println("Linked List is empty");
        } else {
            Node tempHead = head.next;
            head.next = null;
            head = tempHead;
        }
    }

    public static void DeleteFromEnd() {
        // If the LinkedList is Empty
        if (head.data == -1) {
            System.out.println("Linked List is empty");
        } else {
            Node prev = null;
            Node current = head;
            while (current.next != null) {
                prev = current;
                current = current.next;
            }
            prev.next = null;
        }
    }

    public static void DeleteFromPosition(int position) {
        // If the LinkedList is Empty
        if (head.data == -1) {
            System.out.println("Linked List is empty");
        } else {
            Node prev = null;
            Node current = head;
            int count = 1;
            while (count < position) {
                prev = current;
                current = current.next;
                count++;
            }
            prev.next = current.next;
            current.next = null;
        }
    }

    public static void printLL(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        // InsertAtBeginning(1);
        // InsertAtBeginning(2);
        // InsertAtBeginning(3);
        // InsertAtBeginning(4);
        // printLL(head);

        InsertAtEnd(1);
        InsertAtEnd(2);
        InsertAtEnd(3);
        InsertAtEnd(4);
        DeleteFromEnd();
        printLL(head);
    }
}
