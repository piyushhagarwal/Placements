package SearchingSorting;

class BubbleSort {
    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int swaps = 0;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swaps++;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

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
        int arr[] = { 4, 1, 2, 5, 0 };
        bubbleSort(arr);
        for (int num : arr) {
            System.out.println(num);
        }
    }
}
