package SearchingSorting;

class InsertionSort {
    public static void insertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                j--;
            }
        }
    }

    // The best case time complexity of insertionSort: O(n)
    // insertion sort is a better choice and more efficient when the array is
    // partially sorted
    // Avg and worst case complexity is O(n^2)

    public static void main(String args[]) {
        int arr[] = { 4, 1, 2, 5, 0 };
        insertionSort(arr);
        for (int num : arr) {
            System.out.println(num);
        }
    }
}
