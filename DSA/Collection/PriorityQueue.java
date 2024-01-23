package Collection;

import java.util.PriorityQueue;

class PriorityQ {
    public static void main(String args[]) {
        // 1. Initialization
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 2. Insertion
        pq.add(50);
        pq.add(20);
        pq.add(30);

        // 3. First Element
        int head = pq.peek(); // Returns 20
        System.out.println("Head of Queue: " + head);

        // 4. Deletion
        int removedElement = pq.poll(); // Removes and returns the head of the queue (20)
        System.out.println("Removed Element: " + removedElement);

        // 5. Size
        int size = pq.size();
        System.out.println("Size of Queue: " + size);
    }

}
