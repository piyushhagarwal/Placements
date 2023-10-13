package SearchingSorting;

class MergeSort {

    // In this we create an extra array for ans
    public static int[] mergeTwoSortedArr(int arr1[], int arr2[]) {
        int i = 0;
        int j = 0;
        int k = 0;

        int[] ans = new int[arr1.length + arr2.length];

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] >= arr2[j]) {
                ans[k] = arr2[j];
                j++;
            } else {
                ans[k] = arr1[i];
                i++;
            }
            k++;
        }

        while (i < arr1.length) {
            ans[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length) {
            ans[k] = arr2[j];
            j++;
            k++;
        }

        return ans;
    }

    public static int[] mergeSort(int[] arr, int start, int end) {
        if (start == end) {
            return new int[] { arr[start] };
        }

        int mid = start + (end - start) / 2;

        int[] arr1 = mergeSort(arr, start, mid);
        int[] arr2 = mergeSort(arr, mid + 1, end);

        return mergeTwoSortedArr(arr1, arr2);
    }

    // In this we dont create an extra array, we sort the array in place
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
            if (arr1[i] >= arr2[j]) {
                arr[k] = arr2[j];
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

    // Theory:
    // Time complexity = O(nlog(n)) : all cases(worst,best and avg)
    // Space complexity = O(n)
    // This sorting algo is best for sorting large arrays

    public static void main(String args[]) {

        int arr3[] = { 2, 3, 4, 5, 10, 1, 2, 3, 4, 5, 6, 7 };
        mergeSort1(arr3, 0, arr3.length - 1);
        System.out.println();
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
    }
}
