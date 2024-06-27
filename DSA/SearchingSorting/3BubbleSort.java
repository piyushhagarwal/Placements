package SearchingSorting;

class BubbleSort {
    // Method to perform bubble sort on an array
    public static void bubbleSort(int arr[]) {
        int n = arr.length; // Get the length of the array

        // Outer loop to control the number of passes
        for (int i = 0; i < n - 1; i++) {
            int swaps = 0; // Counter to track if any swaps happened in this pass

            // Inner loop to perform the comparison and swapping
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements and swap if they are in the wrong order
                if (arr[j] > arr[j + 1]) {
                    swaps++; // Increment swap counter
                    // Swap the elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            // If no swaps occurred, the array is already sorted, so break out of the loop
            if (swaps == 0) {
                break;
            }
        }
    }

    // The best case time complexity of bubbleSort: O(n) which is better than
    // selection sort.
    // Bubble sort is a better choice when the array is already sorted
    // Avg and worst case complexity is O(n^2)

    public static void main(String args[]) {
        int arr[] = { 4, 1, 2, 5, 0 }; // Example array
        bubbleSort(arr); // Calling the bubbleSort method to sort the array
        // After sorting, the array elements can be printed to verify the sorting
    }
}