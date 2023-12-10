// Given an integer K and a queue of integers, we need to reverse the order of the first K elements of the queue, leaving the other elements in the same relative order.

// Only following standard operations are allowed on queue.

// enqueue(x) : Add an item x to rear of queue
// dequeue() : Remove an item from front of queue
// size() : Returns number of elements in queue.
// front() : Finds front item.
// Note: The above operations represent the general processings. In-built functions of the respective languages can be used to solve the problem.
// Example 1:

// Input:
// 5 3
// 1 2 3 4 5

// Output: 
// 3 2 1 4 5

// Explanation: 
// After reversing the given
// input from the 3rd position the resultant
// output will be 3 2 1 4 5.

// Example 2:

// Input:
// 4 4
// 4 3 2 1

// Output: 
// 1 2 3 4

// Explanation: 
// After reversing the given
// input from the 4th position the resultant
// output will be 1 2 3 4.

package Queue;

import java.util.Queue;
import java.util.Stack;

class ReverseKelements {
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        // Create a stack to temporarily store the first k elements
        Stack<Integer> stack = new Stack<>();

        // Step 1: Pop the first k elements from the queue and push them onto the stack
        for (int i = 1; i <= k; i++) {
            stack.push(q.poll());
        }

        // Step 2: Pop elements from the stack and enqueue them back to the queue
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }

        // Step 3: Rotate the remaining elements in the queue to the end
        for (int i = 1; i <= q.size() - k; i++) {
            q.add(q.poll());
        }

        // Return the modified queue
        return q;
    }

}
