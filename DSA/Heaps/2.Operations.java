package Heaps;

class Heaps {
    int arr[];
    int size;

    public Heaps() {
        arr = new int[100];
        size = 0;
    }

    public void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Algorithm to insert a new element into the heap:
    // 1. Insert the new element at the end of the heap.
    // 2. Compare the value of this child node with its parent.
    // 3. If the value of parent is less than child, then swap them.
    // 4. Repeat steps 2 and 3 until the parent of the child node is greater than or
    // equal to the child node.

    public void insert(int val) {
        size++;
        arr[size] = val;
        int index = size;
        int parent = index / 2;
        while (index > 1 && arr[parent] < arr[index]) {
            swap(arr, parent, index);
            index = parent;
            parent = index / 2;
        }
    }
    // Time Complexity: O(logn)

    // Algorithm to delete an element from the heap: (We will delete the root)
    // 1. Replace the root of the heap with the last element on the last level.
    // 2. Compare the new root with its children; if they are in the correct order,
    // stop.
    // 3. If not, swap the element with one of its children and return to the
    // previous step.
    // (Swap with its smaller child in a min-heap and its larger child in a
    // max-heap.)

    public void delete() {
        arr[1] = arr[size]; // Copy last element to first
        size--; // Reduce size
        int index = 1;
        while (index < size) {
            int left = 2 * index;
            int right = 2 * index + 1;
            if (left <= size && right <= size) { // If both children exist
                // Swap with the larger child
                if (arr[left] > arr[right]) {
                    swap(arr, index, left);
                    index = left;
                } else {
                    swap(arr, index, right);
                    index = right;
                }
            } else if (left <= size && arr[left] > arr[index]) { // If only left child exists
                swap(arr, index, left);
                index = left;
            } else if (right <= size && arr[right] > arr[index]) { // If only right child exists
                swap(arr, index, right);
                index = right;
            } else { // If no child exists
                break;
            }
        }
    }
    // Time Complexity: O(logn)

    public void print() {
        for (int i = 1; i <= size; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String args[]) {
        Heaps h = new Heaps();
        h.insert(10);
        h.insert(20);
        h.insert(40);
        h.insert(30);
        h.insert(60);
        h.insert(50);
        h.insert(5);
        h.print();
        h.delete();
        System.out.println();
        h.print();
    }
}
