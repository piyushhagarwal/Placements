package Queue;

import java.util.ArrayList;

// Queue using Array
class QueueArray<T> {
    private int front;
    private int rear;
    private Object[] queue;
    private int maxSize;

    public QueueArray(int size) {
        front = 0;
        rear = 0;
        maxSize = size;
        queue = new Object[maxSize];
    }

    public void push(T element) {
        if (rear < maxSize) {
            queue[rear] = element;
            rear++;
        } else {
            System.out.println("Queue overflow! Cannot push element.");
        }
    }

    public T pop() {
        if (!isEmpty()) {
            T poppedElement = (T) queue[front];
            front++;
            return poppedElement;
        } else {
            System.out.println("Queue underflow! Cannot pop element.");
            return null;
        }
    }

    public int size() {
        return rear - front;
    }

    public boolean isEmpty() {
        return front == rear;
    }
}

// Queue using Linked List
class QueueLinkedList<T> {
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public QueueLinkedList() {
        front = null;
        rear = null;
        size = 0;
    }

    public void push(T data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Queue underflow! Cannot pop element.");
            return null;
        }
        T data = front.data;
        front = front.next;
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue underflow! Cannot peek element.");
            return null;
        }
        return front.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
