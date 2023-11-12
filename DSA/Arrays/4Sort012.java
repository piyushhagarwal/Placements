// Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.
// In O(n) time complexity
// It is known as Dutch national flag problem(https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/)
package Arrays;

class Sort012 {
    static void sort012(int arr[], int n) {
        int low = 0;
        int mid = 0;
        int high = n - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else { // if arr[mid] == 2
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 0, 2, 1, 2, 0 };
        int[] arr2 = { 0, 1, 2, 0, 1, 2 };
        int[] arr3 = { 1, 2, 0, 1, 2, 0 };
        int[] arr4 = { 2, 1, 0, 2, 1, 0 };

        sort012(arr, arr.length);
        sort012(arr2, arr2.length);
        sort012(arr3, arr3.length);
        sort012(arr4, arr4.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < arr4.length; i++) {
            System.out.print(arr4[i] + " ");
        }

        System.out.println();
    }

}
