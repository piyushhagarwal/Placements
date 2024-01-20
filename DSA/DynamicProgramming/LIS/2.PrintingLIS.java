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
