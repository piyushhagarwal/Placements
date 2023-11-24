// Inversion Count for an array indicates – how far (or close) the array is from being sorted. If the array is already sorted, then the inversion count is 0, but if the array is sorted in reverse order, the inversion count is the maximum. 

// Given an array arr[]. The task is to find the inversion count of arr[]. Where two elements arr[i] and arr[j] form an inversion if a[i] > a[j] and i < j.

// Examples: 

// Input: arr[] = {8, 4, 2, 1}
// Output: 6
// Explanation: Given array has six inversions: (8, 4), (4, 2), (8, 2), (8, 1), (4, 1), (2, 1).

// Input: arr[] = {1, 20, 6, 4, 5}
// Output: 5
// Explanation: Given array has five inversions: (20, 6), (20, 4), (20, 5), (6, 4), (6, 5). 

//Problem link: https://www.geeksforgeeks.org/inversion-count-in-array-using-merge-sort/
//Problem solution video: https://www.youtube.com/watch?v=AseUmwVNaoY

package SearchingSorting;

class Solution {

    // Bruteforce approach
    public static int numberOfInversions1(int[] a, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    count++;
                }
            }
        }
        return count;
    }
    // Time complexity: O(n^2)

    // Optimized approach
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