package Collection;

import java.util.Deque;
import java.util.LinkedList;

public class DequeCollection {
    public static void main(String[] args) {
        // Creating a deque using LinkedList
        Deque<String> deque = new LinkedList<>();

        // Adding elements to the deque
        deque.addFirst("First");
        deque.addLast("Last");
        deque.addFirst("New First");

        // Displaying the deque
        System.out.println("Deque after adding elements: " + deque);

        // Accessing the first and last elements without removing them
        String firstElement = deque.peekFirst();
        String lastElement = deque.peekLast();

        System.out.println("First Element: " + firstElement);
        System.out.println("Last Element: " + lastElement);

        // Removing elements from the deque
        String removedFirst = deque.pollFirst();
        String removedLast = deque.pollLast();

        // Displaying the deque after removal
        System.out.println("Deque after removing elements: " + deque);
        System.out.println("Removed First: " + removedFirst);
        System.out.println("Removed Last: " + removedLast);

        // Checking if the deque is empty
        boolean isEmpty = deque.isEmpty();
        System.out.println("Is deque empty? " + isEmpty);
    }
}
