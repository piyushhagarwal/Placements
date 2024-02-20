package Collection;

import java.util.PriorityQueue;

class PriorityQ {
    public static void main(String args[]) {
        // 1. Initialization
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 2. Insertion Time Complexity: O(log n)
        pq.add(50);
        pq.add(20);
        pq.add(30);

        // 3. First Element
        int head = pq.peek(); // Returns 20
        System.out.println("Head of Queue: " + head);

        // 4. Deletion Time Complexity: O(log n)
        int removedElement = pq.poll(); // Removes and returns the head of the queue (20)
        System.out.println("Removed Element: " + removedElement);

        // 5. Size
        int size = pq.size();
        System.out.println("Size of Queue: " + size);

        // 6. Check if empty
        boolean isEmpty = pq.isEmpty();
        System.out.println("Is Queue Empty: " + isEmpty);

        // Initialize a priority queue which stores elements in descending order
        PriorityQueue<Integer> pqDescending = new PriorityQueue<>((a, b) -> b - a);
    }

}
