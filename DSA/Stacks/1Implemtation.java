package Stacks;

import java.util.ArrayList;

// It uses an ArrayList internally to store the elements.
class Stack<T> {
    private ArrayList<T> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    public void push(T data) {
        stack.add(data);
    }

    public T pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return stack.remove(stack.size() - 1);
    }

    public T peek() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public void clear() {
        stack.clear();
    }

    public void print() {
        for (T data : stack) {
            System.out.print(data + " ");
        }
        System.out.println();
    }
}

// Implementation of Stack using Linked List
class StackLinkedList<T> {
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node top;
    private int size;

    public StackLinkedList() {
        top = null;
        size = 0;
    }

    public void push(T data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public void print() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("");
    }
}