// Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

// Implement the MyQueue class:

// void push(int x) Pushes element x to the back of the queue.
// int pop() Removes the element from the front of the queue and returns it.
// int peek() Returns the element at the front of the queue.
// boolean empty() Returns true if the queue is empty, false otherwise.
// Notes:

// You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
// Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.

// Example 1:

// Input
// ["MyQueue", "push", "push", "peek", "pop", "empty"]
// [[], [1], [2], [], [], []]
// Output
// [null, null, null, 1, 1, false]

// Explanation
// MyQueue myQueue = new MyQueue();
// myQueue.push(1); // queue is: [1]
// myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
// myQueue.peek(); // return 1
// myQueue.pop(); // return 1, queue is [2]
// myQueue.empty(); // return false

// Link : https://leetcode.com/problems/implement-queue-using-stacks/

package Queue;

import java.util.Stack;

class MyQueue {

    public Stack<Integer> stack1; // Main stack for enqueue operations
    public Stack<Integer> stack2; // Temporary stack for dequeue operations

    public MyQueue() {
        stack1 = new Stack<>(); // Initialize main stack for enqueue
        stack2 = new Stack<>(); // Initialize temporary stack for dequeue
    }

    // Enqueue operation: Push the element to stack1 by temporarily moving elements
    // to stack2
    public void push(int x) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop()); // Move elements from stack1 to stack2
        }
        stack2.push(x); // Push the new element to stack2
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop()); // Move elements back from stack2 to stack1
        }
    }

    // Dequeue operation: Pop the front element from stack1
    public int pop() {
        return stack1.pop();
    }

    // Peek operation: Return the front element from stack1 without removing it
    public int peek() {
        return stack1.peek();
    }

    // Check if the queue is empty by checking if stack1 is empty
    public boolean empty() {
        return stack1.isEmpty();
    }
}
