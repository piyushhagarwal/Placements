// You are given an array/list ‘ARR’ of ‘N’ positive integers and an integer ‘K’. Your task is to check if there exists a subset in ‘ARR’ with a sum equal to ‘K’.
// Note: Return true if there exists a subset with sum equal to ‘K’. Otherwise, return false.
// For Example :
// If ‘ARR’ is {1,2,3,4} and ‘K’ = 4, then there exists 2 subsets with sum = 4. These are {1,3} and {4}. Hence, return true.
// Detailed explanation ( Input/output format, Notes, Images )
// Constraints:
// 1 <= T <= 5
// 1 <= N <= 10^3
// 0 <= ARR[i] <= 10^9
// 0 <= K <= 10^3

// Time Limit: 1 sec
// Sample Input 1:
// 2
// 4 5
// 4 3 2 1
// 5 4
// 2 5 1 6 7
// Sample Output 1:
// true
// false
// Explanation For Sample Input 1:
// In example 1, ‘ARR’ is {4,3,2,1} and ‘K’ = 5. There exist 2 subsets with sum = 5. These are {4,1} and {3,2}. Hence, return true.
// In example 2, ‘ARR’ is {2,5,1,6,7} and ‘K’ = 4. There are no subsets with sum = 4. Hence, return false.
// Sample Input 2:
// 2
// 4 4
// 6 1 2 1
// 5 6
// 1 7 2 9 10
// Sample Output 2:
// true
// false
// Explanation For Sample Input 2:
// In example 1, ‘ARR’ is {6,1,2,1} and ‘K’ = 4. There exist 1 subset with sum = 4. That is {1,2,1}. Hence, return true.
// In example 2, ‘ARR’ is {1,7,2,9,10} and ‘K’ = 6. There are no subsets with sum = 6. Hence, return false

package DynamicProgramming.SubSequence;

// By Recursion
class Solution {
    public static boolean solve(int arr[], int index, int n, int k) {
        if (k == 0) {
            return true;
        }
        if (index >= n || k < 0) {
            return false;
        }

        // Include
        boolean include = solve(arr, index + 1, n, k - arr[index]);

        // Exclude
        boolean exclude = solve(arr, index + 1, n, k);

        return include || exclude;
    }

    public static boolean subsetSumToK(int n, int k, int arr[]) {
        // Write your code here.
        int index = 0;
        return solve(arr, index, n, k);
    }
}
// Time complexity : O(2^N)
// Space complexity : O(N)

// By Memoization

class Solution2 {
    // Helper method to recursively check if there is a subset sum to the target
    // value
    public static boolean solve(int arr[], int index, int n, int k, int[][] dp) {
        // Base cases:

        // If the target sum is reached, return true
        if (k == 0) {
            return true;
        }

        // If the end of the array is reached or the target sum becomes negative, return
        // false
        if (index >= n || k < 0) {
            return false;
        }

        // If the result for the current index and target sum is already calculated,
        // return it
        if (dp[index][k] != -1) {
            // If dp[index][k] is 0, it means there is no subset sum to k including the
            // current index
            if (dp[index][k] == 0) {
                return false;
            }
            // If dp[index][k] is 1, it means there is a subset sum to k including the
            // current index
            else if (dp[index][k] == 1) {
                return true;
            }
        }

        // Recursive cases:

        // Include the current element in the subset
        boolean include = solve(arr, index + 1, n, k - arr[index], dp);

        // Exclude the current element from the subset
        boolean exclude = solve(arr, index + 1, n, k, dp);

        // Check if either inclusion or exclusion leads to a subset sum to the target
        // value
        boolean ans = include || exclude;

        // Memoize the result for the current index and target sum
        if (ans == true) {
            dp[index][k] = 1;
        } else {
            dp[index][k] = 0;
        }

        return ans;
    }

    // Main method to check if there is a subset sum to the target value
    public static boolean subsetSumToK(int n, int k, int arr[]) {
        // Initialize a 2D array for dynamic programming memoization
        int dp[][] = new int[n][k + 1];

        // Initialize the array with -1 to indicate that the result is not yet
        // calculated
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k + 1; j++) {
                dp[i][j] = -1;
            }
        }

        // Start checking for the subset sum from the first index of the array
        int index = 0;

        // Call the recursive solve method to check if there is a subset sum to k
        return solve(arr, index, n, k, dp);
    }
}
// Time complexity : O(N * K)
// Space complexity : O(N * K)