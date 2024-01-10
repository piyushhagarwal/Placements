// Ninja is planing this ‘N’ days-long training schedule. Each day, he can perform any one of these three activities. (Running, Fighting Practice or Learning New Moves). Each activity has some merit points on each day. As Ninja has to improve all his skills, he can’t do the same activity in two consecutive days. Can you help Ninja find out the maximum merit points Ninja can earn?
// You are given a 2D array of size N*3 ‘POINTS’ with the points corresponding to each day and activity. Your task is to calculate the maximum number of merit points that Ninja can earn.
// For Example
// If the given ‘POINTS’ array is [[1,2,5], [3 ,1 ,1] ,[3,3,3] ],the answer will be 11 as 5 + 3 + 3.
// Detailed explanation ( Input/output format, Notes, Images )
// Constraints:
// 1 <= T <= 10
// 1 <= N <= 100000.
// 1 <= values of POINTS arrays <= 100 .

// Time limit: 1 sec
// Sample Input 1:
// 2
// 3
// 1 2 5 
// 3 1 1
// 3 3 3
// 3
// 10 40 70
// 20 50 80
// 30 60 90
// Sample Output 1:
// 11
// 210
// Explanation of sample input 1:
// For the first test case,
// One of the answers can be:
// On the first day, Ninja will learn new moves and earn 5 merit points. 
// On the second day, Ninja will do running and earn 3 merit points. 
// On the third day, Ninja will do fighting and earn 3 merit points. 
// The total merit point is 11 which is the maximum. 
// Hence, the answer is 11.

// For the second test case:
// One of the answers can be:
// On the first day, Ninja will learn new moves and earn 70 merit points. 
// On the second day, Ninja will do fighting and earn 50 merit points. 
// On the third day, Ninja will learn new moves and earn 90 merit points. 
// The total merit point is 210 which is the maximum. 
// Hence, the answer is 210.
// Sample Input 2:
// 2
// 3
// 18 11 19
// 4 13 7
// 1 8 13
// 2
// 10 50 1
// 5 100 11
// Sample Output 2:
// 45
// 110

// Link to the problem: https://www.codingninjas.com/studio/problems/ninja’s-training_3621003?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
// Solution : https://www.youtube.com/watch?v=AE39gJYuRog

package DynamicProgramming.TwoDimention;

// By recursive approach
class Solution {
    // Helper method to recursively calculate the maximum points
    public static int solve(int index, int last, int points[][]) {
        // Base case: If at the first row (index 0), find the maximum points for the
        // last color chosen
        if (index == 0) {
            int max = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    max = Math.max(max, points[0][i]);
                }
            }
            return max;
        }

        // Recursive case: Calculate the maximum points for the current index and last
        // color chosen
        int max = 0;

        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int point = points[index][i] + solve(index - 1, i, points);
                max = Math.max(max, point);
            }
        }

        return max;
    }

    // Main method to find the maximum points for the ninja training
    public static int ninjaTraining(int n, int points[][]) {
        // Start solving the problem from the last row and last color (3 represents no
        // color chosen)
        int index = n - 1;
        int last = 3;

        // Call the recursive solve method to find the maximum points
        return solve(index, last, points);
    }
}

// By memoization approach
class Solution2 {
    // Helper method to recursively calculate the maximum points
    public static int solve(int index, int last, int points[][], int dp[][]) {
        // If the result for the current index and last color is already calculated,
        // return it
        if (dp[index][last] != -1) {
            return dp[index][last];
        }

        // Base case: If at the first row (index 0), find the maximum points for the
        // last color chosen
        if (index == 0) {
            int max = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    max = Math.max(max, points[0][i]);
                }
            }
            dp[index][last] = max;
            return dp[index][last];
        }

        // Recursive case: Calculate the maximum points for the current index and last
        // color chosen
        int max = 0;

        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int point = points[index][i] + solve(index - 1, i, points, dp);
                max = Math.max(max, point);
            }
        }

        // Memoize the result for the current index and last color
        dp[index][last] = max;
        return dp[index][last];
    }

    // Main method to find the maximum points for the ninja training
    public static int ninjaTraining(int n, int points[][]) {
        // Initialize a 2D array for dynamic programming memoization
        int dp[][] = new int[n][4];

        // Initialize the array with -1 to indicate that the result is not yet
        // calculated
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = -1;
            }
        }

        // Start solving the problem from the last row and last color (3 represents no
        // color chosen)
        int index = n - 1;
        int last = 3;

        // Call the recursive solve method to find the maximum points
        return solve(index, last, points, dp);
    }
}
