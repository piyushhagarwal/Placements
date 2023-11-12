package SearchingSorting;

class SelectionSort {
    public static void selectionSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    // Avg,best and worst case complexity is O(n^2)

    public static void main(String args[]) {
        int arr[] = { 4, 1, 2, 5, 0 };
        selectionSort(arr);
        for (int num : arr) {
            System.out.println(num);
        }
    }
}
