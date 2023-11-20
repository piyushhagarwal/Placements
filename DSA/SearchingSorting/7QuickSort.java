package SearchingSorting;

class QuickSort {
    public static int partition(int arr[], int start, int end) {
        // Step 1: Take a pivot
        int pivot = start;

        // Step 2: Count all elements < pivot
        int count = 0;
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < arr[pivot]) {
                count++;
            }
        }

        // Step 3: Update pivot
        pivot = start + count;
        int temp = arr[pivot];
        arr[pivot] = arr[start];
        arr[start] = temp;

        // Step 4: Place all smaller elements to the left of pivot and all larger
        // elements to its right
        int i = start;
        int j = end;
        while (i < pivot && j > pivot) {
            if (arr[i] > arr[pivot] && arr[j] < arr[pivot]) {
                int x = arr[i];
                arr[i] = arr[j];
                arr[j] = x;
                i++;
                j--;
            } else {
                if (arr[i] < arr[pivot]) {
                    i++;
                }
                if (arr[j] > arr[pivot]) {
                    j--;
                }
            }
        }
        return pivot;
    }

    public static void quickSort(int arr[], int start, int end) {
        if (start >= end) {
            return;
        }

        int partitionIndex = partition(arr, start, end);

        quickSort(arr, start, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, end);
    }

    // Theory of quick sort

    // It is a non stable sorting algorithm

    // What is the difference between stable and unstable sorting algorithms?
    // A sorting algorithm is said to be stable if two objects with equal keys
    // appear in the same order in sorted output as they appear in the input array
    // to be sorted.
    // Some sorting algorithms are stable by nature like Insertion sort, Merge Sort,
    // Bubble Sort, etc.

    // Time Complexity: O(nlogn)
    // Worst Case: O(n^2)
    // Best Case: O(nlogn)
    // Average Case: O(nlogn)

    // Space Complexity: O(1)
    // It is a inplace sorting algorithm

    // Why Quick Sort is preferred over MergeSort for sorting Arrays?
    // Quick Sort in its general form is an in-place sort (i.e. it doesn’t require
    // any extra storage) whereas merge sort requires O(N) extra storage,
    // N denoting the array size which may be quite expensive. Allocating and
    // de-allocating the extra space used for merge sort increases the running time
    // of the algorithm.
    // Comparing average complexity we find that both type of sorts have O(NlogN)
    // average complexity but the constants differ.
    // For arrays, merge sort loses due to the use of extra O(N) storage space.

    // Why MergeSort is preferred over QuickSort for Linked Lists?
    // In case of linked lists the case is different mainly due to difference in
    // memory allocation of arrays and linked lists.
    // Unlike arrays, linked list nodes may not be adjacent in memory.
    // Unlike array, in linked list, we can insert items in the middle in O(1) extra
    // space and O(1) time.
    // Therefore merge operation of merge sort can be implemented without extra
    // space for linked lists.
    // If we want to retain the original order of elements even for equal elements,
    // merge sort is preferred over quick sort.
    // As Merge sort is stable and in-place sorting algorithm, it is preferred over
    // QuickSort for sorting linked lists.

    public static void main(String args[]) {
        int arr[] = { 5, 4, 3, 6, 2, 1 };
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    // After this solve Kth smallest element problem in the array (3th question in
    // array section)

}
