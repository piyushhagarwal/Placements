// Given a sorted array arr containing n elements with possibly duplicate is to find indexes of first elements, the task is to find the first and last occurrences of an element x in the given array.
// Note: If the number x is not found in the array then return both the indices as -1.

// Example 1:

// Input:
// n=9, x=5
// arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 }
// Output:  
// 2 5
// Explanation: 
// First occurrence of 5 is at index 2 and last occurrence of 5 is at index 5. 
// Example 2:

// Input:
// n=9, x=7
// arr[] = { 1, 3, 5, 5, 5, 5, 7, 123, 125 }
// Output:  
// 6 6
// Explanation: 
// First and last occurrence of 7 is at index 6.

package BinarySearch;

import java.util.ArrayList;

class FirstNLast {
    static ArrayList<Integer> find(int arr[], int n, int x) {
        ArrayList<Integer> ans = new ArrayList<>();
        int minIndex = -1;
        int maxIndex = -1;
        int start = 0;
        int end = n - 1;
        int mid = start + (end - start) / 2;

        while (start <= end) {
            if (arr[mid] == x) {
                minIndex = mid;
                end = mid - 1;
            } else if (arr[mid] > x) {
                end = mid - 1;
            } else if (arr[mid] < x) {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;

        }
        ans.add(minIndex);

        start = 0;
        end = n - 1;
        mid = start + (end - start) / 2;

        while (start <= end) {
            if (arr[mid] == x) {
                maxIndex = mid;
                start = mid + 1;
            } else if (arr[mid] > x) {
                end = mid - 1;
            } else if (arr[mid] < x) {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;

        }
        ans.add(maxIndex);

        return ans;

    }

    public static void main(String args[]) {
        int arr[] = { 7, 7, 9, 10, 10 };
        int n = arr.length;
        ArrayList<Integer> ans = find(arr, n, 7);
        System.out.println(ans.toString());
    }
}
