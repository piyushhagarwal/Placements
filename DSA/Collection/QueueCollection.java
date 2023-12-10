package Collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueCollection {
    public static void main(String args[]) {
        // 1. Initialization
        Queue<Integer> queue = new LinkedList<>();

        // 2. Insertion
        queue.add(1);
        queue.add(2);
        queue.add(3);

        // 3. Deletion
        int removedElement = queue.poll(); // Removes and returns the head of the queue
        System.out.println("Removed Element: " + removedElement);

        // 4. Get Value
        int head = queue.peek();
        System.out.println("Head of Queue: " + head);

        // 5. Check if Queue is Empty
        boolean empty = queue.isEmpty();
        System.out.println("Queue is empty: " + empty);

        // 6. Size
        int size = queue.size();
        System.out.println("Size of Queue: " + size);

        // 7. Clear
        queue.clear();
        System.out.println("Queue after clearing: " + queue);

        // 8. Convert Queue to Array
        Object[] array = queue.toArray();
        // Print the array
        for (Object element : array) {
            System.out.println(element);
        }

        // 9. contains
        // Returns true if the queue contains the specified element
        boolean contains = queue.contains(2);
        System.out.println("Queue contains 2: " + contains);

    }
}
