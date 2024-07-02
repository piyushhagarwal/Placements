// Given a set of N jobs where each jobi has a deadline and profit associated with it.

// Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit associated with job if and only if the job is completed by its deadline.

// Find the number of jobs done and the maximum profit.

// Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job. Deadline of the job is the time before which job needs to be completed to earn the profit.

// Example 1:

// Input:
// N = 4
// Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}
// Output:
// 2 60
// Explanation:
// Job1 and Job3 can be done with
// maximum profit of 60 (20+40).
// Example 2:

// Input:
// N = 5
// Jobs = {(1,2,100),(2,1,19),(3,2,27),
//         (4,1,25),(5,1,15)}
// Output:
// 2 127
// Explanation:
// 2 jobs can be done with
// maximum profit of 127 (100+27).

// Link : https://practice.geeksforgeeks.org/problems/n-job-scheduling-1587115620/1#
// Solution : https://www.youtube.com/watch?v=QbwltemZbRg

package GreedyAlgos;

import java.util.Arrays;

class Solution {
    // Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        // Your code here

        // Sort the array in descending order of profit
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);

        // Calculate the maximum deadline
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(arr[i].deadline, maxDeadline);
        }

        // Create an empty array of size maxDeadline + 1
        int tempArr[] = new int[maxDeadline + 1];

        for (int i = 1; i <= maxDeadline; i++) {
            tempArr[i] = -1;
        }

        // Final logic:
        int count = 0;
        int profit = 0;

        for (int i = 0; i < n; i++) {
            int j = arr[i].deadline;
            while (j > 0 && tempArr[j] != -1) {
                j--;
            }

            if (j != 0) {
                tempArr[j] = arr[i].id;
                count++;
                profit += arr[i].profit;
            }
        }

        return new int[] { count, profit };
    }
}

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}