package SearchingSorting;

class InsertionSort {
    // Method to perform insertion sort on an array
    public static void insertionSort(int arr[]) {
        int n = arr.length; // Get the length of the array

        // Start from the second element (index 1) as the first element is already
        // sorted
        for (int i = 1; i < n; i++) {
            int j = i - 1; // Set the initial comparison index

            // Compare the current element with the sorted portion of the array
            while (j >= 0 && arr[j] > arr[j + 1]) {
                // Swap if the current element is smaller than its predecessor
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                j--; // Move to the previous element in the sorted portion
            }
        }
    }

    // The best case time complexity of insertionSort: O(n)
    // This occurs when the array is already or almost sorted, making insertion sort
    // efficient for such cases
    // Avg and worst case complexity is O(n^2), which happens when the array is
    // sorted in reverse order

    public static void main(String args[]) {
        int arr[] = { 4, 1, 2, 5, 0 }; // Example array
        insertionSort(arr); // Calling the insertionSort method to sort the array
        // Print the sorted array
        for (int num : arr) {
            System.out.println(num);
        }
    }
}