package Heaps;

class Heapify {

    // Heapify function to maintain heap property
    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int leftChild = 2 * i; // Left child
        int rightChild = 2 * i + 1; // Right child

        // If left child is larger than root
        if (leftChild <= n && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        // If right child is larger than largest so far
        if (rightChild <= n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        // If largest is not root
        if (largest != i) {
            // Swap the root with the largest element
            swap(arr, i, largest);

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    // Utility function to swap two elements in an array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Driver method to test heapify on each element except leaves
    public static void main(String[] args) {
        // Example array with starting index 1
        int[] arr = { Integer.MIN_VALUE, 4, 10, 3, 5, 1 };
        int n = arr.length - 1; // Adjust the length to exclude the sentinel element

        System.out.println("Original Array:");
        printArray(arr);

        // Start heapify from the last non-leaf node and go up to the root
        for (int i = n / 2; i >= 1; i--) {
            heapify(arr, n, i);
        }

        System.out.println("Array after Heapify on each non-leaf node:");
        printArray(arr);
    }

    // Utility function to print an array
    public static void printArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}

// Time Complexity of Heapify Operation: O(log n)