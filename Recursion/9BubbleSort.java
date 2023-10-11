package Recursion;

class BubbleSort {
    public static void bubbleSort(int arr[], int n) {
        if (n == 0 || n == 1) {
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        bubbleSort(arr, n - 1);
    }

    public static void main(String args[]) {
        int arr[] = { 2, 3, 6, 5, 1 };
        bubbleSort(arr, arr.length);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
