package SearchingSorting;

class SelectionSort {
    // Method to perform selection sort on an array
    public static void selectionSort(int arr[]) {
        int n = arr.length; // Get the length of the array

        // Loop through each element of the array except the last one
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // Assume the current element is the minimum

            // Find the minimum element in the unsorted part of the array
            for (int j = i + 1; j < n; j++) {
                // If an element smaller than the current minimum is found, update minIndex
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element of the unsorted part
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    // Note: Avg, best, and worst case complexity of Selection Sort is O(n^2)
}