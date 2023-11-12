package SearchingSorting;

//Problem link: https://www.geeksforgeeks.org/inversion-count-in-array-using-merge-sort/
//Problem solution video: https://www.youtube.com/watch?v=AseUmwVNaoY

class Solution {

    static int count = 0;

    public static void solve(int[] arr, int start, int end) {
        int mid = start + (end - start) / 2;

        int arr1[] = new int[mid - start + 1];
        int arr2[] = new int[end - mid];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[start + i];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = start;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] > arr2[j]) {
                arr[k] = arr2[j];
                count += arr1.length - i; // Only change
                j++;
            } else {
                arr[k] = arr1[i];
                i++;
            }
            k++;
        }

        while (i < arr1.length) {
            arr[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length) {
            arr[k] = arr2[j];
            j++;
            k++;
        }

    }

    public static void mergeSort1(int[] arr, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = start + (end - start) / 2;

        mergeSort1(arr, start, mid);
        mergeSort1(arr, mid + 1, end);

        solve(arr, start, end);
    }

    public static int numberOfInversions(int[] a, int n) {
        // Write your code here.
        mergeSort1(a, 0, n - 1);
        return count;
    }
}