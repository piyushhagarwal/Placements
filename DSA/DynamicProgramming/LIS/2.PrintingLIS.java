// You are given an array 'arr' of length 'n'.

// Find the Longest Increasing Subsequence of the array.

// A subsequence is a subset of an array achieved by removing some (possibly 0) elements without changing the order of the remaining elements.

// Increasing subsequence means a subsequence in which all the elements are strictly increasing.

// Longest increasing subsequence is an increasing subsequence that has the largest length possible.

// Please note that there may be more than one LIS (Longest Increasing Subsequence) possible. Return any one of the valid sequences.

// Example:
// Input: ‘arr’ = [5, 6, 3, 4, 7, 6]

// Output: LIS = [5, 6, 7] OR [3, 4, 7] OR [3, 4, 6]

// Explanation: All these three subsequences are valid Longest Increasing Subsequences. Returning any of them is correct.
// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// 6
// 5 6 3 4 7 6

// Sample Output 1:
// 3

// Explanation Of Sample Input 1 :
// There are three valid LIS for the given array: [5, 6, 7], [3, 4, 7] OR [3, 4, 6], and their length is 3.

// Sample Input 2 :
// 5
// 1 2 3 4 5

// Sample Output 2 :
// 5

// Explanation Of Sample Input 2 :
// There is only one valid LIS for the array: [1, 2, 3, 4, 5], and its length is 5.

// Expected time complexity:
// The expected time complexity is O(‘n’ ^ 2).

// Link : https://www.codingninjas.com/studio/problems/printing-longest-increasing-subsequence_8360670

package DynamicProgramming.LIS;

import java.util.*;

class LIS {
    public static void solve(int currIndex, int prevIndex, int[] arr, List<Integer> subAns, List<Integer> ans) {
        if (currIndex >= arr.length) {
            if (ans.size() < subAns.size()) {
                ans.clear();
                ans.addAll(subAns);
            }
            return;
        }

        // Exclude the current element and move on to the next index
        solve(currIndex + 1, prevIndex, arr, subAns, ans);

        // Include the current element and recursively search for combinations
        if (prevIndex == -1 || arr[currIndex] > arr[prevIndex]) {
            subAns.add(arr[currIndex]);
            solve(currIndex + 1, currIndex, arr, subAns, ans);
            subAns.remove(subAns.size() - 1);
        }

    }

    public static List<Integer> printingLongestIncreasingSubsequence(int[] arr, int x) {
        // Write Your Code Here
        int currIndex = 0;
        int prevIndex = -1;
        List<Integer> subAns = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        solve(currIndex, prevIndex, arr, subAns, ans);
        return ans;
    }

    public static void main(String[] args) {
        // Array elements = 5 6 3 4 7 6
        int arr[] = { 5, 6, 3, 4, 7, 6 };
        int x = 6;
        List<Integer> ans = printingLongestIncreasingSubsequence(arr, x);
        System.out.println(ans);
    }
}
