package Collection;

import java.util.Stack;

public class StackCollection {
    public static void main(String args[]) {
        // 1. Initialization
        Stack<Integer> stack = new Stack<>();

        // 2. Insertion
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // 3. Deletion
        int poppedElement = stack.pop(); // Removes and returns the top element of the stack
        System.out.println("Popped Element: " + poppedElement);

        // 4. Get Value
        int top = stack.peek();
        System.out.println("Top of Stack: " + top);

        // 5. Check if Stack is Empty
        boolean empty = stack.isEmpty();
        System.out.println("Stack is empty: " + empty);

        // 6. Size
        int size = stack.size();
        System.out.println("Size of Stack: " + size);

        // 7. Clear
        stack.clear();
        System.out.println("Stack after clearing: " + stack);

        // 8. Search
        // Returns the 1-based position of the element from the top of the stack
        // Returns -1 if the element is not present in the stack
        int position = stack.search(2);
        System.out.println("Position of 2: " + position);

        // 9. Convert Stack to Array
        Object[] array = stack.toArray();
        // Print the array
        for (Object element : array) {
            System.out.println(element);
        }

        // 10. contains
        // Returns true if the stack contains the specified element
        boolean contains = stack.contains(2);
        System.out.println("Stack contains 2: " + contains);
    }
}
