// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

// Implement the MinStack class:

// MinStack() initializes the stack object.
// void push(int val) pushes the element val onto the stack.
// void pop() removes the element on the top of the stack.
// int top() gets the top element of the stack.
// int getMin() retrieves the minimum element in the stack.
// You must implement a solution with O(1) time complexity for each function.

// Example 1:

// Input
// ["MinStack","push","push","push","getMin","pop","top","getMin"]
// [[],[-2],[0],[-3],[],[],[],[]]

// Output
// [null,null,null,null,-3,null,0,-2]

// Explanation
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin(); // return -3
// minStack.pop();
// minStack.top();    // return 0
// minStack.getMin(); // return -2

// Link: https://leetcode.com/problems/min-stack/

package Stacks;

import java.util.Stack;

// Define a class named MinStack to implement a stack with a constant time getMin() operation.
class MinStack {

    // Two stacks are used: one for the main stack and another for tracking the
    // minimum element.
    Stack<Integer> stack; // Main stack to store all elements.
    Stack<Integer> minStack; // Stack to keep track of the minimum element at any point.

    // Constructor to initialize the stacks.
    public MinStack() {
        stack = new Stack<>(); // Initialize the main stack.
        minStack = new Stack<>(); // Initialize the minStack to track the minimum element.
    }

    // Method to push a new element onto the stack.
    public void push(int val) {
        if (stack.isEmpty()) {
            // If the main stack is empty, push the element onto both stacks.
            stack.push(val);
            minStack.push(val);
        } else {
            // If the main stack is not empty, push the element onto the main stack.
            stack.push(val);

            // Check if the new element is smaller than or equal to the current minimum.
            if (val <= minStack.peek()) {
                // If yes, push the new element onto the minStack as well.
                minStack.push(val);
            }
        }
    }

    // Method to pop the top element from the stack.
    public void pop() {
        // Check if the top element of the main stack is the same as the top element of
        // the minStack.
        if (stack.peek().equals(minStack.peek())) {
            // If yes, pop both stacks to maintain consistency.
            stack.pop();
            minStack.pop();
        } else {
            // If not, simply pop the main stack.
            stack.pop();
        }
    }

    // Method to get the top element of the main stack.
    public int top() {
        return stack.peek();
    }

    // Method to get the minimum element in the stack.
    // The minimum element is always present at the top of the minStack.
    public int getMin() {
        return minStack.peek();
    }
}
