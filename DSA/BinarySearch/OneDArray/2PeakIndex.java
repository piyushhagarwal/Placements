// An array arr is a mountain if the following properties hold:

// arr.length >= 3
// There exists some i with 0 < i < arr.length - 1 such that:
// arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
// arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
// Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

// You must solve it in O(log(arr.length)) time complexity.

// Example 1:

// Input: arr = [0,1,0]
// Output: 1
// Example 2:

// Input: arr = [0,2,1,0]
// Output: 1
// Example 3:

// Input: arr = [0,10,5,2]
// Output: 1

// Link: https://leetcode.com/problems/find-peak-element/
// Link 2  https://leetcode.com/problems/peak-index-in-a-mountain-array/
// Solution: https://www.youtube.com/watch?v=zD2Jg3alZV8&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=13&t=4s

package BinarySearch.OneDArray;

class PeakIndex {
    int peakIndex(int arr[]) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        int mid = start + (end - start) / 2;
        while (start < end) { // Here its only less than
            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
            mid = start + (end - start) / 2;
        }

        return mid;
    }
}
